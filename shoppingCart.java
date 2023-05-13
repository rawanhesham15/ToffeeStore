import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class shoppingCart {
    List<item> items = new ArrayList<item>();

    public void addItem(item itemadd, LoggedInUser l) throws IOException {
        items.add(itemadd);
        addItemToFile(itemadd, l);

        System.out.println("Item is added to your cart successfully");
    }

    public void addItemToFile(item itemToadd, LoggedInUser l) throws IOException {
        String id = l.getUserName();

        String n = itemToadd.getName();

        String c = itemToadd.getCategory().getName();

        double q = itemToadd.getOrderedQuantity();

        double p = itemToadd.getPrice();

        String b = itemToadd.getBrand();

        String u = itemToadd.getItemType();

        BufferedWriter out = null;
        try {
            FileWriter fstream = new FileWriter("C:\\Users\\Dell\\Documents\\GitHub\\ToffeeStore\\shoppingCart.txt",
                    true); // true tells to append data.
            out = new BufferedWriter(fstream);
            out.write(id + ","); // user's name l7d ma tofrag
            out.write(n + ","); // the item name
            out.write(c + ","); // category the item belongs to
            out.write(q + ","); // quantity ordered
            out.write(p + ","); // item's price
            out.write(b + ","); // item's brand
            out.write(u + ","); // whether the item is sold per one or kilo
            out.write("\n");
        }

        catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }

        finally {
            if (out != null) {
                out.close();
            }
        }
    }

    public item getItem(String n) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equals(n)) {
                return items.get(i);
            } else {
                continue;
            }
        }
        return null;
    }

    public void displayShoppingCartItems() {
        for (int i = 0; i < items.size(); i++) {
            items.get(i).displayItemForCart();
        }
    }

    public void removeItem(String n) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equals(n)) {
                items.remove(i);
                System.out.println("item is removed from your shopping cart successfully!");
            } else {
                continue;
            }
        }
    }

    public void loadItemsFromCart(LoggedInUser l) throws FileNotFoundException {
        File f = new File("C:\\Users\\Dell\\Documents\\GitHub\\ToffeeStore\\shoppingCart.txt");
        try (Scanner scanner = new Scanner(f)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts[0].equals(l.getName())) {
                    item itemload = new item();
                    itemload.setName(parts[1]);
                    category c = new category();
                    c.setName(parts[2]);
                    itemload.setCategory(c);
                    itemload.setOrderedQuantity(Double.parseDouble(parts[3]));
                    itemload.setPrice(Double.parseDouble(parts[4]));
                    itemload.setBrand(parts[5]);
                    itemload.setIemType(parts[6]);
                    items.add(itemload);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
    }

    public double calcTotalPrice() {
        double totalPrice = 0;
        double totalWithFees;
        int choice;

        for (int i = 0; i < items.size(); i++) {
            totalPrice += items.get(i).getPrice() * items.get(i).getOrderedQuantity();
        }

        System.out.println("\n Total Price: " + totalPrice);
        System.out.println("Shipping Fees: 50");
        totalWithFees = totalPrice + 50;
        System.out.println("Total with Shipping Fees: " + totalWithFees);

        return totalWithFees;
    }

    public List<item> getItems() {
        return items;
    }

}
