import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;

public class CargarDatos {
    CargarDatos(Menu m1, ClientList cl1, Ventana ventana) throws IOException{
        String info = "";
        info +=" \n";
        info +=" ------  CARGANDO DATOS -----\n";
        
        String acomps = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader("src/acomp.json"));
            String linea = "";
            while ((linea = br.readLine()) != null){
                acomps += linea;
            }
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }catch(FileNotFoundException ex){
            info += "Error no se encontro el fichero\n";
        }
        Gson gson = new Gson();
        Accomp[] a = gson.fromJson(acomps, Accomp[].class);

        for (int i = 0; i < a.length ; i++){
            m1.add(a[i]);
        }

        String dish = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader("src/dish.json"));
            String linea = "";
            while ((linea = br.readLine()) != null){
                dish += linea;
            }
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }catch(FileNotFoundException ex){
            info += "Error no se encontro el fichero\n)";
        }
        Gson gson2 = new Gson();
        Dish[] di = gson2.fromJson(dish, Dish[].class);

        for (int i = 0; i < di.length ; i++){
            m1.add(di[i]);
        }
        
        String drinks = "";
        try{
            BufferedReader br = new BufferedReader(new FileReader("src/drink.json"));
            String linea = "";
            while ((linea = br.readLine()) != null){
                drinks += linea;
            }
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }catch(FileNotFoundException ex){
            info += "Error no se encontro el fichero\n";
        }
        Gson gson3 = new Gson();
        Drink[] dr = gson3.fromJson(drinks, Drink[].class);

        for (int i = 0; i < dr.length ; i++){
            m1.add(dr[i]);
        }

<<<<<<< HEAD
        info += " \n";
        info += " - Generando Clientes\n";
        Client c1 = new Client("7777",2,100,ventana);
        Client c2 = new Client("8888",5,3,ventana);
        Client c3 = new Client("3333",3,100,ventana);
=======
        
        System.out.println(" ");
        System.out.println(" - Generando Clientes");
        Client c1 = new Client("7777",2,100);
        Client c2 = new Client("8888",5,3);
        Client c3 = new Client("3333",3,100);
>>>>>>> bbc4f83f662de33c84c3d97965ecc9a555398f3a
        
        cl1.addClient(c1);
        cl1.addClient(c2);
        cl1.addClient(c3);

        info += " \n";
        info += " ------  FIN DE CARGA -----\n";
        if (info != "")
            ventana.setTexto(info);
    }
}
