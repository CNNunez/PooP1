/* 
    Class del Acompanamientos, hereda de Products
*/

public class Accomp extends Product{
    String Type;
    
    Accomp(String newName, int newPrice, String newType){
        super (newName, newPrice, 3);
        Type = newType;
    }
}
