/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package interfaces;

import jogo2048.Tabuleiro;

/**
 *
 * @author marco
 */
public class MenuInicial extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    
    int dificuldade;
    
    public MenuInicial(String dificuldade) {
        initComponents();
        
        if(dificuldade=="Facil"){
            this.dificuldade = 0;
        }
        else if(dificuldade=="Médio"){
            this.dificuldade = 1;
        }
        else if(dificuldade=="Dificil"){
            this.dificuldade = 3;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botaoSair = new javax.swing.JButton();
        botaoJogar = new javax.swing.JButton();
        botaoOpcoes = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(600, 170));
        setMinimumSize(new java.awt.Dimension(700, 700));
        setResizable(false);
        getContentPane().setLayout(null);

        botaoSair.setBackground(new java.awt.Color(153, 153, 153));
        botaoSair.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        botaoSair.setForeground(new java.awt.Color(255, 255, 255));
        botaoSair.setText("SAIR");
        botaoSair.setToolTipText("");
        botaoSair.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(51, 51, 51), new java.awt.Color(51, 51, 51)));
        botaoSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSairActionPerformed(evt);
            }
        });
        getContentPane().add(botaoSair);
        botaoSair.setBounds(240, 450, 210, 70);

        botaoJogar.setBackground(new java.awt.Color(153, 153, 153));
        botaoJogar.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        botaoJogar.setForeground(new java.awt.Color(255, 255, 255));
        botaoJogar.setText("JOGAR");
        botaoJogar.setToolTipText("");
        botaoJogar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(51, 51, 51), new java.awt.Color(51, 51, 51)));
        botaoJogar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoJogarMouseClicked(evt);
            }
        });
        botaoJogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoJogarActionPerformed(evt);
            }
        });
        getContentPane().add(botaoJogar);
        botaoJogar.setBounds(240, 250, 210, 70);

        botaoOpcoes.setBackground(new java.awt.Color(153, 153, 153));
        botaoOpcoes.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        botaoOpcoes.setForeground(new java.awt.Color(255, 255, 255));
        botaoOpcoes.setText("OPÇÕES");
        botaoOpcoes.setToolTipText("");
        botaoOpcoes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, new java.awt.Color(51, 51, 51), new java.awt.Color(51, 51, 51)));
        botaoOpcoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoOpcoesMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                botaoOpcoesMouseReleased(evt);
            }
        });
        botaoOpcoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoOpcoesActionPerformed(evt);
            }
        });
        getContentPane().add(botaoOpcoes);
        botaoOpcoes.setBounds(240, 350, 210, 70);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/MelhorFundo.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 700, 700);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_botaoSairActionPerformed

    private void botaoOpcoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoOpcoesActionPerformed
        // Botão opções
        MenuOpcoes menuOpcoes = new MenuOpcoes();
        menuOpcoes.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_botaoOpcoesActionPerformed

    private void botaoJogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoJogarActionPerformed
        // Botão jogar
        Tabuleiro tab = new Tabuleiro(4,4,this.dificuldade);
        TelaPrincipal tela = new TelaPrincipal(tab);
        tab.setElementos();
        tela.setComponentes(tab.getMatrizElemento());
        tela.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_botaoJogarActionPerformed

    private void botaoOpcoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoOpcoesMouseClicked
        // TODO add your handling code here:
        // Botão opções
    }//GEN-LAST:event_botaoOpcoesMouseClicked

    private void botaoOpcoesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoOpcoesMouseReleased
        
    }//GEN-LAST:event_botaoOpcoesMouseReleased

    private void botaoJogarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoJogarMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_botaoJogarMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuInicial("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoJogar;
    private javax.swing.JButton botaoOpcoes;
    private javax.swing.JButton botaoSair;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
