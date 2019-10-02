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
    
    public double ResistenciaMaterial(double espessura, double condutividade){
        return espessura / condutividade;
    }
    
    public double ResistenciaTotal(double rse, double rlr, double rtij, double rarg, double rges, double rsi){
        return rse + rlr + rtij + rarg + rges + rsi;
    }
    
    public double TransmitanciaTermica (double metros, double resistenciaTotal){
        return metros / resistenciaTotal;
    }
    
    public double DensidadeFluxoInverno (double transmitanciaTermica, double temperaturaInterna, double temperaturaExterna)
    {
        return transmitanciaTermica * (temperaturaInterna - temperaturaExterna);
        
    }
    
    public double DensidadeFluxoVerao (double transmitanciaTermica, double temperaturaSolarAr, double temperaturaInterna, double temperaturaExterna ){
        
        return transmitanciaTermica * (temperaturaSolarAr + temperaturaExterna - temperaturaInterna);
    }
    
    public double TemperaturaSolarAr (double absorvidade, double radiacaoSolar, double resistenciaSuperficial){
        
        return absorvidade * radiacaoSolar * resistenciaSuperficial;
    }
    
    public double FluxoCalor (double densidadeFluxoCalor, double areaFechamento){
        
        return densidadeFluxoCalor * areaFechamento;
    }
    
    public double FluxoTotal (double transmitanciaTermica, double temperaturaInterna, double temperaturaExterna, double fatorSolar, double radiacaoSolarIncidente){
        
        return transmitanciaTermica * (temperaturaExterna - temperaturaInterna) + fatorSolar * radiacaoSolarIncidente;
    }
    
    public double CargaTermica (double fluxoCalor, double vetorValores){
        
        return fluxoCalor + vetorValores;
    }
    
    
}
