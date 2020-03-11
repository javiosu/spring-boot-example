package org.skh.service.dto;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.skh.web.rest.TestUtil;

public class DepartmentDivisionHealthEducationTypeDTOTest {

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(DepartmentDivisionHealthEducationTypeDTO.class);
        DepartmentDivisionHealthEducationTypeDTO departmentDivisionHealthEducationTypeDTO1 = new DepartmentDivisionHealthEducationTypeDTO();
        departmentDivisionHealthEducationTypeDTO1.setId(1L);
        DepartmentDivisionHealthEducationTypeDTO departmentDivisionHealthEducationTypeDTO2 = new DepartmentDivisionHealthEducationTypeDTO();
        assertThat(departmentDivisionHealthEducationTypeDTO1).isNotEqualTo(departmentDivisionHealthEducationTypeDTO2);
        departmentDivisionHealthEducationTypeDTO2.setId(departmentDivisionHealthEducationTypeDTO1.getId());
        assertThat(departmentDivisionHealthEducationTypeDTO1).isEqualTo(departmentDivisionHealthEducationTypeDTO2);
        departmentDivisionHealthEducationTypeDTO2.setId(2L);
        assertThat(departmentDivisionHealthEducationTypeDTO1).isNotEqualTo(departmentDivisionHealthEducationTypeDTO2);
        departmentDivisionHealthEducationTypeDTO1.setId(null);
        assertThat(departmentDivisionHealthEducationTypeDTO1).isNotEqualTo(departmentDivisionHealthEducationTypeDTO2);
    }
}
