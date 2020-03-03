package app;

import java.util.Scanner;

public class App {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        int n;
        System.out.print("Digite o numero da posição da sequencia de fibonacci: ");
        n = sc.nextInt();

        System.out.println("O valor da " + Integer.toString(n) + "° Posição de Fibonacci:  " + fibonacci(n) );

    }
    public static int fibonacci(int n) {
        if ( n < 2 ) {
            return n;
        } else {
            return fibonacci(n - 1) + fibonacci(n -2);
        }
    }
}