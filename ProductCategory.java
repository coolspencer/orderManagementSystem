import java.util.ArrayList;
import java.util.List;

public class ProductCategory {

    int productCategoryId;
    String categoryName;
    double price;
    List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        for (Product p : products) {
            if (p.productId == product.productId)
                products.remove(product);
        }
    }
}