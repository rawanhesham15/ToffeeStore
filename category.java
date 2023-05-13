import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class category {
    private String name;
    List<item> items = new ArrayList<item>();
    String description;

    public category() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int counter() {
        return items.size();
    }

    public void addItem(item item) {
        items.add(item);
    }

    public void displayCategoryItem() throws IOException {
        // readfromfile();
        System.out.println("\n^^^^^^^^^" + getName() + " CATEGORY" + "^^^^^^^^^");
        for (int i = 0; i < items.size(); i++) {
            System.out.println();
            System.out.println("Name: " + items.get(i).getName());
            System.out.println("Category: " + items.get(i).getCategory().getName());
            System.out.println("Brand: " + items.get(i).getBrand());
            System.out.println("Price: " + items.get(i).getPrice());
            System.out.println();
        }
    }
}