/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidade.Formula;
import Hibernate.HibernateUtil;
import Tela.JframeFormula;
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
public class FormulaDAO {
    
    public void SalvarFormula(Formula formula, JframeFormula jframeFormula){
        Session sessao = null;
        JframeFormula jfr = jframeFormula;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();

            if(formula.getNome() != "" && formula.getDescricao() != ""){
                
                if(formula.getId() == null){                 
                    sessao.save(formula);                     
                    t.commit();    
                    jfr.popularTabelaSalvar();
                } else {
                    sessao.update(formula);  
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
    
    public void ExcluirFormula(Integer id){
        Session sessao = null;
        try {
        sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessao.beginTransaction();
     
        Formula formula = ConsultarFormula(id);
        if(formula != null){
            sessao.delete(formula);  
            t.commit(); 
        }
        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            sessao.close();
        }  
    }
          
    public List<Formula> ConsultarTodos() {
//    - método para consultar
        List resultado = null;

            try {
                Session sessao = HibernateUtil.getSessionFactory().openSession();
                sessao.beginTransaction();
                
                org.hibernate.Query q = sessao.createQuery("from Formula");
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
        List<Formula> lista = ConsultarTodos();

        // cabecalho da tabela
        Object[] cabecalho = new Object[3];
        cabecalho[0] = "Id";
        cabecalho[1] = "Nome";
        cabecalho[2] = "Descrição";
        

        // cria matriz de acordo com nº de registros da tabela
        try {
            
            dadosTabela = new Object[lista.size()][6];

        } catch (Exception e) {
            System.out.println("Erro ao consultar os Formulas: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
          
            for (Formula formula : lista) {
                
                dadosTabela[lin][0] = formula.getId();
                dadosTabela[lin][1] = formula.getNome();
                dadosTabela[lin][2] = formula.getDescricao();
               

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
    
    public Formula ConsultarFormula(int id) {
     Formula formula = new Formula();

         try {
             Session sessao = HibernateUtil.getSessionFactory().openSession();
             sessao.beginTransaction();

             org.hibernate.Query q = sessao.createQuery("from Formula where id = " + id);
             formula = Formula.class.cast(q.uniqueResult());

         } catch (HibernateException he) {
             he.printStackTrace();
         }
         return formula;
     }    
}
