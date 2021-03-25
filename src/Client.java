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
    public void addDish(String Dish){
        Order.add(Dish);
    }
}
