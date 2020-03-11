package org.skh.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.skh.domain.portal.DepartmentDivisionHealthEducationType;
import org.skh.repository.portal.DepartmentDivisionHealthEducationTypeRepository;
import org.skh.web.rest.vm.data.HealthEducationType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link DepartmentDivisionHealthEducationType}.
 */
@Slf4j
@AllArgsConstructor
@Service
@Transactional
public class DepartmentDivisionHealthEducationTypeService {

    public static final String DIVISION_ID = "8000";
    private final DepartmentDivisionHealthEducationTypeRepository departmentDivisionHealthEducationTypeRepository;

    /**
     * Get all the departmentDivisionHealthEducationTypes.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<HealthEducationType> findHealthEducationTypes() {
        log.debug("Request to get all DepartmentDivisionHealthEducationTypes");
        return departmentDivisionHealthEducationTypeRepository.findByDivisionId(DIVISION_ID).stream()
            .map(type -> new HealthEducationType(type.getTypeId(), type.getTypeName()))
            .collect(Collectors.toCollection(LinkedList::new));
    }
}
