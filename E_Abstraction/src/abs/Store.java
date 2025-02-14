package E_Abstraction.src.abs;

import java.util.ArrayList;
import java.util.Collections;

public class Store {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<Product>();
        ArrayList<OrderItem> orderItems = new ArrayList<OrderItem>();
        Furniture seat = new Furniture("seat", 4500, "comfy seat");
        Clothing bottom = new Clothing("pants", 300, "comfy pants");
        Furniture table = new Furniture("table", 500, "wooden table");
        Clothing shirt = new Clothing("shirt", 200, "comfy shirt");

        Collections.addAll(products, seat, bottom, table, shirt);
        listProducts(products);
//        orderItems.add(new )
        double totalPrice = seat.getSalesPrice(1) + bottom.getSalesPrice(2);
        orderItems.add(new OrderItem(bottom, 2));
        orderItems.add(new OrderItem(seat, 1));

        Order order = new Order(totalPrice, "123str", orderItems);


    }



    public static void listProducts(ArrayList<Product> products){
        for (Product product : products) {
            product.showDetails();
        }
    }
    public static void listOrderItems(ArrayList<OrderItem> orderItems){

    }
}
