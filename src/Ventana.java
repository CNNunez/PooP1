// Imports
import javax.swing.border.Border;

import java.awt.BorderLayout;

import javax.swing.plaf.DimensionUIResource;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Ventana extends JFrame implements ActionListener{
    int contTicks;
    int contAddOrder;

    // Labels
    JLabel titleMenu;
    JLabel titleOnWaiting;
    JLabel titleReadyToOrder;
    JLabel titleOnPending;
    JLabel titleOnProduction;
    JLabel titleRecord;
    JLabel titleAddOrder;
    JLabel toWhomAddOrder;
    JLabel ejAddOrder;
    JLabel noteAddOrder;
    JLabel titleAddClient;
    JLabel labelID;
    JLabel labelWaitingTime;
    JLabel labelPatience;
    JLabel noteAddClient;


    // Buttons
    JButton buttonTick;
    JButton buttonAddOrder;
    JButton buttonAddClient;

    // Panels
    JScrollPane panelMenu;
    JScrollPane panelOnWaiting;
    JScrollPane panelReadyToOrder;
    JScrollPane panelOnPending;
    JScrollPane panelOnProduction;
    JScrollPane panelRecord;

    // Text Areas
    JTextArea textAreaMenu;
    JTextArea textAreaOnWaiting;
    JTextArea textAreaReadyToOrder;
    JTextArea textAreaOnPending;
    JTextArea textAreaOnProduction;
    JTextArea textAreaRecord;

    // textField
    JTextField textFielNewOrder;
    JTextField textFielTickNumber;
    JTextField textFieldID;
    JTextField textFieldWaitingTime;
    JTextField textFieldPatience;

    // Variables para generar listas
    // Crear Menu
    Menu restaurantMenu;
    ClientList ListOnWating;
    ClientList ListReadyToOrder;
    ClientList ListOnPending;
    ProductionList ListOnProduction;
    Record restaurantRecord;
    CargarDatos newCarga;

    // Constructor
    public Ventana(){
        super("Restaurant Window"); // para ponerle titulo
        // Detalles de ventana
        int width = 1350;
        int height = 500;
        contTicks = 0;
        contAddOrder = 0;

        // Crear ventana
        //JFrame ventana = new JFrame(nombreVentana);
        this.setPreferredSize(new DimensionUIResource(width, height));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Llenar la ventana
        agregarComponentes();

        // Acomoda el tamano y ver la ventana
        this.pack();
        this.setVisible(true);

        // Generar listas
        // Crear Menu
        restaurantMenu = new Menu();

        // Crear lista de espera
        ListOnWating = new ClientList();

        // Crear lista de espera
        ListReadyToOrder = new ClientList();

        // Crear lista de pendientes
        ListOnPending = new ClientList();

        // Crear lista de Produccion
        ListOnProduction = new ProductionList();
        
        // Crear el registro del restaurante
        restaurantRecord = new Record();

        // Cargar los datos iniciales
        CargarDatosNuevos();
    }

    public void CargarDatosNuevos(){
        try{
            newCarga = new CargarDatos(restaurantMenu);
        } catch(java.io.IOException e){
            System.out.println("IOException something failed:" + e);
        }
        printMenu(restaurantMenu);
    }


    private void agregarComponentes(){
        this.setLayout(null);

        //--------------------------------------------------------------------- text area de Menu
        titleMenu = new JLabel("Menu del restaurante: ");
        titleMenu.setBounds(20,20,200,25);//.setBounds(x, y, width, height)
        this.add(titleMenu);

        textAreaMenu = new JTextArea();
        panelMenu = new JScrollPane(textAreaMenu);
        panelMenu.setBounds(20,50,200,400);//.setBounds(x, y, width, height)
        this.add(panelMenu);


        //--------------------------------------------------------------------- text area de OnWaiting
        titleOnWaiting = new JLabel("Lista clientes en espera: ");
        titleOnWaiting.setBounds(40+200,20,200,25);//.setBounds(x, y, width, height)
        this.add(titleOnWaiting);

        textAreaOnWaiting = new JTextArea();
        panelOnWaiting = new JScrollPane(textAreaOnWaiting);
        panelOnWaiting.setBounds(40+200,50,200,250);//.setBounds(x, y, width, height)
        this.add(panelOnWaiting);


        //--------------------------------------------------------------------- set AddClient
        titleAddClient = new JLabel("ANADIR NUEVA CLIENTE ");
        titleAddClient.setBounds(40+(20+200),300,200,25);//.setBounds(x, y, width, height)
        this.add(titleAddClient);

        labelID = new JLabel("ID");
        labelID.setFont(new Font("TimesRoman",Font.BOLD,12));
        labelID.setBounds(20+(20+200),325,25,25);//.setBounds(x, y, width, height)
        this.add(labelID);

        textFieldID = new JTextField();
        textFieldID.setBounds(50+(20+200),325,170,20);//.setBounds(x, y, width, height)
        this.add(textFieldID);

        labelWaitingTime = new JLabel("Waiting");
        labelWaitingTime.setFont(new Font("TimesRoman",Font.BOLD,12));
        labelWaitingTime.setBounds(20+(20+200),350,60,25);//.setBounds(x, y, width, height)
        this.add(labelWaitingTime);

        textFieldWaitingTime = new JTextField();
        textFieldWaitingTime.setBounds(90+(20+200),350,130,20);//.setBounds(x, y, width, height)
        this.add(textFieldWaitingTime);

        labelPatience = new JLabel("Patience");
        labelPatience.setFont(new Font("TimesRoman",Font.BOLD,12));
        labelPatience.setBounds(20+(20+200),375,60,25);//.setBounds(x, y, width, height)
        this.add(labelPatience);

        textFieldPatience = new JTextField();
        textFieldPatience.setBounds(90+(20+200),375,130,20);//.setBounds(x, y, width, height)
        this.add(textFieldPatience);

        noteAddClient = new JLabel("");
        noteAddClient.setForeground(new Color(255,0,0));
        noteAddClient.setFont(new Font("TimesRoman",Font.BOLD,9));
        noteAddClient.setBounds(20+(20+200),400,200,25);//.setBounds(x, y, width, height)
        this.add(noteAddClient);

        buttonAddClient = new JButton("Anadir Cliente");
        buttonAddClient.setBounds(20+(20+200),425,200,25);//.setBounds(x, y, width, height)
        this.add(buttonAddClient);

        buttonAddClient.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                // Obtener datos
                String newID = textFieldID.getText();
                String strWaitingTime = textFieldWaitingTime.getText();
                String strPatience = textFieldPatience.getText();
                if ((newID.equals(""))||(strWaitingTime.equals(""))){
                    noteAddClient.setText("Debe agregar un ID y tiempo de espera");
                }else{
                    if (strPatience.equals("")){
                        strPatience = "1000";
                    }
                    int newWaitingTime = Integer.parseInt(strWaitingTime);
                    int newPatience = Integer.parseInt(strPatience);
                    Client newClient = new Client(newID, newWaitingTime, newPatience);
                    ListOnWating.addClient(newClient);
                    noteAddClient.setText("Cliente agregardo satisfactoriamente");
                    ListOnWating.printClientList(textAreaOnWaiting);
                }
            }
        });


        //--------------------------------------------------------------------- text area de ReadyToOrder
        titleReadyToOrder = new JLabel("Clientes ReadyToOrder: ");
        titleReadyToOrder.setBounds(20+(20+200)*2,20,200,25);//.setBounds(x, y, width, height)
        this.add(titleReadyToOrder);

        textAreaReadyToOrder = new JTextArea();
        panelReadyToOrder = new JScrollPane(textAreaReadyToOrder);
        panelReadyToOrder.setBounds(20+(20+200)*2,50,200,250);//.setBounds(x, y, width, height)
        this.add(panelReadyToOrder);


        //--------------------------------------------------------------------- set AddOrder
        titleAddOrder = new JLabel("ANADIR NUEVA ORDEN ");
        titleAddOrder.setBounds(40+(20+200)*2,300,200,25);//.setBounds(x, y, width, height)
        this.add(titleAddOrder);

        toWhomAddOrder = new JLabel("A primer cliente sin orden: ");
        toWhomAddOrder.setFont(new Font("TimesRoman",Font.BOLD,10));
        toWhomAddOrder.setBounds(20+(20+200)*2,325,200,25);//.setBounds(x, y, width, height)
        this.add(toWhomAddOrder);

        textFielNewOrder = new JTextField();
        textFielNewOrder.setBounds(20+(20+200)*2,350,200,30);//.setBounds(x, y, width, height)
        this.add(textFielNewOrder);

        ejAddOrder = new JLabel("Ej: Costillas,Coca,Arroz,Ensalada");
        ejAddOrder.setForeground(new Color(157,157,157));
        ejAddOrder.setBounds(20+(20+200)*2,380,200,25);//.setBounds(x, y, width, height)
        this.add(ejAddOrder);

        noteAddOrder = new JLabel(" ");
        noteAddOrder.setForeground(new Color(255,0,0));
        noteAddOrder.setFont(new Font("TimesRoman",Font.BOLD,9));
        noteAddOrder.setBounds(20+(20+200)*2,400,200,25);//.setBounds(x, y, width, height)
        this.add(noteAddOrder);

        buttonAddOrder = new JButton("Anadir Orden");
        buttonAddOrder.setBounds(20+(20+200)*2,425,200,25);//.setBounds(x, y, width, height)
        this.add(buttonAddOrder);

        buttonAddOrder.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                // verificar si hay clientes listos para hacer su orden
                if ((ListReadyToOrder.isEmpty()==false)&&(contAddOrder<(ListReadyToOrder.clientList).size())){
                    String newOrder = textFielNewOrder.getText();
                    if (newOrder.equals("")==false){
                        (ListReadyToOrder.clientList).get(contAddOrder).addOrder(restaurantMenu, newOrder);
                        // Imprimir clientes con ordenes
                        ListReadyToOrder.printClientList(textAreaReadyToOrder);
                        // Agregar pedidos y clientes a la lista de pendientes
                        ListOnPending.addClient((ListReadyToOrder.clientList).get(contAddOrder));
                        ListOnPending.printClientList(textAreaOnPending);
                        noteAddOrder.setText("Orden anadida correctamente");
                        contAddOrder = contAddOrder + 1;
                    }else{
                        noteAddOrder.setText("Debe agregar una orden");
                    }
                }else{
                    noteAddOrder.setText("No hay clientes listos para ordenar");
                }
            }
        });


        //--------------------------------------------------------------------- text area de OnPending
        titleOnPending = new JLabel("Ordenes en espera: ");
        titleOnPending.setBounds(20+(20+200)*3,20,200,25);//.setBounds(x, y, width, height)
        this.add(titleOnPending);

        textAreaOnPending = new JTextArea();
        panelOnPending = new JScrollPane(textAreaOnPending);
        panelOnPending.setBounds(20+(20+200)*3,50,200,400);//.setBounds(x, y, width, height)
        this.add(panelOnPending);


        //--------------------------------------------------------------------- text area de OnProduction
        titleOnProduction = new JLabel("Ordenes en produccion: ");
        titleOnProduction.setBounds(20+(20+200)*4,20,200,25);//.setBounds(x, y, width, height)
        this.add(titleOnProduction);

        textAreaOnProduction = new JTextArea();
        panelOnProduction = new JScrollPane(textAreaOnProduction);
        panelOnProduction.setBounds(20+(20+200)*4,50,200,400);//.setBounds(x, y, width, height)
        this.add(panelOnProduction);


        //--------------------------------------------------------------------- set boton next tick
        buttonTick = new JButton("Next Tick");
        buttonTick.setBounds(1120, 50, 200, 40);
        this.add(buttonTick);
        buttonTick.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                contAddOrder = 0;
                toWhomAddOrder = new JLabel("To client ID: ");
                noteAddOrder.setText(" ");
                contTicks = contTicks + 1;
                textFielTickNumber.setText(""+contTicks);
                LogicaDeFuncionamiento();
            }
        });

        textFielTickNumber = new JTextField();
        textFielTickNumber.setFont(new Font("Courier", Font.BOLD,40));
        textFielTickNumber.setBounds(50+20+(20+200)*5,100,100,50);//.setBounds(x, y, width, height)
        this.add(textFielTickNumber);


        //--------------------------------------------------------------------- text area de Record
        titleRecord = new JLabel("Registo: ");
        titleRecord.setBounds(20+(20+200)*5,200,200,25);//.setBounds(x, y, width, height)
        this.add(titleRecord);

        textAreaRecord = new JTextArea();
        panelRecord = new JScrollPane(textAreaRecord);
        panelRecord.setBounds(20+(20+200)*5,230,200,220);//.setBounds(x, y, width, height)
        this.add(panelRecord);

    }

    public void printMenu(Menu restaurantMenu){
        restaurantMenu.print(textAreaMenu);
    }

    public void LogicaDeFuncionamiento(){
        // verificar si hay clientes listos para hacer su orden
        ListReadyToOrder = ListOnWating.checkWaitingTime();
        ListReadyToOrder.printClientList(textAreaReadyToOrder);
        
        // verificar si hay espacio en produccion
        if (ListOnPending.isEmpty() == false){
            System.out.println("Hay pedidos pendientes");
            ListOnProduction.addToProduction(restaurantMenu, ListOnPending);
        }else{
            System.out.println("No hay pedidos pendientes");
        }

        // Print listas
        System.out.println("-------------------------------------- ListOnWating");
        ListOnWating.printClientList(textAreaOnWaiting);

        System.out.println("-------------------------------------- ListOnPending ");
        ListOnPending.printClientList(textAreaOnPending);

        System.out.println("-------------------------------------- ListOnProduction ");
        ListOnProduction.printProductionList(textAreaOnProduction);

        System.out.println("-------------------------------------- restaurantRecord ");
        restaurantRecord.printRecord(textAreaRecord);

        // Actualizar contadores
        ListOnPending.updateClientPatience(ListOnProduction, restaurantRecord);
        ListOnProduction.updateCompleteness(ListOnPending);
        ListOnPending.updateCompleteness(ListOnProduction, restaurantRecord);
        ListOnWating.updateClientWaiting();
    }
}

