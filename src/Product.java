/*
   Class de los productos que seran parte del menu
*/

public class Product{
    // Atributos
    String Type;
    String Name;
    int Price;
    int Time;
    int Size;

    // Inicializar
    public Product(String dishType, String dishName, int dishPrice, int dishTime, int dishSize){
        Type = dishType;
        Name = dishName;
        Price = dishPrice;
        Time = dishTime;
        Size = dishSize;
    }
}