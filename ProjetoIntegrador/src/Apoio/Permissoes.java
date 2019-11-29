/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apoio;

import DAO.DAO;
import Entidade.Usuario;
import Tela.Apoio.DlgAviso;
import Tela.JIFrameDashboard;
import Tela.JIFrameEmail;
import Tela.JIFrameProjeto;
import Tela.JIFrameTelaPrincipal;
import Tela.JIframeConfiguracao;
import Tela.JIframeCorMaterial;
import Tela.JIframeGrupoPermissao;
import Tela.JIframeMaterial;
import Tela.JIframeTipoMaterial;
import Tela.JIframeUsuario;

/**
 *
 * @author Scheibel
 */
public class Permissoes extends DAO{
  
    public void Material(JIFrameTelaPrincipal telaPrincipal, JIframeMaterial jif, Usuario usuario, String classe){       
        if(VerificarPermissao(("ver_" + classe), usuario.getGrupoPermissao().getId()) == true){       
            telaPrincipal.VerJInternalFrame(jif);
        } else {
            new DlgAviso("Permissão Negada");
        }
        if(VerificarPermissao(("adicionar_" + classe), usuario.getGrupoPermissao().getId()) != true) {
            jif.DesativarAdicao();
        }
        if(VerificarPermissao(("editar_" + classe), usuario.getGrupoPermissao().getId()) != true) {
            jif.DesativarEdicao();
        }
    }
    
    public void Usuario(JIFrameTelaPrincipal telaPrincipal, JIframeUsuario jif, Usuario usuario, String classe){
        if(VerificarPermissao(("ver_" + classe), usuario.getGrupoPermissao().getId()) == true){       
            telaPrincipal.VerJInternalFrame(jif);
        } else {
            new DlgAviso("Permissão Negada");
        }
        if(VerificarPermissao(("adicionar_" + classe), usuario.getGrupoPermissao().getId()) != true) {
            jif.DesativarAdicao();
        }
        if(VerificarPermissao(("editar_" + classe), usuario.getGrupoPermissao().getId()) != true) {
            jif.DesativarEdicao();
        }
    }
    
    public void TipoMaterial(JIFrameTelaPrincipal telaPrincipal, JIframeTipoMaterial jif, Usuario usuario, String classe){
        if(VerificarPermissao(("ver_" + classe), usuario.getGrupoPermissao().getId()) == true){       
            telaPrincipal.VerJInternalFrame(jif);
        } else {
            new DlgAviso("Permissão Negada");
        }
        if(VerificarPermissao(("adicionar_" + classe), usuario.getGrupoPermissao().getId()) != true) {
            jif.DesativarAdicao();
        }
        if(VerificarPermissao(("editar_" + classe), usuario.getGrupoPermissao().getId()) != true) {
            jif.DesativarEdicao();
        }
    }
    
    public void CorMaterial(JIFrameTelaPrincipal telaPrincipal, JIframeCorMaterial jif, Usuario usuario, String classe){
        if(VerificarPermissao(("ver_" + classe), usuario.getGrupoPermissao().getId()) == true){       
            telaPrincipal.VerJInternalFrame(jif);
        } else {
            new DlgAviso("Permissão Negada");
        }
        if(VerificarPermissao(("adicionar_" + classe), usuario.getGrupoPermissao().getId()) != true) {
            jif.DesativarAdicao();
        }
        if(VerificarPermissao(("editar_" + classe), usuario.getGrupoPermissao().getId()) != true) {
            jif.DesativarEdicao();
        }
    }
    
    public void GrupoPermissao(JIFrameTelaPrincipal telaPrincipal, JIframeGrupoPermissao jif, Usuario usuario, String classe){
        if(VerificarPermissao(("ver_" + classe), usuario.getGrupoPermissao().getId()) == true){       
            telaPrincipal.VerJInternalFrame(jif);
        } else {
            new DlgAviso("Permissão Negada");
        }
        if(VerificarPermissao(("adicionar_" + classe), usuario.getGrupoPermissao().getId()) != true) {
            jif.DesativarAdicao();
        }
        if(VerificarPermissao(("editar_" + classe), usuario.getGrupoPermissao().getId()) != true) {
            jif.DesativarEdicao();
        }
    }
    
    public void Configuracao(JIFrameTelaPrincipal telaPrincipal, JIframeConfiguracao jif, Usuario usuario, String classe){
        if(VerificarPermissao(("ver_" + classe), usuario.getGrupoPermissao().getId()) == true){       
            telaPrincipal.VerJInternalFrame(jif);
        } else {
            new DlgAviso("Permissão Negada");
        }
        if(VerificarPermissao(("editar_" + classe), usuario.getGrupoPermissao().getId()) != true) {
            jif.DesativarEdicao();
        }
    }

    public void Projeto(JIFrameTelaPrincipal telaPrincipal, JIFrameProjeto jif, Usuario usuario, String classe) {
        if(VerificarPermissao(("ver_" + classe), usuario.getGrupoPermissao().getId()) == true){       
            telaPrincipal.VerJInternalFrame(jif);
        } else {
            new DlgAviso("Permissão Negada");
        }
        if(VerificarPermissao(("adicionar_" + classe), usuario.getGrupoPermissao().getId()) != true) {
            jif.DesativarAdicao();
        }
        if(VerificarPermissao(("editar_" + classe), usuario.getGrupoPermissao().getId()) != true) {
            jif.DesativarEdicao();
        }
    }

    public void Email(JIFrameTelaPrincipal telaPrincipal, JIFrameEmail jif, Usuario usuario, String classe) {
           if(VerificarPermissao(("ver_" + classe), usuario.getGrupoPermissao().getId()) == true){       
            telaPrincipal.VerJInternalFrame(jif);
        } else {
            new DlgAviso("Permissão Negada");
        }
    }
    
    public void Dashboard(JIFrameTelaPrincipal telaPrincipal, JIFrameDashboard jif, Usuario usuario, String classe){       
        if(VerificarPermissao(("ver_" + classe), usuario.getGrupoPermissao().getId()) == true){       
            telaPrincipal.VerJInternalFrame(jif);
        } else {
            new DlgAviso("Permissão Negada");
        }
    }
    
}
