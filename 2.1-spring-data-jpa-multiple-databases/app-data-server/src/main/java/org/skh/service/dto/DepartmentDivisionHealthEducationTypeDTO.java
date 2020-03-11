package org.skh.service.dto;
import lombok.Data;
import org.skh.domain.portal.DepartmentDivisionHealthEducationType;

import java.time.ZonedDateTime;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link DepartmentDivisionHealthEducationType} entity.
 */
@Data
public class DepartmentDivisionHealthEducationTypeDTO implements Serializable {

    private Long id;

    private Integer typeId;

    private String divisionId;

    private String typeName;

    private Integer orders;

    private String createBy;

    private String createName;

    private String createDeptId;

    private String createDeptName;

    private String modifyBy;

    private String modifyName;

    private String modifyDeptId;

    private String modifyDeptName;

    private ZonedDateTime startTime;

    private ZonedDateTime endTime;

    private ZonedDateTime createTime;

    private ZonedDateTime modifyTime;
}
