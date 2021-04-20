/* 
    Class del menu que esta compuesto por productos
    Tambien tiene el metodo de anadir un nuevo producto e
    imprimir las caracteristicas de un producto
*/

// Imports
import java.util.*;
import javax.swing.JTextArea;


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

    public void print(JTextArea textAreaMenu){// imprime todos los productos en el menu
        System.out.println(" ");
        System.out.println("--------MENU DEL RESTAURANTE--------");
        int cont = 0;
        textAreaMenu.setText("");
        for (int i=0; i<listMenu.size();i++) {
            cont = cont + 1;
            System.out.println(cont);
            textAreaMenu.append(""+cont + "\n\r");

            if (listMenu.get(i) instanceof Drink){// imprimir Bebida
                Drink bebida = (Drink)listMenu.get(i);
                System.out.println("Nombre: " + bebida.Name);
                System.out.println(" - Precio: " + bebida.Price);
                System.out.println(" - Tiempo: " + bebida.Time);
                System.out.println(" - Tipo: " + bebida.Type);
                System.out.println(" - Tamano: " + bebida.Size);
                System.out.println(" ");
                
                textAreaMenu.append("Nombre: " + bebida.Name + "\n\r");
                textAreaMenu.append(" - Precio: " + bebida.Price + "\n\r");
                textAreaMenu.append(" - Tiempo: " + bebida.Time + "\n\r");
                textAreaMenu.append(" - Tipo: " + bebida.Type + "\n\r");
                textAreaMenu.append(" - Tamano: " + bebida.Size + "\n\r");
                textAreaMenu.append(" " + "\n\r");
            }
            else if (listMenu.get(i) instanceof Dish){// imprimir plato fuerte
                Dish platoFuerte = (Dish)listMenu.get(i);
                System.out.println("Nombre: " + platoFuerte.Name);
                System.out.println(" - Precio: " + platoFuerte.Price);
                System.out.println(" - Tiempo: " + platoFuerte.Time);
                System.out.println(" - Tamano: " + platoFuerte.Size);
                System.out.println(" ");

                textAreaMenu.append("Nombre: " + platoFuerte.Name + "\n\r");
                textAreaMenu.append(" - Precio: " + platoFuerte.Price + "\n\r");
                textAreaMenu.append(" - Tiempo: " + platoFuerte.Time + "\n\r");
                textAreaMenu.append(" - Tamano: " + platoFuerte.Size + "\n\r");
                textAreaMenu.append(" " + "\n\r");
            }
            else if (listMenu.get(i) instanceof Accomp){// imprimir acompanamiento
                Accomp acompanamiento = (Accomp)listMenu.get(i);
                System.out.println("Nombre: " + acompanamiento.Name);
                System.out.println(" - Precio: " + acompanamiento.Price);
                System.out.println(" - Tiempo: " + acompanamiento.Time);
                System.out.println(" - Tipo: " + acompanamiento.Type);
                System.out.println(" ");

                textAreaMenu.append("Nombre: " + acompanamiento.Name + "\n\r");
                textAreaMenu.append(" - Precio: " + acompanamiento.Price + "\n\r");
                textAreaMenu.append(" - Tiempo: " + acompanamiento.Time + "\n\r");
                textAreaMenu.append(" - Tipo: " + acompanamiento.Type + "\n\r");
                textAreaMenu.append(" " + "\n\r");
            }
            else{
                System.out.println("ERROR: No se reconoce el tipo de producto");
                textAreaMenu.append("ERROR: No se reconoce el tipo de producto" + "\n\r");
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
