public class item {
    private String name;
    private String brand;
    private category category;
    double availablenum;
    private double price;
    String description;
    double maxQuantity;
    double orderedQuantity;
    String itemType;

    public item() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setCategory(category category) {
        this.category = category;
    }

    public category getCategory() {
        return category;
    }

    public void setAvailableNum(double amount) {
        this.availablenum = amount;
    }

    public double getAvailableNum() {
        return availablenum;
    }

    public void setDescription(String desc) {
        this.description = desc;
    }

    public String getDescription() {
        return description;

    }

    public void setPrice(double p) {
        this.price = p;
    }

    public double getPrice() {
        return price;
    }

    public void setMaxQuantity(double max) {
        this.maxQuantity = max;
    }

    public double getMaxQuantity() {
        return maxQuantity;
    }

    public void setOrderedQuantity(double quantity) {
        this.orderedQuantity = quantity;
    }

    public double getOrderedQuantity() {
        return orderedQuantity;
    }

    public void setIemType(String type) {
        itemType = type;
    }

    public String getItemType() {
        return itemType;
    }

    public void displayItem() {
        System.out.println(" Name : " + name);
        System.out.println(" Category : " + category.getName());
        System.out.println(" Brand : " + brand);
        System.out.println(" Price : " + price);
        System.out.println("");
    }

    public void displayItemForCart() {
        System.out.println(" Name : " + name);
        System.out.println(" Category : " + category.getName());
        System.out.println(" Brand : " + brand);
        System.out.println(" Ordered Quantity : " + orderedQuantity);
        System.out.println(" Unit : " + itemType);
        System.out.println(" Price : " + price);
        System.out.println("");
    }

}