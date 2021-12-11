package tech.jhipster.sample.service.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

/**
 * A DTO for the {@link tech.jhipster.sample.domain.MapsIdUserProfileWithDTO} entity.
 */
public class MapsIdUserProfileWithDTODTO implements Serializable {

    private Long id;

    private Instant dateOfBirth;

    private UserDTO user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Instant dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MapsIdUserProfileWithDTODTO)) {
            return false;
        }

        MapsIdUserProfileWithDTODTO mapsIdUserProfileWithDTODTO = (MapsIdUserProfileWithDTODTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, mapsIdUserProfileWithDTODTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "MapsIdUserProfileWithDTODTO{" +
            "id=" + getId() +
            ", dateOfBirth='" + getDateOfBirth() + "'" +
            ", user=" + getUser() +
            "}";
    }
}
