package tech.jhipster.sample.service.mapper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FieldTestMapstructAndServiceClassEntityMapperTest {

    private FieldTestMapstructAndServiceClassEntityMapper fieldTestMapstructAndServiceClassEntityMapper;

    @BeforeEach
    public void setUp() {
        fieldTestMapstructAndServiceClassEntityMapper = new FieldTestMapstructAndServiceClassEntityMapperImpl();
    }
}
