/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.DAO.Atualizar;
import static DAO.DAO.Excluir;
import static DAO.DAO.Salvar;
import Entidade.Projeto;
import Entidade.Usuario;
import Hibernate.HibernateUtil;
import Tela.Apoio.DlgAviso;
import Tela.JIFrameProjeto;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.hibernate.HibernateException;
import org.hibernate.Session;
/**
 *
 * @author patrick.scheibel
 */
public class ProjetoDAO extends DAO{
    
    public void SalvarProjeto(Projeto projeto, JIFrameProjeto jIframeProjeto, Usuario usuario){
        JIFrameProjeto jif = jIframeProjeto;
        if(!projeto.getDescricao().isEmpty() && !projeto.getNome().isEmpty()){
            if(projeto.getId() == null){
                if(Salvar(projeto, usuario) == true) {
                    jif.AvancarAmbiente();
                } else {
                    new DlgAviso("Descrição deve ter no maximo 100 caracteres");
                } 
            } else {
                if(Atualizar(projeto, usuario) == true){
                    jif.AvancarAmbiente();
                } else {
                    new DlgAviso("Descrição deve ter no maximo 100 caracteres");
                } 
                
            }
        } else {
            new DlgAviso("Descrição Incorreta ou invalida");
        }

    }
    
    public void ExcluirProjeto(Integer projetoId, Usuario usuario){
        if(usuario != null){
            Projeto projeto = new ProjetoDAO().ConsultarProjeto(projetoId);         
            Excluir(projeto, usuario);
        }
    }
          
    public List<Projeto> ConsultarTodos() {
//    - método para consultar
        List resultado = null;

        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            org.hibernate.Query q = sessao.createQuery("from Projeto");
            resultado = q.list();

        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return resultado;
    }           
    
    public Projeto ConsultarUltimo() {
        
        Projeto resultado = null;

        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            org.hibernate.Query q = sessao.createQuery("from Projeto");
            resultado = (Projeto) q.uniqueResult();

        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return resultado;
    }
   
    
       //Popular por um id
    public void popularTabela(JTable tabela) {
        // dados da tabela
        Object[][] dadosTabela = null;
        List<Projeto> lista = ConsultarTodos();

        // cabecalho da tabela
        Object[] cabecalho = new Object[3];
        cabecalho[0] = "Id";
        cabecalho[1] = "Nome";
        cabecalho[2] = "Descrição";
        

        // cria matriz de acordo com nº de registros da tabela
        try {
            
            dadosTabela = new Object[lista.size()][3];

        } catch (Exception e) {
            System.out.println("Erro ao consultar os Projetos: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
          
            for (Projeto projeto : lista) {
                
                dadosTabela[lin][0] = projeto.getId();
                dadosTabela[lin][1] = projeto.getNome();
                dadosTabela[lin][2] = projeto.getDescricao();
               

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
    
    public Projeto ConsultarProjeto(int id) {
     Projeto projeto = new Projeto();

         try {
             Session sessao = HibernateUtil.getSessionFactory().openSession();
             sessao.beginTransaction();

             org.hibernate.Query q = sessao.createQuery("from Projeto where id = " + id);
             projeto = Projeto.class.cast(q.uniqueResult());

         } catch (HibernateException he) {
             he.printStackTrace();
         }
         return projeto;
     }    
}
