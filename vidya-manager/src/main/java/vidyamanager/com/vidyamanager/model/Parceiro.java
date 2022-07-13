package vidyamanager.com.vidyamanager.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table
@SequenceGenerator(name = "seq_parceiro", sequenceName = "seq_parceiro", allocationSize = 1, initialValue = 1)
public class Parceiro implements Serializable {

    public static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_parceiro")
    private Long id;

    private String nomeParceiro;

    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeParceiro() {
        return nomeParceiro;
    }

    public void setNomeParceiro(String nomeParceiro) {
        this.nomeParceiro = nomeParceiro;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Parceiro)) return false;
        Parceiro parceiro = (Parceiro) o;
        return Objects.equals(getId(), parceiro.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
