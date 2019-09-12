/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.DAO.Atualizar;
import static DAO.DAO.Excluir;
import static DAO.DAO.Salvar;
import Entidade.Permissao;
import Entidade.PermissaoGrupoPermissao;
import Entidade.Usuario;
import Hibernate.HibernateUtil;
import Tela.Apoio.DlgAviso;
import Tela.JIframePermissao;
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
public class PermissaoDAO extends DAO{
    
    public void SalvarPermissao(Permissao permissao, JIframePermissao jIframePermissao, Usuario usuario){
         JIframePermissao jif = jIframePermissao;
        if(!permissao.getDescricao().isEmpty()){
            if(permissao.getId() == null){
                if(Salvar(permissao, usuario) == true) {
                    jif.popularTabelaSalvar();
                } else {
                    new DlgAviso("Descrição deve ter no maximo 100 caracteres");
                } 
            } else {
                if(Atualizar(permissao, usuario) == true){
                    jif.popularTabelaSalvar();
                } else {
                    new DlgAviso("Descrição deve ter no maximo 100 caracteres");
                } 
                
            }
        } else {
            new DlgAviso("Descrição Incorreta ou invalida");
        }

    }
    
    public void ExcluirPermissao(Integer permissaoId, Usuario usuario){
        if(usuario != null){
            Permissao permissao = new PermissaoDAO().ConsultarPermissao(permissaoId);         
            Excluir(permissao, usuario);
        }
    }
          
    public List<Permissao> ConsultarTodos() {
//    - método para consultar
    List resultado = null;

        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            org.hibernate.Query q = sessao.createQuery("from Permissao");
            resultado = q.list();

        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return resultado;
    }           
    
//    public List<Permissao> ConsultarPemissaoRestante(Usuario usuario) {
////    - método para consultar
//    List<Permissao> lista = null;
//    List resultado = null;
//
//        try {
//            Session sessao = HibernateUtil.getSessionFactory().openSession();
//            sessao.beginTransaction();
//
//            
//            org.hibernate.Query q = sessao.createQuery("from Permissao");
//            lista = q.list();
//            
//            for (PermissaoGrupoPermissao permissoes : new PermissaoGrupoPermissaoDAO().ConsultarTodas(usuario.getGrupoPermissao())) {
//                for (Permissao p : lista) {
//                    if(permissoes.getPermissao().equals(p)){
//                        resultado.add(p);
//                    }
//                }
//            }
//
//        } catch (HibernateException he) {
//            he.printStackTrace();
//        }
//        return resultado;
//    }
      
    public void popularTabela(JTable tabela, Usuario usuario) {
        // dados da tabela
        Object[][] dadosTabela = null;
        List<Permissao> lista = ConsultarTodos();
//        List<Permissao> lista = ConsultarPemissaoRestante(usuario);

        // cabecalho da tabela
        Object[] cabecalho = new Object[2];
        cabecalho[0] = "Id";
        cabecalho[1] = "Descrição";
        

        // cria matriz de acordo com nº de registros da tabela
        try {
            
            dadosTabela = new Object[lista.size()][2];

        } catch (Exception e) {
            System.out.println("Erro ao consultar os Permissao: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
          
            for (Permissao permissao : lista) {
                
                dadosTabela[lin][0] = permissao.getId();
                dadosTabela[lin][1] = permissao.getDescricao();
               

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
    
    public Permissao ConsultarPermissao(int id) {
     Permissao permissao = new Permissao();

        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            org.hibernate.Query q = sessao.createQuery("from Permissao where id = " + id);
            permissao = Permissao.class.cast(q.uniqueResult());

        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return permissao;
    }    
    
}
