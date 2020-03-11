package org.skh.service;

import org.skh.domain.log.PaymentLog;
import org.skh.repository.log.PaymentLogRepository;
import org.skh.service.dto.PaymentLogDTO;
import org.skh.service.mapper.PaymentLogMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing {@link PaymentLog}.
 */
@Service
@Transactional
public class PaymentLogService {

    private final Logger log = LoggerFactory.getLogger(PaymentLogService.class);

    private final PaymentLogRepository paymentLogRepository;

    private final PaymentLogMapper paymentLogMapper;

    public PaymentLogService(PaymentLogRepository paymentLogRepository, PaymentLogMapper paymentLogMapper) {
        this.paymentLogRepository = paymentLogRepository;
        this.paymentLogMapper = paymentLogMapper;
    }

    /**
     * Save a paymentLog.
     *
     * @param paymentLogDTO the entity to save.
     * @return the persisted entity.
     */
    public PaymentLogDTO save(PaymentLogDTO paymentLogDTO) {
        log.debug("Request to save PaymentLog : {}", paymentLogDTO);
        PaymentLog paymentLog = paymentLogMapper.toEntity(paymentLogDTO);
        paymentLog = paymentLogRepository.save(paymentLog);
        return paymentLogMapper.toDto(paymentLog);
    }

    /**
     * Get all the paymentLogs.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<PaymentLogDTO> findAll(Pageable pageable) {
        log.debug("Request to get all PaymentLogs");
        return paymentLogRepository.findAll(pageable)
            .map(paymentLogMapper::toDto);
    }


    /**
     * Get one paymentLog by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<PaymentLogDTO> findOne(Long id) {
        log.debug("Request to get PaymentLog : {}", id);
        return paymentLogRepository.findById(id)
            .map(paymentLogMapper::toDto);
    }

    /**
     * Delete the paymentLog by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete PaymentLog : {}", id);
        paymentLogRepository.deleteById(id);
    }
}
