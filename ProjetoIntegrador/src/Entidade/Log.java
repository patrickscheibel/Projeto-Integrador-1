/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidade;

import com.sun.istack.internal.NotNull;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 *
 * @author conti
 */
@Entity
@Table(name = "log")
public class Log {
    
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotNull()
    @Column(name = "data")
    private Calendar data;
    
    @NotNull()
    @Column(name = "descricao")
    private String descricao;
    
    @NotNull()
    @Column(name = "erro")
    private String erro;
    
    @NotNull()
    @Column(name = "dados")
    private String dados;
    
    public Log(){}

    public Log(int id, Calendar data, String descricao, String erro, String dados) {
        this.id = id;
        this.data = data;
        this.descricao = descricao;
        this.erro = erro;
        this.dados = dados;
    }

    @Override
    public String toString() {
        return "Log{" + "id=" + id + ", data=" + data + ", descricao=" + descricao + ", erro=" + erro + ", dados=" + dados + '}';
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
    
    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }
       

    public String getDados() {
        return dados;
    }

    public void setDados(String dados) {
        this.dados = dados;
    }
}