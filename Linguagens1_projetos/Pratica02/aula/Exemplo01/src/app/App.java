package app;

public class App {
    public static void main(String[] args) throws Exception {
        Conta c1;
        Conta c2;

        c1 = new Conta();
        c2 = new Conta();
        
        c1.cliente.nome = "Ronaldinho";
        System.out.println("Titular C1: " + c1.cliente.nome);
        c1.saldo = 2200;
        c1.visualizarSaldo();
        
        c2.cliente.nome = "Gohan";
        System.out.println("Titular C2: " + c2.cliente.nome);
        c2.saldo = 8001;
        c2.visualizarSaldo();
        
        c1.sacar(1500);
        c1.visualizarSaldo();

        c2.transferirDinheiro(4001, c1);
        c2.visualizarSaldo();
        c1.visualizarSaldo();
    }
}