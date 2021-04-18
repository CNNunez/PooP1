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

    void update(int newNumOrdersCompleted, double newProfits, int newUnsatisfiedClientes){
        numOrdersCompleted = newNumOrdersCompleted;
        Profits = newProfits;
        unsatisfiedClientes = newUnsatisfiedClientes;
    }

    void print(){
        System.out.println("---------- REGISTRO DE VENTAS ----------");
        System.out.println("- Numero de ordenes completadas: " + numOrdersCompleted);
        System.out.println("- Ganancias acumuladas: " + Profits);
        System.out.println("- Clientes insatisfechos: " + unsatisfiedClientes);
        System.out.println("---------- ------------------ ----------");
    }
}
