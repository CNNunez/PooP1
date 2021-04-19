import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;

public class CargarDatos {
    CargarDatos(Menu m1, ClientList cl1) throws IOException{
        System.out.println(" ");
        System.out.println(" ------  CARGANDO DATOS -----");
        
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
            System.out.println("Error no se encontro el fichero");
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
            System.out.println("Error no se encontro el fichero");
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
            System.out.println("Error no se encontro el fichero");
        }
        Gson gson3 = new Gson();
        Drink[] dr = gson3.fromJson(drinks, Drink[].class);

        for (int i = 0; i < dr.length ; i++){
            m1.add(dr[i]);
        }
        
        System.out.println(" ");

        //System.out.println(" - Generando Menu");
        //Drink d1 = new Drink("Coca",1000,"fria",200);
        //Drink d2 = new Drink("Fresa",1500,"fria",250);
        //Dish d3 = new Dish("Costillas",3000,1);
        //Dish d4 = new Dish("Pollo",2500,1);
        //Accomp d5 = new Accomp("Frijoles",500,"Salado");
        //Accomp d6 = new Accomp("Arroz",800,"Salado");
        //m1.add(d1);
        //m1.add(d2);
        //m1.add(d3);
        //m1.add(d4);
        //m1.add(d5);
        //m1.add(d6);

        
        System.out.println(" ");
        System.out.println(" - Generando Clientes");
        Client c1 = new Client("7777",2,17);
        Client c2 = new Client("8888",8,18);
        Client c3 = new Client("3333",3,13);
        
        cl1.addClient(c1);
        cl1.addClient(c2);
        cl1.addClient(c3);

        m1.print();


        System.out.println(" ");
        System.out.println(" ------  FIN DE CARGA -----");
    }
}
