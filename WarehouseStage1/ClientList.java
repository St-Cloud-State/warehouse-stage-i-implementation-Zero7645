import java.io.*;
import java.util.*;

public class ClientList implements Serializable {
    private static final long serialVersionUID = 1L;
    private List<Client> clients = new LinkedList<>();
    private static ClientList clientList;

    private ClientList() {}

    public static ClientList instance() {
        if (clientList == null) {
            clientList = new ClientList();
        }
        return clientList;
    }

    public boolean insertClient(Client client) {
        clients.add(client);
        return true;
    }

    public Iterator<Client> getClients() {
        return clients.iterator();
    }

    private void writeObject(ObjectOutputStream output) throws IOException {
        output.defaultWriteObject();
        output.writeObject(clientList);
    }

    private void readObject(ObjectInputStream input) throws IOException, ClassNotFoundException {
        input.defaultReadObject();
        clientList = (ClientList) input.readObject();
    }

    @Override
    public String toString() {
        return clients.toString();
    }
}
