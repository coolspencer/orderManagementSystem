import java.util.*;

public class Order {
    User user;
    Address deliveryAddress;
    Map<Product, Integer> productCategoryAndCountMap;
    Warehouse warehouse;
    Invoice invoice;
    Payment payment;
    OrderStatus orderStatus;

    Order(User user, Warehouse warehouse) {
        this.user = user;
        this.productCategoryAndCountMap = user.getUserCart().getCartItems();
        this.warehouse = warehouse;
        this.deliveryAddress = user.address;
        invoice = new Invoice();
        invoice.generateInvoice(this);
    }

    public void checkout() {

        // 1. update inventory
        warehouse.removeItemFromInventory(productCategoryAndCountMap);

        // 2. make Payment
        boolean isPaymentSuccess = makePayment(new UPIPaymentMode());

        // 3. make cart empty
        if (isPaymentSuccess) {
            user.getUserCart().emptyCart();
            System.out.println("Order Placed Successfully \n Thanks for Shopping");
        } else {
            warehouse.addItemToInventory(productCategoryAndCountMap);
            System.out.println("Payment got failed");
        }

    }

    public boolean makePayment(PaymentMode paymentMode) {
        payment = new Payment(paymentMode);
        return payment.makePayment();
    }

    public void generateOrderInvoice() {
        invoice.generateInvoice(this);
    }

}
