package tech.jhipster.sample.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EntityWithServiceImplAndDTOMapperTest {

    private EntityWithServiceImplAndDTOMapper entityWithServiceImplAndDTOMapper;

    @BeforeEach
    public void setUp() {
        entityWithServiceImplAndDTOMapper = new EntityWithServiceImplAndDTOMapperImpl();
    }
}
