/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apoio;

import DAO.AmbienteDAO;
import DAO.ProjetoDAO;
import DAO.UsuarioDAO;
import Tela.JIFrameAmbiente;

/**
 *
 * @author patrick.scheibel
 */
public class test {
    
//    public static void main(String[] args) {
//        TesteCalculo tc = new TesteCalculo();
////        tc.Inverno();
//        tc.Verao();
//    }
    public static void main(String[] args) {
//        JIFrameAmbiente j = new JIFrameAmbiente(new UsuarioDAO().ConsultarUsuario(1));
        JIFrameAmbiente j = new JIFrameAmbiente(new UsuarioDAO().ConsultarUsuario(1), new ProjetoDAO().ConsultarProjeto(1));
            
        j.setVisible(true);
//        System.out.println(new AmbienteDAO().ConsultarListaPorId(1));
    }
    
}
