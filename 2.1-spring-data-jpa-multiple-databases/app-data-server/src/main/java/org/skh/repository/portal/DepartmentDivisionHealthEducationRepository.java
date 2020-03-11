package org.skh.repository.portal;

import org.skh.domain.portal.DepartmentDivisionHealthEducation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Spring Data  repository for the DepartmentDivisionHealthEducation entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DepartmentDivisionHealthEducationRepository extends JpaRepository<DepartmentDivisionHealthEducation, Long> {

    List<DepartmentDivisionHealthEducation> findByTypeId(Integer typeId);
}
