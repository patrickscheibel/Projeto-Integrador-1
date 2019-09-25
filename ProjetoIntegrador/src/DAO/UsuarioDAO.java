/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Apoio.ComboItem;
import static DAO.DAO.Atualizar;
import static DAO.DAO.Salvar;
import Entidade.GrupoPermissao;
import Entidade.Usuario;
import Hibernate.HibernateUtil;
import Tela.Apoio.DlgAviso;
import Tela.JIframeUsuario;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author patrick.scheibel
 */
public class UsuarioDAO extends DAO{
    
    public void SalvarUsuario(Usuario usuario, JIframeUsuario jIframeUsuario, Usuario usuarioTela){
        JIframeUsuario jif = jIframeUsuario;
       if(!usuario.getUsuario().isEmpty() && !usuario.getLogin().isEmpty() && !usuario.getSenha().isEmpty() && usuario.getGrupoPermissao() != null){
            if(usuario.getId() == null){
                if(Salvar(usuario, usuario) == true) {
                    jif.popularTabelaSalvar();
                } else {
                    new DlgAviso("Descrição deve ter no maximo 100 caracteres");
                } 
            } else {
                if(Atualizar(usuario, usuario) == true){
                    jif.popularTabelaSalvar();
                } else {
                    new DlgAviso("Descrição deve ter no maximo 100 caracteres");
                } 
                
            }
        } else {
            new DlgAviso("Descrição Incorreta ou invalida");
        }
    }
    
    public void DesativarUsuario(Integer id, Usuario usuarioTela){
        Session sessao = null;
        try {
        sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessao.beginTransaction();
     
        Usuario usuario = ConsultarUsuario(id);
        if(usuario != null){
            
            usuario.setSituacao("Desativado");
            sessao.update(usuario);  
            t.commit(); 
            new AuditoriaDAO().SalvarAuditoria("Disabled", usuario.toString(), usuarioTela);
        }
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            sessao.close();
        }  
    }
          
    public List<Usuario> ConsultarTodos() {
//    - método para consultar
    List resultado = null;

        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            org.hibernate.Query q = sessao.createQuery("from Usuario order by situacao ASC");
            resultado = q.list();

        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return resultado;
    }           
      
    public void popularTabela(JTable tabela) {
        // dados da tabela
        Object[][] dadosTabela = null;
        List<Usuario> lista = ConsultarTodos();

        // cabecalho da tabela
        Object[] cabecalho = new Object[4];
        cabecalho[0] = "Id";
        cabecalho[1] = "Usuario";
        cabecalho[2] = "Login";
        cabecalho[3] = "Situacao";
        
        // cria matriz de acordo com nº de registros da tabela
        try {
            
            dadosTabela = new Object[lista.size()][4];

        } catch (Exception e) {
            System.out.println("Erro ao consultar os Usuarios: " + e);
        }

        int lin = 0;

        // efetua consulta na tabela
        try {
          
            for (Usuario usuario : lista) {
                
                dadosTabela[lin][0] = usuario.getId();
                dadosTabela[lin][1] = usuario.getUsuario();
                dadosTabela[lin][2] = usuario.getLogin();
                dadosTabela[lin][3] = usuario.getSituacao();
               

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
    
    public Usuario ConsultarUsuario(int id) {
     Usuario usuario = new Usuario();

        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            org.hibernate.Query q = sessao.createQuery("from Usuario where id = " + id);
            usuario = Usuario.class.cast(q.uniqueResult());

        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return usuario;
    }   
    
    public Usuario UsuarioLogin(String login, String senha) {
     Usuario usuario = new Usuario();
        if(login.isEmpty() && senha.isEmpty() || (login.isEmpty() || (senha.isEmpty()))){ return usuario; }
        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            org.hibernate.Query q = sessao.createQuery("from Usuario where login = '" + login+ "' and senha = '" + senha + "'");
            usuario = Usuario.class.cast(q.uniqueResult());

        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return usuario;
    }
    
    public void popularCombo(JComboBox combo) {
             
        combo.removeAllItems();

        ComboItem item = new ComboItem();
        item.setCodigo(0);
        item.setDescricao("Selecione");
        combo.addItem(item);

        try {
            
            List<Usuario> resultado = ConsultarTodos();

            for (Usuario usuario : resultado) {
                item = new ComboItem();
                item.setCodigo(usuario.getId());
                item.setDescricao(usuario.getUsuario());

                combo.addItem(item);
            }
        } catch (Exception e) {
            System.out.println("Erro ao popular Combo = " + e.toString());
        }
    }
}
