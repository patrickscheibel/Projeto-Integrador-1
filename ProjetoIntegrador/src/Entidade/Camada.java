/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidade;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 *
 * @author patrick.scheibel
 */
@Entity
@Table(name = "camada")
public class Camada  implements Serializable {

     @Id
     @Column(name="id")
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer id;
     
     @Column(name = "descricao", length = 100)
     private String descricao;
     
         
    @ManyToOne()
    @JoinColumn(name = "material_id", nullable = false)
    private Material material;
     
     
    public Camada() {}  
    
    public Camada(Integer id, String descricao, Material material) {
       this.id = id;
       this.descricao = descricao;
       this.material = material;
       
    }

    @Override
    public String toString() {
        return "Camada{" + "id=" + id + ", descricao=" + descricao + ", material=" + material + '}';
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

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

   
    

    
    
    
    

}