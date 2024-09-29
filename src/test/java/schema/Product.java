package schema;

public class Product {
    private String category;
    private double discount;
    private int id;
    private String name;
    private double price;

    public Product(String category, double discount, int id, String name, double price) {
        this.category = category;
        this.discount = discount;
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public double getDiscount() {
        return discount;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
