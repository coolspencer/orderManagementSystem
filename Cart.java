import java.util.*;

public class Cart {

    Map<Product, Integer> productCategoryIdVsCountMap;

    Cart() {
        productCategoryIdVsCountMap = new HashMap<>();
    }

    public void addItemInCart(Product product, int count) {

        if (productCategoryIdVsCountMap.containsKey(product)) {
            int noOfItemsInCart = productCategoryIdVsCountMap.get(product);
            productCategoryIdVsCountMap.put(product, noOfItemsInCart + count);
        } else {
            productCategoryIdVsCountMap.put(product, count);
        }
    }

    public void removeItemFromCart(Product product, int count) {

        if (productCategoryIdVsCountMap.containsKey(product)) {
            int noOfItemsInCart = productCategoryIdVsCountMap.get(product);
            if (count - noOfItemsInCart == 0) {
                productCategoryIdVsCountMap.remove(product);
            } else {
                productCategoryIdVsCountMap.put(product, noOfItemsInCart - count);
            }
        }
    }

    public void emptyCart() {
        productCategoryIdVsCountMap = new HashMap<>();
    }

    public Map<Product, Integer> getCartItems() {

        return productCategoryIdVsCountMap;
    }
}
