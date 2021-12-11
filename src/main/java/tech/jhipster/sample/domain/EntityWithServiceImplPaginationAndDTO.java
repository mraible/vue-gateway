package tech.jhipster.sample.domain;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

/**
 * A EntityWithServiceImplPaginationAndDTO.
 */
@Table("entity_with_service_impl_pagination_and_dto")
public class EntityWithServiceImplPaginationAndDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column("id")
    private Long id;

    @Column("theo")
    private String theo;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public EntityWithServiceImplPaginationAndDTO id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTheo() {
        return this.theo;
    }

    public EntityWithServiceImplPaginationAndDTO theo(String theo) {
        this.setTheo(theo);
        return this;
    }

    public void setTheo(String theo) {
        this.theo = theo;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EntityWithServiceImplPaginationAndDTO)) {
            return false;
        }
        return id != null && id.equals(((EntityWithServiceImplPaginationAndDTO) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "EntityWithServiceImplPaginationAndDTO{" +
            "id=" + getId() +
            ", theo='" + getTheo() + "'" +
            "}";
    }
}
