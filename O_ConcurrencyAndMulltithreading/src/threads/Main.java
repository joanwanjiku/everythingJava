package threads;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        var currentThread = Thread.currentThread();
        System.out.println(currentThread.getClass().getName());

        System.out.println(currentThread);
        printThreadStats(currentThread);

        CustomThread customThread = new CustomThread();
        customThread.start();
//        printThreadStats(customThread);
        Runnable myRunnable = () -> {
            for (int i = 0; i < 8; i++) {
                System.out.print(" 2 ");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread myThread = new Thread(myRunnable);
        myThread.start();

        for (int i = 0; i < 3; i++) {
            System.out.print(" 0 ");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void printThreadStats(Thread thread) {
        System.out.println("------------------------------------------------");
        System.out.println("ID: " + thread.getId());
        System.out.println("Name: " + thread.getName());
        System.out.println("Priority: " + thread.getPriority());
        System.out.println("State: " + thread.getState());
        System.out.println("Group: " + thread.getThreadGroup());
        System.out.println("Alive: " + thread.isAlive());
        System.out.println("------------------------------------------------");

    }
}
