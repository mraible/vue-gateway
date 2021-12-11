package tech.jhipster.sample.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EntityWithServiceImplPaginationAndDTOMapperTest {

    private EntityWithServiceImplPaginationAndDTOMapper entityWithServiceImplPaginationAndDTOMapper;

    @BeforeEach
    public void setUp() {
        entityWithServiceImplPaginationAndDTOMapper = new EntityWithServiceImplPaginationAndDTOMapperImpl();
    }
}
