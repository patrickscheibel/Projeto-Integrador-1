/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.DAO.Atualizar;
import static DAO.DAO.Excluir;
import static DAO.DAO.Salvar;
import Entidade.AmbienteFace;
import Entidade.Usuario;
import Hibernate.HibernateUtil;
import Tela.Apoio.DlgAviso;
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
public class AmbienteFaceDAO extends DAO{
      
    public void SalvarAmbienteFace(AmbienteFace ambienteFace, JIframeAmbienteFace jIframeAmbienteFace, Usuario usuario){
        JIframeAmbienteFace jif = jIframeAmbienteFace;
        
            if(ambienteFace.getId() == null){
                if(Salvar(ambienteFace, usuario) == true) {
                    jif.popularTabelaSalvar();
                } else {
                    new DlgAviso("Descrição deve ter no maximo 100 caracteres");
                } 
            } else {
                if(Atualizar(ambienteFace, usuario) == true){
                    jif.popularTabelaSalvar();
                } else {
                    new DlgAviso("Descrição deve ter no maximo 100 caracteres");
                } 
                
            }
         
            new DlgAviso("Descrição Incorreta ou invalida");
        
    }
    
    public void ExcluirAmbienteFace(Integer ambienteFaceId, Usuario usuario){
       if(usuario != null){
            AmbienteFace ambienteFace = new AmbienteFaceDAO().ConsultarAmbienteFace(ambienteFaceId);         
            Excluir(ambienteFace, usuario);
        }
    }
          
    public List<AmbienteFace> ConsultarTodos() {
//    - método para consultar
        List resultado = null;

            try {
                Session sessao = HibernateUtil.getSessionFactory().openSession();
                sessao.beginTransaction();
                
                org.hibernate.Query q = sessao.createQuery("from AmbienteFace");
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
        List<AmbienteFace> lista = ConsultarTodos();

        // cabecalho da tabela
        Object[] cabecalho = new Object[3];
        cabecalho[0] = "Id";
        cabecalho[1] = "Descricao";
        cabecalho[2] = "Janela";
            
        // cria matriz de acordo com nº de registros da tabela
        try {
            
            dadosTabela = new Object[lista.size()][3];

        } catch (Exception e) {
            System.out.println("Erro ao consultar os Materiais: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
          
            for (AmbienteFace ambienteFace : lista) {
                
                dadosTabela[lin][0] = ambienteFace.getId();
                dadosTabela[lin][1] = ambienteFace.getFace().getDescricao();  
                dadosTabela[lin][2] = ambienteFace.getFace().getAbertura() == true ? "Sim" : "Não";  
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
    
    public AmbienteFace ConsultarAmbienteFace(int id) {
     AmbienteFace ambienteFace = new AmbienteFace();

         try {
             Session sessao = HibernateUtil.getSessionFactory().openSession();
             sessao.beginTransaction();

             org.hibernate.Query q = sessao.createQuery("from AmbienteFace where id = " + id);
             ambienteFace = AmbienteFace.class.cast(q.uniqueResult());

         } catch (HibernateException he) {
             he.printStackTrace();
         }
         return ambienteFace;
    }

}
