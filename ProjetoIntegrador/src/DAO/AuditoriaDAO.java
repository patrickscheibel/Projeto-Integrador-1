/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidade.Auditoria;
import Entidade.Estado;
import Entidade.Usuario;
import Hibernate.HibernateUtil;
import Tela.JIframeEstado;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Scheibel
 */
public class AuditoriaDAO {
    
    private boolean status;
    private Usuario usuario; 
    
    // Sempre que iniciar a tela inicial executar essa funcao 
    public void SetStatusAndUsuario(boolean statusTela, Usuario usuarioTela){
        status = statusTela;
        usuario = usuarioTela;
    }
    
    public void SalvarAuditoria(String descricao, String dados){
    Session sessao = null;
    try {
        sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessao.beginTransaction();

        if(status != false){
            Auditoria auditoria = new Auditoria();
            auditoria.setUsuario(usuario);
            auditoria.setData(auditoria.dataAtual());
            auditoria.setDescricao(descricao);
            auditoria.setDados(dados);
            
            sessao.save(auditoria);                     
            t.commit();    
        }
          
        } catch (HibernateException he) {
            he.printStackTrace();
        } finally {
            sessao.close();
        }

    }
        
    public List<Auditoria> ConsultarTodos() {
//    - método para consultar
    List resultado = null;

        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            org.hibernate.Query q = sessao.createQuery("from Auditoria");
            resultado = q.list();

        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return resultado;
    }           

    
}
