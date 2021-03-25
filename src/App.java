public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(" ");
        System.out.println(" ------  INICIO DE PRUEBA -----");

        System.out.println(" ");
        System.out.println(" ... Generando Productos");
        Product d1 = new Product("B","Coca",1,2,3);
        Product d2 = new Product("P","Costillas",1,2,3);
        Product d3 = new Product("A","Arroz",1,2,3);


        System.out.println(" ");
        System.out.println(" ... Generando Menu");
        Menu m1 = new Menu();
        m1.addDish(d1);
        m1.addDish(d2);
        m1.addDish(d3);
        m1.printMenu();


        System.out.println(" ");
        System.out.println(" ... Generando Clientes");
        Client c1 = new Client("7777",77,17);
        Client c2 = new Client("8888",88,18);
        Client c3 = new Client("3333",33,13);


        System.out.println(" ");
        System.out.println(" ... Generando WaitingList");
        ClientList cl1 = new ClientList();


        System.out.println(" ");
        System.out.println(" ... Anadiendo clientes al WaitingList");
        cl1.addClient(c1);
        cl1.addClient(c2);
        cl1.addClient(c3);


        System.out.println(" ");
        System.out.println(" ... Anadiendo la Orden a cada cliente");
        c1.addDish("Coca");
        c1.addDish("Pasta");
        c2.addDish("Lentejas");
        c2.addDish("Colita");
        c2.addDish("Papas");
        c3.addDish("Sopa");
        c3.addDish("Helado");

        System.out.println(" ");
        System.out.println(" ... Imprimiendo la WaitingList");
        cl1.printList();


        System.out.println(" ");
        System.out.println(" ------  FIN DE PRUEBA -----");
    }
}
