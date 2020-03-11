package org.skh.domain;

import org.junit.jupiter.api.Test;
import org.skh.domain.portal.RegistrationDivisionMemo;
import org.skh.web.rest.TestUtil;

import static org.assertj.core.api.Assertions.assertThat;

public class RegistrationDivisionMemoTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(RegistrationDivisionMemo.class);
        RegistrationDivisionMemo registrationDivisionMemo1 = new RegistrationDivisionMemo();
        registrationDivisionMemo1.setDivisionId("1");
        RegistrationDivisionMemo registrationDivisionMemo2 = new RegistrationDivisionMemo();
        registrationDivisionMemo2.setDivisionId(registrationDivisionMemo1.getDivisionId());
        assertThat(registrationDivisionMemo1).isEqualTo(registrationDivisionMemo2);
        registrationDivisionMemo2.setDivisionId("2");
        assertThat(registrationDivisionMemo1).isNotEqualTo(registrationDivisionMemo2);
        registrationDivisionMemo1.setDivisionId(null);
        assertThat(registrationDivisionMemo1).isNotEqualTo(registrationDivisionMemo2);
    }
}
