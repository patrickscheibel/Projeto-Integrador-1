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
@Table(name = "ambiente_face")
public class AmbienteFace  implements Serializable {

     @Id
     @Column(name="id")
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer id;
     
     
    @ManyToOne()
    @JoinColumn(name = "ambiente_id", nullable = false)
    private Ambiente ambiente;
    
    @ManyToOne()
    @JoinColumn(name = "face_id", nullable = false)
    private Face face;
     
     
    public AmbienteFace() {}  
    
    public AmbienteFace(Integer id, Ambiente ambiente, Face face) {
       this.id = id;
       this.ambiente = ambiente;
       this.face = face;
       
    }

    @Override
    public String toString() {
        return "Ambiente{" + "id=" + id + ", ambiente=" + ambiente + ", face=" + face + '}';
    }
    
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Ambiente getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(Ambiente ambiente) {
        this.ambiente = ambiente;
    }

    public Face getFace() {
        return face;
    }

    public void setFace(Face face) {
        this.face = face;
    }
    
    
    
    
    

}