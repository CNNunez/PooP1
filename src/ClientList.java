/* 
    Class del ClientList que esta compuesto por Clients
    Tambien tiene el metodo de anadir un nuevo cliente e imprimir la lista
*/

// Imports
import java.util.*;
import javax.swing.JTextArea;


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

    public void printClientList(JTextArea textAreaClientList){// imprime todos los clientes de la lista
        System.out.println(" ");
        System.out.println("---------LISTA DE CLIENTES---------");
        int cont = 0;
        textAreaClientList.setText("");
        for (Client clientInLine : clientList){
            cont = cont + 1;
            System.out.println(cont);
            System.out.println("ID: " + clientInLine.ID);
            System.out.println("Bill: " + clientInLine.Bill);
            System.out.println("WaitingTime: " + clientInLine.waitingTime);
            System.out.println("Patience: " + clientInLine.Patience);
            System.out.print("Order: ");
            for (String dishName: clientInLine.Order){
                System.out.print(dishName + ", ");
            }
            System.out.println(" ");
            System.out.println(" ");

            textAreaClientList.append("" + cont + "\n\r");
            textAreaClientList.append("ID: " + clientInLine.ID + "\n\r");
            textAreaClientList.append("Bill: " + clientInLine.Bill + "\n\r");
            textAreaClientList.append("WaitingTime: " + clientInLine.waitingTime + "\n\r");
            textAreaClientList.append("Patience: " + clientInLine.Patience + "\n\r");
            textAreaClientList.append("Order: ");
            for (String dishName: clientInLine.Order){
                textAreaClientList.append(dishName + ", ");
            }
            textAreaClientList.append(" " + "\n\r");
            textAreaClientList.append(" " + "\n\r");
        }
        System.out.println("-----------------------------------");
        System.out.println(" ");
    }

    public void updateClientWaiting(){// disminuye en 1 el tiempo de espera y paciencia
        for (int i=0; i<clientList.size(); i++){
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

    public void updateClientPatience(ProductionList ListOnProduction, Record restaurantRecord){// si tiempo de espera es 0 borra de waitingList y agrega a nueva lista
        List<Client> ClientsOnPending = new ArrayList<>(clientList);
        for (int i=0; i<ClientsOnPending.size(); i++){
            clientList.get(i).updatePatience();
            if ((ClientsOnPending.get(i)).Patience <= 0){
                restaurantRecord.updateRecord(0, 1);// add unsatisfed client to record
                String IDToRemove = (ClientsOnPending.get(i)).ID;
                clientList.remove(ClientsOnPending.get(i)); // remover cliente de lista de pendiente

                List <Production> OrdersOnProduction = new ArrayList<>(ListOnProduction.listToProduce);
                for (int j=0; j<OrdersOnProduction.size(); j++){// remover orden de lista de produccion
                    if ((OrdersOnProduction.get(j)).clientID.equalsIgnoreCase(IDToRemove)){
                        (ListOnProduction.listToProduce).remove(OrdersOnProduction.get(j));
                    }
                }
            }
        }
    }

    public Client findClient(String findID){// busca por nombre, un producto en el menu. y retorna ese product
        for (int i=0; i<clientList.size(); i++){
            if ((clientList.get(i)).ID.equalsIgnoreCase(findID)){
                return clientList.get(i);
            }
        }
        return null;
    }

    public void updateCompleteness(ProductionList ListOnProduction, Record restaurantRecord){
        for (int i=0; i<clientList.size(); i++){
            if ((clientList.get(i)).Order.isEmpty()){
                boolean found = false;
                for (int j=0; j<(ListOnProduction.listToProduce).size(); j++){
                    if (((ListOnProduction.listToProduce).get(j)).clientID.equals((clientList.get(i)).ID)){
                        found = true;
                    }
                }
                if (found == false){
                    int totalBill = (clientList.get(i)).Bill;
                    restaurantRecord.updateRecord(totalBill, 0);
                    clientList.remove(clientList.get(i));
                }
            }
        }
    }
}