package app;

import java.util.Scanner;

public class App {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        String[] valor;

        int soma = 0;
        System.out.print("Digite um valor: ");
        valor = sc.nextLine().split("");
      
        for (String str : valor) {
            soma += Integer.parseInt(str);
        }
        System.out.print("O somatorio dos algarismos: " + Integer.toString(soma));
        
    }
}