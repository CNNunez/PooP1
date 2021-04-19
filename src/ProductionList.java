// Imports
import java.util.*;

public class ProductionList {
    List <Production> listToProduce;
    int Capacity;

    ProductionList(){
        listToProduce = new ArrayList<>();
        Capacity = 0;
    }

    public void addToProduction(Menu restaurantMenu, ClientList ListOnPending){//anadir pedido a la lista de produccion
        int actualCapacity;
        
        for (int i=0; i<(ListOnPending.clientList).size(); i++){// tomar cada cliente de la lista de espera
            Client ClientOnPending = (ListOnPending.clientList).get(i);
            List<String> ClientOrderList = new ArrayList<>(ClientOnPending.Order);
            int OrderSize = ClientOrderList.size();

            for (int j=0; j<OrderSize; j++){// tomar la orden de cada cliente
                String ProductName = ClientOrderList.get(j);
                Product ProductInOrder = restaurantMenu.findProduct(ProductName);// buscar datos del producto en el menu
                actualCapacity = checkCapacity();
                
                if (ProductInOrder.Time <= actualCapacity){//si hay espacio en produccion
                    Production newProduction = new Production(ClientOnPending.ID, ProductInOrder);

                    // anadir nuevo producto a produccion
                    listToProduce.add(newProduction);
                    Capacity = Capacity + ProductInOrder.Time;

                    // borrar producto de la orden
                    ClientOnPending.removeFromOrder(ProductName);
                }
            }
        }
    }

    public boolean isEmpty(){// retorna true si la lista esta vacia
        return listToProduce.isEmpty();
    }
    /*
    public Production getFirst(){
        return listToProduce.get(0);
    }
    */

    public int checkCapacity(){// retorna la cantidad de espacio en produccion que hay disponible
        int actualCapacity = 10;
        if (listToProduce == null){
            return actualCapacity;
        }else{
            for (int i=0; i<listToProduce.size(); i++){
                actualCapacity = actualCapacity - ((listToProduce.get(i)).productToProduce).Time;
            }
            return actualCapacity;
        }
    }

    public void printProductionList(){// imprime todos los clientes de la lista
        System.out.println(" ");
        System.out.println("---------ORDENES EN PRODUCCION---------");
        int cont = 0;
        for (Production orderInLine : listToProduce){
            cont = cont + 1;
            System.out.println(cont);
            System.out.println("ID: " + orderInLine.clientID);
            System.out.println("Nombre de la orden: " + (orderInLine.productToProduce).Name);
            System.out.println("Completitud: " + orderInLine.completeness + " de " + (orderInLine.productToProduce).Time);
            System.out.println(" ");
            System.out.println(" ");
        }
        System.out.println("---------------------------------------");
        System.out.println(" ");
    }

    public void updateCompleteness(ClientList ListOnPending){
        List <Production> listOfProductsDone = new ArrayList<>();
        for (int i=0; i<listToProduce.size(); i++){
            (listToProduce.get(i)).completeness = (listToProduce.get(i)).completeness + 1;

            // Verificar si producto se ha completado
            if ((listToProduce.get(i)).completeness == ((listToProduce.get(i)).productToProduce).Time){
                String IDToFind = (listToProduce.get(i)).clientID;
                int CostToAddToBill = ((listToProduce.get(i)).productToProduce).Price;

                // Buscar cliente en lista de pendientes
                Client ClientFound = ListOnPending.findClient(IDToFind);

                // Add product to bill
                ClientFound.addToBill(CostToAddToBill);

                // anadir producto a la lista de productos terminados
                listOfProductsDone.add(listToProduce.get(i));

            }
        }
        // eliminar producto de la lista de produccion
        for (int i=0; i<listOfProductsDone.size(); i++){
            listToProduce.remove(listOfProductsDone.get(i));
        }
    }
}
