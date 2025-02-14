package E_Abstraction.src.abs;

public class Furniture extends Product{
    public Furniture(String type, double price, String description) {
        super(type, price, description);
    }

    @Override
    public void showDetails() {
        System.out.println(type + " costs "+ price + " and it is "+ description);
    }
}
