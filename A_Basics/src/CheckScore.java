public class CheckScore {
    public static void main(String[] args) {
        int score = 1000;
        int levelCompleted = 5;
        int bonus = 200;
        calCulateScore();

    }

    public static void calCulateScore() {
        boolean gameOver = true;
        int score = 1000;
        int levelCompleted = 5;
        int bonus = 200;

        int finalScore = score;
        if (gameOver) {
            finalScore += (levelCompleted * bonus);
            System.out.println(finalScore);
        }
    }
}
