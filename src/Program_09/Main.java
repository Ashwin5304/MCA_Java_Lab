package Program_09;

import java.util.Scanner; 
 
class Storage<T> { 
    private T item; 
 
    public void setItem(T item) { 
        this.item = item; 
    } 
 
    public T getItem() { 
        return item; 
    } 
} 
 
public class Main { 
 
    // Generic method to print array 
    public static <E> void printArray(E[] arr) { 
        for (E e : arr) { 
            System.out.print(e + " "); 
        } 
        System.out.println(); 
    } 
 
    public static void main(String[] args) { 
 
        Scanner sc = new Scanner(System.in); 
        int ch; 
 
        // Generic class objects 
        Storage<Integer> intStore = new Storage<>(); 
        Storage<String> strStore = new Storage<>(); 
        Storage<Double> dblStore = new Storage<>(); 
 
        do { 
            System.out.println("\n--- MENU ---"); 
            System.out.println("1. Store Integer"); 
            System.out.println("2. Store String"); 
            System.out.println("3. Store Double"); 
            System.out.println("4. Print Integer Array"); 
            System.out.println("5. Print String Array"); 
            System.out.println("6. Print Double Array"); 
            System.out.println("7. Exit"); 
            System.out.print("Enter your choice: "); 
 
            ch = sc.nextInt(); 
            sc.nextLine();
 
            switch (ch) { 
 
                case 1: 
                    System.out.print("Enter Integer value: "); 
                    intStore.setItem(sc.nextInt()); 
                    System.out.println("Stored Integer: " + intStore.getItem()); 
                    break; 
 
                case 2: 
                    System.out.print("Enter String value: "); 
                    strStore.setItem(sc.nextLine()); 
                    System.out.println("Stored String: " + strStore.getItem()); 
                    break; 
 
                case 3: 
                    System.out.print("Enter Double value: "); 
                    dblStore.setItem(sc.nextDouble()); 
                    System.out.println("Stored Double: " + dblStore.getItem()); 
                    break; 
 
                case 4: 
                    Integer[] intArr = {1, 2, 3}; 
                    System.out.print("Integer Array: "); 
                    printArray(intArr); 
                    break; 
 
                case 5: 
                    String[] strArr = {"Java", "C", "Python"}; 
                    System.out.print("String Array: "); 
                    printArray(strArr); 
                    break; 
 
                case 6: 
                    Double[] dblArr = {10.5, 20.5, 30.5}; 
                    System.out.print("Double Array: "); 
                    printArray(dblArr); 
                    break; 
 
                case 7: 
                    System.out.println("Exiting program..."); 
                    break; 
            } 
 
        } while (ch != 7); 

        sc.close(); 
    } 
}