package org.skh.service.dto;
import lombok.Data;
import org.skh.domain.portal.DepartmentDivisionHealthEducation;

import java.io.Serializable;
import java.time.ZonedDateTime;

/**
 * A DTO for the {@link DepartmentDivisionHealthEducation} entity.
 */
@Data
public class DepartmentDivisionHealthEducationDTO implements Serializable {

    private Integer healthId;

    private Integer typeId;

    private String title;

    private Integer orders;

    private String healthPicture;

    private String healthPictureSrc;

    private ZonedDateTime startTime;

    private ZonedDateTime endTime;

    private String createBy;

    private String createName;

    private ZonedDateTime createTime;

    private String createDeptId;

    private String createDeptName;

    private String modifyBy;

    private String modifyName;

    private ZonedDateTime modifyTime;

    private String modifyDeptId;

    private String modifyDeptName;

    private String contentType;

    private String url;
}
