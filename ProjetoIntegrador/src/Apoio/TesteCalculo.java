/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apoio;

import DAO.CamadaDAO;
import DAO.FaceDAO;
import Entidade.Camada;
import java.util.List;

/**
 *
 * @author patrick.scheibel
 */
public class TesteCalculo {
       
      public void Testar() {
        double resistenciaExterna = 5;
        double resistenciaInterna = 8;
        
        List<Camada> camada = new CamadaDAO().ConsultarPorFace(new FaceDAO().ConsultarFace(?));
            System.out.println("Camadas: " + camada);
        double resistenciaTotal = new Calculo().ResistenciaTotal(resistenciaInterna, camada, resistenciaExterna); 
            System.out.println("resistenciaTotal: " + resistenciaTotal);
        double transmitanciaTermica = new Calculo().TransmitanciaTermica((float) resistenciaTotal);
            System.out.println("transmitanciaTermica: " + transmitanciaTermica);
        double temperaturaSolar = new Calculo().TemperaturaSolarAr(0.20, 511, 0.04);
            System.out.println("temperaturaSolar: " + temperaturaSolar);
        boolean abertura = false;
        double densidadeFluxoCalor = 0;
        if(abertura){
            densidadeFluxoCalor = new Calculo().DensidadeFluxoComSol(transmitanciaTermica, 5, 9);     
        } else {
            densidadeFluxoCalor = new Calculo().DensidadeFluxoSemSol(transmitanciaTermica, temperaturaSolar, 5, 9);
        }
            System.out.println("densidadeFluxoCalor: " + densidadeFluxoCalor);
        double fluxoCalor = new Calculo().FluxoCalor(densidadeFluxoCalor, 5.15);
//            System.out.println("fluxoCalor: " + fluxoCalor);
      }
//    public void Inverno() {
//        System.out.println("Inverno \n");
//        
//        System.out.println("Resistencia do material:");
//            //rm - Resistencia do material
//            float[] rm = new float[3];
//            rm[0] = new Calculo().ResistenciaMaterial(3.2, 2.3);
//            rm[1] = new Calculo().ResistenciaMaterial(2.4, 6.2);
//            rm[2] = new Calculo().ResistenciaMaterial(7.4, 4.5);
//            for (int i = 0; i < rm.length; i++) {
//                System.out.println("RM"+ i + ": " + rm[i]);
//            }
//            System.out.println("");
//        
//        System.out.println("Resistencia total:");
//            //rt - Resistencia total
//            float rt = new Calculo().ResistenciaTotal(1.8, rm, 6.7); 
//            System.out.println("RT: " + rt + "\n");
//        
//        System.out.println("Transmitancia termica:");
//            //tt - Trannsmitancia termica
//            float tt = new Calculo().TransmitanciaTermica(rt);
//            System.out.println("TT:" + tt + "\n");
//        
//        System.out.println("Densidade do fluxo de calor no inverno:");
//            //dfi - Densidade do fluxo de calor no inverno
//            float dfi = new Calculo().DensidadeFluxoComSol(tt, 25.6, 30.7);
//            System.out.println("DFI: " + dfi + "\n");
//        
//        System.out.println("Fluxo de calor:");
//            //fc - Fluxo de calor
//            float[] fc = new float[3];
//            fc[0] = new Calculo().FluxoCalor(dfi, 3.5);
//            fc[1] = new Calculo().FluxoCalor(dfi, 4.5);
//            fc[2] = new Calculo().FluxoCalor(dfi, 5.5);
//            for (int i = 0; i < fc.length; i++) {
//                System.out.println("FC" + i + ": " + fc[i]);
//            }
//            System.out.println("");
//        
//        //Caso use vidro
//        System.out.println("Fluxo de calor, quando tem vidro:");
//            //fcvi - Fluxo de calor no inverno, quando tem vidro
//            float[] fcv = new float[3];
//            fcv[0] = new Calculo().FluxoCalorVidro(tt, 25.6, 30.7, 35.8, 34.2);
//            fcv[1] = new Calculo().FluxoCalorVidro(tt, 23.6, 29.7, 31.8, 32.2);
//            fcv[2] = new Calculo().FluxoCalorVidro(tt, 21.6, 36.7, 34.8, 30.2);
//            for (int i = 0; i < fcv.length; i++) {
//                System.out.println("FCVI"+ i + ": " + fcv[i]);
//            }
//            System.out.println("");
//        
//        //O fcv pode estar vazio
//        System.out.println("Carga Termica:");
//            //ct - Carga Termica
//            float ct = new Calculo().CargaTermica(fc, fcv);
//            System.out.println("CT: " + ct + "\n");   
//    }
    
//    public void Verao() {
//        System.out.println("Verao \n");
//        
//        System.out.println("Resistencia do material:");
//            //rm - Resistencia do material
//            float[] rm = new float[3];
//            rm[0] = new Calculo().ResistenciaMaterial(3.2, 2.3);
//            rm[1] = new Calculo().ResistenciaMaterial(2.4, 6.2);
//            rm[2] = new Calculo().ResistenciaMaterial(7.5, 4.2);
//            for (int i = 0; i < rm.length; i++) {
//                System.out.println("RM"+ i + ": " + rm[i]);
//            }
//            System.out.println("");
//        
//        System.out.println("Resistencia total:");
//            //rt - Resistencia total
//            float rt = new Calculo().ResistenciaTotal(1.8, rm, 6.6); 
//            System.out.println("RT: " + rt + "\n");
//        
//        System.out.println("Transmitancia termica:");
//            //tt - Trannsmitancia termica
//            float tt = new Calculo().TransmitanciaTermica(rt);
//            System.out.println("TT:" + tt + "\n");
//                 
//        System.out.println("Temperatura SolarAr:");
//            //tsa - Temperatura SolarAr
//            float tsa = new Calculo().TemperaturaSolarAr(2.7, 5.9, 7.1);
//            System.out.println("TSA: " + tsa + "\n");  
//        
//        System.out.println("Densidade do fluxo de calor");
//            //dfv - Densidade do fluxo de calor no verao
//            float dfv = new Calculo().DensidadeFluxoVerao(tt, tsa, 25.5, 30.4);
//            System.out.println("DFV: " + dfv + "\n");
//        
//        System.out.println("Fluxo de calor:");
//            //fc - Fluxo de calor
//            float[] fc = new float[3];
//            fc[0] = new Calculo().FluxoCalor(dfv, 3.5);
//            fc[1] = new Calculo().FluxoCalor(dfv, 4.5);
//            fc[2] = new Calculo().FluxoCalor(dfv, 5.5);
//            for (int i = 0; i < fc.length; i++) {
//                System.out.println("FC" + i + ": " + fc[i]);
//            }
//            System.out.println("");
//        
//        //Caso use vidro
//        System.out.println("Fluxo de calor, quando tem vidro:");
//            //fcvv - Fluxo de calor no verao, quando tem vidro
//            float[] fcv = new float[3];
//            fcv[0] = new Calculo().FluxoCalorVidro(tt, 25.6, 30.7, 35.8, 34.2);
//            fcv[1] = new Calculo().FluxoCalorVidro(tt, 23.6, 29.7, 31.8, 32.2);
//            fcv[2] = new Calculo().FluxoCalorVidro(tt, 21.6, 36.7, 34.8, 30.2);
//            for (int i = 0; i < fcv.length; i++) {
//                System.out.println("FCVV"+ i + ": " + fcv[i]);
//            }
//            System.out.println("");
//        
//        System.out.println("Carga Termica:");
//            //O fcv pode estar vazio
//            //ctv - Carga Termica
//            float ctv = new Calculo().CargaTermica(fc, fcv);
//            System.out.println("CT: " + ctv + "\n");
//    }
}
