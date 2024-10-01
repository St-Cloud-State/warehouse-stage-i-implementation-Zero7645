
import java.util.Iterator;
import java.util.Scanner;

public class SimpleTester {
  
  public static void main(String[] s) {

    Scanner scanner = new Scanner(System.in);


    // Testing the Client class.
    System.err.println("\nStart of the tests for the functions in the Client Class\n");

    // Testing constructor
    Client client1 = new Client("TestFirst", "TestSecond", "TestAdd", "320-360-"); 

    // Displaying what was passed to the constructor
    System.err.println("\nStart of the tests for the getters and setters in the Client Class\n");

    System.out.println(client1.getFirstName() + ": should be TestFirst");
    System.out.println(client1.getLastName() + ": should be TestSecond");
    System.out.println(client1.getName() + ": should be TestFirst TestSecond");
    System.out.println(client1.getPhone() + ": should be 320-360-"); 
    System.out.println(client1.getAddress() + ": should be TestAdd"); 

    // Changing the stored values using the set functions
    client1.setFirstName("Sunder");
    client1.setLastName("Zachary");
    client1.setPhone("320-360-5570");
    client1.setAddress("17699 Gayle Dr.");

    // Displaying changed information
    System.out.println(client1.getFirstName() + ": should be Sunder");
    System.out.println(client1.getLastName() + ": should be Zachary");
    System.out.println(client1.getName() + ": should be Sunder Zachary");
    System.out.println(client1.getPhone() + ": should be 320-360-5570"); 
    System.out.println(client1.getAddress() + ": should be 17699 Gayle Dr."); 

    // Using the setName function to change both the firstName and lastName values and displaying the change
    client1.setName("Zachary", "Sunder");
    System.out.println(client1.getFirstName() + ": should be Sunder");
    System.out.println(client1.getLastName() + ": should be Zachary");
    System.out.println(client1.getName() + ": should be Zachary Sunder");


    // Client ID automatically assigned by the ClientIdServer Class starting at 1 for the first client.
    System.out.println(client1.getId() + ": should be C1");

    // User input for adding a client
    System.err.println("\nStart of the tests for user input for creating a Client Class object type\n");

    String f1 = new String();
    String l1 = new String();
    String a1 = new String();
    String p1 = new String();

    System.out.print("Enter the client's first name: ");
    f1 = scanner.nextLine();
    System.out.print("Enter the client's last name: ");
    l1 = scanner.nextLine();
    System.out.print("Enter the client's address: ");
    a1 = scanner.nextLine();
    System.out.print("Enter the client's phone number: ");
    p1 = scanner.nextLine();

    scanner.close();

    Client client2 = new Client(f1, l1, a1, p1);
    System.out.println("User created client information:\n" + client2.toString());


    // Testing the insertWishlisted and getWishlisted functions
    System.err.println("\nStart of the tests for the wishlisted function in the Client Class\n");

    Product item = new Product("Computer", "Electronic", "1");
    if (client1.insertWishlisted(item)) {
      System.out.println(item.toString() + "\nAdded to the Client's Wishlist\n");
    }

    else {
      System.out.println("\nFailed operation.\n");
    }

    Iterator allWishlisted = client1.getWishlisted();

    // Priming the loop
    System.out.println("Items in the Client's Wishlist:");
    while (allWishlisted.hasNext()) {
      Product product = (Product)(allWishlisted.next());
      System.out.println(product.toString() + "\n");
    }



    // Testing the ClientList Class
    ClientList clients;
    clients = ClientList.instance();

    System.err.println("\nStart of the tests for the ClientList Class\n");

    if(clients.insertClient(client1)) {
      System.out.println("Added the client to the ClientList.");
    }

    else {
      System.out.println("Error with adding the client to the ClientList.");
    }

    if(clients.insertClient(client2)) {
      System.out.println("Added the client to the ClientList.");
    }

    else {
      System.out.println("Error with adding the client to the ClientList.");
    }
    
    Iterator allClients = clients.getClients();

    while(allClients.hasNext()) {
      Client client = (Client)(allClients.next());
      System.out.println(client.toString() + "\n");
    }

    System.out.println("\n\nTesting:\n\n " + clients.toString());
  }

}
