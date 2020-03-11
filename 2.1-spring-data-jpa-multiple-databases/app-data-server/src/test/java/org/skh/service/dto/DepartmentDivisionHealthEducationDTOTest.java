package org.skh.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.skh.web.rest.TestUtil;

public class DepartmentDivisionHealthEducationDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(DepartmentDivisionHealthEducationDTO.class);
        DepartmentDivisionHealthEducationDTO departmentDivisionHealthEducationDTO1 = new DepartmentDivisionHealthEducationDTO();
        departmentDivisionHealthEducationDTO1.setId(1L);
        DepartmentDivisionHealthEducationDTO departmentDivisionHealthEducationDTO2 = new DepartmentDivisionHealthEducationDTO();
        assertThat(departmentDivisionHealthEducationDTO1).isNotEqualTo(departmentDivisionHealthEducationDTO2);
        departmentDivisionHealthEducationDTO2.setId(departmentDivisionHealthEducationDTO1.getId());
        assertThat(departmentDivisionHealthEducationDTO1).isEqualTo(departmentDivisionHealthEducationDTO2);
        departmentDivisionHealthEducationDTO2.setId(2L);
        assertThat(departmentDivisionHealthEducationDTO1).isNotEqualTo(departmentDivisionHealthEducationDTO2);
        departmentDivisionHealthEducationDTO1.setId(null);
        assertThat(departmentDivisionHealthEducationDTO1).isNotEqualTo(departmentDivisionHealthEducationDTO2);
    }
}
