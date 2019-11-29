/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tela;

import Entidade.Usuario;
import Apoio.Permissoes;
import javax.swing.JInternalFrame;

/**
 *
 * @author patrick.scheibel
 */
public class JIFrameTelaPrincipal extends javax.swing.JFrame {

    Usuario usuario = new Usuario();
    /**
     * Creates new form JFrameTelaPrincipal
     */
       
    public JIFrameTelaPrincipal(Usuario usuarios) {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        usuario = usuarios;
    }
    
    public void VerJInternalFrame(JInternalFrame jif){
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
        jMenuMaterial = new javax.swing.JMenu();
        jMenuMateriais = new javax.swing.JMenuItem();
        jMenuTipoMaterial = new javax.swing.JMenuItem();
        jMenuCorMaterial = new javax.swing.JMenuItem();
        jMenuProjeto = new javax.swing.JMenu();
        jMenuProjetos = new javax.swing.JMenuItem();
        jMenuEmail = new javax.swing.JMenu();
        jMenuEnviarEmail = new javax.swing.JMenuItem();
        jMenuPermissao = new javax.swing.JMenu();
        jMenuItemGrupoPemissao = new javax.swing.JMenuItem();
        jMenuUsuario = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 230, Short.MAX_VALUE)
                .addComponent(jLabelUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        jMenuMaterial.setText("Material");

        jMenuMateriais.setText("Material");
        jMenuMateriais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuMateriaisActionPerformed(evt);
            }
        });
        jMenuMaterial.add(jMenuMateriais);

        jMenuTipoMaterial.setText("Tipo de Material");
        jMenuTipoMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuTipoMaterialActionPerformed(evt);
            }
        });
        jMenuMaterial.add(jMenuTipoMaterial);

        jMenuCorMaterial.setText("Cor do Material");
        jMenuCorMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCorMaterialActionPerformed(evt);
            }
        });
        jMenuMaterial.add(jMenuCorMaterial);

        jMenuBar1.add(jMenuMaterial);

        jMenuProjeto.setText("Projeto");
        jMenuProjeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuProjetoActionPerformed(evt);
            }
        });

        jMenuProjetos.setText("Projeto");
        jMenuProjetos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuProjetosActionPerformed(evt);
            }
        });
        jMenuProjeto.add(jMenuProjetos);

        jMenuBar1.add(jMenuProjeto);

        jMenuEmail.setText("Email");
        jMenuEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuEmailActionPerformed(evt);
            }
        });

        jMenuEnviarEmail.setText("Escrever email");
        jMenuEnviarEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuEnviarEmailActionPerformed(evt);
            }
        });
        jMenuEmail.add(jMenuEnviarEmail);

        jMenuBar1.add(jMenuEmail);

        jMenuPermissao.setText("Permissão");

        jMenuItemGrupoPemissao.setText("Grupos de Permissões");
        jMenuItemGrupoPemissao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemGrupoPemissaoActionPerformed(evt);
            }
        });
        jMenuPermissao.add(jMenuItemGrupoPemissao);

        jMenuUsuario.setText("Usuário");
        jMenuUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuUsuarioActionPerformed(evt);
            }
        });
        jMenuPermissao.add(jMenuUsuario);

        jMenuBar1.add(jMenuPermissao);

        jMenu1.setText("Gráfico");

        jMenuItem1.setText("Dashboard");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

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
            .addComponent(jDesktopPanel, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        JframeLoginUsuario jf = new JframeLoginUsuario();
        this.dispose();
        jf.setVisible(true);
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jMenuMateriaisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuMateriaisActionPerformed
        JIframeMaterial jifMaterial = new JIframeMaterial(usuario);     
        new Permissoes().Material(this, jifMaterial, usuario, "material");
    }//GEN-LAST:event_jMenuMateriaisActionPerformed

    private void jMenuUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuUsuarioActionPerformed
        JIframeUsuario jifUsuario = new JIframeUsuario(usuario);    
        new Permissoes().Usuario(this, jifUsuario, usuario, "usuario");
    }//GEN-LAST:event_jMenuUsuarioActionPerformed

    private void jButtonConfiguracaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConfiguracaoActionPerformed
        JIframeConfiguracao jifconfiguracao = new JIframeConfiguracao(usuario);    
        new Permissoes().Configuracao(this, jifconfiguracao, usuario, "configuracao");
    }//GEN-LAST:event_jButtonConfiguracaoActionPerformed

    private void jMenuTipoMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuTipoMaterialActionPerformed
        JIframeTipoMaterial jifTipoMaterial = new JIframeTipoMaterial(usuario);    
        new Permissoes().TipoMaterial(this, jifTipoMaterial, usuario, "tipoMaterial");
    }//GEN-LAST:event_jMenuTipoMaterialActionPerformed

    private void jMenuCorMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCorMaterialActionPerformed
        JIframeCorMaterial jifCorMaterial = new JIframeCorMaterial(usuario);    
        new Permissoes().CorMaterial(this, jifCorMaterial, usuario, "corMaterial");
    }//GEN-LAST:event_jMenuCorMaterialActionPerformed

    private void jMenuItemGrupoPemissaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemGrupoPemissaoActionPerformed
        JIframeGrupoPermissao jifGrupoPermissao = new JIframeGrupoPermissao(usuario);    
        new Permissoes().GrupoPermissao(this, jifGrupoPermissao, usuario, "grupoPermissao");
    }//GEN-LAST:event_jMenuItemGrupoPemissaoActionPerformed

    private void jMenuProjetosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuProjetosActionPerformed
        JIFrameProjeto jifProjeto = new JIFrameProjeto(usuario);
        new Permissoes().Projeto(this, jifProjeto, usuario, "projeto");
    }//GEN-LAST:event_jMenuProjetosActionPerformed

    private void jMenuEnviarEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuEnviarEmailActionPerformed
        JIFrameEmail jifEmail = new JIFrameEmail();
        new Permissoes().Email(this, jifEmail, usuario, "email");
    }//GEN-LAST:event_jMenuEnviarEmailActionPerformed

    private void jMenuEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuEmailActionPerformed

    }//GEN-LAST:event_jMenuEmailActionPerformed

    private void jMenuProjetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuProjetoActionPerformed
   
    }//GEN-LAST:event_jMenuProjetoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        JIFrameDashboard jif = new JIFrameDashboard();
        new Permissoes().Dashboard(this, jif, usuario, "dashboard");
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuCorMaterial;
    private javax.swing.JMenu jMenuEmail;
    private javax.swing.JMenuItem jMenuEnviarEmail;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItemGrupoPemissao;
    private javax.swing.JMenuItem jMenuMateriais;
    private javax.swing.JMenu jMenuMaterial;
    private javax.swing.JMenu jMenuPermissao;
    private javax.swing.JMenu jMenuProjeto;
    private javax.swing.JMenuItem jMenuProjetos;
    private javax.swing.JMenuItem jMenuTipoMaterial;
    private javax.swing.JMenuItem jMenuUsuario;
    // End of variables declaration//GEN-END:variables
}
