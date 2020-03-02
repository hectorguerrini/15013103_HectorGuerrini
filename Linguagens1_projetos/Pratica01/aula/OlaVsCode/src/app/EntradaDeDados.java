package app;

import java.util.Scanner;

/**
 * EntradaDeDados
 */
public class EntradaDeDados {
    static Scanner sc = new Scanner(System.in);
    public static String nome;
    public static int n1,n2;
    public static void main(String[] args) {
        
        System.out.println("Informe seu nome:");
        nome = sc.nextLine();
        System.out.println("Olá " + nome);
        System.out.println("Digite 2 numeros:");
        n1 = sc.nextInt();
        n2 = sc.nextInt();
        System.out.println("n1: "+ n1);
        System.out.println("n2: "+ n2);
    }
}
