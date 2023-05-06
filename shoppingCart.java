import java.util.ArrayList;
import java.util.List;

public class shoppingCart
{
    List<item> items = new ArrayList<item>();
    public void addItem(item itemadd)
    {
        items.add( itemadd);

        System.out.println("Item is added to your cart successfully");
    }

    public item getItem(String n)
    {
        for (int i = 0; i < items.size(); i++) {
            if(items.get(i).getName().equals(n))
            {
                return items.get(i);
            }
            else 
            {
                continue;
            }
        }
        return null;
        
    }

    public void displayShoppingCartItems()
    {
        for (int i = 0; i < items.size(); i++) {
            items.get(i).displayItemForCart();
    }
}
public void removeItem(String n)
    {
        for (int i = 0; i < items.size(); i++) {
            if(items.get(i).getName().equals(n))
            {
                items.remove(i);
                System.out.println("item is removed from your shopping cart successfully!");
            }
            else 
            {
                continue;
            }
        }        
    }

}