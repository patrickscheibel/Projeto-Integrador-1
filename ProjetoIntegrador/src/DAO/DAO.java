package DAO;

import Entidade.Usuario;
import Hibernate.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Scheibel
 */
public class DAO {
    
    public static void Salvar(Object object, Usuario usuario){
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();

            if(object != null){                             
                sessao.save(object);                     
                t.commit();    
                new AuditoriaDAO().SalvarAuditoria("Insert", object.toString(), usuario);                              
            }         
        } catch (HibernateException e) {
            e.printStackTrace();
            new LogDAO().SalvarLog("Insert", e.getCause().toString(), object.toString(), usuario);
        } finally {
            sessao.close();
        }
    }
    
    public static void Atualizar(Object object, Usuario usuario){
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();

            if(object != null){                             
                sessao.update(object);                     
                t.commit();    
                new AuditoriaDAO().SalvarAuditoria("Update", object.toString(), usuario);                              
            }         
        } catch (HibernateException e) {
            e.printStackTrace();
            new LogDAO().SalvarLog("Update", e.getCause().toString(), object.toString(), usuario);
        } finally {
            sessao.close();
        }
    }
    
    public static void Excluir(Object object, Usuario usuario){
        Session sessao = null;
        try {
        sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessao.beginTransaction();
     
            if(object != null){
                sessao.delete(object);  
                t.commit(); 
                new AuditoriaDAO().SalvarAuditoria("Delete", object.toString(), usuario);
            }
        } catch (HibernateException e) {
            e.printStackTrace();
            new LogDAO().SalvarLog("Delete", e.getCause().toString(), object.toString(), usuario);
        } finally {
            sessao.close();
        }  
    }
}
