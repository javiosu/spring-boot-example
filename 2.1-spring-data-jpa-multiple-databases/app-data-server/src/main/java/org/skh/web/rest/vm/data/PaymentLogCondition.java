package org.skh.web.rest.vm.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.skh.service.dto.PaymentLogCriteria;
import org.springframework.data.domain.Pageable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentLogCondition {
    private PaymentLogCriteria criteria;
    private Pageable pageable;
}
