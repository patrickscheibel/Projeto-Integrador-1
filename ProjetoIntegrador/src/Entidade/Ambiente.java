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
@Table(name = "ambiente")
public class Ambiente  implements Serializable {

     @Id
     @Column(name="id")
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer id;
     
     @Column(name = "descricao", length = 100)
     private String descricao;    
     
     @Column(name = "transmitancia_termica")
     private double transmitanciaTermica;
     
    @ManyToOne()
    @JoinColumn(name = "projeto_id", nullable = false)
    private Projeto projeto;
     
     
    public Ambiente() {}  

    public Ambiente(Integer id, String descricao, double transmitanciaTermica, Projeto projeto) {
        this.id = id;
        this.descricao = descricao;
        this.transmitanciaTermica = transmitanciaTermica;
        this.projeto = projeto;
    }

    @Override
    public String toString() {
        return "Ambiente{" + "id=" + id + ", descricao=" + descricao + ", transmitanciaTermica=" + transmitanciaTermica + ", projeto=" + projeto + '}';
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

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    } 

    public double getTransmitanciaTermica() {
        return transmitanciaTermica;
    }

    public void setTransmitanciaTermica(double transmitanciaTermica) {
        this.transmitanciaTermica = transmitanciaTermica;
    }
       
}