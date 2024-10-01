import java.io.*;
import java.util.*;
public class Client implements Serializable {
  private static final long serialVersionUID = 1L;
  private String firstName;
  private String lastName;
  private String address;
  private String phone;
  private String id;
  private String name;
  private static final String CLIENT_STRING = "C";
  private static int idNum = 1;
  private List wishListed = new LinkedList();
  private List waitListed = new LinkedList();
  private List transactions = new LinkedList();
  public  Client (String firstName, String lastName, String address, String phone) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.address = address;
    this.phone = phone;
    id = CLIENT_STRING + (ClientIdServer.instance()).getId();
    this.name = firstName + " " + lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getName() {
    return name;
  }
  public String getPhone() {
    return phone;
  }
  public String getAddress() {
    return address;
  }
  public String getId() {
    return id;
  }

  public boolean insertWishlisted(Product product) {
    wishListed.add(product);
    return true;
  }

  public Iterator getWishlisted() {
    return wishListed.iterator();
  }

  public void setFirstName(String newFirst) {
    firstName = newFirst;
    updateName();
  }
  public void setLastName(String newLast) {
    lastName = newLast;
    updateName();
  }
  public void setName(String newFirst, String newLast) {
    firstName = newFirst;
    lastName = newLast;
    name = firstName + " " + lastName;
  }
  public void setAddress(String newAddress) {
    address = newAddress;
  }
  public void setPhone(String newPhone) {
    phone = newPhone;
  }

  public void updateName() {
    name = firstName + " " + lastName;
  }
  public boolean equals(String id) {
    return this.id.equals(id);
  }
  public String toString() {
    String string = "Id " + id + "\nClient name: " + name + "\nAddress " + address + "\nPhone " + phone;
    return string;
  }
}
