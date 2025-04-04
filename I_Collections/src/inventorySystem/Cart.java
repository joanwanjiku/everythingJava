package inventorySystem;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    private static int lastId = 1;
    private int id;
    private Map<String,Integer> products;
    private LocalDate date;
    private CartType type;

    public Cart (CartType type, int days) {
        id = lastId++;
        this.type = type;
        date = LocalDate.now().minusDays(days);
        products = new HashMap<>();
    }

    public Cart(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public Map<String, Integer> getProducts() {
        return products;
    }

    public void addItem(InventoryItem item, int qty) {
        products.merge(item.getProduct().sku(), qty, Integer::sum);
        if (!item.reserveItem(qty)){
            System.out.println("Item is not available");
        }
    }

    public void removeItem(InventoryItem item, int qty) {
        int current = products.get(item.getProduct().sku());
        if (current <= qty){
            qty = current;
            products.remove(item.getProduct().sku());
            System.out.println("Item [%s] removed".formatted(item.getProduct().name()));
        } else{
            products.merge(item.getProduct().sku(), qty, (o, n) -> o -n);
            System.out.println("%d [%s]s removed".formatted(qty,item.getProduct().name()));
        }
        item.releaseItem(qty);
    }
    public void printSalesSlip(Map<String, InventoryItem> inventory){
        double total = 0;
        System.out.println("--------------------------------------------------");

        System.out.println("Thank you for your purchase. Here is your Sales Slip");
        for (var cartItem: products.entrySet()) {
            var item = inventory.get(cartItem.getKey());
            int qty = cartItem.getValue();
            double itemizedPrice = item.getSalesPrice() * qty;
            total += itemizedPrice;
            System.out.printf("\t%s %-10s (%d)@ $%.2f = $%.2f%n", cartItem.getKey(), item.getProduct().name(), qty, item.getSalesPrice(), itemizedPrice);
        }
        System.out.println("Total Sale: $%.2f%n".formatted(total));
        System.out.println("--------------------------------------------------");

    }

    @Override
    public String toString() {
        return "Cart {" + "id=" + id +
                ", products=" + products + ", CartDate=" + date + ", type=" + type + '}';
    }
}
