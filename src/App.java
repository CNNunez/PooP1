// Imports
import java.util.*;
import java.util.LinkedList;

public class App {
    public static void main(String[] args) throws Exception {
        // Crear Menu
        Menu restaurantMenu = new Menu();

        // Crear lista de espera
        ClientList ListOnWating = new ClientList();

        // Crear lista de espera
        ClientList ListReadyToOrder = new ClientList();

        // Crear lista de pendientes
        ClientList ListOnPending = new ClientList();

        // Crear lista de Produccion
        ProductionList ListOnProduction = new ProductionList();
        

        // Cargar los datos iniciales
        new CargarDatos(restaurantMenu, ListOnWating);

        // Contro de tick
        String OnTick = "";
        while (OnTick.equals("")){
            new LogicaDeFuncionamiento(restaurantMenu, ListOnWating, ListReadyToOrder, ListOnPending, ListOnProduction);
            OnTick = System.console().readLine("New tick? ");
        }
        
    }
}
