package com.threadbasic.thread_fila_pilha;

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
import java.awt.BorderLayout;

public class TelaTimerThread extends JDialog {

    /* declarando Panel */
    private JPanel panel = new JPanel(new GridBagLayout());/* painel de componentes */

    private JLabel descricaoHora = new JLabel("Nome: ");
    private JTextField mostraTempo = new JTextField();

    private JLabel descricaoHora2 = new JLabel("E-mail: ");
    private JTextField mostraTempo2 = new JTextField();

    private JButton jButton = new JButton("Add Lista"); /* definindo botao start */
    private JButton jButton2 = new JButton("Stop"); /* definindo botao start */

    private ImplementacaoFilaThread fila = new ImplementacaoFilaThread();

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
        panel.add(mostraTempo, constraints); /* incluido no painelt */

        // constraints.gridx++; /* linha 0 */
        descricaoHora2.setPreferredSize(new DimensionUIResource(200, 25)); /* definindo o tamanho da label */
        constraints.gridy++; /* linha 0 */
        panel.add(descricaoHora2, constraints); /* incluido no painel */

        mostraTempo2.setPreferredSize(new DimensionUIResource(200, 25)); /* Campo Horas */
        constraints.gridy++; /* coluna 1 */
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

                if(fila == null){
                    fila = new ImplementacaoFilaThread();
                    fila.start();
                };

                for (int qtd = 0; qtd < 100; qtd++) {/* simulando 100 envios em massa de arquivos */

                    ObjetoFilaThread filaThread = new ObjetoFilaThread();
                    filaThread.setNome(mostraTempo.getText());
                    filaThread.setEmail(mostraTempo2.getText() + " - " + qtd);

                    fila.add(filaThread);
                }
            }

        });

        /* executa o clique do botao2 */
        jButton2.addActionListener(new ActionListener() {

            /*
             * (non-Javadoc)
             * 
             * @see
             * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                fila.stop();
                fila = null;
            }

        });

        fila.start();

        add(panel, BorderLayout.WEST); /* posicionar a esquerda */
        // add(panel, BorderLayout.CENTER); /* posicionar a esquerda */
        /* sempre será o ultimo comando */
        setVisible(true); /* torna a tela visivel para o usuario */
    };

}
