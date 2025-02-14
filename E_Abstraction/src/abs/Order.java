package E_Abstraction.src.abs;

import java.util.ArrayList;

public class Order{
    private ArrayList<OrderItem> orderItems;
    private double totalPrice;
    private String OrderId;

    public Order(double totalPrice, String OrderId, ArrayList<OrderItem> orderItems) {
        this.OrderId = OrderId;
        this.orderItems = orderItems;
        this.totalPrice = totalPrice;

    }

    public void addOrderItem(OrderItem orderItem) {}

    public void getOrderItems(ArrayList<OrderItem> orderItems) {

    }
}
