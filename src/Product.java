/*
    Class de los productos que seran parte del menu
*/
/* 
    Class del productos del menu en general,
    es la clase padre de las clases Drink, Dish y Accomp
*/

public class Product{
    // Atributos
    String Name;
    int Price;
    int Time;

    // Inicializar
    public Product(String newName, int newPrice, int newTime){
        Name = newName;
        Price = newPrice;
        Time = newTime;
    }
}