public class MathPrecedence {
    public static void main(String[] args) {
        double first = 20.00;
        double second = 80.00;

        double multiplier = (first + second) * 100.00;

        double reminder = multiplier % 40.00;

        boolean value = (reminder == 0.00) ? true : false;
        System.out.println(value);

        if (!value){
            System.out.println("got some reminder");
        }
    }
}
