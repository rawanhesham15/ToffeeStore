import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class category {

    String name;
    int i = 10;
    List<item> items = new ArrayList<item>();
    //item items[] = new item[i] ;
    int itemCounter = 0;
    String description;

    public String getName() {
        return name;
    }

    // public void readfromfile() throws IOException {

    //     BufferedReader br = new BufferedReader(
    //             new FileReader("C:\\Users\\marwa\\OneDrive\\Documents\\toffeeStore\\ToffeeStore\\chocolate.txt"));
    //     String w = br.readLine();
    //     String f[] = w.split(" ");
    //     name = f[1];
    //     System.out.println(" Category name : " + name);
    //     System.out.println("");
    //     for (String line = br.readLine(); line != null; line = br.readLine()) {

    //         String words[] = line.split(" ");
    //         if (line.contains(name)) {
    //             item newitem = new item();
    //             newitem.setName(words[3]);
    //             newitem.setCategory(this);
    //             newitem.setBrand(words[5]);
    //             newitem.setPrice(Double.parseDouble(words[7]));
    //             // newitem.displayItem();
    //             // System.out.println("");
    //             items[itemCounter] = newitem;
    //             itemCounter++;
    //             // System.out.println("counter is now " + itemCounter);
    //         }

    //     }
   // }
    public int counter()
    {
        return items.size();
    }
    public void addItem(item item)
    {
        items.add(item);
    }
    public void displayCategoryItem() throws IOException {
        //readfromfile();
        for (int i = 0; i < items.size(); i++) {
          //  System.out.println("item is supposed to be printed" + i);
            items.get(i).displayItem();

        }
    }
}
