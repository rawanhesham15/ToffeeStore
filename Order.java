import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private String orderID;
    private Date orderDate;
    private List<item> items = new ArrayList<item>();
    private static long idCounter = 0;

    public Order() {
        orderID = String.valueOf(idCounter++);
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderDate(Date date) {
        this.orderDate = date;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void addItems(List<item> orderItems) {
        for (int i = 0; i < orderItems.size(); i++) {
            items.add(orderItems.get(i));
        }
    }

    public List<item> getItems() {
        return items;
    }
}
