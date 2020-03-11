package org.skh.service.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class RegistrationLogMapperTest {

    private RegistrationLogMapper registrationLogMapper;

    @BeforeEach
    public void setUp() {
        registrationLogMapper = new RegistrationLogMapperImpl();
    }

    @Test
    public void testEntityFromId() {
        Long id = 2L;
        assertThat(registrationLogMapper.fromId(id).getId()).isEqualTo(id);
        assertThat(registrationLogMapper.fromId(null)).isNull();
    }
}
