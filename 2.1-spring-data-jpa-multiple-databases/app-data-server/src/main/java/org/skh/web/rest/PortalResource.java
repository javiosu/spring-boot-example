package org.skh.web.rest;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.skh.domain.portal.DepartmentDivisionHealthEducationType;
import org.skh.service.DepartmentDivisionHealthEducationService;
import org.skh.service.DepartmentDivisionHealthEducationTypeService;
import org.skh.web.rest.vm.data.HealthEducation;
import org.skh.web.rest.vm.data.HealthEducationType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing {@link DepartmentDivisionHealthEducationType}.
 */
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/portal")
public class PortalResource {

    private final DepartmentDivisionHealthEducationTypeService departmentDivisionHealthEducationTypeService;
    private final DepartmentDivisionHealthEducationService departmentDivisionHealthEducationService;

    @GetMapping("/healthEducationTypes")
    public List<HealthEducationType> getAllHealthEducationTypes() {
        return departmentDivisionHealthEducationTypeService.findHealthEducationTypes();
    }

    @GetMapping("/healthEducationByType")
    public List<HealthEducation> getHealthEducationByType(@RequestParam("typeId") Integer typeId) {
        List<HealthEducation> departmentDivisionHealthEducationDTO = departmentDivisionHealthEducationService.findByTypeId(typeId);
        return departmentDivisionHealthEducationDTO;
    }

    @GetMapping("/portal/advice/{divisionId}")
    public String getCompletedRemark(@PathVariable("divisionId") String divisionId) {

        return "";
    }
}
