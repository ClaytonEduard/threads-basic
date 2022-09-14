package com.threadbasic;

import javax.swing.JOptionPane;

public class threadParalala {

    public static void main(String[] args) throws InterruptedException {

        // codigo da rotina para executar em background
        for (int i = 0; i < 10; i++) {

            /* excecutar este envio de mesnsagem com tempo deternimado */
            System.out.println("Executando alguma rotina de envio de emails");

            // sleep executa uma impressão a cada 1 segundo
            Thread.sleep(1000); // da um tempo(intervalo) para nova impresão
        }

        /* processo finalizado para o usuario, e o fluxo do sistema normal */
        System.out.println("Final do código.");
        JOptionPane.showMessageDialog(null, "Sistema continua rodando para o usuario", "Mensagem", 1);
    }
}
