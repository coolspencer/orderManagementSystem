import java.util.*;

public class Inventory {

    List<ProductCategory> productCategoryList;

    Inventory() {
        productCategoryList = new ArrayList<>();
    }

    // add new category
    public void addCategory(int categoryId, String name, int price) {
        ProductCategory productCategory = new ProductCategory();
        productCategory.price = price;
        productCategory.categoryName = name;
        productCategory.productCategoryId = categoryId;
        productCategoryList.add(productCategory);
    }

    // add product to the particular category
    public void addProduct(Product product, int productCategoryId) {

        // take out the respective productCategory Object
        ProductCategory categoryObject = null;
        for (ProductCategory category : productCategoryList) {
            if (category.productCategoryId == productCategoryId) {
                categoryObject = category;
            }
        }

        if (categoryObject != null) {
            categoryObject.addProduct(product);
        }
    }

    // remove product from the category
    public void removeItems(Map<Product, Integer> productCategoryAndCountMap) {
        for (Map.Entry<Product, Integer> entry : productCategoryAndCountMap.entrySet()) {
            ProductCategory category = getProductCategoryFromID(entry.getKey());
            category.removeProduct(entry.getKey());
        }

    }

    private ProductCategory getProductCategoryFromID(Product p) {

        for (ProductCategory productCategory : productCategoryList) {

            if (productCategory.productCategoryId == p.productId) {
                return productCategory;
            }
        }

        return null;
    }
}
