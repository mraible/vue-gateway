package tech.jhipster.sample.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link tech.jhipster.sample.domain.EntityWithServiceClassPaginationAndDTO} entity.
 */
public class EntityWithServiceClassPaginationAndDTODTO implements Serializable {

    private Long id;

    private String lena;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLena() {
        return lena;
    }

    public void setLena(String lena) {
        this.lena = lena;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EntityWithServiceClassPaginationAndDTODTO)) {
            return false;
        }

        EntityWithServiceClassPaginationAndDTODTO entityWithServiceClassPaginationAndDTODTO = (EntityWithServiceClassPaginationAndDTODTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, entityWithServiceClassPaginationAndDTODTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "EntityWithServiceClassPaginationAndDTODTO{" +
            "id=" + getId() +
            ", lena='" + getLena() + "'" +
            "}";
    }
}
