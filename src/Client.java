/*
    Class de los Clientes que seran parte de la lista de produccion, espera y clientes atendidos
*/

// Imports
import java.util.*;

public class Client {
    // Atributos
    String ID;
    int waitingTime;
    int Patience;
    int Bill;
    List<String> Order;

    // Inicializar
    public Client(String clientID, int clientWaitingTime, int clientPatience){
        ID = clientID;
        waitingTime = clientWaitingTime;
        Patience = clientPatience;
        Bill = 0;
        Order = new ArrayList<>();
    }

    // Metodo
    public void addDish(String Dish){// anade nuevo producto a la orden
        Order.add(Dish);
    }

    public void addOrder(Menu restaurantMenu, String newOrder){// anade las ordenes de los clientes
        int contAnadidos = 0;                                  // newOrder en formato separado por coma
        ArrayList<String> orderList = new ArrayList<>(Arrays.asList(newOrder.split(",")));
        for (int i=0; i<orderList.size(); i++){
            if (restaurantMenu.findProduct(orderList.get(i)) != null){
                addDish(orderList.get(i));
                contAnadidos = contAnadidos + 1;
            }
        }
        if (contAnadidos != 0){
            System.out.println(" ** ERROR: Algunos productos no se encuentran en el menu. En su orden se anadieron: " + contAnadidos + " productos.");
            System.out.println(" ");
        }
    }

    public void addToBill(int newBill){// anade costo de plato ya producido a la factura
        Bill = Bill + newBill;
    }

    public void updatePatience(){// disminuye en 1 a paciencia del cliente
        Patience = Patience - 1;
    }

    public void updateWaitingTime(){// disminuye en 1 el tiempo de espera del cliente
        waitingTime = waitingTime - 1;
    }

    public void removeFromOrder(String dishToRemove){// elimina pedido de la orden
        Order.remove(dishToRemove);
    }
}
