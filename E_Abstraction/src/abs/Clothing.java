package E_Abstraction.src.abs;

public class Clothing extends Product{
    public Clothing(String type, double price, String description) {
        super(type, price, description);
    }

    @Override
    public void showDetails() {
        System.out.println(type + " costs "+ price + " and it is "+ description);
    }
}
