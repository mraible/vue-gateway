package tech.jhipster.sample.domain;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * A EntityWithServiceImplAndPagination.
 */
@Table("entity_with_service_impl_and_pagination")
public class EntityWithServiceImplAndPagination implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column("id")
    private Long id;

    @Column("hugo")
    private String hugo;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public EntityWithServiceImplAndPagination id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHugo() {
        return this.hugo;
    }

    public EntityWithServiceImplAndPagination hugo(String hugo) {
        this.setHugo(hugo);
        return this;
    }

    public void setHugo(String hugo) {
        this.hugo = hugo;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EntityWithServiceImplAndPagination)) {
            return false;
        }
        return id != null && id.equals(((EntityWithServiceImplAndPagination) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "EntityWithServiceImplAndPagination{" +
            "id=" + getId() +
            ", hugo='" + getHugo() + "'" +
            "}";
    }
}
