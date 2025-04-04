package inventorySystem;

public class InventoryItem {
    private Product product;;
    private int qtyTotal;
    private int qtyReserved;
    private int qtyReorder;
    private int qtyLow;
    private double salesPrice;

    public InventoryItem(Product product, double salesPrice,int qtyTotal, int qtyLow ) {
        this.product = product;
        this.qtyTotal = qtyTotal;
        this.qtyLow = qtyLow;
        this.salesPrice = salesPrice;
        this.qtyReorder = qtyLow;
    }

    public Product getProduct() {
        return product;
    }

    public double getSalesPrice() {
        return salesPrice;
    }

    public boolean reserveItem(int qty) {
        if (qty <= (qtyTotal - qtyReserved)) {
            qtyReserved += qty;
            return true;
        }
        return false;
    }
    public void releaseItem(int qty) {
        qtyReserved -= qty;
    }
    public boolean sellItem(int qty) {
        if (qty <= qtyTotal ) {
            qtyTotal -= qty;
            qtyReserved -= qty;
            if (qtyTotal <= qtyLow) {
                placeInventoryOrder();
            }
            return true;
        }
        return false;
    }
    public void placeInventoryOrder() {}

    @Override
    public String toString() {
        return "%s, $%.2f : [%04d, % 2d]".formatted(product, salesPrice, qtyTotal, qtyReserved);
    }
}
