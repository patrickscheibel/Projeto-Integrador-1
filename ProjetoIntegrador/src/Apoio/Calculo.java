/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apoio;

import Entidade.Camada;
import Entidade.Face;
import Tela.Apoio.SolicitarDado;
import java.util.List;

/**
 *
 * @author conti
 */
public class Calculo {
  
    /** 
    * espessura - espessura do material
    * condutividade - condutividade do material
    */
    public float ResistenciaMaterial(double espessura, double condutividade){
        return (float) (condutividade / espessura);
    }
    
    /** 
    * rse - Resistencia superficial externa
    * rn - resistencias dos materiais
    * rsi - Resistencia superficial interna
    */
    public float ResistenciaTermica(double rse, List<Camada> camadas, double rsi) {
        float resistencia = 0;
        
        for (Camada camada : camadas) {
            resistencia += camada.getResistencia();
        }    
        return (float) (rse + resistencia + rsi);
    }
      
    public float TransmitanciaTermica (float resistenciaTotal) {
        return 1 / resistenciaTotal;
    }
    
    public float DensidadeFluxoSemSol (double transmitanciaTermica, double temperaturaInterna, double temperaturaExterna) {
        return (float) (transmitanciaTermica * (temperaturaExterna - temperaturaInterna));       
    }
    
    public float TemperaturaSolarAr (double absorvidade, double radiacaoSolar, double resistenciaSuperficial) {   
        return (float) (absorvidade * radiacaoSolar * resistenciaSuperficial);
    }
    
    public float DensidadeFluxoComSol (double transmitanciaTermica, 
                                       double temperaturaSolarAr,  
                                       double temperaturaInterna, 
                                       double temperaturaExterna) {       
        return (float) (transmitanciaTermica * (temperaturaSolarAr + (temperaturaExterna - temperaturaInterna)));
    }
    
    /* A densidadeFluxoCalor, muda dependo do clima, DensidadeFluxoInverno ou DensidadeFluxoVerao */
    public float FluxoCalor (double densidadeFluxoCalor, double areaFechamento) {  
        return (float) (densidadeFluxoCalor * areaFechamento);
    }
    
    // Caso seja usado vidro
    public float DensidadeFluxoCalorVidro (double transmitanciaTermica, 
                                           double temperaturaInterna, 
                                           double temperaturaExterna, 
                                           double fatorSolar, 
                                           double radiacaoSolarIncidente) {     
        return (float) (transmitanciaTermica * (temperaturaInterna - temperaturaExterna) + (fatorSolar * radiacaoSolarIncidente));
    }
    
    /* O vetorValor pode estar vazio */
//    public float CargaTermica (float[] fluxoCalor, float[] densidadeFluxoCalor) {
    public float CargaTermica (List<Face> faces) {
        float fluxoCalor = 0;
        float densidadeFluxoCalor = 0;
        
        for (Face valor : faces) {
            fluxoCalor += valor.getFluxoCalor();
            fluxoCalor += valor.getFluxoCalorVidro();
            densidadeFluxoCalor += valor.getDensidadeFluxoCalor();
        }
//        for (float valor : fluxoCalor) {
//            fluxosCalor += valor;
//        }
//        for (float valor : densidadeFluxoCalor) {
//            densidadeFluxoDeCalor += valor;
//        }
        return fluxoCalor + densidadeFluxoCalor;
    }
		
    public float ResistenciaTotalTelhado(double rae, float[] rn, double rai) {
        float camadas = 0;
        
        for (float valor : rn) {
            camadas += valor;
        }    
        return (float) (rae + camadas + rai);
    }
          
    public float TransmitanciaTermicaTelhado (float resistenciaTotalTelhado) {
        return 1 / resistenciaTotalTelhado;
    }

    public float ArCondicionado(List<Face> somatoriaQ, double valorEspecifico) {
        float camadas = 0;
        
        for (Face face : somatoriaQ) {
            camadas += (face.getFluxoCalor() + face.getFluxoCalorVidro());
        }    
        return (float) (camadas * valorEspecifico) / 1000;
    }    

    public double metrosQuadrado = 0;
    public double getMetrosQuadrado() {
        return metrosQuadrado;
    }
    public void setMetrosQuadrado(double metrosQuadrado) {
        this.metrosQuadrado = metrosQuadrado;
    }
    
    public double MetroQuadradoVidro(String texto) {
        new SolicitarDado(this, texto);
        return getMetrosQuadrado();
    }
}