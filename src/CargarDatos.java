public class CargarDatos {
    CargarDatos(Menu m1, ClientList cl1){
        System.out.println(" ");
        System.out.println(" ------  CARGANDO DATOS -----");
        
        System.out.println(" ");
        System.out.println(" - Generando Menu");
        Drink d1 = new Drink("Coca",1000,"fria",200);
        Drink d2 = new Drink("Fresa",1500,"fria",250);
        Dish d3 = new Dish("Costillas",3000,1);
        Dish d4 = new Dish("Pollo",2500,1);
        Accomp d5 = new Accomp("Frijoles",500,"Salado");
        Accomp d6 = new Accomp("Arroz",800,"Salado");
        m1.add(d1);
        m1.add(d2);
        m1.add(d3);
        m1.add(d4);
        m1.add(d5);
        m1.add(d6);

        
        System.out.println(" ");
        System.out.println(" - Generando Clientes");
        Client c1 = new Client("7777",2,17);
        Client c2 = new Client("8888",8,18);
        Client c3 = new Client("3333",3,13);
        
        cl1.addClient(c1);
        cl1.addClient(c2);
        cl1.addClient(c3);


        System.out.println(" ");
        System.out.println(" ------  FIN DE CARGA -----");
    }
}
