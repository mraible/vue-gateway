package tech.jhipster.sample.domain;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * A EntityWithServiceClassAndPagination.
 */
@Table("entity_with_service_class_and_pagination")
public class EntityWithServiceClassAndPagination implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column("id")
    private Long id;

    @Column("enzo")
    private String enzo;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public EntityWithServiceClassAndPagination id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEnzo() {
        return this.enzo;
    }

    public EntityWithServiceClassAndPagination enzo(String enzo) {
        this.setEnzo(enzo);
        return this;
    }

    public void setEnzo(String enzo) {
        this.enzo = enzo;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EntityWithServiceClassAndPagination)) {
            return false;
        }
        return id != null && id.equals(((EntityWithServiceClassAndPagination) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "EntityWithServiceClassAndPagination{" +
            "id=" + getId() +
            ", enzo='" + getEnzo() + "'" +
            "}";
    }
}
