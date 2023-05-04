import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class store {
    category categories[];
    item items[];

    public void viewCategories() throws IOException {
        System.out.println("choose one of the next categories to display its items: ");
        System.out.println("1. Chocolates ");
        System.out.println("2. Cakes ");
        System.out.println("3. Biscuits ");
        System.out.println("4. Sweets ");

        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        // System.out.println(choice);

        switch (choice) {
            case 1:
                BufferedReader br = new BufferedReader(
                        new FileReader(
                                "C:\\Users\\marwa\\OneDrive\\Documents\\toffeeStore\\ToffeeStore\\chocolate.txt"));
                category newcatChoco = new category();
                String ww = br.readLine();
                String ff[] = ww.split(" ");
                newcatChoco.name = ff[1];
                System.out.println(newcatChoco.getName());
                for (String line = br.readLine(); line != null; line = br.readLine()) {
                   // System.out.println(line);
                    String words[] = line.split(" ");

                    item newitem = new item();
                    newitem.setName(words[3]);
                    newitem.setCategory(newcatChoco);
                    newitem.setBrand(words[5]);
                    newitem.setPrice(Double.parseDouble(words[7]));
                    newitem.displayItem();
                
                }
                newcatChoco.displayCategoryItem();
                break;
            case 2:
                BufferedReader brcakes = new BufferedReader(
                        new FileReader("C:\\Users\\marwa\\OneDrive\\Documents\\toffeeStore\\ToffeeStore\\cake.txt"));
                        category newCatcake = new category();
                        String www = brcakes.readLine();
                        String fff[] = www.split(" ");
                        newCatcake.name = fff[1];
                        System.out.println(newCatcake.getName());
                        for (String line = brcakes.readLine(); line != null; line = brcakes.readLine()) {
                           // System.out.println(line);
                            String words[] = line.split(" ");
        
                            item newitem = new item();
                            newitem.setName(words[3]);
                            newitem.setCategory(newCatcake);
                            newitem.setBrand(words[5]);
                            newitem.setPrice(Double.parseDouble(words[7]));
                            newitem.displayItem();

                            
                            
                        }
                        newCatcake.displayCategoryItem();
                break;

            case 3:
                BufferedReader brBiscuits = new BufferedReader(
                        new FileReader("C:\\Users\\marwa\\OneDrive\\Documents\\toffeeStore\\ToffeeStore\\biscuit.txt"));

                        category newCatbiscuit = new category();
                        String wwb = brBiscuits.readLine();
                        String ffb[] = wwb.split(" ");
                        newCatbiscuit.name = ffb[1];
                        System.out.println(newCatbiscuit.getName());
                        for (String line = brBiscuits.readLine(); line != null; line = brBiscuits.readLine()) {
                           // System.out.println(line);
                            String words[] = line.split(" ");
        
                            item newitem = new item();
                            newitem.setName(words[3]);
                            newitem.setCategory(newCatbiscuit);
                            newitem.setBrand(words[5]);
                            newitem.setPrice(Double.parseDouble(words[7]));
                            newitem.displayItem();
                            
                        }
                break;

            case 4:
                BufferedReader brsweet = new BufferedReader(
                        new FileReader("C:\\Users\\marwa\\OneDrive\\Documents\\toffeeStore\\ToffeeStore\\sweet.txt"));
                        category newCatsweet = new category();
                        
                        String wws = brsweet.readLine();
                        String ffs[] = wws.split(" ");
                        newCatsweet.name = ffs[1];
                        System.out.println(newCatsweet.getName());
                        int z = 0;
                        for (String line = brsweet.readLine(); line != null; line = brsweet.readLine()) {
                           // System.out.println(line);
                            String words[] = line.split(" ");
        
                            item newitem = new item();
                            newitem.setName(words[3]);
                            newitem.setCategory(newCatsweet);
                            newitem.setBrand(words[5]);
                            newitem.setPrice(Double.parseDouble(words[7]));
                                newitem.displayItem();
                                newCatsweet.addItem(newitem);
                            
}

                break;
            default:
                System.out.println("Sorry, this category doesn't exist. ");
                break;
        }

    }
}
