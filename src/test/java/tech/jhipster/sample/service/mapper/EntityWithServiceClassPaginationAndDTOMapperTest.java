package tech.jhipster.sample.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EntityWithServiceClassPaginationAndDTOMapperTest {

    private EntityWithServiceClassPaginationAndDTOMapper entityWithServiceClassPaginationAndDTOMapper;

    @BeforeEach
    public void setUp() {
        entityWithServiceClassPaginationAndDTOMapper = new EntityWithServiceClassPaginationAndDTOMapperImpl();
    }
}
