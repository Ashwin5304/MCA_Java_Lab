package Program_08;

import java.util.Scanner;

class Buffer {
     int number;
     boolean isEmpty = true;

    public synchronized void put(int value) {
        try {
            while (!isEmpty) {
                wait();
            }
            number = value;
            System.out.println("Producer puts : " + number);
            
            isEmpty = false;
            System.out.println("Notifying Consumer!");
            
            notify();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public synchronized void get() {
        try {
            while (isEmpty) {
                wait();
            }
            System.out.println("Consumer receives: " + number);
            
            isEmpty = true;
            System.out.println("Notifying Producer!");
            
            notify();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

class Producer extends Thread {
    Buffer buffer;
     int limit;

    Producer(Buffer buffer, int limit) {
        this.buffer = buffer;
        this.limit = limit;
    }

    public void run() {
        for (int i = 0; i < limit; i++) {
            buffer.put(i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class Consumer extends Thread {
     Buffer buffer;
     int limit;

    Consumer(Buffer buffer, int limit) {
        this.buffer = buffer;
        this.limit = limit;
    }

    public void run() {
        for (int i = 0; i < limit; i++) {
            buffer.get();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of items: ");
        int items = sc.nextInt();

        Buffer buffer = new Buffer();
        Producer p = new Producer(buffer, items);
        Consumer c = new Consumer(buffer, items);

        p.start();
        c.start();

        sc.close();
    }
}
