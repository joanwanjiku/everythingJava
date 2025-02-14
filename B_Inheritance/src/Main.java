package B_Inheritance.src;


public class Main {
    public static void main(String[] args) {

        Car car = new Car();
        car.setMake("Ford");
        System.out.println(car.getMake());
        car.describeCar();
//

//     Record example
        for (int i = 1; i <= 5; i++) {
            LpStudent s = new LpStudent("S9200" + i,
                    switch (i) {
                case 1 -> "Mary";
                case 2 -> "John";
                case 3 -> "Jane";
                case 4 -> "Kate";
                case 5 -> "Lisa";
                default -> "Invalid student";
                    },
                    "05/11/1985",
                    "Java");
            System.out.println(s);
        };




    }


}
