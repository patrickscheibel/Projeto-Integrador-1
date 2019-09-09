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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Scheibel
 */
@Entity
@Table(name = "permissao_grupo_permissao")
public class PermissaoGrupoPermissao implements Serializable {
    
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private int id;
    
    @NotNull
    @OneToOne()
    @JoinColumn(name = "permissao_id", nullable = false)
    private Permissao permissao;
    
    @NotNull
    @OneToOne()
    @JoinColumn(name = "grupo_permissao_id", nullable = false)
    private GrupoPermissao grupoPermissao;

    public PermissaoGrupoPermissao(){}
    
    public PermissaoGrupoPermissao(int id, Permissao permissao, GrupoPermissao grupoPermissao) {
        this.id = id;
        this.permissao = permissao;
        this.grupoPermissao = grupoPermissao;
    }

    @Override
    public String toString() {
        return "PermissaoGrupoPermissao{" + "id=" + id + ", permissao=" + permissao + ", grupoPermissao=" + grupoPermissao + '}';
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Permissao getPermissao() {
        return permissao;
    }

    public void setPermissao(Permissao permissao) {
        this.permissao = permissao;
    }

    public GrupoPermissao getGrupoPermissao() {
        return grupoPermissao;
    }

    public void setGrupoPermissao(GrupoPermissao grupoPermissao) {
        this.grupoPermissao = grupoPermissao;
    }
    
}
