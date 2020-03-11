package org.skh.domain.log;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.Instant;

/**
 * A PaymentLog.
 */
@Entity
@Table(name = "payment_log")
public class PaymentLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "user_name", nullable = false)
    private String userName;

    @NotNull
    @Column(name = "payment_method", nullable = false)
    private String paymentMethod;

    @NotNull
    @Column(name = "order_id", nullable = false)
    private String orderId;

    @NotNull
    @Column(name = "amount", nullable = false)
    private String amount;

    @NotNull
    @Column(name = "api_name", nullable = false)
    private String apiName;

    @Column(name = "request_time")
    private Instant requestTime;

    @Column(name = "request_body")
    private String requestBody;

    @Column(name = "response_time")
    private Instant responseTime;

    @Column(name = "response_body")
    private String responseBody;

    @Column(name = "return_code")
    private String returnCode;

    @Column(name = "return_message")
    private String returnMessage;

    @Column(name = "transaction_id")
    private String transactionId;

    @Column(name = "debit_bank_code")
    private String debitBankCode;

    @Column(name = "debit_bank_account")
    private String debitBankAccount;

    @Column(name = "created_time")
    private Instant createdTime;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public PaymentLog userName(String userName) {
        this.userName = userName;
        return this;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public PaymentLog paymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
        return this;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getOrderId() {
        return orderId;
    }

    public PaymentLog orderId(String orderId) {
        this.orderId = orderId;
        return this;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getAmount() {
        return amount;
    }

    public PaymentLog amount(String amount) {
        this.amount = amount;
        return this;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getApiName() {
        return apiName;
    }

    public PaymentLog apiName(String apiName) {
        this.apiName = apiName;
        return this;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public Instant getRequestTime() {
        return requestTime;
    }

    public PaymentLog requestTime(Instant requestTime) {
        this.requestTime = requestTime;
        return this;
    }

    public void setRequestTime(Instant requestTime) {
        this.requestTime = requestTime;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public PaymentLog requestBody(String requestBody) {
        this.requestBody = requestBody;
        return this;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }

    public Instant getResponseTime() {
        return responseTime;
    }

    public PaymentLog responseTime(Instant responseTime) {
        this.responseTime = responseTime;
        return this;
    }

    public void setResponseTime(Instant responseTime) {
        this.responseTime = responseTime;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public PaymentLog responseBody(String responseBody) {
        this.responseBody = responseBody;
        return this;
    }

    public void setResponseBody(String responseBody) {
        this.responseBody = responseBody;
    }

    public String getReturnCode() {
        return returnCode;
    }

    public PaymentLog returnCode(String returnCode) {
        this.returnCode = returnCode;
        return this;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public String getReturnMessage() {
        return returnMessage;
    }

    public PaymentLog returnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
        return this;
    }

    public void setReturnMessage(String returnMessage) {
        this.returnMessage = returnMessage;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public PaymentLog transactionId(String transactionId) {
        this.transactionId = transactionId;
        return this;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getDebitBankCode() {
        return debitBankCode;
    }

    public PaymentLog debitBankCode(String debitBankCode) {
        this.debitBankCode = debitBankCode;
        return this;
    }

    public void setDebitBankCode(String debitBankCode) {
        this.debitBankCode = debitBankCode;
    }

    public String getDebitBankAccount() {
        return debitBankAccount;
    }

    public PaymentLog debitBankAccount(String debitBankAccount) {
        this.debitBankAccount = debitBankAccount;
        return this;
    }

    public void setDebitBankAccount(String debitBankAccount) {
        this.debitBankAccount = debitBankAccount;
    }

    public Instant getCreatedTime() {
        return createdTime;
    }

    public PaymentLog createdTime(Instant createdTime) {
        this.createdTime = createdTime;
        return this;
    }

    public void setCreatedTime(Instant createdTime) {
        this.createdTime = createdTime;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PaymentLog)) {
            return false;
        }
        return id != null && id.equals(((PaymentLog) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "PaymentLog{" +
            "id=" + getId() +
            ", userName='" + getUserName() + "'" +
            ", paymentMethod='" + getPaymentMethod() + "'" +
            ", orderId='" + getOrderId() + "'" +
            ", amount='" + getAmount() + "'" +
            ", apiName='" + getApiName() + "'" +
            ", requestTime='" + getRequestTime() + "'" +
            ", requestBody='" + getRequestBody() + "'" +
            ", responseTime='" + getResponseTime() + "'" +
            ", responseBody='" + getResponseBody() + "'" +
            ", returnCode='" + getReturnCode() + "'" +
            ", returnMessage='" + getReturnMessage() + "'" +
            ", transactionId='" + getTransactionId() + "'" +
            ", debitBankCode='" + getDebitBankCode() + "'" +
            ", debitBankAccount='" + getDebitBankAccount() + "'" +
            ", createdTime='" + getCreatedTime() + "'" +
            "}";
    }
}
