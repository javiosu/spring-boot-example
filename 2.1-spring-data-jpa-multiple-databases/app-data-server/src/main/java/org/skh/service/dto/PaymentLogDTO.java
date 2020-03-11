package org.skh.service.dto;

import lombok.Data;
import org.skh.domain.log.PaymentLog;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.Instant;

/**
 * A DTO for the {@link PaymentLog} entity.
 */
@Data
public class PaymentLogDTO implements Serializable {

    private Long id;

    @NotNull
    private String userName;

    @NotNull
    private String paymentMethod;

    @NotNull
    private String orderId;

    @NotNull
    private String amount;

    @NotNull
    private String apiName;

    private Instant requestTime;

    private String requestBody;

    private Instant responseTime;

    private String responseBody;

    private String returnCode;

    private String returnMessage;

    private String transactionId;

    private String debitBankCode;

    private String debitBankAccount;

    private Instant createdTime;
}
