package org.skh.domain;

import org.junit.jupiter.api.Test;
import org.skh.domain.portal.DepartmentDivisionHealthEducationType;
import org.skh.web.rest.TestUtil;

import static org.assertj.core.api.Assertions.assertThat;

public class DepartmentDivisionHealthEducationTypeTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(DepartmentDivisionHealthEducationType.class);
        DepartmentDivisionHealthEducationType departmentDivisionHealthEducationType1 = new DepartmentDivisionHealthEducationType();
        departmentDivisionHealthEducationType1.setTypeId(1);
        DepartmentDivisionHealthEducationType departmentDivisionHealthEducationType2 = new DepartmentDivisionHealthEducationType();
        departmentDivisionHealthEducationType2.setTypeId(departmentDivisionHealthEducationType1.getTypeId());
        assertThat(departmentDivisionHealthEducationType1).isEqualTo(departmentDivisionHealthEducationType2);
        departmentDivisionHealthEducationType2.setTypeId(2);
        assertThat(departmentDivisionHealthEducationType1).isNotEqualTo(departmentDivisionHealthEducationType2);
        departmentDivisionHealthEducationType1.setTypeId(null);
        assertThat(departmentDivisionHealthEducationType1).isNotEqualTo(departmentDivisionHealthEducationType2);
    }
}
