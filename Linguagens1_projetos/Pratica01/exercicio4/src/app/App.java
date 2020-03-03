package app;

import java.util.Scanner;

public class App {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        String frase, newFrase;        
        Boolean palindromo = true;
        System.out.print("Digite uma Frase: ");
        frase = sc.nextLine();

        newFrase = frase.replace(" ", "").toLowerCase();

        for (int i = 0, j = newFrase.length()-1; i < newFrase.length(); i++, j--) {
            if (newFrase.charAt(i) !=  newFrase.charAt(j)) {
                palindromo = false;
                break;
            }        
        }

        if (palindromo) {
            System.out.println("É uma Palíndromo");
        } else {
            System.out.println("Não é uma Palíndromo");
        }
    }
}