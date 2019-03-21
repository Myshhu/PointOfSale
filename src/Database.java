import java.util.HashMap;
import java.util.Map;

public class Database {

    public static Map<Integer, Product> products = new HashMap<>(){
        {
            put(1, new Product("Apple", 2));
            put(2, new Product("Lemon", 5));
            put(3, new Product("Bread", 2));
            put(4, new Product("Water", 2.99));
            put(5, new Product("Beer", 2.99));
            put(6, new Product("Meat", 2.99));
            put(7, new Product("Juice", 2.99));
            put(8, new Product("T-shirt", 2.99));
            put(9, new Product("Sunglasses", 2.99));
            put(10, new Product("Car", 2.99));
        }
    };

    public static Product findProduct(int Barcode) {
        return products.getOrDefault(Barcode, null);
    }

}
