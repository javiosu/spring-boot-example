package org.skh.repository.portal;

import org.skh.domain.portal.DepartmentDivisionHealthEducationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Spring Data  repository for the DepartmentDivisionHealthEducationType entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DepartmentDivisionHealthEducationTypeRepository extends JpaRepository<DepartmentDivisionHealthEducationType, Long> {

    List<DepartmentDivisionHealthEducationType> findByDivisionId(String divisionId);
}
