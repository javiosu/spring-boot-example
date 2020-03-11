package org.skh.domain.portal;

import javax.persistence.*;

import java.io.Serializable;
import java.time.ZonedDateTime;

/**
 * A DepartmentDivisionHealthEducation.
 */
@Entity
@Table(name = "department_division_health_education")
public class DepartmentDivisionHealthEducation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "health_id")
    private Integer healthId;

    @Column(name = "type_id")
    private Integer typeId;

    @Column(name = "title")
    private String title;

    @Column(name = "orders")
    private Integer orders;

    @Column(name = "health_picture")
    private String healthPicture;

    @Column(name = "health_picture_src")
    private String healthPictureSrc;

    @Column(name = "start_time")
    private ZonedDateTime startTime;

    @Column(name = "end_time")
    private ZonedDateTime endTime;

    @Column(name = "create_by")
    private String createBy;

    @Column(name = "create_name")
    private String createName;

    @Column(name = "create_time")
    private ZonedDateTime createTime;

    @Column(name = "create_dept_id")
    private String createDeptId;

    @Column(name = "create_dept_name")
    private String createDeptName;

    @Column(name = "modify_by")
    private String modifyBy;

    @Column(name = "modify_name")
    private String modifyName;

    @Column(name = "modify_time")
    private ZonedDateTime modifyTime;

    @Column(name = "modify_dept_id")
    private String modifyDeptId;

    @Column(name = "modify_dept_name")
    private String modifyDeptName;

    @Column(name = "content_type")
    private String contentType;

    @Column(name = "url")
    private String url;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Integer getHealthId() {
        return healthId;
    }

    public void setHealthId(Integer healthId) {
        this.healthId = healthId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public DepartmentDivisionHealthEducation typeId(Integer typeId) {
        this.typeId = typeId;
        return this;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTitle() {
        return title;
    }

    public DepartmentDivisionHealthEducation title(String title) {
        this.title = title;
        return this;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getOrders() {
        return orders;
    }

    public DepartmentDivisionHealthEducation orders(Integer orders) {
        this.orders = orders;
        return this;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    public String getHealthPicture() {
        return healthPicture;
    }

    public DepartmentDivisionHealthEducation healthPicture(String healthPicture) {
        this.healthPicture = healthPicture;
        return this;
    }

    public void setHealthPicture(String healthPicture) {
        this.healthPicture = healthPicture;
    }

    public String getHealthPictureSrc() {
        return healthPictureSrc;
    }

    public DepartmentDivisionHealthEducation healthPictureSrc(String healthPictureSrc) {
        this.healthPictureSrc = healthPictureSrc;
        return this;
    }

    public void setHealthPictureSrc(String healthPictureSrc) {
        this.healthPictureSrc = healthPictureSrc;
    }

    public ZonedDateTime getStartTime() {
        return startTime;
    }

    public DepartmentDivisionHealthEducation startTime(ZonedDateTime startTime) {
        this.startTime = startTime;
        return this;
    }

    public void setStartTime(ZonedDateTime startTime) {
        this.startTime = startTime;
    }

    public ZonedDateTime getEndTime() {
        return endTime;
    }

    public DepartmentDivisionHealthEducation endTime(ZonedDateTime endTime) {
        this.endTime = endTime;
        return this;
    }

    public void setEndTime(ZonedDateTime endTime) {
        this.endTime = endTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public DepartmentDivisionHealthEducation createBy(String createBy) {
        this.createBy = createBy;
        return this;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateName() {
        return createName;
    }

    public DepartmentDivisionHealthEducation createName(String createName) {
        this.createName = createName;
        return this;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public ZonedDateTime getCreateTime() {
        return createTime;
    }

    public DepartmentDivisionHealthEducation createTime(ZonedDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public void setCreateTime(ZonedDateTime createTime) {
        this.createTime = createTime;
    }

    public String getCreateDeptId() {
        return createDeptId;
    }

    public DepartmentDivisionHealthEducation createDeptId(String createDeptId) {
        this.createDeptId = createDeptId;
        return this;
    }

    public void setCreateDeptId(String createDeptId) {
        this.createDeptId = createDeptId;
    }

    public String getCreateDeptName() {
        return createDeptName;
    }

    public DepartmentDivisionHealthEducation createDeptName(String createDeptName) {
        this.createDeptName = createDeptName;
        return this;
    }

    public void setCreateDeptName(String createDeptName) {
        this.createDeptName = createDeptName;
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public DepartmentDivisionHealthEducation modifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
        return this;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    public String getModifyName() {
        return modifyName;
    }

    public DepartmentDivisionHealthEducation modifyName(String modifyName) {
        this.modifyName = modifyName;
        return this;
    }

    public void setModifyName(String modifyName) {
        this.modifyName = modifyName;
    }

    public ZonedDateTime getModifyTime() {
        return modifyTime;
    }

    public DepartmentDivisionHealthEducation modifyTime(ZonedDateTime modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }

    public void setModifyTime(ZonedDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getModifyDeptId() {
        return modifyDeptId;
    }

    public DepartmentDivisionHealthEducation modifyDeptId(String modifyDeptId) {
        this.modifyDeptId = modifyDeptId;
        return this;
    }

    public void setModifyDeptId(String modifyDeptId) {
        this.modifyDeptId = modifyDeptId;
    }

    public String getModifyDeptName() {
        return modifyDeptName;
    }

    public DepartmentDivisionHealthEducation modifyDeptName(String modifyDeptName) {
        this.modifyDeptName = modifyDeptName;
        return this;
    }

    public void setModifyDeptName(String modifyDeptName) {
        this.modifyDeptName = modifyDeptName;
    }

    public String getContentType() {
        return contentType;
    }

    public DepartmentDivisionHealthEducation contentType(String contentType) {
        this.contentType = contentType;
        return this;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getUrl() {
        return url;
    }

    public DepartmentDivisionHealthEducation url(String url) {
        this.url = url;
        return this;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DepartmentDivisionHealthEducation)) {
            return false;
        }
        return healthId != null && healthId.equals(((DepartmentDivisionHealthEducation) o).healthId);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "DepartmentDivisionHealthEducation{" +
            "  healthId=" + getHealthId() +
            ", typeId=" + getTypeId() +
            ", title='" + getTitle() + "'" +
            ", orders=" + getOrders() +
            ", healthPicture='" + getHealthPicture() + "'" +
            ", healthPictureSrc='" + getHealthPictureSrc() + "'" +
            ", startTime='" + getStartTime() + "'" +
            ", endTime='" + getEndTime() + "'" +
            ", createBy='" + getCreateBy() + "'" +
            ", createName='" + getCreateName() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            ", createDeptId='" + getCreateDeptId() + "'" +
            ", createDeptName='" + getCreateDeptName() + "'" +
            ", modifyBy='" + getModifyBy() + "'" +
            ", modifyName='" + getModifyName() + "'" +
            ", modifyTime='" + getModifyTime() + "'" +
            ", modifyDeptId='" + getModifyDeptId() + "'" +
            ", modifyDeptName='" + getModifyDeptName() + "'" +
            ", contentType='" + getContentType() + "'" +
            ", url='" + getUrl() + "'" +
            "}";
    }
}
