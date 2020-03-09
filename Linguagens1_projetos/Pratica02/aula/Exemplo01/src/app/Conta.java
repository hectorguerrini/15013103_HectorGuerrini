package app;

/**
 * Conta
 */
public class Conta {
    public int numero;
    public Cliente cliente = new Cliente();
    public double saldo;
    
    boolean sacar(double valor) {
        if (this.saldo < valor) {
            return false;
        } else {
            this.saldo -= valor;
            return true;
        }
    }
    void depositar(double valor) {
        this.saldo += valor;

    }
    boolean transferirDinheiro(double valor, Conta conta) {
        System.out.println(this.cliente.nome + " Transferindo R$ " + Double.toString(valor).replace('.', ',') + " para " + conta.cliente.nome);
        if (sacar(valor)) {
            conta.depositar(valor);
            return true;
        } else {                        
            return false;
        }
    }
    void visualizarSaldo() {
        System.out.println(this.cliente.nome + " Saldo: " + this.saldo);
    }
}