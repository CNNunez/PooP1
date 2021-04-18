public class Production {
    String clientID;
    Product productToProduce;
    int completeness;
    
    Production(String newClientID, Product newProductToProduce){
        clientID = newClientID;
        productToProduce = newProductToProduce;
        completeness = 0;
    }

    public boolean updateCompleteness(){//retorna true si el producto se ha terminado de producir
        completeness = completeness + 1;
        if (productToProduce.Time == completeness){
            return true;
        }
        return false;
    }
}
