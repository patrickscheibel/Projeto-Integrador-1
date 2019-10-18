/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tela;

import DAO.UsuarioDAO;
import Entidade.Usuario;
import Apoio.Permissoes;
import javax.swing.JInternalFrame;

/**
 *
 * @author patrick.scheibel
 */
public class JFrameTelaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form JFrameTelaPrincipal
     */
    Usuario usuario = new Usuario();
    
    public JFrameTelaPrincipal(Usuario usuarios) {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        usuario = usuarios;
    }
    
    public void Ver(JInternalFrame jif){
        jDesktopPanel.add(jif);
        jif.setVisible(true);
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
        jButtonSair = new javax.swing.JButton();
        jLabelEmpresa = new javax.swing.JLabel();
        jLabelUsuario = new javax.swing.JLabel();
        jButtonConfiguracao = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu4 = new javax.swing.JMenu();
        jMenuMaterial = new javax.swing.JMenuItem();
        jMenuUsuario = new javax.swing.JMenuItem();
        jMenuTipoMaterial = new javax.swing.JMenuItem();
        jMenuCorMaterial = new javax.swing.JMenuItem();
        jMenuCorMaterial1 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItemGrupoPemissao = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela Principal");

        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        jLabelEmpresa.setBackground(new java.awt.Color(51, 51, 51));
        jLabelEmpresa.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabelEmpresa.setForeground(new java.awt.Color(255, 255, 255));

        jLabelUsuario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jButtonConfiguracao.setText("Configuração");
        jButtonConfiguracao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConfiguracaoActionPerformed(evt);
            }
        });

        jDesktopPanel.setLayer(jButtonSair, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPanel.setLayer(jLabelEmpresa, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPanel.setLayer(jLabelUsuario, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPanel.setLayer(jButtonConfiguracao, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPanelLayout = new javax.swing.GroupLayout(jDesktopPanel);
        jDesktopPanel.setLayout(jDesktopPanelLayout);
        jDesktopPanelLayout.setHorizontalGroup(
            jDesktopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPanelLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPanelLayout.createSequentialGroup()
                .addContainerGap(214, Short.MAX_VALUE)
                .addComponent(jLabelEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125)
                .addGroup(jDesktopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonConfiguracao))
                .addGap(23, 23, 23))
        );
        jDesktopPanelLayout.setVerticalGroup(
            jDesktopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonSair)
                .addGap(22, 22, 22)
                .addGroup(jDesktopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelEmpresa, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonConfiguracao))
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

        jMenuUsuario.setText("Usuário");
        jMenuUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuUsuarioActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuUsuario);

        jMenuTipoMaterial.setText("Tipo de Material");
        jMenuTipoMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuTipoMaterialActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuTipoMaterial);

        jMenuCorMaterial.setText("Cor do Material");
        jMenuCorMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCorMaterialActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuCorMaterial);

        jMenuCorMaterial1.setText("Projeto");
        jMenuCorMaterial1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCorMaterial1ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuCorMaterial1);

        jMenuBar1.add(jMenu4);

        jMenu1.setText("Permissão");

        jMenuItemGrupoPemissao.setText("Grupos de Permissões");
        jMenuItemGrupoPemissao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGrupoPemissaoActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItemGrupoPemissao);

        jMenuBar1.add(jMenu1);

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

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        JframeLoginUsuario jf = new JframeLoginUsuario();
        this.dispose();
        jf.setVisible(true);
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jMenuMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuMaterialActionPerformed
        JIframeMaterial jifMaterial = new JIframeMaterial(usuario);     
        new Permissoes().Material(this, jifMaterial, usuario);
    }//GEN-LAST:event_jMenuMaterialActionPerformed

    private void jMenuUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuUsuarioActionPerformed
        JIframeUsuario jifUsuario = new JIframeUsuario(usuario);    
        new Permissoes().Usuario(this, jifUsuario, usuario);
    }//GEN-LAST:event_jMenuUsuarioActionPerformed

    private void jButtonConfiguracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfiguracaoActionPerformed
        JIframeConfiguracao jifconfiguracao = new JIframeConfiguracao(usuario);    
        new Permissoes().Configuracao(this, jifconfiguracao, usuario);
    }//GEN-LAST:event_jButtonConfiguracaoActionPerformed

    private void jMenuTipoMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuTipoMaterialActionPerformed
        JIframeTipoMaterial jifTipoMaterial = new JIframeTipoMaterial(usuario);    
        new Permissoes().TipoMaterial(this, jifTipoMaterial, usuario);
    }//GEN-LAST:event_jMenuTipoMaterialActionPerformed

    private void jMenuCorMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCorMaterialActionPerformed
        JIframeCorMaterial jifCorMaterial = new JIframeCorMaterial(usuario);    
        new Permissoes().CorMaterial(this, jifCorMaterial, usuario);
    }//GEN-LAST:event_jMenuCorMaterialActionPerformed

    private void jMenuItemGrupoPemissaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGrupoPemissaoActionPerformed
        JIframeGrupoPermissao jifGrupoPermissao = new JIframeGrupoPermissao(usuario);    
        new Permissoes().GrupoPermissao(this, jifGrupoPermissao, usuario);
    }//GEN-LAST:event_jMenuItemGrupoPemissaoActionPerformed

    private void jMenuCorMaterial1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCorMaterial1ActionPerformed
        JIFrameAmbiente jif = new JIFrameAmbiente(usuario);
        jDesktopPanel.add(jif);
        jif.setVisible(true);
    }//GEN-LAST:event_jMenuCorMaterial1ActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(JFrameTelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(JFrameTelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(JFrameTelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(JFrameTelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new JFrameTelaPrincipal().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConfiguracao;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JDesktopPane jDesktopPanel;
    private javax.swing.JLabel jLabelEmpresa;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuCorMaterial;
    private javax.swing.JMenuItem jMenuCorMaterial1;
    private javax.swing.JMenuItem jMenuItemGrupoPemissao;
    private javax.swing.JMenuItem jMenuMaterial;
    private javax.swing.JMenuItem jMenuTipoMaterial;
    private javax.swing.JMenuItem jMenuUsuario;
    // End of variables declaration//GEN-END:variables
}
