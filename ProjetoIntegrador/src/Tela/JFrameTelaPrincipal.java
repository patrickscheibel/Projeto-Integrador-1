/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tela;

import DAO.AuditoriaDAO;
import DAO.UsuarioDAO;
import Entidade.Usuario;

/**
 *
 * @author patrick.scheibel
 */
public class JFrameTelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form JFrameTelaPrincipal
     */
    Usuario usuario;
    
    public JFrameTelaPrincipal() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        usuario = new UsuarioDAO().ConsultarUsuario(1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPanel = new javax.swing.JDesktopPane();
        jButtonFechar = new javax.swing.JButton();
        jLabelEmpresa = new javax.swing.JLabel();
        jLabelUsuario = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenuMaterial = new javax.swing.JMenuItem();
        jMenuItemFormula = new javax.swing.JMenuItem();
        jMenuEstado = new javax.swing.JMenuItem();
        jMenuUsuario = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Principal");

        jButtonFechar.setText("Fechar");
        jButtonFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFecharActionPerformed(evt);
            }
        });

        jLabelEmpresa.setBackground(new java.awt.Color(51, 51, 51));
        jLabelEmpresa.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelEmpresa.setForeground(new java.awt.Color(255, 255, 255));

        jLabelUsuario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jDesktopPanel.setLayer(jButtonFechar, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPanel.setLayer(jLabelEmpresa, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPanel.setLayer(jLabelUsuario, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPanelLayout = new javax.swing.GroupLayout(jDesktopPanel);
        jDesktopPanel.setLayout(jDesktopPanelLayout);
        jDesktopPanelLayout.setHorizontalGroup(
            jDesktopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPanelLayout.createSequentialGroup()
                .addContainerGap(363, Short.MAX_VALUE)
                .addGroup(jDesktopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPanelLayout.createSequentialGroup()
                        .addComponent(jLabelEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(96, 96, 96))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPanelLayout.createSequentialGroup()
                        .addComponent(jButtonFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        jDesktopPanelLayout.setVerticalGroup(
            jDesktopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonFechar)
                .addGap(22, 22, 22)
                .addComponent(jLabelEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 228, Short.MAX_VALUE)
                .addComponent(jLabelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        jMenu4.setText("Cadastrar");

        jMenuMaterial.setText("Material");
        jMenuMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuMaterialActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuMaterial);

        jMenuItemFormula.setText("Fórmula");
        jMenuItemFormula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemFormulaActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItemFormula);

        jMenuEstado.setText("Estado");
        jMenuEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuEstadoActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuEstado);

        jMenuUsuario.setText("Usuário");
        jMenuUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuUsuarioActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuUsuario);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPanel, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPanel)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFecharActionPerformed
    this.dispose();
    }//GEN-LAST:event_jButtonFecharActionPerformed

    private void jMenuMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuMaterialActionPerformed
    JIframeMaterial jifMaterial = new JIframeMaterial(usuario);    
    jDesktopPanel.add(jifMaterial);
    jifMaterial.setVisible(true);
    }//GEN-LAST:event_jMenuMaterialActionPerformed

    private void jMenuItemFormulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemFormulaActionPerformed
    JIframeFormula jifFormula = new JIframeFormula(usuario);    
    jDesktopPanel.add(jifFormula);
    jifFormula.setVisible(true);
    }//GEN-LAST:event_jMenuItemFormulaActionPerformed

    private void jMenuEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuEstadoActionPerformed
    JIframeEstado jifEstado = new JIframeEstado(usuario);    
    jDesktopPanel.add(jifEstado);
    jifEstado.setVisible(true);
    }//GEN-LAST:event_jMenuEstadoActionPerformed

    private void jMenuUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuUsuarioActionPerformed
    JIframeUsuario jifUsuario = new JIframeUsuario(usuario);    
    jDesktopPanel.add(jifUsuario);
    jifUsuario.setVisible(true);
    }//GEN-LAST:event_jMenuUsuarioActionPerformed

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
            java.util.logging.Logger.getLogger(JFrameTelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameTelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameTelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameTelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameTelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonFechar;
    private javax.swing.JDesktopPane jDesktopPanel;
    private javax.swing.JLabel jLabelEmpresa;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuEstado;
    private javax.swing.JMenuItem jMenuItemFormula;
    private javax.swing.JMenuItem jMenuMaterial;
    private javax.swing.JMenuItem jMenuUsuario;
    // End of variables declaration//GEN-END:variables
}
