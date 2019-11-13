/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.DAO.Atualizar;
import static DAO.DAO.Excluir;
import static DAO.DAO.Salvar;
import Entidade.Ambiente;
import Entidade.Projeto;
import Entidade.Usuario;
import Hibernate.HibernateUtil;
import Tela.Apoio.DlgAviso;
import Tela.JIFrameAmbiente;
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
public class AmbienteDAO extends DAO{
      
    public void SalvarAmbiente(Ambiente ambiente, JIFrameAmbiente jIframeProjeto, Usuario usuario){
        JIFrameAmbiente jif = jIframeProjeto;
        if(!ambiente.getDescricao().isEmpty() && ambiente.getProjeto()!= null){
            if(ambiente.getId() == null){
                if(Salvar(ambiente, usuario) == true) {                  
                    jif.AvancarListaFace(ambiente);
                    jif.AtualizarTabelaFace(ambiente);
                } else {
                    new DlgAviso("Descrição deve ter no maximo 100 caracteres");
                } 
            } else {
                if(Atualizar(ambiente, usuario) == true){
                    jif.AvancarListaFace(ambiente);
                    jif.AtualizarTabelaFace(ambiente);
                } else {
                    new DlgAviso("Descrição deve ter no maximo 100 caracteres");
                } 
                
            }
        } else {
            new DlgAviso("Descrição Incorreta ou invalida");
        }
    }
    public void EditarAmbiente(Ambiente ambiente, JIFrameAmbiente jIframeProjeto, Usuario usuario){
        JIFrameAmbiente jif = jIframeProjeto;
        if(!ambiente.getDescricao().isEmpty() && ambiente.getProjeto()!= null){
            
            if(Atualizar(ambiente, usuario) == true){
                jif.AvancarListaAmbiente(ambiente.getProjeto());
            } else {
                new DlgAviso("Descrição deve ter no maximo 100 caracteres");
            }                      
        } else {
            new DlgAviso("Descrição Incorreta ou invalida");
        }
    }
    
    public void ExcluirAmbiente(Ambiente ambiente, Usuario usuario){
        if(ambiente != null && usuario != null){        
            Excluir(ambiente, usuario);
        }
    }
          
    public List<Ambiente> ConsultarListaPorId(int id) {
    List resultado = null;

        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            org.hibernate.Query q = sessao.createQuery("from Ambiente ambiente where ambiente.projeto.id = " + id);
            resultado = q.list();

        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return resultado;
    }           
      
   
    
       //Popular por um id
    public void popularTabela(JTable tabela, Projeto projeto) {
        // dados da tabela
        Object[][] dadosTabela = null;
        List<Ambiente> lista = ConsultarListaPorId(projeto.getId());
        System.out.println(projeto.getId());

        // cabecalho da tabela
        Object[] cabecalho = new Object[3];
        cabecalho[0] = "Id";
        cabecalho[1] = "Descrição";
        cabecalho[2] = "Transmitancia Termica";
       
        // cria matriz de acordo com nº de registros da tabela
        try {
            
            dadosTabela = new Object[lista.size()][3];

        } catch (Exception e) {
            System.out.println("Erro ao consultar os Materiais: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
          
            for (Ambiente ambiente : lista) {
                
                dadosTabela[lin][0] = ambiente.getId();
                dadosTabela[lin][1] = ambiente.getDescricao(); 
                dadosTabela[lin][2] = ambiente.getTransmitanciaTermica();
                             
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
    
    public Ambiente ConsultarAmbiente(int id) {
     Ambiente ambiente = new Ambiente();

         try {
             Session sessao = HibernateUtil.getSessionFactory().openSession();
             sessao.beginTransaction();

             org.hibernate.Query q = sessao.createQuery("from Ambiente where id = " + id);
             ambiente = Ambiente.class.cast(q.uniqueResult());

         } catch (HibernateException he) {
             he.printStackTrace();
         }
         return ambiente;
    }
    
    public Ambiente ConsultarUltimo() {
        
        Ambiente resultado = null;

        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            org.hibernate.Query q = sessao.createQuery("select max(ambiente) from Ambiente ambiente");
            resultado = (Ambiente) q.uniqueResult();

        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return resultado;
    }
    
    public void VerificarAmbiente(Ambiente ambiente, JIFrameAmbiente jif) {
        if(ambiente != null){
            jif.EditarAmbiente(ambiente);
        } else {
            
        }
    }

}
