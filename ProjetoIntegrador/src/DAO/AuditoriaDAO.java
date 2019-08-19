/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidade.Auditoria;
import Entidade.Usuario;
import Hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Scheibel
 */
public class AuditoriaDAO {
    
//    private Usuario usuario = new Usuario(); 
    
    public void SalvarAuditoria(String descricao, String dados, Usuario usuario){
    Session sessao = null;
    try {
        sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessao.beginTransaction();
        
        if(usuario.getAuditoria() != false){
            Auditoria auditoriaSalvar = new Auditoria();
            auditoriaSalvar.setUsuario(usuario);
            auditoriaSalvar.setData(auditoriaSalvar.dataAtual());
            auditoriaSalvar.setDescricao(descricao);
            auditoriaSalvar.setDados(dados);
            
            sessao.save(auditoriaSalvar);                     
            t.commit();    
        }
          
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            sessao.close();
        }

    }
    
    public void AtualizarAuditoria(Usuario usuario, boolean auditoria){
    Session sessao = null;
    try {
         sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessao.beginTransaction();
    
        if(usuario.getAuditoria() != auditoria){
            usuario.setAuditoria(auditoria);
            sessao.update(usuario);                     
            t.commit();    
        }
       
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            sessao.close();
        }
    }
        
    //Consulta para utilizar no relatorio
    public List<Auditoria> ConsultarTodos() {
    List resultado = null;

        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            org.hibernate.Query q = sessao.createQuery("from Auditoria");
            resultado = q.list();

        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return resultado;
    }           

    
}
