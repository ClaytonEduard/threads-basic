package com.threadbasic;


import javax.swing.JOptionPane;

public class ThreadComRunnable {

    public static void main(String[] args) throws InterruptedException {
        /*
         * Primeira therad simplificada
         * Transformando a mesma em um objeto manipulado
         */
        Thread threadEmail = new Thread(thred1);
        threadEmail.start();

        /* Divisão das Threads */

        /* Segunda Thread */
        Thread threadNFCE = new Thread(thread2);
        threadNFCE.start();

        /* processo finalizado para o usuario, e o fluxo do sistema normal */
        System.out.println("Final do código.");
        JOptionPane.showMessageDialog(null, "Sistema continua rodando para o usuário", "Mensagem", 1);
    }

    /* Runnable thread 1 */

    private static Runnable thred1 = new Runnable() {

        @Override
        public void run() {

            new Thread() {

                public void run() { /* exceuta o que é definido */
                    /* rotina criada */

                    /* codigo da rotina para executar em background */
                    for (int i = 0; i < 10; i++) {

                        /* excecutar este envio de mesnsagem com tempo deternimado */
                        System.out.println("Executando rotina de envio de emails");
                        System.out.println("----------------------------------------------------------------");
                        // sleep executa uma impressão a cada 2 segundos
                        try {
                            Thread.sleep(4000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } // da um tempo(intervalo) para nova impresão
                    }
                };

            }.start(); /* start liga a thred que fica rodando paralemente */

        }

    };

    private static Runnable thread2 = new Runnable() {

        @Override
        public void run() {
            /* rotina criada */

            /* codigo da rotina para executar em background */
            for (int i = 0; i < 10; i++) {

                /* excecutar este envio de mesnsagem com tempo deternimado */
                System.out.println("Executando rotina de envio de notas fiscais");
                System.out.println("----------------------------------------------------------------");
                // sleep executa uma impressão a cada 2 segundos
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } // da um tempo(intervalo) para nova impresão
            }
        };

    };

}
