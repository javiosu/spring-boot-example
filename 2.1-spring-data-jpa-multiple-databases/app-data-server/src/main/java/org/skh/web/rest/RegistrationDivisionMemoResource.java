package org.skh.web.rest;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.skh.domain.portal.RegistrationDivisionMemo;
import org.skh.repository.portal.RegistrationDivisionMemoRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for managing {@link RegistrationDivisionMemo}.
 */
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/portal")
@Transactional
public class RegistrationDivisionMemoResource {
    private final RegistrationDivisionMemoRepository registrationDivisionMemoRepository;
    @GetMapping("/registration-division-memos/{divisionId}")
    public String getRegistrationDivisionMemo(@PathVariable String divisionId) {
        return registrationDivisionMemoRepository.findOneByDivisionId(divisionId)
            .map(it -> it.getCompletedRemark())
            .orElse("");
    }
}
