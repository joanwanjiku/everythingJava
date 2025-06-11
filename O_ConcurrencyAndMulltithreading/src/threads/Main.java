package threads;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
//        var currentThread = Thread.currentThread();
//        System.out.println(currentThread.getClass().getName());
//
//        System.out.println(currentThread);
//        printThreadStats(currentThread);
//
//        CustomThread customThread = new CustomThread();
//        customThread.start();
////        printThreadStats(customThread);
//        Runnable myRunnable = () -> {
//            for (int i = 0; i < 8; i++) {
//                System.out.print(" 2 ");
//                try {
//                    TimeUnit.SECONDS.sleep(2);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//        Thread myThread = new Thread(myRunnable);
//        myThread.start();
//
//        for (int i = 0; i < 3; i++) {
//            System.out.print(" 0 ");
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
        System.out.println("Main thread running");
        try {
            System.out.println("Main thread sleeping for 1 second");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread thread = new Thread(() -> {
            String tname = Thread.currentThread().getName();
            System.out.println(tname + " should take 10 dots to run");
            for (int i = 0; i < 10; i++) {
                System.out.print(". ");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println("\n Whoops!! "+ tname + " was interrupted");
                    Thread.currentThread().interrupt();
                    return;
                }
            }
            System.out.println("\n" + tname + " is done");
        });

        Thread installThread = new Thread(() -> {
            try {
                for (int i = 0; i < 3; i++) {
                    Thread.sleep(250);
                    System.out.println("Installation step " + (i+1) + " is done");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Install thread is done");
        }, "InstallThread");



        Thread threadMonitor = new Thread(() -> {
            long now = System.currentTimeMillis();
            while (thread.isAlive()) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    if (System.currentTimeMillis() - now > 2000) {
                        System.out.println("Thread is taking too long");
                        thread.interrupt();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        System.out.println(thread.getName() + " is starting");
        thread.start();
        threadMonitor.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (!thread.isInterrupted()) {
            installThread.start();
        }else {
            System.out.println("Previous Thread was interrupted, "+installThread.getName() + " is not starting");
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
