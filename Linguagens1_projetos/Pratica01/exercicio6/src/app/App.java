package app;

import java.util.Scanner;

public class App {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        int vI, vF, soma = 0;
        long prod = 1;
        System.out.print("Valor Inicial da sequencia: ");
        vI = sc.nextInt();
        System.out.print("Valor Final da sequencia: ");
        vF = sc.nextInt();

        System.out.println();

        for (int i = vI; i <= vF; i++) {
            soma += i;
            prod *= i;
        }
        System.out.println("Somatorio da sequencia: " + Integer.toString(soma));
        System.out.println("Produto da sequencia: " + prod);
    }
}