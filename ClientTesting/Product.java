import java.io.*;
import java.lang.*;
public class Product implements Serializable {
  private static final long serialVersionUID = 1L;
  private String productName;
  private String productType;
  private String id;


  public Product(String productName, String productType, String id) {
    this.productName = productName;
    this.productType = productType;
    this.id = id;
  }

  public String getAuthor() {
    return productType;
  }
  public String getTitle() {
    return productName;
  }
  public String getId() {
    return id;
  }

  public String toString() {
      return "productName: " + productName + "\nproductType: " + productType + "\nid: " + id;
  }
}
