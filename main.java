import java.io.IOException;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        GneralUser generalUser = new GneralUser();
        LoggedInUser loggedUser = new LoggedInUser();
        shoppingCart cart = new shoppingCart();

        store store = new store();
        store.storeCatg();
        String data[];
        String user = "General";
        int choice = 0;
        while (user == "General" && choice != 5) {
            Scanner sc = new Scanner(System.in);
            System.out.println("\n*********Welcome to Toffee Store*********\n");
            System.out.println("1- log in.");
            System.out.println("2- Register.");
            System.out.println("3- View Categories.");
            System.out.println("4- Search for Item.");
            System.out.println("5- Exit.");
            System.out.print("What do you want to do? choose a number (1, 2, 3, 4, or 5): ");
            choice = sc.nextInt();
            if (choice == 1) {
                data = new String[7];
                data = generalUser.logIn();
                if (data[0] == null) {
                    System.out.println("invalid username or password");
                    System.out.println("please try again");
                    data = generalUser.logIn();
                }
                loggedUser = new LoggedInUser(data);
                loggedUser.setShoppingCart(cart);
                cart.loadItemsFromCart(loggedUser);
                user = "logged";
            } else if (choice == 2) {
                data = new String[5];
                data = generalUser.register();
                loggedUser = new LoggedInUser(data);
                loggedUser.setShoppingCart(cart);
                user = "logged";
            } else if (choice == 3) {
                store.viewCategories("general");
                System.out.println("To start Shopping you must login or register if it is your first time");
            } else if (choice == 4) {
                // generalUser.searchForItem();
                System.out.println("Enter the item's name: ");
                store.search("general");
                System.out.println("To start Shopping you must login or register if it is your first time");

            } else if (choice == 5) {
                return;
            }
        }
        while (choice != 6) {
            Scanner sc = new Scanner(System.in);
            System.out.println("\n*********Welcome " + loggedUser.getUserName() + "*********\n");
            System.out.println("1- View Categories.");
            System.out.println("2- Search for Item.");
            System.out.println("3- View Shopping Cart.");
            System.out.println("4- Remove item from Shopping Cart.");
            System.out.println("5- Make an order.");
            System.out.println("6- Exit.");
            System.out.print("What do you want to do? choose a number (1, 2, 3, 4, 5, or 6): ");
            choice = sc.nextInt();
            if (choice == 1) {
                item cartitem = new item();
                cartitem = store.viewCategories("loggedin");
                loggedUser.getCart().addItem(cartitem, loggedUser);
            } else if (choice == 2) {
                // loggedUser.sea1rchForItem();
                item cartitem = new item();
                cartitem = store.search("loggedin");
                loggedUser.getCart().addItem(cartitem, loggedUser);
            } else if (choice == 3) {
                System.out.println("Viewing " + loggedUser.getName() + "'s Shopping Cart");
                loggedUser.getCart().displayShoppingCartItems();
            } else if (choice == 4) {
                System.out.println("Enter the item you want to remove from the cart");
                String s = sc.next();
                loggedUser.getCart().removeItem(s);
            } else if (choice == 5) {
                System.out.println("\n" + loggedUser.getName() + "'s Shpping Cart\n");
                loggedUser.makeAnOrdrer();
            } else if (choice == 6) {
                return;
            }
        }
    }
}

// i added the user type because the functions will do additional steps if it
// was logged in user