package com.threadbasic.thread_fila_pilha;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/* Thread do pacote java.lang */
public class ImplementacaoFilaThread extends Thread {
    private static ConcurrentLinkedQueue<ObjetoFilaThread> pilha_fila = new ConcurrentLinkedQueue<ObjetoFilaThread>();

    public static void add(ObjetoFilaThread objetoFilaThread) {
        pilha_fila.add(objetoFilaThread);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Thread#run()
     */
    @Override
    public void run() {

        System.out.println("Fila rodando");

        while (true) {
            final Iterator iterador = pilha_fila.iterator();

            synchronized (iterador) { /* garante o bloqueio do acesso a esta lista por outro processo */
                while (iterador.hasNext()) { /* enquanto conter dados na lista */
                    ObjetoFilaThread processar = (ObjetoFilaThread) iterador.next();/* pega objeto atual */

                    /*
                     * processar 10 k de notas
                     * gearar lista de processos em pdf
                     */

                    System.out.println("---------------------------------------------------");

                    System.out.println(processar.getNome());
                    System.out.println(processar.getEmail());

                    System.out.println("---------------------------------------------------");

                    iterador.remove();

                    try {
                        Thread.sleep(1000); /* tempo para descarga de memoria */
                    } catch (InterruptedException e) {

                        e.printStackTrace();
                    }

                }

            }

            try {
                Thread.sleep(1000); /* tempo para limpeza de memoria pos processamento */
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
