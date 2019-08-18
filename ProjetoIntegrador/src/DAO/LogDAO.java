/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidade.Log;
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
public class LogDAO {
    
//    private Usuario usuario = new Usuario(); 
    
    public void SalvarLog(String descricao, String erro, String dados){
    Session sessao = null;
    try {
        sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction t = sessao.beginTransaction();
        
        
           
            Log logSalvar = new Log();
            logSalvar.setData(logSalvar.dataAtual());
            logSalvar.setDescricao(descricao);
            logSalvar.setErro(erro);
            logSalvar.setDados(dados);
            
            sessao.save(logSalvar);                     
            t.commit();    
        
          
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            sessao.close();
        }

    }
        
    //Consulta para utilizar no relatorio
    public List<Log> ConsultarTodos() {
    List resultado = null;

        try {
            Session sessao = HibernateUtil.getSessionFactory().openSession();
            sessao.beginTransaction();

            org.hibernate.Query q = sessao.createQuery("from Log");
            resultado = q.list();

        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return resultado;
    }           

     
}
