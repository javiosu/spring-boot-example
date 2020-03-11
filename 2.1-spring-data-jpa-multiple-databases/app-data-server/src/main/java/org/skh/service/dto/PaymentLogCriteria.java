package org.skh.service.dto;

import java.io.Serializable;
import java.util.Objects;
import io.github.jhipster.service.Criteria;
import io.github.jhipster.service.filter.Filter;
import io.github.jhipster.service.filter.LongFilter;
import io.github.jhipster.service.filter.StringFilter;
import io.github.jhipster.service.filter.InstantFilter;
import org.skh.domain.log.PaymentLog;

/**
 * Criteria class for the {@link PaymentLog} entity. This class is used
 * in {@link org.skh.web.rest.PaymentLogResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /payment-logs?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class PaymentLogCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter userName;

    private StringFilter paymentMethod;

    private StringFilter orderId;

    private StringFilter amount;

    private StringFilter apiName;

    private InstantFilter requestTime;

    private StringFilter requestBody;

    private InstantFilter responseTime;

    private StringFilter responseBody;

    private StringFilter returnCode;

    private StringFilter returnMessage;

    private StringFilter transactionId;

    private StringFilter debitBankCode;

    private StringFilter debitBankAccount;

    private InstantFilter createdTime;

    public PaymentLogCriteria(){
    }

    public PaymentLogCriteria(PaymentLogCriteria other){
        this.id = other.id == null ? null : other.id.copy();
        this.userName = other.userName == null ? null : other.userName.copy();
        this.paymentMethod = other.paymentMethod == null ? null : other.paymentMethod.copy();
        this.orderId = other.orderId == null ? null : other.orderId.copy();
        this.amount = other.amount == null ? null : other.amount.copy();
        this.apiName = other.apiName == null ? null : other.apiName.copy();
        this.requestTime = other.requestTime == null ? null : other.requestTime.copy();
        this.requestBody = other.requestBody == null ? null : other.requestBody.copy();
        this.responseTime = other.responseTime == null ? null : other.responseTime.copy();
        this.responseBody = other.responseBody == null ? null : other.responseBody.copy();
        this.returnCode = other.returnCode == null ? null : other.returnCode.copy();
        this.returnMessage = other.returnMessage == null ? null : other.returnMessage.copy();
        this.transactionId = other.transactionId == null ? null : other.transactionId.copy();
        this.debitBankCode = other.debitBankCode == null ? null : other.debitBankCode.copy();
        this.debitBankAccount = other.debitBankAccount == null ? null : other.debitBankAccount.copy();
        this.createdTime = other.createdTime == null ? null : other.createdTime.copy();
    }

    @Override
    public PaymentLogCriteria copy() {
        return new PaymentLogCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getUserName() {
        return userName;
    }

    public void setUserName(StringFilter userName) {
        this.userName = userName;
    }

    public StringFilter getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(StringFilter paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public StringFilter getOrderId() {
        return orderId;
    }

    public void setOrderId(StringFilter orderId) {
        this.orderId = orderId;
    }

    public StringFilter getAmount() {
        return amount;
    }

    public void setAmount(StringFilter amount) {
        this.amount = amount;
    }

    public StringFilter getApiName() {
        return apiName;
    }

    public void setApiName(StringFilter apiName) {
        this.apiName = apiName;
    }

    public InstantFilter getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(InstantFilter requestTime) {
        this.requestTime = requestTime;
    }

    public StringFilter getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(StringFilter requestBody) {
        this.requestBody = requestBody;
    }

    public InstantFilter getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(InstantFilter responseTime) {
        this.responseTime = responseTime;
    }

    public StringFilter getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(StringFilter responseBody) {
        this.responseBody = responseBody;
    }

    public StringFilter getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(StringFilter returnCode) {
        this.returnCode = returnCode;
    }

    public StringFilter getReturnMessage() {
        return returnMessage;
    }

    public void setReturnMessage(StringFilter returnMessage) {
        this.returnMessage = returnMessage;
    }

    public StringFilter getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(StringFilter transactionId) {
        this.transactionId = transactionId;
    }

    public StringFilter getDebitBankCode() {
        return debitBankCode;
    }

    public void setDebitBankCode(StringFilter debitBankCode) {
        this.debitBankCode = debitBankCode;
    }

    public StringFilter getDebitBankAccount() {
        return debitBankAccount;
    }

    public void setDebitBankAccount(StringFilter debitBankAccount) {
        this.debitBankAccount = debitBankAccount;
    }

    public InstantFilter getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(InstantFilter createdTime) {
        this.createdTime = createdTime;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final PaymentLogCriteria that = (PaymentLogCriteria) o;
        return
            Objects.equals(id, that.id) &&
            Objects.equals(userName, that.userName) &&
            Objects.equals(paymentMethod, that.paymentMethod) &&
            Objects.equals(orderId, that.orderId) &&
            Objects.equals(amount, that.amount) &&
            Objects.equals(apiName, that.apiName) &&
            Objects.equals(requestTime, that.requestTime) &&
            Objects.equals(requestBody, that.requestBody) &&
            Objects.equals(responseTime, that.responseTime) &&
            Objects.equals(responseBody, that.responseBody) &&
            Objects.equals(returnCode, that.returnCode) &&
            Objects.equals(returnMessage, that.returnMessage) &&
            Objects.equals(transactionId, that.transactionId) &&
            Objects.equals(debitBankCode, that.debitBankCode) &&
            Objects.equals(debitBankAccount, that.debitBankAccount) &&
            Objects.equals(createdTime, that.createdTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
        id,
        userName,
        paymentMethod,
        orderId,
        amount,
        apiName,
        requestTime,
        requestBody,
        responseTime,
        responseBody,
        returnCode,
        returnMessage,
        transactionId,
        debitBankCode,
        debitBankAccount,
        createdTime
        );
    }

    @Override
    public String toString() {
        return "PaymentLogCriteria{" +
                (id != null ? "id=" + id + ", " : "") +
                (userName != null ? "userName=" + userName + ", " : "") +
                (paymentMethod != null ? "paymentMethod=" + paymentMethod + ", " : "") +
                (orderId != null ? "orderId=" + orderId + ", " : "") +
                (amount != null ? "amount=" + amount + ", " : "") +
                (apiName != null ? "apiName=" + apiName + ", " : "") +
                (requestTime != null ? "requestTime=" + requestTime + ", " : "") +
                (requestBody != null ? "requestBody=" + requestBody + ", " : "") +
                (responseTime != null ? "responseTime=" + responseTime + ", " : "") +
                (responseBody != null ? "responseBody=" + responseBody + ", " : "") +
                (returnCode != null ? "returnCode=" + returnCode + ", " : "") +
                (returnMessage != null ? "returnMessage=" + returnMessage + ", " : "") +
                (transactionId != null ? "transactionId=" + transactionId + ", " : "") +
                (debitBankCode != null ? "debitBankCode=" + debitBankCode + ", " : "") +
                (debitBankAccount != null ? "debitBankAccount=" + debitBankAccount + ", " : "") +
                (createdTime != null ? "createdTime=" + createdTime + ", " : "") +
            "}";
    }

}
