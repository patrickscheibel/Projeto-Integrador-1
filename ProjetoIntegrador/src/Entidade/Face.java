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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 *
 * @author patrick.scheibel
 */
@Entity
@Table(name = "face")
public class Face  implements Serializable {
    
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer id;

    @NotNull()
    @Column(name="descricao", length = 100)
    private String descricao;
     
    @Column(name = "abertura")
    private boolean abertura;
    
    @Column(name = "carga_calor")
    private double cargaCalor;
    
    @ManyToOne()
    @JoinColumn(name = "ambiente_id", nullable = false)
    private Ambiente ambiente;

    public Face() {
    }

    public Face(Integer id, String descricao, boolean abertura, Ambiente ambiente) {
        this.id = id;
        this.descricao = descricao;
        this.abertura = abertura;
        this.ambiente = ambiente;
    }

    @Override
    public String toString() {
        return "Face{" + "id=" + id + ", descricao=" + descricao + ", abertura=" + abertura + '}';
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

    public boolean getAbertura() {
        return this.abertura;
    }

    public void setAbertura(boolean abertura) {
        this.abertura = abertura;
    }

    public double getCargaCalor() {
        return cargaCalor;
    }

    public void setCargaCalor(double cargaCalor) {
        this.cargaCalor = cargaCalor;
    }

    public Ambiente getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(Ambiente ambiente) {
        this.ambiente = ambiente;
    }

}