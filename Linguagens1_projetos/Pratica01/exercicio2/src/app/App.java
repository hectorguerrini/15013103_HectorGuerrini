package app;

import java.util.Scanner;

public class App {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        String nome1, nome2;
        int idade1, idade2, diff;
        System.out.print("Digite o Nome da 1° Pessoa: ");
        nome1 = sc.next();
        System.out.print("Digite a Idade da 1° Pessoa: ");
        idade1 = sc.nextInt();        
        System.out.print("Digite o Nome da 2° Pessoa: ");
        nome2 = sc.next();
        System.out.print("Digite a Idade da 2° Pessoa: ");
        idade2 = sc.nextInt();

        diff = Math.abs(idade1 - idade2);
        if (idade1 > idade2) {
            System.out.println(nome1 + " é " + Integer.toString(diff) + " Ano" + (diff > 1 ? "s" : "") + " mais velho que " + nome2);
        } else if (idade2 > idade1) {
            System.out.println(nome2 + " é " + Integer.toString(diff) + " Ano" + (diff > 1 ? "s" : "") + " mais velho que " + nome1);
        } else {
            System.out.println(nome1 + " e " + nome2 + "tem a mesma idade.");
        }
    }
}