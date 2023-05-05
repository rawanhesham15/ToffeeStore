import java.io.BufferedReader;
import java.io.FileNotFoundException;
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

    public void viewCategories() throws IOException {
        System.out.println("choose one of the next categories to display its items: ");
        System.out.println("1. Chocolates ");
        System.out.println("2. Cakes ");
        System.out.println("3. Biscuits ");
        System.out.println("4. Sweets ");

        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                BufferedReader chocFile = new BufferedReader(
                        new FileReader("C:\\Users\\Dell\\Documents\\GitHub\\ToffeeStore\\chocolate.txt"));
                category chocolate = new category();
                String chocCategoryLine = chocFile.readLine();
                String categoryName1[] = chocCategoryLine.split(" ");
                chocolate.setName(categoryName1[1]);
                System.out.println("\n^^^^^^^^^" + chocolate.getName() + " CATEGORY" + "^^^^^^^^^");

                for (int i = 0; i < 2; i++) {
                    String line = chocFile.readLine();
                    String words[] = line.split(" ");

                    item newitem = new item();
                    newitem.setName(words[3]);
                    newitem.setCategory(chocolate);
                    newitem.setBrand(words[5]);
                    newitem.setPrice(Double.parseDouble(words[7]));
                    chocolate.addItem(newitem);
                    addItem(newitem);
                }
                chocolate.displayCategoryItem();
                addCategory(chocolate);
                break;

            case 2:
                BufferedReader cakeFile = new BufferedReader(
                        new FileReader("C:\\Users\\Dell\\Documents\\GitHub\\ToffeeStore\\cake.txt"));
                category cake = new category();
                String cakeCategoryLine = cakeFile.readLine();
                String categoryName2[] = cakeCategoryLine.split(" ");
                cake.setName(categoryName2[1]);
                System.out.println("\n^^^^^^^^^" + cake.getName() + " CATEGORY" + "^^^^^^^^^");

                for (int i = 0; i < 3; i++) {
                    String line = cakeFile.readLine();
                    String words[] = line.split(" ");

                    item newitem = new item();
                    newitem.setName(words[3]);
                    newitem.setCategory(cake);
                    newitem.setBrand(words[5]);
                    newitem.setPrice(Double.parseDouble(words[7]));
                    cake.addItem(newitem);
                    addItem(newitem);
                }
                cake.displayCategoryItem();
                addCategory(cake);
                break;

            case 3:
                BufferedReader biscFile = new BufferedReader(
                        new FileReader("C:\\Users\\Dell\\Documents\\GitHub\\ToffeeStore\\biscuit.txt"));
                category biscuit = new category();
                String biscCategoryLine = biscFile.readLine();
                String categoryName3[] = biscCategoryLine.split(" ");
                biscuit.setName(categoryName3[1]);
                System.out.println("\n^^^^^^^^^" + biscuit.getName() + " CATEGORY" + "^^^^^^^^^");

                for (int i = 0; i < 3; i++) {
                    String line = biscFile.readLine();
                    String words[] = line.split(" ");

                    item newitem = new item();
                    newitem.setName(words[3]);
                    newitem.setCategory(biscuit);
                    newitem.setBrand(words[5]);
                    newitem.setPrice(Double.parseDouble(words[7]));
                    biscuit.addItem(newitem);
                    addItem(newitem);
                }
                biscuit.displayCategoryItem();
                addCategory(biscuit);
                break;

            case 4:
                BufferedReader sweetFile = new BufferedReader(
                        new FileReader("C:\\Users\\Dell\\Documents\\GitHub\\ToffeeStore\\sweet.txt"));
                category sweet = new category();
                String sweetCategoryLine = sweetFile.readLine();
                String categoryName4[] = sweetCategoryLine.split(" ");
                sweet.setName(categoryName4[1]);
                System.out.println("\n^^^^^^^^^" + sweet.getName() + " CATEGORY" + "^^^^^^^^^");

                for (int i = 0; i < 3; i++) {
                    String line = sweetFile.readLine();
                    String words[] = line.split(" ");

                    item newitem = new item();
                    newitem.setName(words[3]);
                    newitem.setCategory(sweet);
                    newitem.setBrand(words[5]);
                    newitem.setPrice(Double.parseDouble(words[7]));
                    sweet.addItem(newitem);
                    addItem(newitem);
                }
                sweet.displayCategoryItem();
                addCategory(sweet);
                break;

            default:
                System.out.println("Sorry, this category doesn't exist. ");
                break;
        }
    }
}
