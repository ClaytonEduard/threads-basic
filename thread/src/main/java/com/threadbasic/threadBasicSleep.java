package com.threadbasic;

public class ThreadBasicSleep {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {       

            /* excecutar este envio de mesnsagem com tempo deternimado */
            System.out.println("Executando alguma rotina de envio de emails");

             // sleep executa uma impressão a cada 1 segundo
             Thread.sleep(1000); //da um tempo(intervalo) para nova impresão
        }
        System.out.println("Final do código.");
    }

}