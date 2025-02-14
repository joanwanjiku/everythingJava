public class Methods {

    public static void main(String[] args) {

        int position = calculateScore(1500);
        displayHighSchoolPos("tim", position);

        position = calculateScore(1000);
        displayHighSchoolPos("bob", position);

        position= calculateScore(500);
        displayHighSchoolPos("jim", position);

        position = calculateScore(100);
        displayHighSchoolPos("jane", position);

        position = calculateScore(25);
        displayHighSchoolPos("tom", position);
    }
    public static void displayHighSchoolPos(String playerName, int position) {
        System.out.println("player " + playerName + " is position " + position);
    }

    public static int calculateScore(int score) {
        int pos = 4;
        if (score >= 1000) {
           pos= 1;
        } else if (score >= 500 ) {
            pos= 2;
        }else if (score >= 100 ){
            pos= 3;
        }
        return pos;

    }
}
