import java.io.Serializable;

public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String productID;
    private double price;
    private int quantity;

    public Product(String name, String productID, double price, int quantity) {
        this.name = name;
        this.productID = productID;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public String getProductID() {
        return productID;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product name: " + name + ", ID: " + productID + ", Price: " + price + ", Quantity: " + quantity;
    }
}
