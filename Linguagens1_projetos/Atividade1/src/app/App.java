package app;

import java.util.ArrayList;
import java.util.Scanner;

// Hector Guerrini Herrera
// R.A 15.01310-3
public class App {
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        ArrayList<Usuarios> listaUsers = new ArrayList<>();
        String nome;
        String senha;
        String email;
        nome = sc.nextLine();
        senha = sc.nextLine();
        email = sc.nextLine();
        Usuarios user1 = new Usuarios(nome, senha, email);
        listaUsers.add(user1);
        nome = sc.nextLine();
        senha = sc.nextLine();
        email = sc.nextLine();
        Usuarios user2 = new Usuarios(nome, senha, email);        
        listaUsers.add(user2);
        nome = sc.nextLine();
        senha = sc.nextLine();
        email = sc.nextLine();
        Usuarios user3 = new Usuarios(nome, senha, email);        
        listaUsers.add(user3);

        user1.AbrirConta(1000);
        user2.AbrirConta(250);
        user3.AbrirConta(3000);

        exibirInformacoes(listaUsers);

        user1.gerarRecebimento(250);
        user2.pagarUsuario(user1);
        user3.pagarUsuario(user1);
        user2.pagarUsuario(user1);
        user2.gerarRecebimento(1000);
        user3.pagarUsuario(user2);
        exibirInformacoes(listaUsers);


        sc.close();
    }

    public static void exibirInformacoes(ArrayList<Usuarios> users) {
        for (Usuarios usuarios : users) {
            usuarios.getInformacoes();
        }
    }
}