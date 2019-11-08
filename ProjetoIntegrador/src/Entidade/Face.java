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
    
    @NotNull()
    @Column(name = "resistencia_interna")
    private double resistenciaInterna;
    
    @NotNull()
    @Column(name = "resistencia_externa")
    private double resistenciaExterna;
    
    @Column(name = "resistencia_total")
    private double resistenciaTotal;
    
    @Column(name = "transmitancia_termica")
    private double transmitanciaTermica;
    
    @Column(name = "temperatura_solar")
    private double temperaturaSolar;
    
    @Column(name = "abertura")
    private boolean abertura;
    
    @Column(name = "densidade_fluxo_calor")
    private double densidadeFluxoCalor;
    
    @Column(name = "fluxo_calor")
    private double fluxoCalor;
    
    @ManyToOne()
    @JoinColumn(name = "ambiente_id", nullable = false)
    private Ambiente ambiente;

    public Face() {
    }

    public Face(Integer id, String descricao, double resistenciaInterna, double resistenciaExterna, double resistenciaTotal, double transmitanciaTermica, double temperaturaSolar, boolean abertura, double densidadeFluxoCalor, double fluxoCalor, Ambiente ambiente) {
        this.id = id;
        this.descricao = descricao;
        this.resistenciaInterna = resistenciaInterna;
        this.resistenciaExterna = resistenciaExterna;
        this.resistenciaTotal = resistenciaTotal;
        this.transmitanciaTermica = transmitanciaTermica;
        this.temperaturaSolar = temperaturaSolar;
        this.abertura = abertura;
        this.densidadeFluxoCalor = densidadeFluxoCalor;
        this.fluxoCalor = fluxoCalor;
        this.ambiente = ambiente;
    }

    public Face(Integer id, String descricao, double resistenciaInterna, double resistenciaExterna, boolean abertura, Ambiente ambiente) {
        this.id = id;
        this.descricao = descricao;
        this.resistenciaInterna = resistenciaInterna;
        this.resistenciaExterna = resistenciaExterna;
        this.abertura = abertura;
        this.ambiente = ambiente;
    }

    @Override
    public String toString() {
        return "Face{" + "id=" + id + ", descricao=" + descricao + ", resistenciaInterna=" + resistenciaInterna + ", resistenciaExterna=" + resistenciaExterna + ", transmitanciaTermica=" + transmitanciaTermica + ", ambiente=" + ambiente + '}';
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

    public Ambiente getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(Ambiente ambiente) {
        this.ambiente = ambiente;
    }

    public double getResistenciaInterna() {
        return resistenciaInterna;
    }

    public void setResistenciaInterna(double resistenciaInterna) {
        this.resistenciaInterna = resistenciaInterna;
    }

    public double getResistenciaExterna() {
        return resistenciaExterna;
    }

    public void setResistenciaExterna(double resistenciaExterna) {
        this.resistenciaExterna = resistenciaExterna;
    }

    public double getTransmitanciaTermica() {
        return transmitanciaTermica;
    }

    public void setTransmitanciaTermica(double transmitanciaTermica) {
        this.transmitanciaTermica = transmitanciaTermica;
    }

    public double getFluxoCalor() {
        return fluxoCalor;
    }

    public void setFluxoCalor(double fluxoCalor) {
        this.fluxoCalor = fluxoCalor;
    }

    public double getTemperaturaSolar() {
        return temperaturaSolar;
    }

    public void setTemperaturaSolar(double temperaturaSolar) {
        this.temperaturaSolar = temperaturaSolar;
    }

    public double getDensidadeFluxoCalor() {
        return densidadeFluxoCalor;
    }

    public void setDensidadeFluxoCalor(double densidadeFluxoCalor) {
        this.densidadeFluxoCalor = densidadeFluxoCalor;
    }

    public boolean isAbertura() {
        return abertura;
    }

    public void setAbertura(boolean abertura) {
        this.abertura = abertura;
    }

    public double getResistenciaTotal() {
        return resistenciaTotal;
    }

    public void setResistenciaTotal(double resistenciaTotal) {
        this.resistenciaTotal = resistenciaTotal;
    }
   
}