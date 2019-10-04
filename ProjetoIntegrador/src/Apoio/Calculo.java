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
    public double ResistenciaMaterial(double espessura, double condutividade){
        return espessura / condutividade;
    }
    
    /** 
    * rse - Resistencia superficial externa
    * rn - resistencias dos materiais
    * rsi - Resistencia superficial interna
    */
    public double ResistenciaTotal(double rse, double[] rn, double rsi) {
        double camadas = 0;
        
        for (double valor : rn) {
            camadas += valor;
        }    
        return rse + camadas + rsi;
    }
      
    public double TransmitanciaTermica (double resistenciaTotal) {
        return 1 / resistenciaTotal;
    }
    
    public double DensidadeFluxoInverno (double transmitanciaTermica, double temperaturaInterna, double temperaturaExterna) {
        return transmitanciaTermica * (temperaturaInterna - temperaturaExterna);       
    }
    
    public double DensidadeFluxoVerao (double transmitanciaTermica, 
                                       double temperaturaSolarAr,  
                                       double temperaturaInterna, 
                                       double temperaturaExterna) {       
        return transmitanciaTermica * (temperaturaSolarAr + temperaturaExterna - temperaturaInterna);
    }
    
    public double TemperaturaSolarAr (double absorvidade, double radiacaoSolar, double resistenciaSuperficial) {   
        return absorvidade * radiacaoSolar * resistenciaSuperficial;
    }
    
    public double FluxoCalor (double densidadeFluxoCalor, double areaFechamento) {       
        return densidadeFluxoCalor * areaFechamento;
    }
    
    // Caso seja usado vidro
    public double FluxoTotal (double transmitanciaTermica, 
                              double temperaturaInterna, 
                              double temperaturaExterna, 
                              double fatorSolar, 
                              double radiacaoSolarIncidente) {     
        return transmitanciaTermica * (temperaturaExterna - temperaturaInterna) + fatorSolar * radiacaoSolarIncidente;
    }
    
    public double CargaTermica (double[] fluxoCalor, double[] vetorValor) {
        double fluxosCalor = 0;
        double vetorValores = 0;
        
        for (double valor : fluxoCalor) {
            fluxosCalor += valor;
        }
        for (double valor : vetorValor) {
            vetorValores += valor;
        }
        return fluxosCalor + vetorValores;
    }
    
}