package org.skh.repository.log;

import org.skh.domain.log.PaymentLog;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the PaymentLog entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PaymentLogRepository extends JpaRepository<PaymentLog, Long>, JpaSpecificationExecutor<PaymentLog> {

}
