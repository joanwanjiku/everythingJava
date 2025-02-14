public class MethodOverloading {
    public static void main(String[] args) {
        System.out.println(getDurationString(3945));

    }


    public static String getDurationString(int seconds) {
        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        int secondsRemaining = (seconds % 3600) % 60;
        String minSecs = getDurationString(minutes, secondsRemaining);
        return hours+" h "+ minSecs;
    }
    public static String getDurationString(int minutes, int seconds) {
        return minutes+" m " + seconds + " s";
    }
}
