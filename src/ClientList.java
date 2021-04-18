/* 
    Class del ClientList que esta compuesto por Clients
    Tambien tiene el metodo de anadir un nuevo cliente e imprimir la lista
*/

// Imports
import java.util.*;


// Class
public class ClientList{
    // Atributo
    public List<Client> clientList;

    // Inicializar
    public ClientList(){
        clientList = new ArrayList<>();
    }

    // Metodos
    public void addClient(Client newClient){// anade un nuevo cliente a la lista
        clientList.add(newClient);
    }

    public void addClientList(ClientList newClientList){
        while (newClientList.isEmpty() == false){
            Client ClientToAdd = newClientList.getFirst();
            addClient(ClientToAdd);
            newClientList.removeClient(ClientToAdd.ID);
        }
    }

    public void addOrdersToClients(Menu restaurantMenu){
        for (int i=0; i<clientList.size(); i++){
            System.out.println("Agregue una nueva orden para el cliente: " + (clientList.get(i)).ID);
            String newOrder = System.console().readLine();
            clientList.get(i).addOrder(restaurantMenu, newOrder);
        }
    }

    public boolean isEmpty(){// retorna true si la lista esta vacia
        return clientList.isEmpty();
    }

    public Client getFirst(){// retorna el primer cliente de la lista
        return clientList.get(0);
    }

    public void printClientList(){// imprime todos los clientes de la lista
        System.out.println(" ");
        System.out.println("---------LISTA DE CLIENTES---------");
        int cont = 0;
        for (Client clientInLine : clientList){
            cont = cont + 1;
            System.out.println(cont);
            System.out.println("ID: " + clientInLine.ID);
            System.out.println("Bill: " + clientInLine.Bill);
            System.out.print("Order: ");
            for (String dishName: clientInLine.Order){
                System.out.print(dishName + ", ");
            }
            System.out.println(" ");
            System.out.println(" ");
        }
        System.out.println("-----------------------------------");
        System.out.println(" ");
    }

    public void updateClientPatieneAndWaiting(){// disminuye en 1 el tiempo de espera y paciencia
        for (int i=0; i<clientList.size(); i++){
            clientList.get(i).updatePatience();
            clientList.get(i).updateWaitingTime();
        }
    }

    public Client removeClient(String IDToRemove){// borrar cliente de lista
        for (int i=0; i<clientList.size(); i++){
            if ((clientList.get(i)).ID.equalsIgnoreCase(IDToRemove)){
                Client removedClient = clientList.get(i);
                clientList.remove(clientList.get(i));
                return removedClient;
            }
        }
        return null;
    }
    
    public ClientList checkWaitingTime(){// si tiempo de espera es 0 borra de waitingList y agrega a nueva lista
        ClientList clientsToOrder = new ClientList();
        for (int i=0; i<clientList.size(); i++){
            if ((clientList.get(i)).waitingTime <= 0){
                clientsToOrder.addClient(clientList.get(i));
                clientList.remove(clientList.get(i));
            }
        }
        return clientsToOrder;
    }
}