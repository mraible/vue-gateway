package tech.jhipster.sample.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EntityWithPaginationAndDTOMapperTest {

    private EntityWithPaginationAndDTOMapper entityWithPaginationAndDTOMapper;

    @BeforeEach
    public void setUp() {
        entityWithPaginationAndDTOMapper = new EntityWithPaginationAndDTOMapperImpl();
    }
}
