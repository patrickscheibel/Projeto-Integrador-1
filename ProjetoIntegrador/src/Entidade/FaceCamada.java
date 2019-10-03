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
@Table(name = "face_camada")
public class FaceCamada  implements Serializable {

     @Id
     @Column(name="id")
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer id;
     
     
    @ManyToOne()
    @JoinColumn(name = "face_id", nullable = false)
    private Face face;
    
    @ManyToOne()
    @JoinColumn(name = "camada_id", nullable = false)
    private Camada camada;
    
     @Column(name = "resistencia_total", precision = 10)
     private double resistenciaTotal;
     
     
    public FaceCamada() {}  
    
    public FaceCamada(Integer id, Face face, Camada camada, double resistenciaTotal) {
       this.id = id;
       this.face = face;
       this.camada = camada;
       this.resistenciaTotal = resistenciaTotal;
       
    }

    @Override
    public String toString() {
        return "Ambiente{" + "id=" + id + ", face=" + face + ", camada=" + camada + ", resistenciaTotal=" + resistenciaTotal + '}';
    }
    
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Face getFace() {
        return face;
    }

    public void setFace(Face face) {
        this.face = face;
    }

    public Camada getCamada() {
        return camada;
    }

    public void setCamada(Camada camada) {
        this.camada = camada;
    }

    public double getResistenciaTotal() {
        return resistenciaTotal;
    }

    public void setResistenciaTotal(double resistenciaTotal) {
        this.resistenciaTotal = resistenciaTotal;
    }

  
    
    
    
    
    

}