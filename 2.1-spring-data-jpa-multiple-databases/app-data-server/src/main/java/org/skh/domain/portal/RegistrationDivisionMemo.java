package org.skh.domain.portal;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * A RegistrationDivisionMemo.
 */
@Data
@Entity
@Table(name = "v_regis_division_memo")
public class RegistrationDivisionMemo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "division_id")
    private String divisionId;

    @Column(name = "division_name")
    private String divisionName;

    @Column(name = "remark")
    private String remark;

    @Column(name = "completed_remark")
    private String completedRemark;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
}
