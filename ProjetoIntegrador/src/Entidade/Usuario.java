/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidade;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 *
 * @author Scheibel
 */
@Entity
@Table(name = "usuario")
public class Usuario  implements java.io.Serializable {
    
     @Id
     @Column(name= "id")
     @GeneratedValue(strategy = GenerationType.IDENTITY) 
     private Integer id;
     
     @Column(name = "usuario", length = 100)
     private String usuario;
     
     @Column(name= "login", length = 100)
     private String login;
     
     @Column(name= "senha", length = 100)
     private String senha;
     
     @Column(name= "situacao", length = 100)
     private String situacao;
     
     @Column(name = "auditoria")
     private boolean auditoria;
     
     @Column(name = "log")
     private boolean log;

    public Usuario() {
    }

    public Usuario(Integer id, String usuario, String login, String senha, String situacao, boolean auditoria, boolean log) {
        this.id = id;
        this.usuario = 
        this.login = login;
        this.senha = senha;
        this.situacao = situacao;
        this.auditoria = auditoria;
        this.log = log;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", usuario=" + usuario + ", login=" + login + ", senha=" + senha + ", situacao=" + situacao + ", auditoria=" + auditoria + ", log=" + log + '}';
    }

    public Integer getId() {
        return this.id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuario() {
        return this.usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return this.senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSituacao() {
        return this.situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public boolean getAuditoria() {
        return auditoria;
    }

    public void setAuditoria(boolean auditoria) {
        this.auditoria = auditoria;
    }

    public boolean getLog() {
        return log;
    }

    public void setLog(boolean log) {
        this.log = log;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

}