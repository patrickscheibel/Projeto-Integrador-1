/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.DAO.Atualizar;
import static DAO.DAO.Excluir;
import static DAO.DAO.Salvar;
import Entidade.FaceCamada;
import Entidade.Usuario;
import Hibernate.HibernateUtil;
import Tela.Apoio.DlgAviso;
import Tela.JIframeFaceCamada;
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
public class FaceCamadaDAO extends DAO{
      
    public void SalvarFaceCamada(FaceCamada faceCamada, JIframeFaceCamada jIframeFaceCamada, Usuario usuario){
        JIframeFaceCamada jif = jIframeFaceCamada;
        
            if(faceCamada.getId() == null){
                if(Salvar(faceCamada, usuario) == true) {
                    jif.popularTabelaSalvar();
                } else {
                    new DlgAviso("Descrição deve ter no maximo 100 caracteres");
                } 
            } else {
                if(Atualizar(faceCamada, usuario) == true){
                    jif.popularTabelaSalvar();
                } else {
                    new DlgAviso("Descrição deve ter no maximo 100 caracteres");
                } 
                
            }
         
            new DlgAviso("Descrição Incorreta ou invalida");
        
    }
    
    public void ExcluirFaceCamada(Integer faceCamadaId, Usuario usuario){
       if(usuario != null){
            FaceCamada faceCamada = new FaceCamadaDAO().ConsultarFaceCamada(faceCamadaId);         
            Excluir(faceCamada, usuario);
        }
    }
          
    public List<FaceCamada> ConsultarTodos() {
//    - método para consultar
        List resultado = null;

            try {
                Session sessao = HibernateUtil.getSessionFactory().openSession();
                sessao.beginTransaction();
                
                org.hibernate.Query q = sessao.createQuery("from FaceCamada");
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
        List<FaceCamada> lista = ConsultarTodos();

        // cabecalho da tabela
        Object[] cabecalho = new Object[2];
        cabecalho[0] = "Id";
        cabecalho[1] = "Resistencia Total";
        
        
        

        // cria matriz de acordo com nº de registros da tabela
        try {
            
            dadosTabela = new Object[lista.size()][2];

        } catch (Exception e) {
            System.out.println("Erro ao consultar os Materiais: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
          
            for (FaceCamada faceCamada : lista) {
                
                dadosTabela[lin][0] = faceCamada.getId();
                dadosTabela[lin][1] = faceCamada.getResistenciaTotal();
                
                
                

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
    
    public FaceCamada ConsultarFaceCamada(int id) {
     FaceCamada faceCamada = new FaceCamada();

         try {
             Session sessao = HibernateUtil.getSessionFactory().openSession();
             sessao.beginTransaction();

             org.hibernate.Query q = sessao.createQuery("from FaceCamada where id = " + id);
             faceCamada = FaceCamada.class.cast(q.uniqueResult());

         } catch (HibernateException he) {
             he.printStackTrace();
         }
         return faceCamada;
    }

}
