package org.skh.service.mapper;

import org.skh.domain.log.PaymentLog;
import org.skh.service.dto.PaymentLogDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link PaymentLog} and its DTO {@link PaymentLogDTO}.
 */
@Mapper(componentModel = "spring", uses = {})
public interface PaymentLogMapper extends EntityMapper<PaymentLogDTO, PaymentLog> {



    default PaymentLog fromId(Long id) {
        if (id == null) {
            return null;
        }
        PaymentLog paymentLog = new PaymentLog();
        paymentLog.setId(id);
        return paymentLog;
    }
}
