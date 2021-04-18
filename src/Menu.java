/* 
    Class del menu que esta compuesto por productos
    Tambien tiene el metodo de anadir un nuevo producto e
    imprimir las caracteristicas de un producto
*/

// Imports
import java.util.*;


// Class
public class Menu{
    // Atributo
    public List<Product> listMenu;

    // Inicializar
    public Menu(){
        listMenu = new ArrayList<>();
    }

    // Metodos
    //                                ** Falta modificar para que no repita Products
    public void add(Product newProduct){// anade producto al menu
        listMenu.add(newProduct);
    }

    public void print(){// imprime todos los productos en el menu
        System.out.println(" ");
        System.out.println("--------MENU DEL RESTAURANTE--------");
        int cont = 0;
        for (int i=0; i<listMenu.size();i++) {
            cont = cont + 1;
            System.out.println(cont);

            if (listMenu.get(i) instanceof Drink){// imprimir Bebida
                Drink bebida = (Drink)listMenu.get(i);
                System.out.println("Nombre: " + bebida.Name);
                System.out.println(" - Precio: " + bebida.Price);
                System.out.println(" - Tiempo: " + bebida.Time);
                System.out.println(" - Tipo: " + bebida.Type);
                System.out.println(" - Tamano: " + bebida.Size);
                System.out.println(" ");
            }
            else if (listMenu.get(i) instanceof Dish){// imprimir plato fuerte
                Dish platoFuerte = (Dish)listMenu.get(i);
                System.out.println("Nombre: " + platoFuerte.Name);
                System.out.println(" - Precio: " + platoFuerte.Price);
                System.out.println(" - Tiempo: " + platoFuerte.Time);
                System.out.println(" - Tamano: " + platoFuerte.Size);
                System.out.println(" ");
            }
            else if (listMenu.get(i) instanceof Accomp){// imprimir acompanamiento
                Accomp acompanamiento = (Accomp)listMenu.get(i);
                System.out.println("Nombre: " + acompanamiento.Name);
                System.out.println(" - Precio: " + acompanamiento.Price);
                System.out.println(" - Tiempo: " + acompanamiento.Time);
                System.out.println(" - Tipo: " + acompanamiento.Type);
                System.out.println(" ");
            }
            else{
                System.out.println("ERROR: No se reconoce el tipo de producto");
            }
        }
        System.out.println("------------------------------------");
        System.out.println(" ");
    }

    public Product findProduct(String findName){// busca por nombre, un producto en el menu. y retorna ese product
        for (int i=0; i<listMenu.size(); i++){
            if ((listMenu.get(i)).Name.equalsIgnoreCase(findName)){
                return listMenu.get(i);
            }
        }
        return null;
    }
    


}
