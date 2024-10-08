import java.io.*;
import java.util.*;

public class Warehouse implements Serializable {
    private static final long serialVersionUID = 1L;

    private ProductList productList; 
    private ClientList clientList;  
    private static Warehouse warehouse; 

    // Private constructor for Singleton pattern
    private Warehouse() {
        productList = ProductList.instance(); 
        clientList = ClientList.instance();   
    }

    // Method to get the Singleton instance of Warehouse
    public static Warehouse instance() {
        if (warehouse == null) {
            warehouse = new Warehouse(); 
        }
        return warehouse; 
    }

    // Add a new product to the product list
    public Product addProduct(String name, String productID, double price, int quantity) {
        Product newProduct = new Product(name, productID, price, quantity); 
        if (productList.insertProduct(newProduct)) { 
            return newProduct; 
        }
        return null; 
    }

    // Add a new client to the client list
    public Client addClient(String clientID, String firstName, String lastName, String address, String phone) {
        Client newClient = new Client(clientID, firstName, lastName, address, phone); // Create a new client
        if (clientList.insertClient(newClient)) { 
            return newClient; 
        }
        return null;
    }

    // Get clients from the client list
    public Iterator<Client> getClients() {
        return clientList.getClients(); 
    }

    // Get products from the product list
    public Iterator<Product> getProducts() {
        return productList.getProducts(); 
    }

    // Add product to a client's wishlist
    public String addToWishList(String clientID, String productID, int quantity) {
        Client client = findClientById(clientID); 
        Product product = findProductById(productID); 

        // Check if both client and product exist
        if (client != null && product != null) {
            client.addToWishList(product); 
            return "Product added to wishlist.";
        }
        return "Client or Product not found."; 
    }

    // Restock a product by adding quantity
    public void restockProduct(String productID, int quantity) {
        Product product = findProductById(productID); 
        if (product != null) { 
            product.setQuantity(product.getQuantity() + quantity); 
            System.out.println("Product " + product.getName() + " restocked by " + quantity);
        } else {
            System.out.println("Product not found."); 
        }
    }

    // Helper method to find a client by their ID
    private Client findClientById(String clientID) {
        Iterator<Client> clientIterator = clientList.getClients(); 
        while (clientIterator.hasNext()) { 
            Client client = clientIterator.next(); 
            if (client.getClientID().equals(clientID)) { 
                return client; 
            }
        }
        return null; 
    }

    // Helper method to find a product by its ID
    private Product findProductById(String productID) {
        Iterator<Product> productIterator = productList.getProducts(); 
        while (productIterator.hasNext()) { 
            Product product = productIterator.next(); 
            if (product.getProductID().equals(productID)) { 
                return product;
            }
        }
        return null; 
    }

    // Save the warehouse data to file
    public static boolean save() {
        try (FileOutputStream file = new FileOutputStream("WarehouseData");
             ObjectOutputStream output = new ObjectOutputStream(file)) {
            output.writeObject(warehouse);
            return true; 
        } catch (IOException e) {
            e.printStackTrace(); 
            return false; 
        }
    }

    // Retrieve warehouse data from file
    public static Warehouse retrieve() {
        try (FileInputStream file = new FileInputStream("WarehouseData");
             ObjectInputStream input = new ObjectInputStream(file)) {
            warehouse = (Warehouse) input.readObject(); 
            return warehouse; 
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace(); 
            return null; 
        }
    }

    // Override toString method to show warehouse information
    @Override
    public String toString() {
        return "Warehouse: \n" + productList + "\n" + clientList; 
    }
}
