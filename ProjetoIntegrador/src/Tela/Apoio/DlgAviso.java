/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tela.Apoio;

import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author Scheibel
 */
public class DlgAviso extends javax.swing.JDialog {

    JFrame frame = new JFrame();
    JDialog dialog = new JDialog();
    /**
     * Creates new form DlgComplemetar
     */
    public DlgAviso(JDialog tela, String aviso) {
        initComponents();
        setModal(true);
        dialog = tela;
        jLabelAviso.setText(aviso);
        this.setLocationRelativeTo(null);
    }
    
    public DlgAviso(JFrame tela, String aviso) {
        initComponents();
        setModal(true);
        frame = tela;
        jLabelAviso.setText(aviso);
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelAviso = new javax.swing.JLabel();
        jButtonVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Aviso");

        jLabelAviso.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelAviso.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jButtonVoltar.setText("Voltar");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabelAviso, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonVoltar)
                .addGap(75, 75, 75))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabelAviso, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jButtonVoltar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        if(frame != null){
            this.dispose();
            frame.setVisible(true);
        }
        if(dialog != null){
            this.dispose();
            dialog.setVisible(true);
        }
    }//GEN-LAST:event_jButtonVoltarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JLabel jLabelAviso;
    // End of variables declaration//GEN-END:variables
}
