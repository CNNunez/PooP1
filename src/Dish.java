/* 
    Class del Platos Fuertes, hereda de Products
*/

public class Dish extends Product{
    int Size;
    
    Dish(String newName, int newPrice, int newSize){
        super (newName, newPrice, 5);
        Size = newSize;
    }
}
