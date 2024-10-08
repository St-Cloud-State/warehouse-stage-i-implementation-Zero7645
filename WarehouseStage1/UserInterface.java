import java.util.Iterator;
import java.util.Scanner;

public class UserInterface {
    private Warehouse warehouse;
    private Scanner scanner;

    public UserInterface() {
        this.warehouse = Warehouse.instance();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\nWelcome to the Warehouse Management System");
            System.out.println("1. Add Client");
            System.out.println("2. Add Product");
            System.out.println("3. View Clients");
            System.out.println("4. View Products");
            System.out.println("5. Add Product to Wishlist");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    addClient();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    viewClients();
                    break;
                case 4:
                    viewProducts();
                    break;
                case 5:
                    addToWishlist();
                    break;
                case 6:
                    Warehouse.save();
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void addClient() {
        System.out.print("Enter Client First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter Client Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter Client Address: ");
        String address = scanner.nextLine();
        System.out.print("Enter Client Phone Number: ");
        String phone = scanner.nextLine();
        String clientID = IdServer.instance().getClientId();

        Client client = warehouse.addClient(clientID, firstName, lastName, address, phone);
        System.out.println("Client added: \n" + client);
    }

    private void addProduct() {
        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Product Price: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.print("Enter Product Quantity: ");
        int quantity = Integer.parseInt(scanner.nextLine());
        String productID = IdServer.instance().getProductId();

        Product product = warehouse.addProduct(name, productID, price, quantity);
        System.out.println("Product added: " + product);
    }

    private void viewClients() {
        Iterator<Client> clients = warehouse.getClients();
        System.out.println("\nClients:");
        while (clients.hasNext()) {
            System.out.println(clients.next());
        }
    }

    private void viewProducts() {
        Iterator<Product> products = warehouse.getProducts();
        System.out.println("\nProducts:");
        while (products.hasNext()) {
            System.out.println(products.next());
        }
    }

    private void addToWishlist() {
        System.out.print("Enter Client ID: ");
        String clientID = scanner.nextLine();
        System.out.print("Enter Product ID: ");
        String productID = scanner.nextLine();

        String message = warehouse.addToWishList(clientID, productID, 1);
        System.out.println(message);
    }

    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        ui.start();
    }
}
