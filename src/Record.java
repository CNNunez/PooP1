import javax.swing.JTextArea;

/* 
    Class del Registo, para llevar el registro de estadisticas
*/

public class Record {
    int numOrdersCompleted;
    double Profits;
    int unsatisfiedClientes;
    
    Record(){
        numOrdersCompleted = 0;
        Profits = 0;
        unsatisfiedClientes = 0;
    }

    void updateRecord(double newProfits, int newUnsatisfiedClientes){
        numOrdersCompleted = numOrdersCompleted + 1;
        Profits = Profits + newProfits;
        unsatisfiedClientes = unsatisfiedClientes + newUnsatisfiedClientes;
    }

    void printRecord(JTextArea textAreaRecord){
        System.out.println("---------- REGISTRO DE VENTAS ----------");
        System.out.println("- Numero de ordenes completadas: " + numOrdersCompleted);
        System.out.println("- Ganancias acumuladas: " + Profits);
        System.out.println("- Clientes insatisfechos: " + unsatisfiedClientes);
        System.out.println("---------- ------------------ ----------");

        textAreaRecord.setText("");
        textAreaRecord.append("- Ordenes completadas: " + numOrdersCompleted + "\n\r");
        textAreaRecord.append("- Ganancias acumuladas: " + Profits + "\n\r");
        textAreaRecord.append("- Clientes insatisfechos: " + unsatisfiedClientes + "\n\r");
    }
}
