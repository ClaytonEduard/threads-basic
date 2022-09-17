package com.threadbasic.tela;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.DimensionUIResource;
import javax.swing.plaf.InsetsUIResource;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.BorderLayout;

public class TelaTimerThread extends JDialog {

    /* declarando Panel */
    private JPanel panel = new JPanel(new GridBagLayout());/* painel de componentes */

    private JLabel descricaoHora = new JLabel("Timer Thread 1");
    private JTextField mostraTempo = new JTextField();

    private JLabel descricaoHora2 = new JLabel("Timer Thread 2");
    private JTextField mostraTempo2 = new JTextField();

    private JButton jButton = new JButton("Start"); /* definindo botao start */
    private JButton jButton2 = new JButton("Stop"); /* definindo botao start */

    /* Funcao runnable para iserir a hora atual no label */
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            while (true) {
                mostraTempo
                        .setText(new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(Calendar.getInstance().getTime()));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

    };
    private Thread thread1Time;

    /*----------------------------------------------------------------------------- */
    /* Funcao runnable para iserir a hora atual no label */
    private Runnable runnable2 = new Runnable() {
        @Override
        public void run() {
            while (true) {
                mostraTempo2
                        .setText(new SimpleDateFormat("dd/MM/yyyy hh:mm:ss").format(Calendar.getInstance().getTime()));
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

    };

    private Thread thread2Time;

    /*----------------------------------------------------------------------------- */
    /*
     * inciando construtor
     * Excecuta o que tiver dentro no momento da abertura ou execução
     */
    public TelaTimerThread() {

        /* configurações da tela */
        setTitle("Minha tela de timer de Thread"); /* Titulo da tela */
        setSize(new DimensionUIResource(240, 240)); /* dimenções da tela */
        setLocationRelativeTo(null);/* centralizar tela */
        setResizable(false); /* nao permite alterar o tamanhao da tela */
        /* fim da tela */

        /* gerenciamento de posicoes */
        GridBagConstraints constraints = new GridBagConstraints();
        /* parametros */
        constraints.gridx = 0; /* linha 0 */
        constraints.gridy = 0; /* coluna 0 */
        constraints.gridwidth = 2; /* Largura da celula de ocupacao */
        constraints.insets = new InsetsUIResource(5, 10, 5, 5); /* espaços entre os objetos */
        constraints.anchor = GridBagConstraints.WEST; /* alinhar objetos a esquerta */

        descricaoHora.setPreferredSize(new DimensionUIResource(200, 25)); /* definindo o tamanho da label */
        panel.add(descricaoHora, constraints); /* incluido no painel */

        mostraTempo.setPreferredSize(new DimensionUIResource(200, 25)); /* Campo Horas */
        constraints.gridy++; /* coluna 1 */
        mostraTempo.setEditable(false); /* nao editavel */
        panel.add(mostraTempo, constraints); /* incluido no painelt */

        // constraints.gridx++; /* linha 0 */
        descricaoHora2.setPreferredSize(new DimensionUIResource(200, 25)); /* definindo o tamanho da label */
        constraints.gridy++; /* linha 0 */
        panel.add(descricaoHora2, constraints); /* incluido no painel */

        mostraTempo2.setPreferredSize(new DimensionUIResource(200, 25)); /* Campo Horas */
        constraints.gridy++; /* coluna 1 */
        mostraTempo2.setEditable(false); /* nao editavel */
        panel.add(mostraTempo2, constraints); /* incluido no painel */

        /*------------------------------------------------------------------------------------ */

        constraints.gridwidth = 1; /* Largura volta a ser uma celula de ocupacao */

        /* definindo tamanho dos botões */
        jButton.setPreferredSize(new DimensionUIResource(92, 25));
        constraints.gridy++;
        panel.add(jButton, constraints);

        jButton2.setPreferredSize(new DimensionUIResource(92, 25));
        constraints.gridx++;
        panel.add(jButton2, constraints);

        /* executa o clique do botao1 */
        jButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                thread1Time = new Thread(runnable);
                thread1Time.start();

                thread2Time = new Thread(runnable2);
                thread2Time.start();

                /* desabilitando o botao stop quando inicia a tela */
                jButton2.setEnabled(true);
                jButton.setEnabled(false);
            }

        });

        /* executa o clique do botao2 */
        jButton2.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                thread1Time.stop();
                thread2Time.stop();
                jButton.setEnabled(true);
                jButton2.setEnabled(false);
            }

        });

        /* desabilitando o botao stop quando inicia a tela */
        jButton2.setEnabled(false);

        add(panel, BorderLayout.WEST); /* posicionar a esquerda */
        // add(panel, BorderLayout.CENTER); /* posicionar a esquerda */
        /* sempre será o ultimo comando */
        setVisible(true); /* torna a tela visivel para o usuario */
    };

}
