package org.skh.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.skh.domain.portal.DepartmentDivisionHealthEducation;
import org.skh.repository.portal.DepartmentDivisionHealthEducationRepository;
import org.skh.web.rest.vm.data.HealthEducation;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing {@link DepartmentDivisionHealthEducation}.
 */
@Slf4j
@AllArgsConstructor
@Service
@Transactional
public class DepartmentDivisionHealthEducationService {

    private final DepartmentDivisionHealthEducationRepository departmentDivisionHealthEducationRepository;

    public List<HealthEducation> findByTypeId(Integer divisionId) {
        return departmentDivisionHealthEducationRepository.findByTypeId(divisionId).stream()
            .map(education -> new HealthEducation(education.getTitle() , education.getHealthPicture()))
            .collect(Collectors.toCollection(LinkedList::new));
    }
}
