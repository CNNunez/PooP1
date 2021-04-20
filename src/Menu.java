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
    public Ventana ventana;

    // Inicializar
    public Menu(Ventana vent){
        listMenu = new ArrayList<>();
        ventana = vent;
    }

    // Metodos
    //                                ** Falta modificar para que no repita Products
    public void add(Product newProduct){// anade producto al menu
        listMenu.add(newProduct);
    }

    public void print(){// imprime todos los productos en el menu
        String info = ""; 
        info += " \n";
        info += "--------MENU DEL RESTAURANTE--------\n";
        int cont = 0;
        for (int i=0; i<listMenu.size();i++) {
            cont = cont + 1;
            info += cont + "\n";

            if (listMenu.get(i) instanceof Drink){// imprimir Bebida
                Drink bebida = (Drink)listMenu.get(i);
                info += "Nombre: " + bebida.Name +"\n";
                info += " - Precio: " + bebida.Price + "\n";
                info += " - Tiempo: " + bebida.Time + "\n";
                info += " - Tipo: " + bebida.Type + "\n";
                info += " - Tamano: " + bebida.Size + "\n";
                info += " \n";
            }
            else if (listMenu.get(i) instanceof Dish){// imprimir plato fuerte
                Dish platoFuerte = (Dish)listMenu.get(i);
                info += "Nombre: " + platoFuerte.Name + "\n";
                info += " - Precio: " + platoFuerte.Price + "\n";
                info += " - Tiempo: " + platoFuerte.Time + "\n";
                info += " - Tamano: " + platoFuerte.Size + "\n";
                info += " \n";
            }
            else if (listMenu.get(i) instanceof Accomp){// imprimir acompanamiento
                Accomp acompanamiento = (Accomp)listMenu.get(i);
                info += "Nombre: " + acompanamiento.Name + "\n";
                info += " - Precio: " + acompanamiento.Price + "\n";
                info += " - Tiempo: " + acompanamiento.Time + "\n";
                info += " - Tipo: " + acompanamiento.Type + "\n";
                info += " \n";
            }
            else{
                System.out.println("ERROR: No se reconoce el tipo de producto");
            }
        }
        info += "------------------------------------\n";
        info += " \n";
        if (info != "")
            ventana.setTexto(info);
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
