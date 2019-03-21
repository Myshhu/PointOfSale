import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private List<Product> boughtProducts;
    private double totalSum;

    public Receipt() {
        this.boughtProducts = new ArrayList<>();
        totalSum = 0;
    }

    public void addProductToReceipt(Product product) {
        boughtProducts.add(product);
        totalSum += product.getProductPrice();
    }

    public List<Product> getBoughtProducts() {
        return boughtProducts;
    }

    public double getTotalSum() {
        return Math.round(totalSum * 100.0) / 100.0;
    }
}
