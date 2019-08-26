/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import Entidade.Estado;
import Entidade.Usuario;
import Hibernate.HibernateUtil;
import Tela.Apoio.DlgAviso;
import Tela.JIframeEstado;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.hibernate.HibernateException;
import org.hibernate.Session;
/**
 *
 * @author conti
 */
public class EstadoDAO extends DAO{
    
    public void SalvarEstado(Estado estado, JIframeEstado jIframeEstado, Usuario usuario){
        JIframeEstado jif = jIframeEstado;
        if(!estado.getDescricao().isEmpty()){
            if(estado.getId() == null){
                Salvar(estado, usuario);
                jif.popularTabelaSalvar();
            } else {
                Atualizar(estado, usuario);  
                jif.popularTabelaSalvar();
            }
        } else {
            new DlgAviso("Descrição Incorreta ou invalida");
        }
    }
    
    public void ExcluirEstado(Integer estadoId, Usuario usuario){
        if(usuario != null){
            Estado estado = new EstadoDAO().ConsultarEstado(estadoId);         
            Excluir(estado, usuario);
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
