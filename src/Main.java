import java.util.ArrayList;
import java.util.Stack;

public class Main {

    // Recursive version of factorial
    // Assumes that n >= 0 otherwise will crash or go into infinite loop
    public static int factorial(int n) {
        // This is our base case, 0! = 1
        if(n == 0) {
            return 1;
        }

        // Recursive call
        return n * factorial(n-1);
    }

    // Recursive version of fibonacci
    // Even though this implementation looks elegant
    // It is very inefficient because it recalculates values
    // already know
    // To see that, try to imagine all the function call of fibonacciBad(6)
    // Hint: draw a tree of the function calls
    public static  int fibonacciBad(int n) {
        // These are our base cases
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }

        // This is the recursive part
        return fibonacciBad(n-1) + fibonacciBad(n -2);

    }

    // Hold 50 fibonacci numbers for faster lookup
    public static int[] fibonacci = new int[50];

    // Recursive version of fibonacci
    // The difference is that this one "caches" the calculated values
    // so that the next time we ask the same value we can directly find it
    // in the fibonacci array
    // If it doesn't exist then we simply calculate it then store it
    public static int fibonacciGood(int n) {
        // Not calculated
        if(fibonacci[n] == -1) {
            fibonacci[n] = fibonacciGood(n-1) + fibonacciGood(n-2);
        }
        // By this time we know the fibonacci value of n
        // We return it
        return fibonacci[n];
    }

    // "Mystery" function
    // Actually prints numbers from n to 1 then 1 to n again
    // Called mystery because the result of the function wasn't
    // shown, it was an exercise
    public static void mystery(int n) {
        // Base case
        if(n==0) {
            return;
        }

        // Recursive part
        System.out.println(n);
        mystery(n-1);
        System.out.println(n);
    }

    public static void factorialExample() {
        for(int i = 0; i < 8; i++) {
            System.out.println(factorial(i));
        }
    }

    public static void fibonacciExample() {
        // -1 means we have not calculated the value of f(n)
        // It is a good value because f(n) is never smaller than 0
        for(int i = 0; i < 50; i++) {
            fibonacci[i] = -1;
        }
        for (int i = 0; i < 10; i++) {
            // Try both on bigger numbers, you will notice
            // a difference in the run time
            int nFibonacci = fibonacciGood(i);
//            int nFibonacci = fibonacciBad(i);
            System.out.println(nFibonacci);
        }
    }

    // What does this function do ...
    public static void mysteryExample() {
        mystery(3);
    }

    public static void hanoiExample() {
        Hanoi game = new Hanoi(7);
        game.printState();
        System.out.println();
        game.solve();
        game.printState();
    }

    public static void main(String[] args) {
        factorialExample();
        fibonacciExample();
        mysteryExample();
        hanoiExample();
    }
}

