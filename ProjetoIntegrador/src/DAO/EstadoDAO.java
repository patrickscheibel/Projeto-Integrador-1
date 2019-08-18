/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import Entidade.Estado;
import Entidade.Usuario;
import Hibernate.HibernateUtil;
import Tela.JIframeEstado;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
/**
 *
 * @author conti
 */
public class EstadoDAO {
    
    public void SalvarEstado(Estado estado, JIframeEstado jframeEstado, Usuario usuario){
        Session sessao = null;
        JIframeEstado jfr = jframeEstado;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();

            if(!estado.getDescricao().equals("")){
                
                if(estado.getId() == null){                 
                    sessao.save(estado);                     
                    t.commit();    
                    new AuditoriaDAO().SalvarAuditoria("Insert", estado.toString(), usuario);
                    jfr.popularTabelaSalvar();
                } else {
                    sessao.update(estado);  
                    t.commit();
                    new AuditoriaDAO().SalvarAuditoria("Update", estado.toString(), usuario);
                    jfr.popularTabelaSalvar();
                }
                                
            } else {
                String descricao = estado.getId() == null ? "Insert" : "Update";
                new LogDAO().SalvarLog(descricao, "Dados Invalidos ou não informados", estado.toString());
            }
          
        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            sessao.close();
        }

    }
    
    public void ExcluirEstado(Integer id, Usuario usuario){
        Session sessao = null;
        try {
        sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessao.beginTransaction();
     
        Estado estado = ConsultarEstado(id);
        if(estado != null){
            sessao.delete(estado);  
            t.commit(); 
            new AuditoriaDAO().SalvarAuditoria("Delete", estado.toString(), usuario);
        }
        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            sessao.close();
        }  
    }
          
    public List<Estado> ConsultarTodos() {
//    - método para consultar
        List resultado = null;

            try {
                Session sessao = HibernateUtil.getSessionFactory().openSession();
                sessao.beginTransaction();
                
                org.hibernate.Query q = sessao.createQuery("from Estado");
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
        List<Estado> lista = ConsultarTodos();

        // cabecalho da tabela
        Object[] cabecalho = new Object[2];
        cabecalho[0] = "Id";
        cabecalho[1] = "Descrição";
        

        // cria matriz de acordo com nº de registros da tabela
        try {
            
            dadosTabela = new Object[lista.size()][2];

        } catch (Exception e) {
            System.out.println("Erro ao consultar os Estados: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
          
            for (Estado estado : lista) {
                
                dadosTabela[lin][0] = estado.getId();
                dadosTabela[lin][1] = estado.getDescricao();
               

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
    
    public Estado ConsultarEstado(int id) {
     Estado estado = new Estado();

         try {
             Session sessao = HibernateUtil.getSessionFactory().openSession();
             sessao.beginTransaction();

             org.hibernate.Query q = sessao.createQuery("from Estado where id = " + id);
             estado = Estado.class.cast(q.uniqueResult());

         } catch (HibernateException he) {
             he.printStackTrace();
         }
         return estado;
     }    

    
}
