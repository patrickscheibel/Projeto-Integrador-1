/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidade;

import java.math.BigDecimal;
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
     private BigDecimal radiacao_minima;
     
     @Column(name = "radiacao_maxima", precision = 10)
     private BigDecimal radiacao_maxima;

    public CorMaterial() {
    }

	
    public CorMaterial(int id) {
        this.id = id;
    }
    public CorMaterial(Integer id, String descricao, BigDecimal radiacao_minima, BigDecimal radiacao_maxima) {
       this.id = id;
       this.descricao = descricao;
       this.radiacao_minima = radiacao_minima;
       this.radiacao_maxima = radiacao_maxima;
    }

    @Override
    public String toString() {
        return "CorMaterial{" + "id=" + id + ", descricao=" + descricao + ", preco=" + radiacao_minima + ", preco=" + radiacao_maxima + '}';
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

    public BigDecimal getRadiacao_minima() {
        return radiacao_minima;
    }

    public void setRadiacao_minima(BigDecimal radiacao_minima) {
        this.radiacao_minima = radiacao_minima;
    }

    public BigDecimal getRadiacao_maxima() {
        return radiacao_maxima;
    }

    public void setRadiacao_maxima(BigDecimal radiacao_maxima) {
        this.radiacao_maxima = radiacao_maxima;
    }
    
    
    

}