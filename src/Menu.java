/* 
    Class del menu que esta compuesto por productos
    Tambien tiene el metodo de anadir un nuevo plato e
    imprimir las caracteristicas de un producto
*/

// Imports
import java.util.*;


// Class
public class Menu{
    // Atributo
    private List<Product> listMenu;

    // Inicializar
    public Menu(){
        listMenu = new ArrayList<>();
    }

    // Metodos
    //                                ** Falta modificar para que no repita Products
    public void addDish(Product Dish){
        listMenu.add(Dish);
    }

    public double printMenu(){
        int cont = 0;
        for (Product Dish : listMenu){
            cont = cont + 1;
            System.out.println(cont);
            System.out.println("Tipo: " + Dish.Type);
            System.out.println("Nombre: " + Dish.Name);
            System.out.println("Precio: " + Dish.Price);
            System.out.println("Tiempo: " + Dish.Time);
            System.out.println("Tamano: " + Dish.Size);
            System.out.println("------------------------");
        }
        return 0;
    }
}