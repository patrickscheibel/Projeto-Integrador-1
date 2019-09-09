/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Apoio.ComboItem;
import static DAO.DAO.Atualizar;
import static DAO.DAO.Excluir;
import static DAO.DAO.Salvar;
import Entidade.GrupoPermissao;
import Entidade.Usuario;
import Hibernate.HibernateUtil;
import Tela.Apoio.DlgAviso;
import Tela.JIframeGrupoPermissao;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author patrick.scheibel
 */
public class GrupoPermissaoDAO extends DAO{
    
    public void SalvarGrupoPermissao(GrupoPermissao grupoGrupoPermissao, JIframeGrupoPermissao jIframeGrupoPermissao, Usuario usuario){
         JIframeGrupoPermissao jif = jIframeGrupoPermissao;
        if(!grupoGrupoPermissao.getDescricao().isEmpty()){
            if(grupoGrupoPermissao.getId() == null){
                if(Salvar(grupoGrupoPermissao, usuario) == true) {
                    jif.popularTabelaSalvar();
                } else {
                    new DlgAviso("Descrição deve ter no maximo 100 caracteres");
                } 
            } else {
                if(Atualizar(grupoGrupoPermissao, usuario) == true){
                    jif.popularTabelaSalvar();
                } else {
                    new DlgAviso("Descrição deve ter no maximo 100 caracteres");
                } 
                
            }
        } else {
            new DlgAviso("Descrição Incorreta ou invalida");
        }

    }
    
    public void ExcluirGrupoPermissao(Integer grupoGrupoPermissaoId, Usuario usuario){
        if(usuario != null){
            GrupoPermissao grupoGrupoPermissao = new GrupoPermissaoDAO().ConsultarGrupoPermissaoComId(grupoGrupoPermissaoId);         
            Excluir(grupoGrupoPermissao, usuario);
        }
    }
          
    public List<GrupoPermissao> ConsultarTodos() {
//    - método para consultar
        List resultado = null;

            try {
                Session sessao = HibernateUtil.getSessionFactory().openSession();
                sessao.beginTransaction();
                
                org.hibernate.Query q = sessao.createQuery("from GrupoPermissao");
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
        List<GrupoPermissao> lista = ConsultarTodos();

        // cabecalho da tabela
        Object[] cabecalho = new Object[2];
        cabecalho[0] = "Id";
        cabecalho[1] = "Descrição";
        

        // cria matriz de acordo com nº de registros da tabela
        try {
            
            dadosTabela = new Object[lista.size()][2];

        } catch (Exception e) {
            System.out.println("Erro ao consultar os GrupoPermissao: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
          
            for (GrupoPermissao grupoGrupoPermissao : lista) {
                
                dadosTabela[lin][0] = grupoGrupoPermissao.getId();
                dadosTabela[lin][1] = grupoGrupoPermissao.getDescricao();
               

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
    
    public GrupoPermissao ConsultarGrupoPermissaoComId(int id) {
     GrupoPermissao grupoGrupoPermissao = new GrupoPermissao();

        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            org.hibernate.Query q = sessao.createQuery("from GrupoPermissao where id = " + id);
            grupoGrupoPermissao = GrupoPermissao.class.cast(q.uniqueResult());

        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return grupoGrupoPermissao;
    }  
    
    public GrupoPermissao ConsultarGrupoPermissaoComDescricao(String descricao) {
     GrupoPermissao grupoGrupoPermissao = new GrupoPermissao();

        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            org.hibernate.Query q = sessao.createQuery("from GrupoPermissao where descricao = '" + descricao+ "'");
            grupoGrupoPermissao = GrupoPermissao.class.cast(q.uniqueResult());

        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return grupoGrupoPermissao;
    }
    
    public void popularCombo(JComboBox combo) {
             
        combo.removeAllItems();

        ComboItem item = new ComboItem();
        item.setCodigo(0);
        item.setDescricao("Selecione");
        combo.addItem(item);

        try {
            
            List<GrupoPermissao> resultado = ConsultarTodos();

            for (GrupoPermissao grupoPermissao : resultado) {
                item = new ComboItem();
                item.setCodigo(grupoPermissao.getId());
                item.setDescricao(grupoPermissao.getDescricao());

                combo.addItem(item);
            }
        } catch (Exception e) {
            System.out.println("Erro ao popular Combo = " + e.toString());
        }
    }
}
