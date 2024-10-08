import java.io.Serializable;
import java.util.*;

public class Client implements Serializable {
    private static final long serialVersionUID = 1L;
    private String clientID;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private List<Product> wishList = new LinkedList<>();  
    private List waitListed = new LinkedList();
    private List transactions = new LinkedList();

    public Client(String clientID, String firstName, String lastName, String address, String phone) {
        this.clientID = clientID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
    }

    public String getClientID() {
        return clientID;
    }

    public String getfirstName() {
        return firstName;
    }

    public String getlastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public void addToWishList(Product product) {
        wishList.add(product);
    }

    public List<Product> getWishList() {
        return wishList;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    @Override
    public String toString() {
        return "\tClient's name: " + firstName + " " + lastName + ", ID: " + clientID + ", Address: " + address + ", Phone Number: " + phone;
    }
}
