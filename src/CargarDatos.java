import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.google.gson.Gson;

public class CargarDatos {
    CargarDatos(Menu m1) throws IOException{
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
    }
}
