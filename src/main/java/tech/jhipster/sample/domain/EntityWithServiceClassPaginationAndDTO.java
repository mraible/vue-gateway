package tech.jhipster.sample.domain;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * A EntityWithServiceClassPaginationAndDTO.
 */
@Table("entity_with_service_class_pagination_and_dto")
public class EntityWithServiceClassPaginationAndDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column("id")
    private Long id;

    @Column("lena")
    private String lena;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public EntityWithServiceClassPaginationAndDTO id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLena() {
        return this.lena;
    }

    public EntityWithServiceClassPaginationAndDTO lena(String lena) {
        this.setLena(lena);
        return this;
    }

    public void setLena(String lena) {
        this.lena = lena;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EntityWithServiceClassPaginationAndDTO)) {
            return false;
        }
        return id != null && id.equals(((EntityWithServiceClassPaginationAndDTO) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "EntityWithServiceClassPaginationAndDTO{" +
            "id=" + getId() +
            ", lena='" + getLena() + "'" +
            "}";
    }
}
