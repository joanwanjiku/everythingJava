package challenge.burger;

public class Store {
    public static void main(String[] args) {
        Meal meal = new Meal();
        System.out.println(meal);
        System.out.println("-------------------------------------");
        Meal usRegular = new Meal(0.86);
        usRegular.addToppings("mayo", "bacon");
        System.out.println(usRegular);
        System.out.println("----------------------------");
    }
}



