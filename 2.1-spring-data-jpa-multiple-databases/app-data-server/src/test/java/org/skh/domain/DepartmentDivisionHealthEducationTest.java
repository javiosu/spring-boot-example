package org.skh.domain;

import org.junit.jupiter.api.Test;
import org.skh.domain.portal.DepartmentDivisionHealthEducation;
import org.skh.web.rest.TestUtil;

import static org.assertj.core.api.Assertions.assertThat;

public class DepartmentDivisionHealthEducationTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(DepartmentDivisionHealthEducation.class);
        DepartmentDivisionHealthEducation departmentDivisionHealthEducation1 = new DepartmentDivisionHealthEducation();
        departmentDivisionHealthEducation1.setHealthId(1);
        DepartmentDivisionHealthEducation departmentDivisionHealthEducation2 = new DepartmentDivisionHealthEducation();
        departmentDivisionHealthEducation2.setHealthId(departmentDivisionHealthEducation1.getHealthId());
        assertThat(departmentDivisionHealthEducation1).isEqualTo(departmentDivisionHealthEducation2);
        departmentDivisionHealthEducation2.setHealthId(2);
        assertThat(departmentDivisionHealthEducation1).isNotEqualTo(departmentDivisionHealthEducation2);
        departmentDivisionHealthEducation1.setHealthId(null);
        assertThat(departmentDivisionHealthEducation1).isNotEqualTo(departmentDivisionHealthEducation2);
    }
}
