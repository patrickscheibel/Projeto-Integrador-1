/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidade;



import com.sun.istack.internal.NotNull;
import java.io.Serializable;
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
@Table(name = "grupo_permissao")
public class GrupoPermissao  implements Serializable {
    
     @Id
     @Column(name="id")
     @GeneratedValue(strategy = GenerationType.IDENTITY) 
     private Integer id;
     
         
     @NotNull()
     @Column(name="descricao", length = 100)
     private String descricao;

    public GrupoPermissao() {
    }

    public GrupoPermissao(Integer id, String descricao) {
       this.id = id;
       this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "GrupoPermissao{" + "id=" + id + ", descricao=" + descricao + '}';
    }
    
   public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
   
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }




}
