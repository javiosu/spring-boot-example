package org.skh.service;

import io.github.jhipster.service.QueryService;
import org.skh.domain.log.PaymentLog;
import org.skh.domain.log.PaymentLog_;
import org.skh.repository.log.PaymentLogRepository;
import org.skh.service.dto.PaymentLogCriteria;
import org.skh.service.dto.PaymentLogDTO;
import org.skh.service.mapper.PaymentLogMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Service for executing complex queries for {@link PaymentLog} entities in the database.
 * The main input is a {@link PaymentLogCriteria} which gets converted to {@link Specification},
 * in a way that all the filters must apply.
 * It returns a {@link List} of {@link PaymentLogDTO} or a {@link Page} of {@link PaymentLogDTO} which fulfills the criteria.
 */
@Service
@Transactional(readOnly = true)
public class PaymentLogQueryService extends QueryService<PaymentLog> {

    private final Logger log = LoggerFactory.getLogger(PaymentLogQueryService.class);

    private final PaymentLogRepository paymentLogRepository;

    private final PaymentLogMapper paymentLogMapper;

    public PaymentLogQueryService(PaymentLogRepository paymentLogRepository, PaymentLogMapper paymentLogMapper) {
        this.paymentLogRepository = paymentLogRepository;
        this.paymentLogMapper = paymentLogMapper;
    }

    /**
     * Return a {@link List} of {@link PaymentLogDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public List<PaymentLogDTO> findByCriteria(PaymentLogCriteria criteria) {
        log.debug("find by criteria : {}", criteria);
        final Specification<PaymentLog> specification = createSpecification(criteria);
        return paymentLogMapper.toDto(paymentLogRepository.findAll(specification));
    }

    /**
     * Return a {@link Page} of {@link PaymentLogDTO} which matches the criteria from the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @param page The page, which should be returned.
     * @return the matching entities.
     */
    @Transactional(readOnly = true)
    public Page<PaymentLogDTO> findByCriteria(PaymentLogCriteria criteria, Pageable page) {
        log.debug("find by criteria : {}, page: {}", criteria, page);
        final Specification<PaymentLog> specification = createSpecification(criteria);
        return paymentLogRepository.findAll(specification, page)
            .map(paymentLogMapper::toDto);
    }

    /**
     * Return the number of matching entities in the database.
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the number of matching entities.
     */
    @Transactional(readOnly = true)
    public long countByCriteria(PaymentLogCriteria criteria) {
        log.debug("count by criteria : {}", criteria);
        final Specification<PaymentLog> specification = createSpecification(criteria);
        return paymentLogRepository.count(specification);
    }

    /**
     * Function to convert {@link PaymentLogCriteria} to a {@link Specification}
     * @param criteria The object which holds all the filters, which the entities should match.
     * @return the matching {@link Specification} of the entity.
     */
    protected Specification<PaymentLog> createSpecification(PaymentLogCriteria criteria) {
        Specification<PaymentLog> specification = Specification.where(null);
        if (criteria != null) {
            if (criteria.getId() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getId(), PaymentLog_.id));
            }
            if (criteria.getUserName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getUserName(), PaymentLog_.userName));
            }
            if (criteria.getPaymentMethod() != null) {
                specification = specification.and(buildStringSpecification(criteria.getPaymentMethod(), PaymentLog_.paymentMethod));
            }
            if (criteria.getOrderId() != null) {
                specification = specification.and(buildStringSpecification(criteria.getOrderId(), PaymentLog_.orderId));
            }
            if (criteria.getAmount() != null) {
                specification = specification.and(buildStringSpecification(criteria.getAmount(), PaymentLog_.amount));
            }
            if (criteria.getApiName() != null) {
                specification = specification.and(buildStringSpecification(criteria.getApiName(), PaymentLog_.apiName));
            }
            if (criteria.getRequestTime() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getRequestTime(), PaymentLog_.requestTime));
            }
            if (criteria.getRequestBody() != null) {
                specification = specification.and(buildStringSpecification(criteria.getRequestBody(), PaymentLog_.requestBody));
            }
            if (criteria.getResponseTime() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getResponseTime(), PaymentLog_.responseTime));
            }
            if (criteria.getResponseBody() != null) {
                specification = specification.and(buildStringSpecification(criteria.getResponseBody(), PaymentLog_.responseBody));
            }
            if (criteria.getReturnCode() != null) {
                specification = specification.and(buildStringSpecification(criteria.getReturnCode(), PaymentLog_.returnCode));
            }
            if (criteria.getReturnMessage() != null) {
                specification = specification.and(buildStringSpecification(criteria.getReturnMessage(), PaymentLog_.returnMessage));
            }
            if (criteria.getTransactionId() != null) {
                specification = specification.and(buildStringSpecification(criteria.getTransactionId(), PaymentLog_.transactionId));
            }
            if (criteria.getDebitBankCode() != null) {
                specification = specification.and(buildStringSpecification(criteria.getDebitBankCode(), PaymentLog_.debitBankCode));
            }
            if (criteria.getDebitBankAccount() != null) {
                specification = specification.and(buildStringSpecification(criteria.getDebitBankAccount(), PaymentLog_.debitBankAccount));
            }
            if (criteria.getCreatedTime() != null) {
                specification = specification.and(buildRangeSpecification(criteria.getCreatedTime(), PaymentLog_.createdTime));
            }
        }
        return specification;
    }
}
