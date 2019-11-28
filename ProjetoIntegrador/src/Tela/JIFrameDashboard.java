/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tela;

import Apoio.ComboDAO;
import DAO.AmbienteDAO;
import DAO.CamadaDAO;
import DAO.FaceDAO;
import DAO.MaterialDAO;
import DAO.ProjetoDAO;
import Entidade.Ambiente;
import Entidade.Face;
import Entidade.Material;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Scheibel
 */
public class JIFrameDashboard extends javax.swing.JInternalFrame {

    /**
     * Creates new form JIFrameMaterialGrafico
     */
    public JIFrameDashboard() {
        initComponents();
        jComboBoxSelecionarFace.setVisible(false);
        jButtonUso.setEnabled(false);
        jButtonComparar.setEnabled(false);      
        jButtonComodo.setEnabled(false);
        
        jButtonConsultarMaterial.setVisible(false);
        jLabelFace.setVisible(false);
                
        jLabelQtdProjeto.setText(new ProjetoDAO().QuantidadeDeProjeto() + "");
        jLabelQtdMateriais.setText(new MaterialDAO().QuantidadeDeMaterial() + "");
        new ComboDAO().popularComboProjeto("Projeto", "", jComboBoxSelecionarProjeto);
    }
    
    public void filtroMaterial(boolean status){
        new ComboDAO().popularComboFace(jComboBoxSelecionarProjeto.getSelectedIndex(), jComboBoxSelecionarFace);
        jComboBoxSelecionarFace.setVisible(status);
        jButtonConsultarMaterial.setVisible(status);
        jLabelFace.setVisible(status);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jButton1 = new javax.swing.JButton();
        jButtonSair = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabelQtdProjeto = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabelQtdMateriais = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jComboBoxSelecionarProjeto = new javax.swing.JComboBox<>();
        jButtonUso = new javax.swing.JButton();
        jButtonComparar = new javax.swing.JButton();
        jButtonComodo = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jComboBoxSelecionarFace = new javax.swing.JComboBox<>();
        jButtonConsultarMaterial = new javax.swing.JButton();
        jLabelFace = new javax.swing.JLabel();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jButton1.setText("jButton1");

        setTitle("Dashboard");

        jButtonSair.setText("Sair");
        jButtonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 718, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 386, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Projetos:");

        jLabelQtdProjeto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelQtdProjeto.setText("AAA");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabelQtdProjeto)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabelQtdProjeto))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Materiais: ");

        jLabelQtdMateriais.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabelQtdMateriais.setText("AAA");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabelQtdMateriais)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabelQtdMateriais))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jComboBoxSelecionarProjeto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxSelecionarProjeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSelecionarProjetoActionPerformed(evt);
            }
        });

        jButtonUso.setText("Uso dos materiais");
        jButtonUso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUsoActionPerformed(evt);
            }
        });

        jButtonComparar.setText("Comparar preços do materiais ");
        jButtonComparar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCompararActionPerformed(evt);
            }
        });

        jButtonComodo.setText("Comparar Comodos");
        jButtonComodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonComodoActionPerformed(evt);
            }
        });

        jLabel3.setText("Selecione um Projeto");

        jComboBoxSelecionarFace.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxSelecionarFace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSelecionarFaceActionPerformed(evt);
            }
        });

        jButtonConsultarMaterial.setText("Consultar");
        jButtonConsultarMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConsultarMaterialActionPerformed(evt);
            }
        });

        jLabelFace.setText("Selecionar face:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(153, 153, 153)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 718, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(45, 45, 45))
            .addGroup(layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelFace)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxSelecionarFace, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonConsultarMaterial))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(162, 162, 162)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBoxSelecionarProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonUso)
                        .addGap(62, 62, 62)
                        .addComponent(jButtonComparar)
                        .addGap(73, 73, 73)
                        .addComponent(jButtonComodo)
                        .addGap(113, 113, 113))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSair))
                .addGap(21, 21, 21)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxSelecionarProjeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonComparar)
                    .addComponent(jButtonUso)
                    .addComponent(jButtonComodo))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonConsultarMaterial)
                    .addComponent(jComboBoxSelecionarFace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelFace))
                .addGap(15, 15, 15)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButtonSairActionPerformed

    private void jComboBoxSelecionarProjetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSelecionarProjetoActionPerformed
        if(jComboBoxSelecionarProjeto.getSelectedIndex() > 0){
            jButtonUso.setEnabled(true);   
            jButtonComparar.setEnabled(true);   
            jButtonComodo.setEnabled(true);      
        }
    }//GEN-LAST:event_jComboBoxSelecionarProjetoActionPerformed

    private void jButtonUsoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUsoActionPerformed
        if(jComboBoxSelecionarProjeto.getSelectedIndex() > 0){
            List<Material> lista = new MaterialDAO().ConsultarMaterialPorProjeto(jComboBoxSelecionarProjeto.getSelectedIndex());
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            for(Material material : lista) {
                Integer qtd = new CamadaDAO().ContarCamadaPorMaterial(material.getId());
                dataset.addValue(qtd, "Material", material.getDescricao());
            }

            filtroMaterial(true);
            
            JFreeChart chart = null;
            chart = ChartFactory.createBarChart3D("Material",
                    "Material", "Frequência de uso", dataset, PlotOrientation.VERTICAL, false, true, false);
            CategoryPlot p = chart.getCategoryPlot();
            p.setRangeGridlinePaint(Color.black);

            ChartPanel cp = new ChartPanel(chart);
            jPanel1.setLayout(new java.awt.BorderLayout());
            jPanel1.add(cp, BorderLayout.CENTER);
            jPanel1.validate();
        }
    }//GEN-LAST:event_jButtonUsoActionPerformed

    private void jButtonCompararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCompararActionPerformed
        if(jComboBoxSelecionarProjeto.getSelectedIndex() > 0){
            List<Material> lista = new MaterialDAO().ConsultarMaterialPorProjeto(jComboBoxSelecionarProjeto.getSelectedIndex());
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            for(Material material : lista) {
                double preco = material.getPreco();
                dataset.addValue(preco, "Material", material.getDescricao());
            }

            filtroMaterial(false);
            
            JFreeChart chart = null;
            chart = ChartFactory.createBarChart3D("Material",
                    "Material", "Preço", dataset, PlotOrientation.VERTICAL, false, true, false);
            CategoryPlot p = chart.getCategoryPlot();
            p.setRangeGridlinePaint(Color.black);

            ChartPanel cp = new ChartPanel(chart);
            jPanel1.setLayout(new java.awt.BorderLayout());
            jPanel1.add(cp, BorderLayout.CENTER);
            jPanel1.validate();
        }
    }//GEN-LAST:event_jButtonCompararActionPerformed

    private void jButtonComodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonComodoActionPerformed
        if(jComboBoxSelecionarProjeto.getSelectedIndex() > 0){
            List<Ambiente> lista = new AmbienteDAO().ConsultarListaPorProjeto(jComboBoxSelecionarProjeto.getSelectedIndex());
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            
            for(Ambiente ambiente : lista) {
                dataset.addValue(ambiente.getTransmitanciaTermica(), "Comodos", ambiente.getDescricao());
            }
            
            filtroMaterial(false);
            
            JFreeChart chart = null;
            chart = ChartFactory.createBarChart3D("Comodos",
                    "Comodo", "Transmitancia Térmica", dataset, PlotOrientation.VERTICAL, false, true, false);
            CategoryPlot p = chart.getCategoryPlot();
            p.setRangeGridlinePaint(Color.black);

            ChartPanel cp = new ChartPanel(chart);
            jPanel1.setLayout(new java.awt.BorderLayout());
            jPanel1.add(cp, BorderLayout.CENTER);
            jPanel1.validate();
        }
    }//GEN-LAST:event_jButtonComodoActionPerformed

    private void jComboBoxSelecionarFaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSelecionarFaceActionPerformed
   
    }//GEN-LAST:event_jComboBoxSelecionarFaceActionPerformed

    private void jButtonConsultarMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConsultarMaterialActionPerformed
        if(jComboBoxSelecionarFace.getSelectedIndex() > 0){
            List<Material> lista = new MaterialDAO().ConsultarMaterialPorFace(jComboBoxSelecionarProjeto.getSelectedIndex());
            Face face = new FaceDAO().ConsultarFace(jComboBoxSelecionarFace.getSelectedIndex());
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            for(Material material : lista) {
                Integer qtd = new CamadaDAO().ContarCamadaPorFace(material.getId(), face.getId());
                dataset.addValue(qtd, "Material", material.getDescricao());
            }
                            
            new ComboDAO().popularComboFace(jComboBoxSelecionarProjeto.getSelectedIndex(), jComboBoxSelecionarFace);
            
            JFreeChart chart = null;
            chart = ChartFactory.createBarChart3D("Material",
                    "Material", "Frequência de uso", dataset, PlotOrientation.VERTICAL, false, true, false);
            CategoryPlot p = chart.getCategoryPlot();
            p.setRangeGridlinePaint(Color.black);

            ChartPanel cp = new ChartPanel(chart);
            jPanel1.setLayout(new java.awt.BorderLayout());
            jPanel1.add(cp, BorderLayout.CENTER);
            jPanel1.validate();
        }
    }//GEN-LAST:event_jButtonConsultarMaterialActionPerformed
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonComodo;
    private javax.swing.JButton jButtonComparar;
    private javax.swing.JButton jButtonConsultarMaterial;
    private javax.swing.JButton jButtonSair;
    private javax.swing.JButton jButtonUso;
    private javax.swing.JComboBox<String> jComboBoxSelecionarFace;
    private javax.swing.JComboBox<String> jComboBoxSelecionarProjeto;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelFace;
    private javax.swing.JLabel jLabelQtdMateriais;
    private javax.swing.JLabel jLabelQtdProjeto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
