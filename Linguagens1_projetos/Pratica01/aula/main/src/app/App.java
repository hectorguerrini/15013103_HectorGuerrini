package app;

import java.util.Scanner;

public class App {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        double n1,n2;
        System.out.println("Informe 2 valores: ");
        n1 = sc.nextDouble();
        n2 = sc.nextDouble();
        if (n1 > n2) {
            System.out.println("N1 Maior!");
        } else {
            System.out.println("N2 Maior!");
        }
    }
}