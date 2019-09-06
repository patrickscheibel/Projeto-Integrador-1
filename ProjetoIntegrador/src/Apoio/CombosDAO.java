///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Apoio;
//
//import java.sql.ResultSet;
//import java.sql.Statement;
//import javax.swing.JComboBox;
//
///**
// *
// * @author patrick.scheibel
// */
//    public class CombosDAO {
//
//      ResultSet resultado = null;
//    
//        // construtor 1
//    public void popularCombo(String tabela, String order, JComboBox combo) {
//        
//        combo.removeAllItems();
//
//        ComboItem item = new ComboItem();
//        item.setCodigo(0);
//        item.setDescricao("Selecione");
//        combo.addItem(item);
//
//        try {
//            resultado = new ConexaoBD().getConnection().createStatement().executeQuery("select * from " + tabela + " order by " + order);
//
//            if (resultado.isBeforeFirst()) {
//                while (resultado.next()) {
//                    item = new ComboItem();
//                    item.setCodigo(resultado.getInt(1));
//                    item.setDescricao(resultado.getString(2));
//
//                    combo.addItem(item);
//                }
//            }
//        } catch (Exception e) {
//            System.out.println("Erro ao popular Combo = " + e.toString());
//        }
//    }
//    
//        // construtor 2
//        public void popularCombo(String tabela, String campo1, String campo2, JComboBox combo, String complementoSQL) {
//
//            combo.removeAllItems();
//
//            ComboItem item = new ComboItem();
//            item.setCodigo(0);
//            item.setDescricao("Selecione");
//            combo.addItem(item);
//
//            try {
//                resultado = new ConexaoBD().getConnection().createStatement().executeQuery("select * from " + tabela + " " + complementoSQL);
//
//                if (resultado.isBeforeFirst()) {
//                    while (resultado.next()) {
//                        item = new ComboItem();
//                        item.setCodigo(resultado.getInt(campo1));
//                        item.setDescricao(resultado.getString(campo2));
//
//                        combo.addItem(item);
//                    }
//                }
//            } catch (Exception e) {
//                System.out.println("Erro ao popular Combo = " + e.toString());
//            }
//        }
//
//        public void definirItemCombo(JComboBox combo, ComboItem item) {
//            for (int i = 0; i < combo.getItemCount(); i++) {
//                if (((ComboItem) combo.getItemAt(i)).getCodigo() == (item.getCodigo())) {
//                    combo.setSelectedIndex(i);
//                    return;
//                }
//            }
//        }
//        
//        //Buscar por nome
//        public int polularComboPorString(String descricao, String tabela) {
//        
//            int posicao = 0;           
//        try {
//            resultado = new ConexaoBD().getConnection().createStatement().executeQuery("select * from " + tabela + " where descricao ILIKE '%" + descricao + "%'");
//
//            if (resultado.next()) {
//                    posicao = resultado.getInt("id");
//            }
//        } catch (Exception e) {
//            System.out.println("Erro ao retornar o id = " + e.toString());
//        }
//        return posicao;
//        }
//}
