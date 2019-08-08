/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidade.Material;
import Hibernate.HibernateUtil;
import Tela.JIframeMaterial;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author patrick.scheibel
 */
public class MaterialDAO {
    
    public void SalvarMaterial(Material material, JIframeMaterial jframeMaterial){
        Session sessao = null;
        JIframeMaterial jfr = jframeMaterial;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();

            if(!material.getDescricao().equals("") && !material.getPreco().equals("   .  ")){
                if(material.getId() == null){
                    sessao.save(material);                     
                    t.commit();    
                    jfr.popularTabelaSalvar();
                } else {
                    sessao.update(material);  
                    t.commit(); 
                    jfr.popularTabelaSalvar();
                }
            }
          
        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            sessao.close();
        }

    }
    
    public void ExcluirMaterial(Integer id){
        Session sessao = null;
        try {
        sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessao.beginTransaction();
     
        Material material = ConsultarMaterial(id);
        if(material != null){
            sessao.delete(material);  
            t.commit(); 
        }
        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            sessao.close();
        }  
    }
          
    public List<Material> ConsultarTodos() {
//    - método para consultar
        List resultado = null;

            try {
                Session sessao = HibernateUtil.getSessionFactory().openSession();
                sessao.beginTransaction();
                
                org.hibernate.Query q = sessao.createQuery("from Material");
                resultado = q.list();

            } catch (HibernateException he) {
                he.printStackTrace();
            }
            return resultado;
        }           
      
   
    
       //Popular por um id
    public void popularTabela(JTable tabela) {
        // dados da tabela
        Object[][] dadosTabela = null;
        List<Material> lista = ConsultarTodos();

        // cabecalho da tabela
        Object[] cabecalho = new Object[6];
        cabecalho[0] = "Id";
        cabecalho[1] = "Descrição";
        cabecalho[2] = "Tipo";
        cabecalho[3] = "Tamanho";
        cabecalho[4] = "Aplicação";
        cabecalho[5] = "Preço";

        // cria matriz de acordo com nº de registros da tabela
        try {
            
            dadosTabela = new Object[lista.size()][6];

        } catch (Exception e) {
            System.out.println("Erro ao consultar os Materiais: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
          
            for (Material material : lista) {
                
                dadosTabela[lin][0] = material.getId();
                dadosTabela[lin][1] = material.getDescricao();
                dadosTabela[lin][2] = material.getTipo();
                dadosTabela[lin][3] = material.getTamanho();
                dadosTabela[lin][4] = material.getAplicacao();
                dadosTabela[lin][5] = material.getPreco();

                lin++;
            }
        } catch (Exception e) {
            System.out.println("problemas para popular tabela...");
            System.out.println(e);
        }

        // configuracoes adicionais no componente tabela
        tabela.setModel(new DefaultTableModel(dadosTabela, cabecalho) {
            @Override
            // quando retorno for FALSE, a tabela nao é editavel
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        });

        // permite seleção de apenas uma linha da tabela
        tabela.setSelectionMode(0);

        // redimensiona as colunas de uma tabela
        TableColumn column = null;
        for (int i = 0; i < tabela.getColumnCount(); i++) {
            column = tabela.getColumnModel().getColumn(i);
            switch (i) {
                case 0:
                    column.setPreferredWidth(17);
                    break;
                case 1:
                    column.setPreferredWidth(140);
                    break;
            }
        }

    }
    
    public Material ConsultarMaterial(int id) {
     Material material = new Material();

         try {
             Session sessao = HibernateUtil.getSessionFactory().openSession();
             sessao.beginTransaction();

             org.hibernate.Query q = sessao.createQuery("from Material where id = " + id);
             material = Material.class.cast(q.uniqueResult());

         } catch (HibernateException he) {
             he.printStackTrace();
         }
         return material;
     }    
}
