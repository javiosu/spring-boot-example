package org.skh.service.dto;
import lombok.Data;
import org.skh.domain.log.RegistrationLog;

import java.time.ZonedDateTime;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link RegistrationLog} entity.
 */
@Data
public class RegistrationLogDTO implements Serializable {

    private Long id;

    private String deviceType;

    private ZonedDateTime createdTime;

    private String reqPersonalNo;

    private String reqBirthday;

    private String reqVisitDate;

    private String reqShiftCode;

    private String reqDivisionCode;

    private String reqClinicCode;

    private String reqDoctorEmpNo;

    private String reqIsPublicName;

    private String reqIsBypassFirstVisitCheck;

    private String resStatus;

    private String resTitle;

    private String resPath;

    private String resMessage;

    private String resBirthday;

    private String resPatientName;

    private String resIdNo;

    private String resMedicalNoteNo;

    private String resDivisionCode;

    private String resDivisionName;

    private String resDoctorEmpNo;

    private String resDoctorName;

    private String resVisitDate;

    private String resDisplayVisitDateShift;

    private String resDisplayClinicNameCategory;

    private String resVisitSeqNo;

    private String resSuggestedArrivalTime;
}
