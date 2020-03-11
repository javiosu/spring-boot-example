package org.skh.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.skh.domain.log.RegistrationLog;
import org.skh.repository.log.RegistrationLogRepository;
import org.skh.service.dto.RegistrationLogDTO;
import org.skh.service.mapper.RegistrationLogMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link RegistrationLog}.
 */
@Slf4j
@AllArgsConstructor
@Service
@Transactional
public class RegistrationLogService {

    private final RegistrationLogRepository registrationLogRepository;

    private final RegistrationLogMapper registrationLogMapper;

    /**
     * Save a registrationLog.
     *
     * @param registrationLogDTO the entity to save.
     * @return the persisted entity.
     */
    public RegistrationLogDTO save(RegistrationLogDTO registrationLogDTO) {
        log.debug("Request to save RegistrationLog : {}", registrationLogDTO);
        RegistrationLog registrationLog = registrationLogMapper.toEntity(registrationLogDTO);
        registrationLog = registrationLogRepository.save(registrationLog);
        return registrationLogMapper.toDto(registrationLog);
    }

}
