/*
    Clase que se enca=rga de mostrar el GUI junto con los datos
*/
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;

public class Ventana extends JFrame implements ActionListener{

    private static final long serialVersionUID = 1L;

    JLabel Nombre;
    JLabel carac;

    JButton botonSiguiente;

    JButton botonClientes;


    JPanel panelPrincipal;
    JPanel panelBotones;


    JTextField textField;

    JTextArea textArea;

    JScrollPane sp;

    Menu restaurantMenu;
    ClientList ListOnWating;
    ClientList ListReadyToOrder;
    ClientList ListOnPending;
    ProductionList ListOnProduction;
    Record restaurantRecord;

    boolean order;
    int cont;

    public Ventana(){
        super("GUI");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cont = 0;

        agregarComponentes();

        this.pack();
        this.setVisible(true);
    }

    private void agregarComponentes(){
        panelPrincipal = new JPanel();
        
        Nombre = new JLabel("My label");
        Nombre.setText("Nombre:  ");

        order = false;

        carac = new JLabel("Opcional");
        carac.setText("Caracteristica:  ");

        botonSiguiente = new JButton("Siguiente(Tick)");
        botonSiguiente.addActionListener(this);

        botonClientes = new JButton("Generar clientes");
        botonClientes.addActionListener(this);

        panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(10, 1));

        panelBotones.add(botonClientes);
        panelBotones.add(botonSiguiente);

        this.add(panelBotones, BorderLayout.LINE_END);

        textArea = new JTextArea(20, 32);
        sp = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        panelPrincipal.add(sp);

        panelPrincipal.add(Nombre);


        textField = new JTextField(22);
 
        panelPrincipal.add(textField);

        panelPrincipal.add(carac);

        
        textField.setVisible(true);
        
        Nombre.setVisible(false);
        carac.setVisible(false);

        this.add(panelPrincipal, BorderLayout.CENTER);
        this.setPreferredSize(new Dimension(600, 600));
        

    }
    public void setTexto(String text){
        textArea.setText(textArea.getText() + "\n" + text);
    }
    public void setDatos(Menu restaurantMenu, ClientList ListOnWating, ClientList ListReadyToOrder, ClientList ListOnPending, ProductionList ListOnProduction, Record restaurantRecord){
        this.restaurantMenu = restaurantMenu;
        this.ListOnWating = ListOnWating;
        this.ListReadyToOrder = ListReadyToOrder;
        this.ListOnPending =ListOnPending;
        this.ListOnProduction = ListOnProduction;
        this.restaurantRecord = restaurantRecord;
    }
    public void setOrder(){
        order = true;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(botonSiguiente)){
            //aqui va los pasos ticks
            String info = "";
            info += " \n";
            info += " \n";
            info += "******************************\n";
            info += "******************************\n";
            info += "Tick #" + cont + "\n";
            cont += 1;
            this.setTexto(info);
            new LogicaDeFuncionamiento(restaurantMenu, ListOnWating, ListReadyToOrder, ListOnPending, ListOnProduction, restaurantRecord, this);
        }
        if(e.getSource().equals(botonClientes)){
            //While para crear clientes aleatorios
            if (order){
                String newOrder = textField.getText();
                //clientList.get(i).addOrder(restaurantMenu, newOrder);
                textField.setText("");
                order = false;
            }
        }
    }
}
