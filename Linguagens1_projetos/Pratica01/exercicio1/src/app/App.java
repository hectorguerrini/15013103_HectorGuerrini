package app;

import java.util.Scanner;

public class App {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        String ra, nome,telefone,email;
        int idade;
        System.out.print("Digite seu R.A: ");
        ra = sc.nextLine();
        System.out.print("Digite seu Nome Completo: ");
        nome = sc.nextLine();
        System.out.print("Digite seu Telefone: ");
        telefone = sc.nextLine();
        System.out.print("Digite seu Email: ");
        email = sc.nextLine();
        System.out.print("Digite sua Idade: ");
        idade = sc.nextInt();

        System.out.println("Dados Salvo\n");
        System.out.println("R.a: " + ra);
        System.out.println("Nome: " + nome);
        System.out.println("Telefon: " + telefone);
        System.out.println("Email: " + email);
        System.out.println("Idade: " + Integer.toString(idade));


    }
}