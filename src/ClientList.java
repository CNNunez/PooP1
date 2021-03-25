/* 
   Class del ClientList que esta compuesto por Clients
   Tambien tiene el metodo de anadir un nuevo cliente e imprimir la lista
*/

// Imports
import java.util.*;


// Class
public class ClientList{
    // Atributo
    private List<Client> Line;

    // Inicializar
    public ClientList(){
        Line = new ArrayList<>();
    }

    // Metodos
    //                                ** Falta modificar para que no repita Products
    public void addClient(Client newClient){
        Line.add(newClient);
    }

    public double printList(){
        int cont = 0;
        for (Client clientInLine : Line){
            cont = cont + 1;
            System.out.println(cont);
            System.out.println("ID: " + clientInLine.ID);
            System.out.print("Order: ");
            for (String dishName: clientInLine.Order){
                System.out.print(dishName + " ");
            }
            System.out.println(" ");
            System.out.println("------------------------");
        }
        return 0;
    }
}