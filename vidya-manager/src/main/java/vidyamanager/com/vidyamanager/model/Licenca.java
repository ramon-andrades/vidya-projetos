package vidyamanager.com.vidyamanager.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table
@SequenceGenerator(name = "seq_licenca", sequenceName = "seq_licenca", allocationSize = 1, initialValue = 1)
public class Licenca implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_licenca")
    private Long id;

    private String nomeLicenca;

    @Temporal(TemporalType.DATE)
    private Date datavalid;

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "produto_fk"))
    private Produto produto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeLicenca() {
        return nomeLicenca;
    }

    public void setNomeLicenca(String nomeLicenca) {
        this.nomeLicenca = nomeLicenca;
    }

    public Date getDatavalid() {
        return datavalid;
    }

    public void setDatavalid(Date datavalid) {
        this.datavalid = datavalid;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Licenca)) return false;
        Licenca licenca = (Licenca) o;
        return Objects.equals(getId(), licenca.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
