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
 * @author patrick.scheibel
 */
@Entity
@Table(name = "cor_material")
public class CorMaterial  implements java.io.Serializable {

     @Id
     @Column(name="id")
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer id;
     
     @Column(name = "descricao", length = 100)
     private String descricao;
     
     @Column(name = "radiacao_minima", precision = 10)
     private double radiacaoMinima;
     
     @Column(name = "radiacao_maxima", precision = 10)
     private double radiacaoMaxima;

    public CorMaterial() {}  
    
    public CorMaterial(Integer id, String descricao, double radiacaoMinima, double radiacaoMaxima) {
       this.id = id;
       this.descricao = descricao;
       this.radiacaoMinima = radiacaoMinima;
       this.radiacaoMaxima = radiacaoMaxima;
    }

    @Override
    public String toString() {
        return "CorMaterial{" + "id=" + id + ", descricao=" + descricao + ", preco=" + radiacaoMinima + ", preco=" + radiacaoMaxima + '}';
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

    public double getRadiacaoMinima() {
        return radiacaoMinima;
    }

    public void setRadiacaoMinima(double radiacaoMinima) {
        this.radiacaoMinima = radiacaoMinima;
    }

    public double getRadiacaoMaxima() {
        return radiacaoMaxima;
    }

    public void setRadiacaoMaxima(double radiacaoMaxima) {
        this.radiacaoMaxima = radiacaoMaxima;
    }
    
    
    

}