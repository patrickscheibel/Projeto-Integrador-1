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
     @Column(name="id")
     @GeneratedValue(strategy = GenerationType.IDENTITY) 
     private Integer id;
     
     @Column(name="usuario", length = 100)
     private String usuario;
     
     @Column(name="senha", length = 100)
     private String senha;
     
     @Column(name="situacao", length = 100)
     private String situacao;

    public Usuario() {
    }

   public Usuario(int id) {
        this.id = id;
    } 
    
    
    public Usuario(Integer id, String usuario, String senha, String situacao) {
        this.id = id;
        this.usuario = usuario;
        this.senha = senha;
        this.situacao = situacao;
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

    
   

	
  




}