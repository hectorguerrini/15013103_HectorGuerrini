package app;

import java.util.Random;

// Hector Guerrini Herrera
// R.A 15.01310-3
public class Transacoes {

    private static int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public static String getQRCode(int idConta, String nome, double valor ) {
        String qrCode = String.format("%s;%s;%s;%s", idConta,nome,valor,getRandomNumberInRange(1000, 9999));
        return qrCode;
    }

    public static boolean pagamentos(Usuarios pagador, Usuarios recebedor, double valor ){
        if (pagador.getConta().getSaldo() >= valor){
            Contas.pagamento(pagador.getConta(), valor);
            Contas.recebimento(recebedor.getConta(),valor);
            return true;
        }
        return false;
    }
}