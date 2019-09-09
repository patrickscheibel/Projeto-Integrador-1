/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tela.Apoio;

import DAO.DAO;
import Entidade.Usuario;
import Tela.JFrameTelaPrincipal;
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
    
    public void Material(JFrameTelaPrincipal telaPrincipal, JIframeMaterial jif, Usuario usuario){
        if(VerificarPermissao("ver_material", usuario.getGrupoPermissao().getId()) == true){       
            telaPrincipal.Ver(jif);
        } else {
            new DlgAviso("Permissão Negada");
        }
        if(VerificarPermissao("adicionar_material", usuario.getGrupoPermissao().getId()) != true) {
            jif.DesativarAdicao();
        }
        if(VerificarPermissao("editar_material", usuario.getGrupoPermissao().getId()) != true) {
            jif.DesativarEdicao();
        }
    }
    
    public void Usuario(JFrameTelaPrincipal telaPrincipal, JIframeUsuario jif, Usuario usuario){
        if(VerificarPermissao("ver_usuario", usuario.getGrupoPermissao().getId()) == true){       
            telaPrincipal.Ver(jif);
        } else {
            new DlgAviso("Permissão Negada");
        }
        if(VerificarPermissao("adicionar_usuario", usuario.getGrupoPermissao().getId()) != true) {
            jif.DesativarAdicao();
        }
        if(VerificarPermissao("editar_usuario", usuario.getGrupoPermissao().getId()) != true) {
            jif.DesativarEdicao();
        }
    }
    
    public void TipoMaterial(JFrameTelaPrincipal telaPrincipal, JIframeTipoMaterial jif, Usuario usuario){
        if(VerificarPermissao("ver_tipoMaterial", usuario.getGrupoPermissao().getId()) == true){       
            telaPrincipal.Ver(jif);
        } else {
            new DlgAviso("Permissão Negada");
        }
        if(VerificarPermissao("adicionar_tipoMaterial", usuario.getGrupoPermissao().getId()) != true) {
            jif.DesativarAdicao();
        }
        if(VerificarPermissao("editar_tipoMaterial", usuario.getGrupoPermissao().getId()) != true) {
            jif.DesativarEdicao();
        }
    }
    
    public void CorMaterial(JFrameTelaPrincipal telaPrincipal, JIframeCorMaterial jif, Usuario usuario){
        if(VerificarPermissao("ver_corMaterial", usuario.getGrupoPermissao().getId()) == true){       
            telaPrincipal.Ver(jif);
        } else {
            new DlgAviso("Permissão Negada");
        }
        if(VerificarPermissao("adicionar_corMaterial", usuario.getGrupoPermissao().getId()) != true) {
            jif.DesativarAdicao();
        }
        if(VerificarPermissao("editar_corMaterial", usuario.getGrupoPermissao().getId()) != true) {
            jif.DesativarEdicao();
        }
    }
    
    public void GrupoPermissao(JFrameTelaPrincipal telaPrincipal, JIframeGrupoPermissao jif, Usuario usuario){
        if(VerificarPermissao("ver_grupoPermissao", usuario.getGrupoPermissao().getId()) == true){       
            telaPrincipal.Ver(jif);
        } else {
            new DlgAviso("Permissão Negada");
        }
        if(VerificarPermissao("adicionar_grupoPermissao", usuario.getGrupoPermissao().getId()) != true) {
            jif.DesativarAdicao();
        }
        if(VerificarPermissao("editar_grupoPermissao", usuario.getGrupoPermissao().getId()) != true) {
            jif.DesativarEdicao();
        }
    }
    
    public void Configuracao(JFrameTelaPrincipal telaPrincipal, JIframeConfiguracao jif, Usuario usuario){
        if(VerificarPermissao("ver_configuracao", usuario.getGrupoPermissao().getId()) == true){       
            telaPrincipal.Ver(jif);
        } else {
            new DlgAviso("Permissão Negada");
        }
        if(VerificarPermissao("editar_configuracao", usuario.getGrupoPermissao().getId()) != true) {
            jif.DesativarEdicao();
        }
    }
    
}
