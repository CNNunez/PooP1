/* 
    Class del Registo, para llevar el registro de estadisticas
*/

public class Record {
    int numOrdersCompleted;
    double Profits;
    int unsatisfiedClientes;
    Ventana ventana;
    
    Record(Ventana vent){
        numOrdersCompleted = 0;
        Profits = 0;
        unsatisfiedClientes = 0;
        ventana = vent;
    }

    void updateRecord(double newProfits, int newUnsatisfiedClientes){
        numOrdersCompleted = numOrdersCompleted + 1;
        Profits = Profits + newProfits;
        unsatisfiedClientes = unsatisfiedClientes + newUnsatisfiedClientes;
    }

    void printRecord(){
        String info = "";
        info += "---------- REGISTRO DE VENTAS ----------\n";
        info += "- Numero de ordenes completadas: " + numOrdersCompleted + "\n";
        info += "- Ganancias acumuladas: " + Profits + "\n";
        info += "- Clientes insatisfechos: " + unsatisfiedClientes + "\n";
        info +="---------- ------------------ ----------\n";
        ventana.setTexto(info);
    }
}
