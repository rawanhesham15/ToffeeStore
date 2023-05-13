import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoggedInUser {
    private String name;
    private String password;
    private String status;
    private String phoneNum;
    private String email;
    private String address;
    private int loayaltyPoint;
    private shoppingCart cart;
    private List<Order> orders = new ArrayList<Order>();

    public LoggedInUser() {
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public LoggedInUser(String data[]) {
        setName(data[0]);
        setPassword(data[1]);
        setAddress(data[2]);
        setPhoneNum(data[3]);
        setEmail(data[4]);
        if (data.length == 5) {
            String status = "Active";
            setStatus(status);
            int loyaltyPoint = 0;
            setLoayaltyPoint(loyaltyPoint);
        } else {
            setStatus(data[5]);
            setLoayaltyPoint(Integer.parseInt(data[6]));
        }
    }

    public String getUserName() {
        return name;
    }

    public void setUserName(String USERNAME) {
        this.name = USERNAME;
    }

    public String getPass() {
        return password;
    }

    public void setPass(String pass) {
        this.password = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLoayaltyPoint() {
        return loayaltyPoint;
    }

    public void setLoayaltyPoint(int loayaltyPoint) {
        this.loayaltyPoint = loayaltyPoint;
    }

    public void setShoppingCart(shoppingCart c) {
        cart = c;
    }

    public shoppingCart getCart() {
        return cart;
    }

    public void makeAnOrdrer() {
        int choice;
        double price;
        List<item> items = new ArrayList<item>();
        Scanner sc = new Scanner(System.in);

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();

        cart.displayShoppingCartItems();
        price = cart.calcTotalPrice();
        items = cart.getItems();
        System.out.println("Enter 1 to place the order and 2 to return the menu: ");
        choice = sc.nextInt();
        if (choice == 1) {
            System.out.println("Order Details: \n" + "Address: " + address + "\n Phone Number: " + phoneNum
                    + "\n Total Price: " + price + "\nDate: " + formatter.format(date));
            System.out.println("\nItems: ");

            for (int i = 0; i < items.size(); i++) {
                items.get(i).displayItem();
            }

            System.out.println("Enter 3 to confirm the order: ");
            choice = sc.nextInt();
            if (choice == 3) {
                Order order = new Order();
                order.setOrderDate(date);
                order.addItems(items);
                orders.add(order);
            }
            System.out.println("Order is confirmed, You will receive the order within 24 hours.");
        }
    }

    public void viewCategories() {
        System.out.println("^^^^^VIEW CATEGORIES^^^^^");
    }

    public void searchForItem() {
        System.out.println("^^^^^SEARCH FOR ITEM^^^^^");
    }

}