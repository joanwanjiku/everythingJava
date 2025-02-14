package challenge.burger;

import java.util.ArrayList;
import java.util.List;

public class Meal {
    private double price = 5.0;
    private Burger burger;
    private Item drink;
    private Item side;

    private double conversionRate;
    public Meal(){
        this(1);
    }
    public Meal(double conversionRate){
        this.conversionRate = conversionRate;
        burger = new Burger("burger");
        drink = new Item("drink", "Coke", 1.5);
        side = new Item("side", "Fries", 2.0);
    }

    public double getTotal(){
        double total = burger.getPrice() + drink.price + side.price;
        return Item.getPrice(total, conversionRate);
    }
    @Override
    public String toString() {
        return "%s%n%s%n%s%n%26s$%.2f".formatted(burger, drink, side," total due: ", getTotal() );
    }

    public void addToppings(String... selectedToppings) {
        burger.addToppings(selectedToppings);
        burger.toString();
    }

    private class Item{
        private String type;
        private String name;
        private double price;
        public Item(String type, String name) {
          this(type, name, type.equalsIgnoreCase("burger") ? Meal.this.price : 0);
      }
        public Item(String type, String name, double price) {
            this.type = type;
            this.name = name;
            this.price = price;
        }
        @Override
        public String toString() {
            return "%10s: %10s ($%.2f)".formatted(type, name, getPrice(price, conversionRate));
        }


        private static double getPrice(double price, double rate) {
            return price *  rate;
        }

  }
  private class Burger extends Item{
      private enum Extra {
          AVOCADO,
          MUSHROOM,
          ONION,
          BACON,
          MAYO,
          PICKLES;
          private double getPrice() {
              return switch (this){
                  case AVOCADO:
                      yield 1.5;
                  case MUSHROOM:
                      yield 0.5;
                  case ONION:
                      yield 0.3;
                  case BACON:
                      yield 1.0;
                  case MAYO:
                      yield 0.7;
                  case PICKLES:
                      yield 0.2;
                  default:
                      yield 0.0;
              };
          }
      }
        private List<Item> toppings = new ArrayList<>();
        Burger(String name) {
            super(name, "burger", 5.0);
        }
        public double getPrice(){
            double total = super.price;
            for (Item topping: toppings
                 ) {
                total += topping.price;
            }
            return total;
        }

      private void addToppings(String... topping) {

          for (var top: topping) {
              try {
                  Extra topp = Extra.valueOf(top.toUpperCase());
                  toppings.add(new Item(topp.name(), "TOPPING", topp.getPrice()));
              } catch (IllegalArgumentException e) {
                  System.out.println("No topping for "+ top);
              }


          }
      }
      @Override
      public String toString(){
            StringBuilder itemized = new StringBuilder(super.toString());
          for (Item topping: toppings) {
              itemized.append(" \n ");
              itemized.append(topping);
          }
          return itemized.toString();
      }
  }


}
