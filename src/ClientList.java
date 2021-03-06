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
    public Ventana ventana;

    // Inicializar
    public ClientList(Ventana vent){
        clientList = new ArrayList<>();
        ventana = vent;
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
            String info = "";
            info += "Agregue una nueva orden para el cliente: " + (clientList.get(i)).ID + "\n";
            ventana.setTexto(info);
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
        String info ="";
        info += " \n";
        info += "---------LISTA DE CLIENTES---------\n";
        int cont = 0;
        for (Client clientInLine : clientList){
            cont = cont + 1;
<<<<<<< HEAD
            info += cont +"\n";
            info += "ID: " + clientInLine.ID +"\n";
            info += "Bill: " + clientInLine.Bill + "\n";
            info += "WaitingTime: " + clientInLine.waitingTime + "\n";
            info += "Patience: " + clientInLine.Patience + "\n";
            info += "Order: \n";
=======
            System.out.println(cont);
            System.out.println("ID: " + clientInLine.ID);
            System.out.println("Bill: " + clientInLine.Bill);
            System.out.println("WaitingTime: " + clientInLine.waitingTime);
            System.out.println("Patience: " + clientInLine.Patience);
            System.out.print("Order: ");
>>>>>>> bbc4f83f662de33c84c3d97965ecc9a555398f3a
            for (String dishName: clientInLine.Order){
                info += dishName + ", " + "\n";
            }
            info += "\n\n";
        }
        info +="-----------------------------------\n";
        info += " \n";
        if (info != "")
            ventana.setTexto(info);
    }

<<<<<<< HEAD
    public void  updateClientWaiting(){// disminuye en 1 el tiempo de espera y paciencia
=======
    public void updateClientWaiting(){// disminuye en 1 el tiempo de espera y paciencia
>>>>>>> bbc4f83f662de33c84c3d97965ecc9a555398f3a
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
    public ClientList checkWaitingTime(){// si tiempo de espera es 0 borra de waitingList y agrega a nueva lista
        ClientList clientsToOrder = new ClientList(ventana);
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