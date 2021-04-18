/* 
    Class del bebidas, hereda de Products
*/

public class Drink extends Product {
    String Type;
    int Size;
    
    Drink(String newName, int newPrice, String newType, int newSize){
        super (newName, newPrice, 1);
        Type = newType;
        Size = newSize;
    }
}
