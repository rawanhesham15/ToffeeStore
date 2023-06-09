import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class store {
    List<category> categories = new ArrayList<category>();
    List<item> items = new ArrayList<item>();

    public void addCategory(category category) {
        categories.add(category);
    }

    public void addItem(item item) {
        items.add(item);
    }

    // storing all the categories and items we have into the array of categories and
    // items
    public void storeCatg() throws IOException {
        // load chocolate , the first category
        BufferedReader chocFile = new BufferedReader(
                new FileReader("C:\\Users\\Dell\\Documents\\GitHub\\ToffeeStore\\chocolate.txt"));
        category chocolate = new category();
        String chocCategoryLine = chocFile.readLine();
        String categoryName1[] = chocCategoryLine.split(" ");
        chocolate.setName(categoryName1[1]);

        for (int i = 0; i < 2; i++) {
            String line = chocFile.readLine();
            String words[] = line.split(" ");

            item newitem = new item();
            newitem.setName(words[3]);
            newitem.setCategory(chocolate);
            newitem.setBrand(words[5]);
            newitem.setPrice(Double.parseDouble(words[7]));
            newitem.setAvailableNum(Double.parseDouble(words[9]));
            newitem.setIemType(words[11]);
            newitem.setMaxQuantity(Double.parseDouble(words[13]));
            chocolate.addItem(newitem);
            addItem(newitem);
        }

        addCategory(chocolate);

        // load the cake , the second category
        BufferedReader cakeFile = new BufferedReader(
                new FileReader("C:\\Users\\Dell\\Documents\\GitHub\\ToffeeStore\\cake.txt"));
        category cake = new category();
        String cakeCategoryLine = cakeFile.readLine();
        String categoryName2[] = cakeCategoryLine.split(" ");
        cake.setName(categoryName2[1]);

        for (int i = 0; i < 3; i++) {
            String line = cakeFile.readLine();
            String words[] = line.split(" ");

            item newitem = new item();
            newitem.setName(words[3]);
            newitem.setCategory(cake);
            newitem.setBrand(words[5]);
            newitem.setPrice(Double.parseDouble(words[7]));
            newitem.setAvailableNum(Double.parseDouble(words[9]));
            newitem.setIemType(words[11]);
            newitem.setMaxQuantity(Double.parseDouble(words[13]));
            cake.addItem(newitem);
            addItem(newitem);
        }

        addCategory(cake);

        // load the biscuits, the third category
        BufferedReader biscFile = new BufferedReader(
                new FileReader("C:\\Users\\Dell\\Documents\\GitHub\\ToffeeStore\\biscuit.txt"));
        category biscuit = new category();
        String biscCategoryLine = biscFile.readLine();
        String categoryName3[] = biscCategoryLine.split(" ");
        biscuit.setName(categoryName3[1]);

        for (int i = 0; i < 3; i++) {
            String line = biscFile.readLine();
            String words[] = line.split(" ");

            item newitem = new item();
            newitem.setName(words[3]);
            newitem.setCategory(biscuit);
            newitem.setBrand(words[5]);
            newitem.setPrice(Double.parseDouble(words[7]));
            newitem.setAvailableNum(Double.parseDouble(words[9]));
            newitem.setIemType(words[11]);
            newitem.setMaxQuantity(Double.parseDouble(words[13]));
            biscuit.addItem(newitem);
            addItem(newitem);
        }

        addCategory(biscuit);

        // load the sweets, the fourth and last category
        BufferedReader sweetFile = new BufferedReader(
                new FileReader("C:\\Users\\Dell\\Documents\\GitHub\\ToffeeStore\\sweet.txt"));
        category sweet = new category();
        String sweetCategoryLine = sweetFile.readLine();
        String categoryName4[] = sweetCategoryLine.split(" ");
        sweet.setName(categoryName4[1]);

        for (int i = 0; i < 3; i++) {
            String line = sweetFile.readLine();
            String words[] = line.split(" ");

            item newitem = new item();
            newitem.setName(words[3]);
            newitem.setCategory(sweet);
            newitem.setBrand(words[5]);
            newitem.setPrice(Double.parseDouble(words[7]));
            newitem.setAvailableNum(Double.parseDouble(words[9]));
            newitem.setIemType(words[11]);
            newitem.setMaxQuantity(Double.parseDouble(words[13]));
            sweet.addItem(newitem);
            addItem(newitem);
        }

        addCategory(sweet);
    }

    Scanner sc = new Scanner(System.in);

    public item viewCategories(String userType) throws IOException {
        System.out.println("choose one of the next categories to display its items: ");
        System.out.println("1. Chocolates ");
        System.out.println("2. Cakes ");
        System.out.println("3. Biscuits ");
        System.out.println("4. Sweets ");

        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                categories.get(0).displayCategoryItem();
                break;

            case 2:
                categories.get(1).displayCategoryItem();
                break;

            case 3:
                categories.get(2).displayCategoryItem();
                break;

            case 4:
                categories.get(3).displayCategoryItem();
                break;

            default:
                System.out.println("Sorry, this category doesn't exist. ");
                break;
        }

        String t = "loggedin";
        if (userType.equals(t)) {
            System.out.println("Enter 1 if you want to add an item to your shopping cart");
            System.err.println("Enter 0 to quit");
            int ch = sc.nextInt();
            if (ch == 1) {
                System.out.println("Enter name of item: ");
                String nm = sc.next();
                System.out.println("Enter Quantity you want:");
                int num = sc.nextInt();
                boolean checkQuantity = checkQuantity(nm, num);
                double availableAmount = availableAmount(nm);

                while (checkQuantity == false || availableAmount < num) {
                    System.out.println("Not Valid Quantity!");
                    System.out.println("Available Amout of " + nm + "is: " + availableAmount);
                    System.out.println("Valid Quantity for Sealed Items(Sold by unit): maximum 50 unit");
                    System.out.println("Valid Quantity for Loose Items(Sold by kilo): maximum 10 kilo");
                    System.out.println("Enter Quantity you want:");
                    num = sc.nextInt();
                    checkQuantity = checkQuantity(nm, num);
                }

                for (int x = 0; x < items.size(); x++) {
                    String tempp = items.get(x).getName();
                    if (tempp.equals(nm)) {
                        item addt = items.get(x);
                        addt.setOrderedQuantity(num);
                        double itemQuant = items.get(x).getAvailableNum();
                        items.get(x).setAvailableNum(itemQuant - num);
                        return items.get(x);
                    }
                }
                item i = search(t);
                return i;
            } else if (ch == 0) {
                return null;
            }
        }
        return null;
    }

    public double availableAmount(String itemName) {
        for (int i = 0; i < items.size(); i++) {
            String temp = items.get(i).getName();
            if (temp.equals(itemName)) {
                return items.get(i).getAvailableNum();
            }
        }
        return 0;
    }

    public boolean checkQuantity(String itemName, double quantity) {
        for (int i = 0; i < items.size(); i++) {
            String temp = items.get(i).getName();
            if (temp.equals(itemName)) {
                if (items.get(i).getItemType().equals("kilo") && quantity > 10) {
                    return false;
                } else if (items.get(i).getItemType().equals("one") && quantity > 50) {

                    return false;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public item searchForItemByName(String n, String userType) {
        boolean flag = false;
        String itemType = "";
        String itemName = "";
        for (int i = 0; i < items.size(); i++) {
            String temp = items.get(i).getName();
            if (temp.equals(n)) {
                itemName = items.get(i).getName();
                flag = true;
                itemType = items.get(i).getItemType();
                items.get(i).displayItem();
            } else {
                continue;
            }
        }

        String t = "loggedin";
        if (userType.equals(t)) {
            System.out.println("Enter 1 if you want to add an item to your shopping cart");
            System.err.println("Enter 0 to quit");
            int ch = sc.nextInt();
            if (ch == 1) {
                System.out.println("Enter Quantity you want:");
                int num = sc.nextInt();
                double availableAmount = availableAmount(itemName);
                while (itemType.equals("kilo") && num > 10 || (availableAmount < num)) {
                    System.out.println("Available Amout of " + itemName + "is: " + availableAmount);
                    System.out.println("Valid Quantity for Loose Items(Sold by kilo): maximum 10 kilo");
                    System.out.println("Enter Quantity you want:");
                    num = sc.nextInt();
                }
                while (itemType.equals("one") && num > 50 || (availableAmount < num)) {
                    System.out.println("Available Amout of " + itemName + "is: " + availableAmount);
                    System.out.println("Valid Quantity for Sealed Items(Sold by unit): maximum 50 unit");
                    System.out.println("Enter Quantity you want:");
                    num = sc.nextInt();
                }

                for (int x = 0; x < items.size(); x++) {
                    String tempp = items.get(x).getName();
                    if (tempp.equals(n)) {
                        item addt = items.get(x);
                        addt.setOrderedQuantity(num);
                        double itemQuant = items.get(x).getAvailableNum();
                        items.get(x).setAvailableNum(itemQuant - num);
                        return items.get(x);
                    }
                }
            } else if (ch == 0) {
                return null;
            }
        }
        return null;

    }

    public item searchForItemByBrand(String n, String userType) {
        boolean flag = false;
        for (int i = 0; i < items.size(); i++) {
            String temp = items.get(i).getBrand();
            if (temp.equals(n)) {
                flag = true;
                items.get(i).displayItem();
            } else {
                continue;
            }
            String t = "loggedin";
            if (userType.equals(t)) {
                System.out.println("Enter 1 if you want to add an item to your shopping cart");
                System.err.println("Enter 0 to quit");
                int ch = sc.nextInt();
                if (ch == 1) {
                    System.out.println("Enter name of item: ");
                    String nm = sc.next();
                    System.out.println("Enter Quantity you want:");
                    int num = sc.nextInt();

                    boolean checkQuantity = checkQuantity(nm, num);
                    double availableAmount = availableAmount(nm);

                    while (checkQuantity == false || availableAmount < num) {
                        System.out.println("Not Valid Quantity!");
                        System.out.println("Available Amout of " + nm + "is: " + availableAmount);
                        System.out.println("Valid Quantity for Sealed Items(Sold by unit): maximum 50 unit");
                        System.out.println("Valid Quantity for Loose Items(Sold by kilo): maximum 10 kilo");
                        System.out.println("Enter Quantity you want:");
                        num = sc.nextInt();
                        checkQuantity = checkQuantity(nm, num);
                    }

                    for (int x = 0; x < items.size(); x++) {
                        String tempp = items.get(x).getBrand();
                        if (tempp.equals(n)) {
                            item addt = items.get(x);
                            addt.setOrderedQuantity(num);
                            double itemQuant = items.get(x).getAvailableNum();
                            items.get(x).setAvailableNum(itemQuant - num);
                            return items.get(x);
                        }
                    }
                } else if (ch == 0) {
                    return null;
                }
            }
        }
        return null;
    }

    public item search(String useType) {
        System.out.println("Choose the number of the searching you want: ");
        System.out.println("1. Search By Item Name: ");
        System.out.println("2. Search By Brand Name: ");
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        switch (c) {
            case 1:
                Boolean itemExist = true;
                while (itemExist) {
                    System.out.println("Enter the item's name: ");
                    String it = sc.next();
                    for (item item : items) {
                        if (item.getName().equals(it)) {
                            itemExist = false;
                            item cartitem2 = searchForItemByName(it, useType);
                            return cartitem2;
                        }
                    }
                    if (itemExist) {
                        System.err.println("Sorry this item doesn't exist ");
                        System.err.println("Try again");
                    }
                }

            case 2:
                Boolean br = true;

                // validating that the brand exists
                while (br) {
                    System.out.println("Enter the item's brand: ");
                    String it = sc.next();
                    for (item item : items) {
                        if (item.getBrand().equals(it)) {
                            br = false;
                            item cartitem = searchForItemByBrand(it, useType);
                            return cartitem;
                        }
                    }
                    if (br) {
                        System.err.println("Sorry this brand doesn't exist ");
                        System.err.println("Try again");
                    }
                }
            default:
                System.err.println("Invalid input");
                break;
        }
        return null;
    }
};
