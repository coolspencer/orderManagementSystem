import java.util.*;

public class Warehouse {
    String wareHouseName;
    Inventory inventory;
    Address address;
    Warehouse(){}
    
    public Warehouse(String wareHouseName, Inventory inventory, Address address) {
        this.wareHouseName = wareHouseName;
        this.inventory = inventory;
        this.address = address;
    }

    // update inventory
    public void removeItemFromInventory(Map<Product, Integer> productCategoryAndCountMap) {

        // it will update the items in the inventory based upon product category.
        inventory.removeItems(productCategoryAndCountMap);
    }

    public void addItemToInventory(Map<Product, Integer> productCategoryAndCountMap) {

        // it will update the items in the inventory based upon product category.
    }
}