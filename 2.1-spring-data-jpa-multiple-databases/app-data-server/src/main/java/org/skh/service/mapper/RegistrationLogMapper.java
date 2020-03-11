package org.skh.service.mapper;

import org.skh.domain.log.RegistrationLog;
import org.skh.service.dto.RegistrationLogDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link RegistrationLog} and its DTO {@link RegistrationLogDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface RegistrationLogMapper extends EntityMapper<RegistrationLogDTO, RegistrationLog> {



    default RegistrationLog fromId(Long id) {
        if (id == null) {
            return null;
        }
        RegistrationLog registrationLog = new RegistrationLog();
        registrationLog.setId(id);
        return registrationLog;
    }
}
