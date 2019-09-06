/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidade;

import com.sun.istack.internal.NotNull;
import java.io.Serializable;
import java.util.Calendar;
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
@Table(name = "auditoria")
public class Auditoria implements Serializable{
    
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull()
    @OneToOne()
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
    
    @NotNull()
    @Column(name = "data")
    private Calendar data;
    
    @NotNull()
    @Column(name = "acao")
    private String acao;
    
    @NotNull()
    @Column(name = "dados")
    private String dados;
    
    public Auditoria(){}

    public Auditoria(int id, Usuario usuario, Calendar data, String descricao, String dados) {
        this.id = id;
        this.usuario = usuario;
        this.data = data;
        this.acao = descricao;
        this.dados = dados;
    }

    @Override
    public String toString() {
        return "Auditoria{" + "id=" + id + ", usuario=" + usuario + ", data=" + data + ", descricao=" + acao + ", dados=" + dados + '}';
    }
    
    public Calendar dataAtual(){
        return Calendar.getInstance();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public String getDescricao() {
        return acao;
    }

    public void setDescricao(String descricao) {
        this.acao = descricao;
    }

    public String getDados() {
        return dados;
    }

    public void setDados(String dados) {
        this.dados = dados;
    }
}
