package Entidade;
// Generated 03/08/2019 20:15:02 by Hibernate Tools 4.3.1


import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Material generated by hbm2java
 */
@Entity
@Table(name = "material")
public class Material  implements Serializable {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne()
    @JoinColumn(name = "tipo_material_id", nullable = false)
    private TipoMaterial tipoMaterial;   
    
    @Column(name = "descricao", length = 100)
    private String descricao;

    @ManyToOne()
    @JoinColumn(name = "cor_material_id", nullable = false)
    private CorMaterial corMaterial;

    @Column(name = "condutividade", precision = 10)
    private double condutividade;

    @Column(name = "espessura", precision = 10)
    private double espessura;
    
    @Column(name = "preco", precision = 10)
    private double preco;

    public Material() {
    }

    public Material(Integer id, TipoMaterial tipoMaterial, String descricao, CorMaterial corMaterial, double condutividade, double espessura, double preco) {
        this.id = id;
        this.tipoMaterial = tipoMaterial;
        this.descricao = descricao;
        this.corMaterial = corMaterial;
        this.condutividade = condutividade;
        this.espessura = espessura;
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Material{" + "id=" + id + ", tipoMaterial=" + tipoMaterial + ", descricao=" + descricao + ", corMaterial=" + corMaterial + ", condutividade=" + condutividade + ", espessura=" + espessura + ", preco=" + preco + '}';
    }
   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public TipoMaterial getTipoMaterial() {
        return tipoMaterial;
    }

    public void setTipoMaterial(TipoMaterial tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }

    public CorMaterial getCorMaterial() {
        return corMaterial;
    }

    public void setCorMaterial(CorMaterial corMaterial) {
        this.corMaterial = corMaterial;
    }

    public double getCondutividade() {
        return condutividade;
    }

    public void setCondutividade(double condutividade) {
        this.condutividade = condutividade;
    }

    public double getEspessura() {
        return espessura;
    }

    public void setEspessura(double espessura) {
        this.espessura = espessura;
    }
    
    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
     
}


