package tech.jhipster.sample.domain;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * A EntityWithServiceImplAndDTO.
 */
@Table("entity_with_service_impl_and_dto")
public class EntityWithServiceImplAndDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column("id")
    private Long id;

    @Column("louis")
    private String louis;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public EntityWithServiceImplAndDTO id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLouis() {
        return this.louis;
    }

    public EntityWithServiceImplAndDTO louis(String louis) {
        this.setLouis(louis);
        return this;
    }

    public void setLouis(String louis) {
        this.louis = louis;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EntityWithServiceImplAndDTO)) {
            return false;
        }
        return id != null && id.equals(((EntityWithServiceImplAndDTO) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "EntityWithServiceImplAndDTO{" +
            "id=" + getId() +
            ", louis='" + getLouis() + "'" +
            "}";
    }
}
