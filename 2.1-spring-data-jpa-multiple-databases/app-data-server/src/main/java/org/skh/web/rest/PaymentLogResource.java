package org.skh.web.rest;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.skh.service.PaymentLogQueryService;
import org.skh.service.PaymentLogService;
import org.skh.service.dto.PaymentLogCriteria;
import org.skh.service.dto.PaymentLogDTO;
import org.skh.web.rest.errors.BadRequestAlertException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;


@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/log")
public class PaymentLogResource {
    private static final String ENTITY_NAME = "logPaymentLog";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final PaymentLogService paymentLogService;

    private final PaymentLogQueryService paymentLogQueryService;


    @PostMapping("/payment-logs")
    public ResponseEntity<PaymentLogDTO> createPaymentLog(@Valid @RequestBody PaymentLogDTO paymentLogDTO) throws URISyntaxException {
        log.debug("REST request to save PaymentLog : {}", paymentLogDTO);
        if (paymentLogDTO.getId() != null) {
            throw new BadRequestAlertException("A new paymentLog cannot already have an ID", ENTITY_NAME, "idexists");
        }
        PaymentLogDTO result = paymentLogService.save(paymentLogDTO);
        return ResponseEntity.created(new URI("/api/payment-logs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    @GetMapping("/payment-logs")
    public ResponseEntity<List<PaymentLogDTO>> getAllPaymentLogs(PaymentLogCriteria criteria, Pageable pageable) {
        Page<PaymentLogDTO> page = paymentLogQueryService.findByCriteria(criteria, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    @PostMapping("/payment-logs/count")
    public ResponseEntity<Long> countPaymentLogs(@RequestBody PaymentLogCriteria criteria) {
        log.debug("REST request to count PaymentLogs by criteria: {}", criteria);
        return ResponseEntity.ok().body(paymentLogQueryService.countByCriteria(criteria));
    }

    @GetMapping("/payment-logs/{id}")
    public ResponseEntity<PaymentLogDTO> getPaymentLog(@PathVariable Long id) {
        log.debug("REST request to get PaymentLog : {}", id);
        Optional<PaymentLogDTO> paymentLogDTO = paymentLogService.findOne(id);
        return ResponseUtil.wrapOrNotFound(paymentLogDTO);
    }

}
