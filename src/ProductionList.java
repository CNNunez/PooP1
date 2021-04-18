import java.util.*;

public class ProductionList {
    List <Production> listToProduce;
    int Capacity;

    ProductionList(){
        listToProduce = new ArrayList<>();
        Capacity = 0;
    }

    public boolean addToProduction(Menu restaurantMenu, ClientList ListOnPending){//anadir pedido a la lista de produccion
        int actualCapacity = checkCapacity();
        while (actualCapacity != 0){
            for (int i=0; i<ListOnPending.clientList.size(); i++){// tomar cada cliente de la lista de espera
                Client ClientOnPending = (ListOnPending.clientList).get(i);

                for (int j=0; j<(ClientOnPending.Order).size(); j++){// tomar la orden de cada cliente
                    String ProductName = (ClientOnPending.Order).get(i);
                    Product ProductInOrder = restaurantMenu.findProduct(ProductName);// buscar datos del producto en el menu
                    
                    if (ProductInOrder.Time <= actualCapacity){//si hay espacio en produccion
                        Production newProduction = new Production(ClientOnPending.ID, ProductInOrder);

                        // anadir nuevo producto a produccion
                        listToProduce.add(newProduction);
                        Capacity = Capacity + ProductInOrder.Time;

                        // borrar producto de la orden
                        ClientOnPending.removeFromOrder(ProductName);
                        return true;
                    }
                }
            }
        }
        return false;
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
                actualCapacity = actualCapacity - listToProduce.get(i).productToProduce.Time;
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
}
