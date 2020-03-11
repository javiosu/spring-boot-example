package org.skh.domain.log;

import javax.persistence.*;

import java.io.Serializable;
import java.time.ZonedDateTime;

/**
 * A RegistrationLog.
 */
@Entity
@Table(name = "registration_log")
public class RegistrationLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "device_type")
    private String deviceType;

    @Column(name = "created_time")
    private ZonedDateTime createdTime;

    @Column(name = "req_personal_no")
    private String reqPersonalNo;

    @Column(name = "req_birthdate")
    private String reqBirthday;

    @Column(name = "req_visitdate")
    private String reqVisitDate;

    @Column(name = "req_shift_code")
    private String reqShiftCode;

    @Column(name = "req_division_code")
    private String reqDivisionCode;

    @Column(name = "req_clinic_code")
    private String reqClinicCode;

    @Column(name = "req_doctor_emp_no")
    private String reqDoctorEmpNo;

    @Column(name = "req_ispublic_name")
    private String reqIsPublicName;

    @Column(name = "req_isbypass_firstvisit_check")
    private String reqIsBypassFirstVisitCheck;

    @Column(name = "res_status")
    private String resStatus;

    @Column(name = "res_title")
    private String resTitle;

    @Column(name = "res_path")
    private String resPath;

    @Column(name = "res_message")
    private String resMessage;

    @Column(name = "res_birthday")
    private String resBirthday;

    @Column(name = "res_patient_name")
    private String resPatientName;

    @Column(name = "res_id_no")
    private String resIdNo;

    @Column(name = "res_medical_note_no")
    private String resMedicalNoteNo;

    @Column(name = "res_division_code")
    private String resDivisionCode;

    @Column(name = "res_division_name")
    private String resDivisionName;

    @Column(name = "res_doctor_emp_no")
    private String resDoctorEmpNo;

    @Column(name = "res_doctor_name")
    private String resDoctorName;

    @Column(name = "res_visit_date")
    private String resVisitDate;

    @Column(name = "res_display_visitdate_shift")
    private String resDisplayVisitDateShift;

    @Column(name = "res_display_clinicname_category")
    private String resDisplayClinicNameCategory;

    @Column(name = "res_visit_seq_no")
    private String resVisitSeqNo;

    @Column(name = "res_suggested_arrivaltime")
    private String resSuggestedArrivalTime;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public RegistrationLog deviceType(String deviceType) {
        this.deviceType = deviceType;
        return this;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public ZonedDateTime getCreatedTime() {
        return createdTime;
    }

    public RegistrationLog createdTime(ZonedDateTime createdTime) {
        this.createdTime = createdTime;
        return this;
    }

    public void setCreatedTime(ZonedDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public String getReqPersonalNo() {
        return reqPersonalNo;
    }

    public RegistrationLog reqPersonalNo(String reqPersonalNo) {
        this.reqPersonalNo = reqPersonalNo;
        return this;
    }

    public void setReqPersonalNo(String reqPersonalNo) {
        this.reqPersonalNo = reqPersonalNo;
    }

    public String getReqBirthday() {
        return reqBirthday;
    }

    public RegistrationLog reqBirthday(String reqBirthday) {
        this.reqBirthday = reqBirthday;
        return this;
    }

    public void setReqBirthday(String reqBirthday) {
        this.reqBirthday = reqBirthday;
    }

    public String getReqVisitDate() {
        return reqVisitDate;
    }

    public RegistrationLog reqVisitDate(String reqVisitDate) {
        this.reqVisitDate = reqVisitDate;
        return this;
    }

    public void setReqVisitDate(String reqVisitDate) {
        this.reqVisitDate = reqVisitDate;
    }

    public String getReqShiftCode() {
        return reqShiftCode;
    }

    public RegistrationLog reqShiftCode(String reqShiftCode) {
        this.reqShiftCode = reqShiftCode;
        return this;
    }

    public void setReqShiftCode(String reqShiftCode) {
        this.reqShiftCode = reqShiftCode;
    }

    public String getReqDivisionCode() {
        return reqDivisionCode;
    }

    public RegistrationLog reqDivisionCode(String reqDivisionCode) {
        this.reqDivisionCode = reqDivisionCode;
        return this;
    }

    public void setReqDivisionCode(String reqDivisionCode) {
        this.reqDivisionCode = reqDivisionCode;
    }

    public String getReqClinicCode() {
        return reqClinicCode;
    }

    public RegistrationLog reqClinicCode(String reqClinicCode) {
        this.reqClinicCode = reqClinicCode;
        return this;
    }

    public void setReqClinicCode(String reqClinicCode) {
        this.reqClinicCode = reqClinicCode;
    }

    public String getReqDoctorEmpNo() {
        return reqDoctorEmpNo;
    }

    public RegistrationLog reqDoctorEmpNo(String reqDoctorEmpNo) {
        this.reqDoctorEmpNo = reqDoctorEmpNo;
        return this;
    }

    public void setReqDoctorEmpNo(String reqDoctorEmpNo) {
        this.reqDoctorEmpNo = reqDoctorEmpNo;
    }

    public String getReqIsPublicName() {
        return reqIsPublicName;
    }

    public RegistrationLog reqIsPublicName(String reqIsPublicName) {
        this.reqIsPublicName = reqIsPublicName;
        return this;
    }

    public void setReqIsPublicName(String reqIsPublicName) {
        this.reqIsPublicName = reqIsPublicName;
    }

    public String getReqIsBypassFirstVisitCheck() {
        return reqIsBypassFirstVisitCheck;
    }

    public RegistrationLog reqIsBypassFirstVisitCheck(String reqIsBypassFirstVisitCheck) {
        this.reqIsBypassFirstVisitCheck = reqIsBypassFirstVisitCheck;
        return this;
    }

    public void setReqIsBypassFirstVisitCheck(String reqIsBypassFirstVisitCheck) {
        this.reqIsBypassFirstVisitCheck = reqIsBypassFirstVisitCheck;
    }

    public String getResStatus() {
        return resStatus;
    }

    public RegistrationLog resStatus(String resStatus) {
        this.resStatus = resStatus;
        return this;
    }

    public void setResStatus(String resStatus) {
        this.resStatus = resStatus;
    }

    public String getResTitle() {
        return resTitle;
    }

    public RegistrationLog resTitle(String resTitle) {
        this.resTitle = resTitle;
        return this;
    }

    public void setResTitle(String resTitle) {
        this.resTitle = resTitle;
    }

    public String getResPath() {
        return resPath;
    }

    public RegistrationLog resPath(String resPath) {
        this.resPath = resPath;
        return this;
    }

    public void setResPath(String resPath) {
        this.resPath = resPath;
    }

    public String getResMessage() {
        return resMessage;
    }

    public RegistrationLog resMessage(String resMessage) {
        this.resMessage = resMessage;
        return this;
    }

    public void setResMessage(String resMessage) {
        this.resMessage = resMessage;
    }

    public String getResBirthday() {
        return resBirthday;
    }

    public RegistrationLog resBirthday(String resBirthday) {
        this.resBirthday = resBirthday;
        return this;
    }

    public void setResBirthday(String resBirthday) {
        this.resBirthday = resBirthday;
    }

    public String getResPatientName() {
        return resPatientName;
    }

    public RegistrationLog resPatientName(String resPatientName) {
        this.resPatientName = resPatientName;
        return this;
    }

    public void setResPatientName(String resPatientName) {
        this.resPatientName = resPatientName;
    }

    public String getResIdNo() {
        return resIdNo;
    }

    public RegistrationLog resIdNo(String resIdNo) {
        this.resIdNo = resIdNo;
        return this;
    }

    public void setResIdNo(String resIdNo) {
        this.resIdNo = resIdNo;
    }

    public String getResMedicalNoteNo() {
        return resMedicalNoteNo;
    }

    public RegistrationLog resMedicalNoteNo(String resMedicalNoteNo) {
        this.resMedicalNoteNo = resMedicalNoteNo;
        return this;
    }

    public void setResMedicalNoteNo(String resMedicalNoteNo) {
        this.resMedicalNoteNo = resMedicalNoteNo;
    }

    public String getResDivisionCode() {
        return resDivisionCode;
    }

    public RegistrationLog resDivisionCode(String resDivisionCode) {
        this.resDivisionCode = resDivisionCode;
        return this;
    }

    public void setResDivisionCode(String resDivisionCode) {
        this.resDivisionCode = resDivisionCode;
    }

    public String getResDivisionName() {
        return resDivisionName;
    }

    public RegistrationLog resDivisionName(String resDivisionName) {
        this.resDivisionName = resDivisionName;
        return this;
    }

    public void setResDivisionName(String resDivisionName) {
        this.resDivisionName = resDivisionName;
    }

    public String getResDoctorEmpNo() {
        return resDoctorEmpNo;
    }

    public RegistrationLog resDoctorEmpNo(String resDoctorEmpNo) {
        this.resDoctorEmpNo = resDoctorEmpNo;
        return this;
    }

    public void setResDoctorEmpNo(String resDoctorEmpNo) {
        this.resDoctorEmpNo = resDoctorEmpNo;
    }

    public String getResDoctorName() {
        return resDoctorName;
    }

    public RegistrationLog resDoctorName(String resDoctorName) {
        this.resDoctorName = resDoctorName;
        return this;
    }

    public void setResDoctorName(String resDoctorName) {
        this.resDoctorName = resDoctorName;
    }

    public String getResVisitDate() {
        return resVisitDate;
    }

    public RegistrationLog resVisitDate(String resVisitDate) {
        this.resVisitDate = resVisitDate;
        return this;
    }

    public void setResVisitDate(String resVisitDate) {
        this.resVisitDate = resVisitDate;
    }

    public String getResDisplayVisitDateShift() {
        return resDisplayVisitDateShift;
    }

    public RegistrationLog resDisplayVisitDateShift(String resDisplayVisitDateShift) {
        this.resDisplayVisitDateShift = resDisplayVisitDateShift;
        return this;
    }

    public void setResDisplayVisitDateShift(String resDisplayVisitDateShift) {
        this.resDisplayVisitDateShift = resDisplayVisitDateShift;
    }

    public String getResDisplayClinicNameCategory() {
        return resDisplayClinicNameCategory;
    }

    public RegistrationLog resDisplayClinicNameCategory(String resDisplayClinicNameCategory) {
        this.resDisplayClinicNameCategory = resDisplayClinicNameCategory;
        return this;
    }

    public void setResDisplayClinicNameCategory(String resDisplayClinicNameCategory) {
        this.resDisplayClinicNameCategory = resDisplayClinicNameCategory;
    }

    public String getResVisitSeqNo() {
        return resVisitSeqNo;
    }

    public RegistrationLog resVisitSeqNo(String resVisitSeqNo) {
        this.resVisitSeqNo = resVisitSeqNo;
        return this;
    }

    public void setResVisitSeqNo(String resVisitSeqNo) {
        this.resVisitSeqNo = resVisitSeqNo;
    }

    public String getResSuggestedArrivalTime() {
        return resSuggestedArrivalTime;
    }

    public RegistrationLog resSuggestedArrivalTime(String resSuggestedArrivalTime) {
        this.resSuggestedArrivalTime = resSuggestedArrivalTime;
        return this;
    }

    public void setResSuggestedArrivalTime(String resSuggestedArrivalTime) {
        this.resSuggestedArrivalTime = resSuggestedArrivalTime;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RegistrationLog)) {
            return false;
        }
        return id != null && id.equals(((RegistrationLog) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "RegistrationLog{" +
            "id=" + getId() +
            ", deviceType='" + getDeviceType() + "'" +
            ", createdTime='" + getCreatedTime() + "'" +
            ", reqPersonalNo='" + getReqPersonalNo() + "'" +
            ", reqBirthday='" + getReqBirthday() + "'" +
            ", reqVisitDate='" + getReqVisitDate() + "'" +
            ", reqShiftCode='" + getReqShiftCode() + "'" +
            ", reqDivisionCode='" + getReqDivisionCode() + "'" +
            ", reqClinicCode='" + getReqClinicCode() + "'" +
            ", reqDoctorEmpNo='" + getReqDoctorEmpNo() + "'" +
            ", reqIsPublicName='" + getReqIsPublicName() + "'" +
            ", reqIsBypassFirstVisitCheck='" + getReqIsBypassFirstVisitCheck() + "'" +
            ", resStatus='" + getResStatus() + "'" +
            ", resTitle='" + getResTitle() + "'" +
            ", resPath='" + getResPath() + "'" +
            ", resMessage='" + getResMessage() + "'" +
            ", resBirthday='" + getResBirthday() + "'" +
            ", resPatientName='" + getResPatientName() + "'" +
            ", resIdNo='" + getResIdNo() + "'" +
            ", resMedicalNoteNo='" + getResMedicalNoteNo() + "'" +
            ", resDivisionCode='" + getResDivisionCode() + "'" +
            ", resDivisionName='" + getResDivisionName() + "'" +
            ", resDoctorEmpNo='" + getResDoctorEmpNo() + "'" +
            ", resDoctorName='" + getResDoctorName() + "'" +
            ", resVisitDate='" + getResVisitDate() + "'" +
            ", resDisplayVisitDateShift='" + getResDisplayVisitDateShift() + "'" +
            ", resDisplayClinicNameCategory='" + getResDisplayClinicNameCategory() + "'" +
            ", resVisitSeqNo='" + getResVisitSeqNo() + "'" +
            ", resSuggestedArrivalTime='" + getResSuggestedArrivalTime() + "'" +
            "}";
    }
}
