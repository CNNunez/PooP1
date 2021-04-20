// Imports
import java.util.*;
import java.util.LinkedList;

public class App {
    public static void main(String[] args) throws Exception {
        // Cargar la ventana correspondiente al GUI
        Ventana ventana = new Ventana();

        // Crear Menu
<<<<<<< HEAD
        Menu restaurantMenu = new Menu(ventana);
=======
        
        Menu restaurantMenu = new Menu();
>>>>>>> bbc4f83f662de33c84c3d97965ecc9a555398f3a

        // Crear lista de espera
        ClientList ListOnWating = new ClientList(ventana);

        // Crear lista de espera
        ClientList ListReadyToOrder = new ClientList(ventana);

        // Crear lista de pendientes
        ClientList ListOnPending = new ClientList(ventana);

        // Crear lista de Produccion
        ProductionList ListOnProduction = new ProductionList(ventana);
        
        // Crear el registro del restaurante
        Record restaurantRecord = new Record(ventana);

        // Cargar los datos iniciales
        new CargarDatos(restaurantMenu, ListOnWating, ventana);

        //setReferencias
        ventana.setDatos(restaurantMenu, ListOnWating, ListReadyToOrder, ListOnPending, ListOnProduction, restaurantRecord);
        new LogicaDeFuncionamiento(restaurantMenu, ListOnWating, ListReadyToOrder, ListOnPending, ListOnProduction, restaurantRecord, ventana);

        // Contro de tick
<<<<<<< HEAD
        //String OnTick = "";
        //while (OnTick.equals("")){
        //    new LogicaDeFuncionamiento(restaurantMenu, ListOnWating, ListReadyToOrder, ListOnPending, ListOnProduction, restaurantRecord);
        //    OnTick = System.console().readLine("New tick? ");
        //}
=======
        String OnTick = "";
        int cont = 0;
        while (OnTick.equals("")){
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("******************************");
            System.out.println("******************************");
            System.out.println("Tick #" + cont);
            cont = cont + 1;
            new LogicaDeFuncionamiento(restaurantMenu, ListOnWating, ListReadyToOrder, ListOnPending, ListOnProduction, restaurantRecord);
            OnTick = System.console().readLine("New tick? ");
        }
>>>>>>> bbc4f83f662de33c84c3d97965ecc9a555398f3a
        
    }
}
