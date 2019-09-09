package DAO;

import Entidade.PermissaoGrupoPermissao;
import Entidade.Usuario;
import Hibernate.HibernateUtil;
import java.util.List;
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
    
    public static boolean Salvar(Object object, Usuario usuario){
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();

            if(object != null){                             
                sessao.save(object);                     
                t.commit();    
                new AuditoriaDAO().SalvarAuditoria("Insert", object.toString(), usuario);
                return true;
            }         
        } catch (HibernateException e) {
            e.printStackTrace();
            new LogDAO().SalvarLog("Insert", e.getCause().toString(), object.toString(), usuario);
        } finally {
            sessao.close();
        }
        return false;
    }
    
    public static boolean Atualizar(Object object, Usuario usuario){
        Session sessao = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Transaction t = sessao.beginTransaction();

            if(object != null){                             
                sessao.update(object);                     
                t.commit();    
                new AuditoriaDAO().SalvarAuditoria("Update", object.toString(), usuario);   
                return true;
            }         
        } catch (HibernateException e) {
            e.printStackTrace();
            new LogDAO().SalvarLog("Update", e.getCause().toString(), object.toString(), usuario);
        } finally {
            sessao.close();
        }
        return false;
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
    
    public static boolean VerificarPermissao(String permissao, int grupoPermissaoId){
       try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            org.hibernate.Query q = sessao.createQuery("From PermissaoGrupoPermissao");
//            org.hibernate.Query q = sessao.createQuery("From PermissaoGrupoPermissao pgp, Permissao p, GrupoPermissao gp"
//                    + " where gpp.permissao = p and pgp.grupoPermissao = gp"
//                    + " and p.descridao = '" + permissao + "' and gp.id = " + grupoPermissaoId);
            List<PermissaoGrupoPermissao> pgp = (List<PermissaoGrupoPermissao>) q.list();
            for (PermissaoGrupoPermissao permissaoGrupoPermissao : pgp) {
                if(permissaoGrupoPermissao.getPermissao().getDescricao().equals(permissao) 
                        && permissaoGrupoPermissao.getGrupoPermissao().getId() == grupoPermissaoId){
                return true;
            }
           }
          
         } catch (HibernateException he) {
             he.printStackTrace();
         }
         return false;
    }
   
}
