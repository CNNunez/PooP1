/* 
    Class del Platos Fuertes, hereda de Products
*/

public class Dish extends Product{
    float Size;
    
    Dish(String newName, int newPrice, float newSize){
        super (newName, newPrice, 5);
        Size = newSize;
    }
}
