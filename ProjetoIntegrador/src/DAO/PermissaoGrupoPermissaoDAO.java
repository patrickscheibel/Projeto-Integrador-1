/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.DAO.Atualizar;
import static DAO.DAO.Excluir;
import static DAO.DAO.Salvar;
import Entidade.Formula;
import Entidade.GrupoPermissao;
import Entidade.PermissaoGrupoPermissao;
import Entidade.Usuario;
import Hibernate.HibernateUtil;
import Tela.Apoio.DlgAviso;
import Tela.JIframeFormula;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.hibernate.HibernateException;
import org.hibernate.Session;

/**
 *
 * @author Scheibel
 */
public class PermissaoGrupoPermissaoDAO {
    
    public void SalvarPermissaoGrupoPermissao(PermissaoGrupoPermissao permissao, Usuario usuario){       
        if(permissao.getPermissao() != null && permissao.getGrupoPermissao() != null){
            Salvar(permissao, usuario);       
        } 
    }
    
    public void ExcluirPermissaoGrupoPermissao(Integer id, Usuario usuario){
        if(usuario != null){
            PermissaoGrupoPermissao permissao = ConsultarPemissao(id);         
            Excluir(permissao, usuario);
        }
    }
    
    public PermissaoGrupoPermissao ConsultarPemissao(int id) {
     PermissaoGrupoPermissao permissao = new PermissaoGrupoPermissao();

         try {
             Session sessao = HibernateUtil.getSessionFactory().openSession();
             sessao.beginTransaction();

             org.hibernate.Query q = sessao.createQuery("from PermisaaoGrupoPermissao where id = " + id);
             permissao = PermissaoGrupoPermissao.class.cast(q.uniqueResult());

         } catch (HibernateException he) {
             he.printStackTrace();
         }
         return permissao;
    }    
    
    public List<PermissaoGrupoPermissao> ConsultarTodas(GrupoPermissao grupoPremissao) {
    // Método para consultar
    List resultado = null;

        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            org.hibernate.Query q = sessao.createQuery("from PermissaoGrupoPermissao where grupo_permissao_id = " + grupoPremissao.getId());
            resultado = q.list();

        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return resultado;
    }  
    
    public void popularTabela(JTable tabela, GrupoPermissao grupoPermissao) {
        // dados da tabela
        Object[][] dadosTabela = null;
        List<PermissaoGrupoPermissao> lista = ConsultarTodas(grupoPermissao);

        // cabecalho da tabela
        Object[] cabecalho = new Object[2];
        cabecalho[0] = "Id";
        cabecalho[1] = "Permissão";
        
        // cria matriz de acordo com nº de registros da tabela
        try {
            
            dadosTabela = new Object[lista.size()][2];

        } catch (Exception e) {
            System.out.println("Erro ao consultar a PermissaoGrupoPermissao: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
          
            for (PermissaoGrupoPermissao permissao : lista) {
                
                dadosTabela[lin][0] = permissao.getId();
                dadosTabela[lin][1] = permissao.getPermissao().getDescricao();
               
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
    
}
