package org.skh.repository.log;

import org.skh.domain.log.RegistrationLog;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the RegistrationLog entity.
 */
@SuppressWarnings("unused")
@Repository
public interface RegistrationLogRepository extends JpaRepository<RegistrationLog, Long> {

}
