package org.skh.domain;

import org.junit.jupiter.api.Test;
import org.skh.domain.log.RegistrationLog;
import org.skh.web.rest.TestUtil;

import static org.assertj.core.api.Assertions.assertThat;

public class RegistrationLogTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(RegistrationLog.class);
        RegistrationLog registrationLog1 = new RegistrationLog();
        registrationLog1.setId(1L);
        RegistrationLog registrationLog2 = new RegistrationLog();
        registrationLog2.setId(registrationLog1.getId());
        assertThat(registrationLog1).isEqualTo(registrationLog2);
        registrationLog2.setId(2L);
        assertThat(registrationLog1).isNotEqualTo(registrationLog2);
        registrationLog1.setId(null);
        assertThat(registrationLog1).isNotEqualTo(registrationLog2);
    }
}
