class Thread1 extends Thread {

    static Object lock = new Object();

    public void run() {
        synchronized (lock) {

            System.out.println("Thread 1 state at run start : " + this.getState());

            for (int i = 1; i <= 5; i++) {
                try {
                    System.out.println("Thread 1 running : " + i +" | STATE : " + this.getState());
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }
            }

            System.out.println("Thread 1 END state : " + this.getState());
        }
    }
}

class Thread2 extends Thread {

    public void run() {
        synchronized (Thread1.lock) {

            System.out.println("Thread 2 state at run start : " + this.getState());

            for (int i = 10; i <= 15; i++) {
                try {
                    System.out.println("Thread 2 running : " + i +" | STATE : " + this.getState());
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }
            }

            System.out.println("Thread 2 END state : " + this.getState());
        }
    }
}

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();

        System.out.println("Initial state of t1 : " + t1.getState());
        System.out.println("Initial state of t2 : " + t2.getState());

        t1.start();
        Thread.sleep(100);
        t2.start();

        System.out.println("t1 state in main : " + t1.getState()); //timed_waiting
        System.out.println("t2 state in main : " + t2.getState()); //blocked

        t1.join();  // Main thread waits for Thread1 to finish
        
        System.out.println("Final state of t1 : " + t1.getState()); //terminated
        System.out.println("Final state of t2 : " + t2.getState()); //terminated
    }
}