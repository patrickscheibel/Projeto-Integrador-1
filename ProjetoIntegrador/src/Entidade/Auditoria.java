/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidade;

import com.sun.istack.internal.NotNull;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author Scheibel
 */
public class Auditoria {
    
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
    @Column(name = "descricao")
    private String descricao;
    
    @NotNull()
    @Column(name = "dados")
    private String dados;
    
    public Auditoria(){}

    public Auditoria(int id, Usuario usuario, Calendar data, String descricao, String dados) {
        this.id = id;
        this.usuario = usuario;
        this.data = data;
        this.descricao = descricao;
        this.dados = dados;
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
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDados() {
        return dados;
    }

    public void setDados(String dados) {
        this.dados = dados;
    }
}
