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
@Table(name = "camada")
public class Camada  implements Serializable {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
              
    @ManyToOne()
    @JoinColumn(name = "material_id", nullable = false)
    private Material material;
    
    @ManyToOne()
    @JoinColumn(name = "face_id", nullable = false)
    private Face face;
    
    @NotNull()
    @Column(name = "resistencia")
    private double resistencia;

    public Camada(Integer id, Material material, Face face, double resistencia) {
        this.id = id;
        this.material = material;
        this.face = face;
        this.resistencia = resistencia;
    }

    
        
    public Camada() {}  
     
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public Face getFace() {
        return face;
    }

    public void setFace(Face face) {
        this.face = face;
    }

    public double getResistencia() {
        return resistencia;
    }

    public void setResistencia(double resistenciaTotal) {
        this.resistencia = resistenciaTotal;
    }
}