package org.skh.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.skh.web.rest.TestUtil;

public class RegistrationLogDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(RegistrationLogDTO.class);
        RegistrationLogDTO registrationLogDTO1 = new RegistrationLogDTO();
        registrationLogDTO1.setId(1L);
        RegistrationLogDTO registrationLogDTO2 = new RegistrationLogDTO();
        assertThat(registrationLogDTO1).isNotEqualTo(registrationLogDTO2);
        registrationLogDTO2.setId(registrationLogDTO1.getId());
        assertThat(registrationLogDTO1).isEqualTo(registrationLogDTO2);
        registrationLogDTO2.setId(2L);
        assertThat(registrationLogDTO1).isNotEqualTo(registrationLogDTO2);
        registrationLogDTO1.setId(null);
        assertThat(registrationLogDTO1).isNotEqualTo(registrationLogDTO2);
    }
}
