package tech.jhipster.sample.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link tech.jhipster.sample.domain.EntityWithServiceImplPaginationAndDTO} entity.
 */
public class EntityWithServiceImplPaginationAndDTODTO implements Serializable {

    private Long id;

    private String theo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTheo() {
        return theo;
    }

    public void setTheo(String theo) {
        this.theo = theo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EntityWithServiceImplPaginationAndDTODTO)) {
            return false;
        }

        EntityWithServiceImplPaginationAndDTODTO entityWithServiceImplPaginationAndDTODTO = (EntityWithServiceImplPaginationAndDTODTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, entityWithServiceImplPaginationAndDTODTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "EntityWithServiceImplPaginationAndDTODTO{" +
            "id=" + getId() +
            ", theo='" + getTheo() + "'" +
            "}";
    }
}
