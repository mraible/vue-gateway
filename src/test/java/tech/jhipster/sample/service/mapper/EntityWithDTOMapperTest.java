package tech.jhipster.sample.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EntityWithDTOMapperTest {

    private EntityWithDTOMapper entityWithDTOMapper;

    @BeforeEach
    public void setUp() {
        entityWithDTOMapper = new EntityWithDTOMapperImpl();
    }
}
