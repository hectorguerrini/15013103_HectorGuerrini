package app;

import java.util.Scanner;

public class App {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        String username, pw;
        String _username, _pw;
        System.out.println("Cadastre Usuario e Senha");
        System.out.print("Digite o Usuario: ");
        username = sc.nextLine();

        System.out.print("Digite a Senha: ");
        pw = sc.nextLine();
        
        
        while (true) {
            System.out.println();
            System.out.println("Validar Usuario e Senha");
            System.out.print("Digite o Usuario: ");
            _username = sc.nextLine();

            System.out.print("Digite a Senha: ");
            _pw = sc.nextLine();

            if( username.equals(_username) && pw.equals(_pw)) {
                break;
            }

        }

    }
}