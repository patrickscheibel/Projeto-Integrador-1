/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.DAO.Atualizar;
import static DAO.DAO.Excluir;
import static DAO.DAO.Salvar;
import Entidade.Camada;
import Entidade.Face;
import Entidade.Usuario;
import Hibernate.HibernateUtil;
import Tela.Apoio.DlgAviso;
import Tela.DlgCamada;
import Tela.DlgSelecionarMaterial;
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
public class CamadaDAO extends DAO{
    
    public void SalvarCamada(Camada camada, DlgSelecionarMaterial dlg, JIFrameAmbiente jif, Usuario usuario){
        if(camada.getId() == null){
            if(Salvar(camada, usuario) == true) {
                jif.AtualizarTabelaCamada(camada.getFace());
                jif.setEnabled(true);
                dlg.dispose();            
            } else {
                new DlgAviso("Descrição deve ter no maximo 100 caracteres");
            } 
        } else {
            if(Atualizar(camada, usuario) == true){
                jif.AtualizarTabelaCamada(camada.getFace());
                jif.setEnabled(true);
                dlg.dispose();
            } else {
                new DlgAviso("Descrição deve ter no maximo 100 caracteres");
            } 
        } 
    }
    
    public void ExcluirCamada(Integer camadaId, Usuario usuario){
        if(usuario != null){
            Camada camada = new CamadaDAO().ConsultarCamada(camadaId);         
            Excluir(camada, usuario);
        }
    }
          
    public List<Camada> ConsultarTodos() {
//    - método para consultar
        List resultado = null;

            try {
                Session sessao = HibernateUtil.getSessionFactory().openSession();
                sessao.beginTransaction();
                
                org.hibernate.Query q = sessao.createQuery("from Camada");
                resultado = q.list();

            } catch (HibernateException he) {
                he.printStackTrace();
            }
            return resultado;
        }           
      
   
    
       //Popular por um id
    public void popularTabela(JTable tabela, Face face) {
        // dados da tabela
        Object[][] dadosTabela = null;
        List<Camada> lista = ConsultarTodos();

        // cabecalho da tabela
        Object[] cabecalho = new Object[2];
        cabecalho[0] = "Id";
        cabecalho[1] = "Descrição";
        

        // cria matriz de acordo com nº de registros da tabela
        try {
            
            dadosTabela = new Object[lista.size()][2];

        } catch (Exception e) {
            System.out.println("Erro ao consultar os Camadas: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
          
            for (Camada camada : lista) {
                
                dadosTabela[lin][0] = camada.getId();
                dadosTabela[lin][1] = camada.getDescricao();
               

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
    
    public Camada ConsultarCamada(int id) {
     Camada camada = new Camada();

         try {
             Session sessao = HibernateUtil.getSessionFactory().openSession();
             sessao.beginTransaction();

             org.hibernate.Query q = sessao.createQuery("from Camada where id = " + id);
             camada = Camada.class.cast(q.uniqueResult());

         } catch (HibernateException he) {
             he.printStackTrace();
         }
         return camada;
     }    
}
