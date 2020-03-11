package org.skh.domain.portal;

import javax.persistence.*;

import java.io.Serializable;
import java.time.ZonedDateTime;

/**
 * A DepartmentDivisionHealthEducationType.
 */
@Entity
@Table(name = "department_division_health_education_type")
public class DepartmentDivisionHealthEducationType implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    private Integer typeId;

    @Column(name = "division_id")
    private String divisionId;

    @Column(name = "type_name")
    private String typeName;

    @Column(name = "orders")
    private Integer orders;

    @Column(name = "create_by")
    private String createBy;

    @Column(name = "create_name")
    private String createName;

    @Column(name = "create_dept_id")
    private String createDeptId;

    @Column(name = "create_dept_name")
    private String createDeptName;

    @Column(name = "modify_by")
    private String modifyBy;

    @Column(name = "modify_name")
    private String modifyName;

    @Column(name = "modify_dept_id")
    private String modifyDeptId;

    @Column(name = "modify_dept_name")
    private String modifyDeptName;

    @Column(name = "start_time")
    private ZonedDateTime startTime;

    @Column(name = "end_time")
    private ZonedDateTime endTime;

    @Column(name = "create_time")
    private ZonedDateTime createTime;

    @Column(name = "modify_time")
    private ZonedDateTime modifyTime;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getDivisionId() {
        return divisionId;
    }

    public DepartmentDivisionHealthEducationType divisionId(String divisionId) {
        this.divisionId = divisionId;
        return this;
    }

    public void setDivisionId(String divisionId) {
        this.divisionId = divisionId;
    }

    public String getTypeName() {
        return typeName;
    }

    public DepartmentDivisionHealthEducationType typeName(String typeName) {
        this.typeName = typeName;
        return this;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getOrders() {
        return orders;
    }

    public DepartmentDivisionHealthEducationType orders(Integer orders) {
        this.orders = orders;
        return this;
    }

    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    public String getCreateBy() {
        return createBy;
    }

    public DepartmentDivisionHealthEducationType createBy(String createBy) {
        this.createBy = createBy;
        return this;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateName() {
        return createName;
    }

    public DepartmentDivisionHealthEducationType createName(String createName) {
        this.createName = createName;
        return this;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public String getCreateDeptId() {
        return createDeptId;
    }

    public DepartmentDivisionHealthEducationType createDeptId(String createDeptId) {
        this.createDeptId = createDeptId;
        return this;
    }

    public void setCreateDeptId(String createDeptId) {
        this.createDeptId = createDeptId;
    }

    public String getCreateDeptName() {
        return createDeptName;
    }

    public DepartmentDivisionHealthEducationType createDeptName(String createDeptName) {
        this.createDeptName = createDeptName;
        return this;
    }

    public void setCreateDeptName(String createDeptName) {
        this.createDeptName = createDeptName;
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public DepartmentDivisionHealthEducationType modifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
        return this;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    public String getModifyName() {
        return modifyName;
    }

    public DepartmentDivisionHealthEducationType modifyName(String modifyName) {
        this.modifyName = modifyName;
        return this;
    }

    public void setModifyName(String modifyName) {
        this.modifyName = modifyName;
    }

    public String getModifyDeptId() {
        return modifyDeptId;
    }

    public DepartmentDivisionHealthEducationType modifyDeptId(String modifyDeptId) {
        this.modifyDeptId = modifyDeptId;
        return this;
    }

    public void setModifyDeptId(String modifyDeptId) {
        this.modifyDeptId = modifyDeptId;
    }

    public String getModifyDeptName() {
        return modifyDeptName;
    }

    public DepartmentDivisionHealthEducationType modifyDeptName(String modifyDeptName) {
        this.modifyDeptName = modifyDeptName;
        return this;
    }

    public void setModifyDeptName(String modifyDeptName) {
        this.modifyDeptName = modifyDeptName;
    }

    public ZonedDateTime getStartTime() {
        return startTime;
    }

    public DepartmentDivisionHealthEducationType startTime(ZonedDateTime startTime) {
        this.startTime = startTime;
        return this;
    }

    public void setStartTime(ZonedDateTime startTime) {
        this.startTime = startTime;
    }

    public ZonedDateTime getEndTime() {
        return endTime;
    }

    public DepartmentDivisionHealthEducationType endTime(ZonedDateTime endTime) {
        this.endTime = endTime;
        return this;
    }

    public void setEndTime(ZonedDateTime endTime) {
        this.endTime = endTime;
    }

    public ZonedDateTime getCreateTime() {
        return createTime;
    }

    public DepartmentDivisionHealthEducationType createTime(ZonedDateTime createTime) {
        this.createTime = createTime;
        return this;
    }

    public void setCreateTime(ZonedDateTime createTime) {
        this.createTime = createTime;
    }

    public ZonedDateTime getModifyTime() {
        return modifyTime;
    }

    public DepartmentDivisionHealthEducationType modifyTime(ZonedDateTime modifyTime) {
        this.modifyTime = modifyTime;
        return this;
    }

    public void setModifyTime(ZonedDateTime modifyTime) {
        this.modifyTime = modifyTime;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DepartmentDivisionHealthEducationType)) {
            return false;
        }
        return typeId != null && typeId.equals(((DepartmentDivisionHealthEducationType) o).typeId);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "DepartmentDivisionHealthEducationType{" +
            "typeId=" + getTypeId() +
            ", divisionId='" + getDivisionId() + "'" +
            ", typeName='" + getTypeName() + "'" +
            ", orders=" + getOrders() +
            ", createBy='" + getCreateBy() + "'" +
            ", createName='" + getCreateName() + "'" +
            ", createDeptId='" + getCreateDeptId() + "'" +
            ", createDeptName='" + getCreateDeptName() + "'" +
            ", modifyBy='" + getModifyBy() + "'" +
            ", modifyName='" + getModifyName() + "'" +
            ", modifyDeptId='" + getModifyDeptId() + "'" +
            ", modifyDeptName='" + getModifyDeptName() + "'" +
            ", startTime='" + getStartTime() + "'" +
            ", endTime='" + getEndTime() + "'" +
            ", createTime='" + getCreateTime() + "'" +
            ", modifyTime='" + getModifyTime() + "'" +
            "}";
    }
}
