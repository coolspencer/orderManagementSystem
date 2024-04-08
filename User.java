import java.util.*;

public class User {

    int userId;
    String userName;
    Address address;
    Cart userCartDetails;
    List<Integer> orderIds;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public User() {
        userCartDetails = new Cart();
        orderIds = new ArrayList<>();
    }

    // get UserCart
    public Cart getUserCart() {
        return userCartDetails;
    }
}
