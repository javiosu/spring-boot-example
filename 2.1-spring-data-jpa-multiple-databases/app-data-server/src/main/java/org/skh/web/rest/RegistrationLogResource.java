package org.skh.web.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.skh.domain.log.RegistrationLog;
import org.skh.service.RegistrationLogService;
import org.skh.service.dto.RegistrationLogDTO;
import org.skh.web.rest.errors.BadRequestAlertException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for managing {@link RegistrationLog}.
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/log")
public class RegistrationLogResource {

    private static final String ENTITY_NAME = "logRegistrationLog";

    private final RegistrationLogService registrationLogService;

    @PostMapping("/registration-logs")
    public RegistrationLogDTO createRegistrationLog(@RequestBody RegistrationLogDTO registrationLogDTO) {
        if (registrationLogDTO.getId() != null) {
            throw new BadRequestAlertException("A new registrationLog cannot already have an ID", ENTITY_NAME, "idexists");
        }
        return registrationLogService.save(registrationLogDTO);
    }
}
