/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apoio;

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
        return (float) (espessura / condutividade);
    }
    
    /** 
    * rse - Resistencia superficial externa
    * rn - resistencias dos materiais
    * rsi - Resistencia superficial interna
    */
    public float ResistenciaTotal(double rse, float[] rn, double rsi) {
        float camadas = 0;
        
        for (float valor : rn) {
            camadas += valor;
        }    
        return (float) (rse + camadas + rsi);
    }
      
    public float TransmitanciaTermica (float resistenciaTotal) {
        return 1 / resistenciaTotal;
    }
    
    public float DensidadeFluxoInverno (float transmitanciaTermica, double temperaturaInterna, double temperaturaExterna) {
        return (float) (transmitanciaTermica * (temperaturaInterna - temperaturaExterna));       
    }
    
    public float TemperaturaSolarAr (double absorvidade, double radiacaoSolar, double resistenciaSuperficial) {   
        return (float) (absorvidade * radiacaoSolar * resistenciaSuperficial);
    }
    
    public float DensidadeFluxoVerao (float transmitanciaTermica, 
                                      float temperaturaSolarAr,  
                                      double temperaturaInterna, 
                                      double temperaturaExterna) {       
        return (float) (transmitanciaTermica * (temperaturaSolarAr + temperaturaExterna - temperaturaInterna));
    }
    
    /* A densidadeFluxoCalor, muda dependo do clima, DensidadeFluxoInverno ou DensidadeFluxoVerao */
    public float FluxoCalor (float densidadeFluxoCalor, double areaFechamento) {       
        return (float) (densidadeFluxoCalor * areaFechamento);
    }
    
    // Caso seja usado vidro
    public float FluxoCalorVidro (float transmitanciaTermica, 
                                  double temperaturaInterna, 
                                  double temperaturaExterna, 
                                  double fatorSolar, 
                                  double radiacaoSolarIncidente) {     
        return (float) (transmitanciaTermica * (temperaturaExterna - temperaturaInterna) + fatorSolar * radiacaoSolarIncidente);
    }
    
    //O vetorValor pode estar vazio
    public float CargaTermica (float[] fluxoCalor, float[] vetorValor) {
        float fluxosCalor = 0;
        float vetorValores = 0;
        
        for (float valor : fluxoCalor) {
            fluxosCalor += valor;
        }
        for (float valor : vetorValor) {
            vetorValores += valor;
        }
        return fluxosCalor + vetorValores;
    }
    
}