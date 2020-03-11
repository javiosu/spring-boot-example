package org.skh.web.rest;

import org.skh.AppDataApp;
import org.skh.domain.log.PaymentLog;
import org.skh.repository.log.PaymentLogRepository;
import org.skh.service.PaymentLogService;
import org.skh.service.dto.PaymentLogDTO;
import org.skh.service.mapper.PaymentLogMapper;
import org.skh.web.rest.errors.ExceptionTranslator;
import org.skh.service.PaymentLogQueryService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Validator;

import javax.persistence.EntityManager;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static org.skh.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link PaymentLogResource} REST controller.
 */
@SpringBootTest(classes = AppDataApp.class)
public class PaymentLogResourceIT {

    private static final String DEFAULT_USER_NAME = "AAAAAAAAAA";
    private static final String UPDATED_USER_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_PAYMENT_METHOD = "AAAAAAAAAA";
    private static final String UPDATED_PAYMENT_METHOD = "BBBBBBBBBB";

    private static final String DEFAULT_ORDER_ID = "AAAAAAAAAA";
    private static final String UPDATED_ORDER_ID = "BBBBBBBBBB";

    private static final String DEFAULT_AMOUNT = "AAAAAAAAAA";
    private static final String UPDATED_AMOUNT = "BBBBBBBBBB";

    private static final String DEFAULT_API_NAME = "AAAAAAAAAA";
    private static final String UPDATED_API_NAME = "BBBBBBBBBB";

    private static final Instant DEFAULT_REQUEST_TIME = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_REQUEST_TIME = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String DEFAULT_REQUEST_BODY = "AAAAAAAAAA";
    private static final String UPDATED_REQUEST_BODY = "BBBBBBBBBB";

    private static final Instant DEFAULT_RESPONSE_TIME = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_RESPONSE_TIME = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String DEFAULT_RESPONSE_BODY = "AAAAAAAAAA";
    private static final String UPDATED_RESPONSE_BODY = "BBBBBBBBBB";

    private static final String DEFAULT_RETURN_CODE = "AAAAAAAAAA";
    private static final String UPDATED_RETURN_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_RETURN_MESSAGE = "AAAAAAAAAA";
    private static final String UPDATED_RETURN_MESSAGE = "BBBBBBBBBB";

    private static final String DEFAULT_TRANSACTION_ID = "AAAAAAAAAA";
    private static final String UPDATED_TRANSACTION_ID = "BBBBBBBBBB";

    private static final String DEFAULT_DEBIT_BANK_CODE = "AAAAAAAAAA";
    private static final String UPDATED_DEBIT_BANK_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_DEBIT_BANK_ACCOUNT = "AAAAAAAAAA";
    private static final String UPDATED_DEBIT_BANK_ACCOUNT = "BBBBBBBBBB";

    private static final Instant DEFAULT_CREATED_TIME = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_CREATED_TIME = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    @Autowired
    private PaymentLogRepository paymentLogRepository;

    @Autowired
    private PaymentLogMapper paymentLogMapper;

    @Autowired
    private PaymentLogService paymentLogService;

    @Autowired
    private PaymentLogQueryService paymentLogQueryService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    @Autowired
    private Validator validator;

    private MockMvc restPaymentLogMockMvc;

    private PaymentLog paymentLog;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final PaymentLogResource paymentLogResource = new PaymentLogResource(paymentLogService, paymentLogQueryService);
        this.restPaymentLogMockMvc = MockMvcBuilders.standaloneSetup(paymentLogResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter)
            .setValidator(validator).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static PaymentLog createEntity(EntityManager em) {
        PaymentLog paymentLog = new PaymentLog()
            .userName(DEFAULT_USER_NAME)
            .paymentMethod(DEFAULT_PAYMENT_METHOD)
            .orderId(DEFAULT_ORDER_ID)
            .amount(DEFAULT_AMOUNT)
            .apiName(DEFAULT_API_NAME)
            .requestTime(DEFAULT_REQUEST_TIME)
            .requestBody(DEFAULT_REQUEST_BODY)
            .responseTime(DEFAULT_RESPONSE_TIME)
            .responseBody(DEFAULT_RESPONSE_BODY)
            .returnCode(DEFAULT_RETURN_CODE)
            .returnMessage(DEFAULT_RETURN_MESSAGE)
            .transactionId(DEFAULT_TRANSACTION_ID)
            .debitBankCode(DEFAULT_DEBIT_BANK_CODE)
            .debitBankAccount(DEFAULT_DEBIT_BANK_ACCOUNT)
            .createdTime(DEFAULT_CREATED_TIME);
        return paymentLog;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static PaymentLog createUpdatedEntity(EntityManager em) {
        PaymentLog paymentLog = new PaymentLog()
            .userName(UPDATED_USER_NAME)
            .paymentMethod(UPDATED_PAYMENT_METHOD)
            .orderId(UPDATED_ORDER_ID)
            .amount(UPDATED_AMOUNT)
            .apiName(UPDATED_API_NAME)
            .requestTime(UPDATED_REQUEST_TIME)
            .requestBody(UPDATED_REQUEST_BODY)
            .responseTime(UPDATED_RESPONSE_TIME)
            .responseBody(UPDATED_RESPONSE_BODY)
            .returnCode(UPDATED_RETURN_CODE)
            .returnMessage(UPDATED_RETURN_MESSAGE)
            .transactionId(UPDATED_TRANSACTION_ID)
            .debitBankCode(UPDATED_DEBIT_BANK_CODE)
            .debitBankAccount(UPDATED_DEBIT_BANK_ACCOUNT)
            .createdTime(UPDATED_CREATED_TIME);
        return paymentLog;
    }

    @BeforeEach
    public void initTest() {
        paymentLog = createEntity(em);
    }

    @Test
    @Transactional
    public void createPaymentLog() throws Exception {
        int databaseSizeBeforeCreate = paymentLogRepository.findAll().size();

        // Create the PaymentLog
        PaymentLogDTO paymentLogDTO = paymentLogMapper.toDto(paymentLog);
        restPaymentLogMockMvc.perform(post("/api/payment-logs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(paymentLogDTO)))
            .andExpect(status().isCreated());

        // Validate the PaymentLog in the database
        List<PaymentLog> paymentLogList = paymentLogRepository.findAll();
        assertThat(paymentLogList).hasSize(databaseSizeBeforeCreate + 1);
        PaymentLog testPaymentLog = paymentLogList.get(paymentLogList.size() - 1);
        assertThat(testPaymentLog.getUserName()).isEqualTo(DEFAULT_USER_NAME);
        assertThat(testPaymentLog.getPaymentMethod()).isEqualTo(DEFAULT_PAYMENT_METHOD);
        assertThat(testPaymentLog.getOrderId()).isEqualTo(DEFAULT_ORDER_ID);
        assertThat(testPaymentLog.getAmount()).isEqualTo(DEFAULT_AMOUNT);
        assertThat(testPaymentLog.getApiName()).isEqualTo(DEFAULT_API_NAME);
        assertThat(testPaymentLog.getRequestTime()).isEqualTo(DEFAULT_REQUEST_TIME);
        assertThat(testPaymentLog.getRequestBody()).isEqualTo(DEFAULT_REQUEST_BODY);
        assertThat(testPaymentLog.getResponseTime()).isEqualTo(DEFAULT_RESPONSE_TIME);
        assertThat(testPaymentLog.getResponseBody()).isEqualTo(DEFAULT_RESPONSE_BODY);
        assertThat(testPaymentLog.getReturnCode()).isEqualTo(DEFAULT_RETURN_CODE);
        assertThat(testPaymentLog.getReturnMessage()).isEqualTo(DEFAULT_RETURN_MESSAGE);
        assertThat(testPaymentLog.getTransactionId()).isEqualTo(DEFAULT_TRANSACTION_ID);
        assertThat(testPaymentLog.getDebitBankCode()).isEqualTo(DEFAULT_DEBIT_BANK_CODE);
        assertThat(testPaymentLog.getDebitBankAccount()).isEqualTo(DEFAULT_DEBIT_BANK_ACCOUNT);
        assertThat(testPaymentLog.getCreatedTime()).isEqualTo(DEFAULT_CREATED_TIME);
    }

    @Test
    @Transactional
    public void createPaymentLogWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = paymentLogRepository.findAll().size();

        // Create the PaymentLog with an existing ID
        paymentLog.setId(1L);
        PaymentLogDTO paymentLogDTO = paymentLogMapper.toDto(paymentLog);

        // An entity with an existing ID cannot be created, so this API call must fail
        restPaymentLogMockMvc.perform(post("/api/payment-logs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(paymentLogDTO)))
            .andExpect(status().isBadRequest());

        // Validate the PaymentLog in the database
        List<PaymentLog> paymentLogList = paymentLogRepository.findAll();
        assertThat(paymentLogList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void checkUserNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = paymentLogRepository.findAll().size();
        // set the field null
        paymentLog.setUserName(null);

        // Create the PaymentLog, which fails.
        PaymentLogDTO paymentLogDTO = paymentLogMapper.toDto(paymentLog);

        restPaymentLogMockMvc.perform(post("/api/payment-logs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(paymentLogDTO)))
            .andExpect(status().isBadRequest());

        List<PaymentLog> paymentLogList = paymentLogRepository.findAll();
        assertThat(paymentLogList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkPaymentMethodIsRequired() throws Exception {
        int databaseSizeBeforeTest = paymentLogRepository.findAll().size();
        // set the field null
        paymentLog.setPaymentMethod(null);

        // Create the PaymentLog, which fails.
        PaymentLogDTO paymentLogDTO = paymentLogMapper.toDto(paymentLog);

        restPaymentLogMockMvc.perform(post("/api/payment-logs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(paymentLogDTO)))
            .andExpect(status().isBadRequest());

        List<PaymentLog> paymentLogList = paymentLogRepository.findAll();
        assertThat(paymentLogList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkOrderIdIsRequired() throws Exception {
        int databaseSizeBeforeTest = paymentLogRepository.findAll().size();
        // set the field null
        paymentLog.setOrderId(null);

        // Create the PaymentLog, which fails.
        PaymentLogDTO paymentLogDTO = paymentLogMapper.toDto(paymentLog);

        restPaymentLogMockMvc.perform(post("/api/payment-logs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(paymentLogDTO)))
            .andExpect(status().isBadRequest());

        List<PaymentLog> paymentLogList = paymentLogRepository.findAll();
        assertThat(paymentLogList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkAmountIsRequired() throws Exception {
        int databaseSizeBeforeTest = paymentLogRepository.findAll().size();
        // set the field null
        paymentLog.setAmount(null);

        // Create the PaymentLog, which fails.
        PaymentLogDTO paymentLogDTO = paymentLogMapper.toDto(paymentLog);

        restPaymentLogMockMvc.perform(post("/api/payment-logs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(paymentLogDTO)))
            .andExpect(status().isBadRequest());

        List<PaymentLog> paymentLogList = paymentLogRepository.findAll();
        assertThat(paymentLogList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkApiNameIsRequired() throws Exception {
        int databaseSizeBeforeTest = paymentLogRepository.findAll().size();
        // set the field null
        paymentLog.setApiName(null);

        // Create the PaymentLog, which fails.
        PaymentLogDTO paymentLogDTO = paymentLogMapper.toDto(paymentLog);

        restPaymentLogMockMvc.perform(post("/api/payment-logs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(paymentLogDTO)))
            .andExpect(status().isBadRequest());

        List<PaymentLog> paymentLogList = paymentLogRepository.findAll();
        assertThat(paymentLogList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllPaymentLogs() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList
        restPaymentLogMockMvc.perform(get("/api/payment-logs?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(paymentLog.getId().intValue())))
            .andExpect(jsonPath("$.[*].userName").value(hasItem(DEFAULT_USER_NAME)))
            .andExpect(jsonPath("$.[*].paymentMethod").value(hasItem(DEFAULT_PAYMENT_METHOD)))
            .andExpect(jsonPath("$.[*].orderId").value(hasItem(DEFAULT_ORDER_ID)))
            .andExpect(jsonPath("$.[*].amount").value(hasItem(DEFAULT_AMOUNT)))
            .andExpect(jsonPath("$.[*].apiName").value(hasItem(DEFAULT_API_NAME)))
            .andExpect(jsonPath("$.[*].requestTime").value(hasItem(DEFAULT_REQUEST_TIME.toString())))
            .andExpect(jsonPath("$.[*].requestBody").value(hasItem(DEFAULT_REQUEST_BODY)))
            .andExpect(jsonPath("$.[*].responseTime").value(hasItem(DEFAULT_RESPONSE_TIME.toString())))
            .andExpect(jsonPath("$.[*].responseBody").value(hasItem(DEFAULT_RESPONSE_BODY)))
            .andExpect(jsonPath("$.[*].returnCode").value(hasItem(DEFAULT_RETURN_CODE)))
            .andExpect(jsonPath("$.[*].returnMessage").value(hasItem(DEFAULT_RETURN_MESSAGE)))
            .andExpect(jsonPath("$.[*].transactionId").value(hasItem(DEFAULT_TRANSACTION_ID)))
            .andExpect(jsonPath("$.[*].debitBankCode").value(hasItem(DEFAULT_DEBIT_BANK_CODE)))
            .andExpect(jsonPath("$.[*].debitBankAccount").value(hasItem(DEFAULT_DEBIT_BANK_ACCOUNT)))
            .andExpect(jsonPath("$.[*].createdTime").value(hasItem(DEFAULT_CREATED_TIME.toString())));
    }

    @Test
    @Transactional
    public void getPaymentLog() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get the paymentLog
        restPaymentLogMockMvc.perform(get("/api/payment-logs/{id}", paymentLog.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(paymentLog.getId().intValue()))
            .andExpect(jsonPath("$.userName").value(DEFAULT_USER_NAME))
            .andExpect(jsonPath("$.paymentMethod").value(DEFAULT_PAYMENT_METHOD))
            .andExpect(jsonPath("$.orderId").value(DEFAULT_ORDER_ID))
            .andExpect(jsonPath("$.amount").value(DEFAULT_AMOUNT))
            .andExpect(jsonPath("$.apiName").value(DEFAULT_API_NAME))
            .andExpect(jsonPath("$.requestTime").value(DEFAULT_REQUEST_TIME.toString()))
            .andExpect(jsonPath("$.requestBody").value(DEFAULT_REQUEST_BODY))
            .andExpect(jsonPath("$.responseTime").value(DEFAULT_RESPONSE_TIME.toString()))
            .andExpect(jsonPath("$.responseBody").value(DEFAULT_RESPONSE_BODY))
            .andExpect(jsonPath("$.returnCode").value(DEFAULT_RETURN_CODE))
            .andExpect(jsonPath("$.returnMessage").value(DEFAULT_RETURN_MESSAGE))
            .andExpect(jsonPath("$.transactionId").value(DEFAULT_TRANSACTION_ID))
            .andExpect(jsonPath("$.debitBankCode").value(DEFAULT_DEBIT_BANK_CODE))
            .andExpect(jsonPath("$.debitBankAccount").value(DEFAULT_DEBIT_BANK_ACCOUNT))
            .andExpect(jsonPath("$.createdTime").value(DEFAULT_CREATED_TIME.toString()));
    }


    @Test
    @Transactional
    public void getPaymentLogsByIdFiltering() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        Long id = paymentLog.getId();

        defaultPaymentLogShouldBeFound("id.equals=" + id);
        defaultPaymentLogShouldNotBeFound("id.notEquals=" + id);

        defaultPaymentLogShouldBeFound("id.greaterThanOrEqual=" + id);
        defaultPaymentLogShouldNotBeFound("id.greaterThan=" + id);

        defaultPaymentLogShouldBeFound("id.lessThanOrEqual=" + id);
        defaultPaymentLogShouldNotBeFound("id.lessThan=" + id);
    }


    @Test
    @Transactional
    public void getAllPaymentLogsByUserNameIsEqualToSomething() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where userName equals to DEFAULT_USER_NAME
        defaultPaymentLogShouldBeFound("userName.equals=" + DEFAULT_USER_NAME);

        // Get all the paymentLogList where userName equals to UPDATED_USER_NAME
        defaultPaymentLogShouldNotBeFound("userName.equals=" + UPDATED_USER_NAME);
    }

    @Test
    @Transactional
    public void getAllPaymentLogsByUserNameIsNotEqualToSomething() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where userName not equals to DEFAULT_USER_NAME
        defaultPaymentLogShouldNotBeFound("userName.notEquals=" + DEFAULT_USER_NAME);

        // Get all the paymentLogList where userName not equals to UPDATED_USER_NAME
        defaultPaymentLogShouldBeFound("userName.notEquals=" + UPDATED_USER_NAME);
    }

    @Test
    @Transactional
    public void getAllPaymentLogsByUserNameIsInShouldWork() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where userName in DEFAULT_USER_NAME or UPDATED_USER_NAME
        defaultPaymentLogShouldBeFound("userName.in=" + DEFAULT_USER_NAME + "," + UPDATED_USER_NAME);

        // Get all the paymentLogList where userName equals to UPDATED_USER_NAME
        defaultPaymentLogShouldNotBeFound("userName.in=" + UPDATED_USER_NAME);
    }

    @Test
    @Transactional
    public void getAllPaymentLogsByUserNameIsNullOrNotNull() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where userName is not null
        defaultPaymentLogShouldBeFound("userName.specified=true");

        // Get all the paymentLogList where userName is null
        defaultPaymentLogShouldNotBeFound("userName.specified=false");
    }
                @Test
    @Transactional
    public void getAllPaymentLogsByUserNameContainsSomething() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where userName contains DEFAULT_USER_NAME
        defaultPaymentLogShouldBeFound("userName.contains=" + DEFAULT_USER_NAME);

        // Get all the paymentLogList where userName contains UPDATED_USER_NAME
        defaultPaymentLogShouldNotBeFound("userName.contains=" + UPDATED_USER_NAME);
    }

    @Test
    @Transactional
    public void getAllPaymentLogsByUserNameNotContainsSomething() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where userName does not contain DEFAULT_USER_NAME
        defaultPaymentLogShouldNotBeFound("userName.doesNotContain=" + DEFAULT_USER_NAME);

        // Get all the paymentLogList where userName does not contain UPDATED_USER_NAME
        defaultPaymentLogShouldBeFound("userName.doesNotContain=" + UPDATED_USER_NAME);
    }


    @Test
    @Transactional
    public void getAllPaymentLogsByPaymentMethodIsEqualToSomething() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where paymentMethod equals to DEFAULT_PAYMENT_METHOD
        defaultPaymentLogShouldBeFound("paymentMethod.equals=" + DEFAULT_PAYMENT_METHOD);

        // Get all the paymentLogList where paymentMethod equals to UPDATED_PAYMENT_METHOD
        defaultPaymentLogShouldNotBeFound("paymentMethod.equals=" + UPDATED_PAYMENT_METHOD);
    }

    @Test
    @Transactional
    public void getAllPaymentLogsByPaymentMethodIsNotEqualToSomething() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where paymentMethod not equals to DEFAULT_PAYMENT_METHOD
        defaultPaymentLogShouldNotBeFound("paymentMethod.notEquals=" + DEFAULT_PAYMENT_METHOD);

        // Get all the paymentLogList where paymentMethod not equals to UPDATED_PAYMENT_METHOD
        defaultPaymentLogShouldBeFound("paymentMethod.notEquals=" + UPDATED_PAYMENT_METHOD);
    }

    @Test
    @Transactional
    public void getAllPaymentLogsByPaymentMethodIsInShouldWork() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where paymentMethod in DEFAULT_PAYMENT_METHOD or UPDATED_PAYMENT_METHOD
        defaultPaymentLogShouldBeFound("paymentMethod.in=" + DEFAULT_PAYMENT_METHOD + "," + UPDATED_PAYMENT_METHOD);

        // Get all the paymentLogList where paymentMethod equals to UPDATED_PAYMENT_METHOD
        defaultPaymentLogShouldNotBeFound("paymentMethod.in=" + UPDATED_PAYMENT_METHOD);
    }

    @Test
    @Transactional
    public void getAllPaymentLogsByPaymentMethodIsNullOrNotNull() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where paymentMethod is not null
        defaultPaymentLogShouldBeFound("paymentMethod.specified=true");

        // Get all the paymentLogList where paymentMethod is null
        defaultPaymentLogShouldNotBeFound("paymentMethod.specified=false");
    }
                @Test
    @Transactional
    public void getAllPaymentLogsByPaymentMethodContainsSomething() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where paymentMethod contains DEFAULT_PAYMENT_METHOD
        defaultPaymentLogShouldBeFound("paymentMethod.contains=" + DEFAULT_PAYMENT_METHOD);

        // Get all the paymentLogList where paymentMethod contains UPDATED_PAYMENT_METHOD
        defaultPaymentLogShouldNotBeFound("paymentMethod.contains=" + UPDATED_PAYMENT_METHOD);
    }

    @Test
    @Transactional
    public void getAllPaymentLogsByPaymentMethodNotContainsSomething() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where paymentMethod does not contain DEFAULT_PAYMENT_METHOD
        defaultPaymentLogShouldNotBeFound("paymentMethod.doesNotContain=" + DEFAULT_PAYMENT_METHOD);

        // Get all the paymentLogList where paymentMethod does not contain UPDATED_PAYMENT_METHOD
        defaultPaymentLogShouldBeFound("paymentMethod.doesNotContain=" + UPDATED_PAYMENT_METHOD);
    }


    @Test
    @Transactional
    public void getAllPaymentLogsByOrderIdIsEqualToSomething() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where orderId equals to DEFAULT_ORDER_ID
        defaultPaymentLogShouldBeFound("orderId.equals=" + DEFAULT_ORDER_ID);

        // Get all the paymentLogList where orderId equals to UPDATED_ORDER_ID
        defaultPaymentLogShouldNotBeFound("orderId.equals=" + UPDATED_ORDER_ID);
    }

    @Test
    @Transactional
    public void getAllPaymentLogsByOrderIdIsNotEqualToSomething() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where orderId not equals to DEFAULT_ORDER_ID
        defaultPaymentLogShouldNotBeFound("orderId.notEquals=" + DEFAULT_ORDER_ID);

        // Get all the paymentLogList where orderId not equals to UPDATED_ORDER_ID
        defaultPaymentLogShouldBeFound("orderId.notEquals=" + UPDATED_ORDER_ID);
    }

    @Test
    @Transactional
    public void getAllPaymentLogsByOrderIdIsInShouldWork() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where orderId in DEFAULT_ORDER_ID or UPDATED_ORDER_ID
        defaultPaymentLogShouldBeFound("orderId.in=" + DEFAULT_ORDER_ID + "," + UPDATED_ORDER_ID);

        // Get all the paymentLogList where orderId equals to UPDATED_ORDER_ID
        defaultPaymentLogShouldNotBeFound("orderId.in=" + UPDATED_ORDER_ID);
    }

    @Test
    @Transactional
    public void getAllPaymentLogsByOrderIdIsNullOrNotNull() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where orderId is not null
        defaultPaymentLogShouldBeFound("orderId.specified=true");

        // Get all the paymentLogList where orderId is null
        defaultPaymentLogShouldNotBeFound("orderId.specified=false");
    }
                @Test
    @Transactional
    public void getAllPaymentLogsByOrderIdContainsSomething() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where orderId contains DEFAULT_ORDER_ID
        defaultPaymentLogShouldBeFound("orderId.contains=" + DEFAULT_ORDER_ID);

        // Get all the paymentLogList where orderId contains UPDATED_ORDER_ID
        defaultPaymentLogShouldNotBeFound("orderId.contains=" + UPDATED_ORDER_ID);
    }

    @Test
    @Transactional
    public void getAllPaymentLogsByOrderIdNotContainsSomething() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where orderId does not contain DEFAULT_ORDER_ID
        defaultPaymentLogShouldNotBeFound("orderId.doesNotContain=" + DEFAULT_ORDER_ID);

        // Get all the paymentLogList where orderId does not contain UPDATED_ORDER_ID
        defaultPaymentLogShouldBeFound("orderId.doesNotContain=" + UPDATED_ORDER_ID);
    }


    @Test
    @Transactional
    public void getAllPaymentLogsByAmountIsEqualToSomething() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where amount equals to DEFAULT_AMOUNT
        defaultPaymentLogShouldBeFound("amount.equals=" + DEFAULT_AMOUNT);

        // Get all the paymentLogList where amount equals to UPDATED_AMOUNT
        defaultPaymentLogShouldNotBeFound("amount.equals=" + UPDATED_AMOUNT);
    }

    @Test
    @Transactional
    public void getAllPaymentLogsByAmountIsNotEqualToSomething() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where amount not equals to DEFAULT_AMOUNT
        defaultPaymentLogShouldNotBeFound("amount.notEquals=" + DEFAULT_AMOUNT);

        // Get all the paymentLogList where amount not equals to UPDATED_AMOUNT
        defaultPaymentLogShouldBeFound("amount.notEquals=" + UPDATED_AMOUNT);
    }

    @Test
    @Transactional
    public void getAllPaymentLogsByAmountIsInShouldWork() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where amount in DEFAULT_AMOUNT or UPDATED_AMOUNT
        defaultPaymentLogShouldBeFound("amount.in=" + DEFAULT_AMOUNT + "," + UPDATED_AMOUNT);

        // Get all the paymentLogList where amount equals to UPDATED_AMOUNT
        defaultPaymentLogShouldNotBeFound("amount.in=" + UPDATED_AMOUNT);
    }

    @Test
    @Transactional
    public void getAllPaymentLogsByAmountIsNullOrNotNull() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where amount is not null
        defaultPaymentLogShouldBeFound("amount.specified=true");

        // Get all the paymentLogList where amount is null
        defaultPaymentLogShouldNotBeFound("amount.specified=false");
    }
                @Test
    @Transactional
    public void getAllPaymentLogsByAmountContainsSomething() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where amount contains DEFAULT_AMOUNT
        defaultPaymentLogShouldBeFound("amount.contains=" + DEFAULT_AMOUNT);

        // Get all the paymentLogList where amount contains UPDATED_AMOUNT
        defaultPaymentLogShouldNotBeFound("amount.contains=" + UPDATED_AMOUNT);
    }

    @Test
    @Transactional
    public void getAllPaymentLogsByAmountNotContainsSomething() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where amount does not contain DEFAULT_AMOUNT
        defaultPaymentLogShouldNotBeFound("amount.doesNotContain=" + DEFAULT_AMOUNT);

        // Get all the paymentLogList where amount does not contain UPDATED_AMOUNT
        defaultPaymentLogShouldBeFound("amount.doesNotContain=" + UPDATED_AMOUNT);
    }


    @Test
    @Transactional
    public void getAllPaymentLogsByApiNameIsEqualToSomething() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where apiName equals to DEFAULT_API_NAME
        defaultPaymentLogShouldBeFound("apiName.equals=" + DEFAULT_API_NAME);

        // Get all the paymentLogList where apiName equals to UPDATED_API_NAME
        defaultPaymentLogShouldNotBeFound("apiName.equals=" + UPDATED_API_NAME);
    }

    @Test
    @Transactional
    public void getAllPaymentLogsByApiNameIsNotEqualToSomething() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where apiName not equals to DEFAULT_API_NAME
        defaultPaymentLogShouldNotBeFound("apiName.notEquals=" + DEFAULT_API_NAME);

        // Get all the paymentLogList where apiName not equals to UPDATED_API_NAME
        defaultPaymentLogShouldBeFound("apiName.notEquals=" + UPDATED_API_NAME);
    }

    @Test
    @Transactional
    public void getAllPaymentLogsByApiNameIsInShouldWork() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where apiName in DEFAULT_API_NAME or UPDATED_API_NAME
        defaultPaymentLogShouldBeFound("apiName.in=" + DEFAULT_API_NAME + "," + UPDATED_API_NAME);

        // Get all the paymentLogList where apiName equals to UPDATED_API_NAME
        defaultPaymentLogShouldNotBeFound("apiName.in=" + UPDATED_API_NAME);
    }

    @Test
    @Transactional
    public void getAllPaymentLogsByApiNameIsNullOrNotNull() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where apiName is not null
        defaultPaymentLogShouldBeFound("apiName.specified=true");

        // Get all the paymentLogList where apiName is null
        defaultPaymentLogShouldNotBeFound("apiName.specified=false");
    }
                @Test
    @Transactional
    public void getAllPaymentLogsByApiNameContainsSomething() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where apiName contains DEFAULT_API_NAME
        defaultPaymentLogShouldBeFound("apiName.contains=" + DEFAULT_API_NAME);

        // Get all the paymentLogList where apiName contains UPDATED_API_NAME
        defaultPaymentLogShouldNotBeFound("apiName.contains=" + UPDATED_API_NAME);
    }

    @Test
    @Transactional
    public void getAllPaymentLogsByApiNameNotContainsSomething() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where apiName does not contain DEFAULT_API_NAME
        defaultPaymentLogShouldNotBeFound("apiName.doesNotContain=" + DEFAULT_API_NAME);

        // Get all the paymentLogList where apiName does not contain UPDATED_API_NAME
        defaultPaymentLogShouldBeFound("apiName.doesNotContain=" + UPDATED_API_NAME);
    }


    @Test
    @Transactional
    public void getAllPaymentLogsByRequestTimeIsEqualToSomething() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where requestTime equals to DEFAULT_REQUEST_TIME
        defaultPaymentLogShouldBeFound("requestTime.equals=" + DEFAULT_REQUEST_TIME);

        // Get all the paymentLogList where requestTime equals to UPDATED_REQUEST_TIME
        defaultPaymentLogShouldNotBeFound("requestTime.equals=" + UPDATED_REQUEST_TIME);
    }

    @Test
    @Transactional
    public void getAllPaymentLogsByRequestTimeIsNotEqualToSomething() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where requestTime not equals to DEFAULT_REQUEST_TIME
        defaultPaymentLogShouldNotBeFound("requestTime.notEquals=" + DEFAULT_REQUEST_TIME);

        // Get all the paymentLogList where requestTime not equals to UPDATED_REQUEST_TIME
        defaultPaymentLogShouldBeFound("requestTime.notEquals=" + UPDATED_REQUEST_TIME);
    }

    @Test
    @Transactional
    public void getAllPaymentLogsByRequestTimeIsInShouldWork() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where requestTime in DEFAULT_REQUEST_TIME or UPDATED_REQUEST_TIME
        defaultPaymentLogShouldBeFound("requestTime.in=" + DEFAULT_REQUEST_TIME + "," + UPDATED_REQUEST_TIME);

        // Get all the paymentLogList where requestTime equals to UPDATED_REQUEST_TIME
        defaultPaymentLogShouldNotBeFound("requestTime.in=" + UPDATED_REQUEST_TIME);
    }

    @Test
    @Transactional
    public void getAllPaymentLogsByRequestTimeIsNullOrNotNull() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where requestTime is not null
        defaultPaymentLogShouldBeFound("requestTime.specified=true");

        // Get all the paymentLogList where requestTime is null
        defaultPaymentLogShouldNotBeFound("requestTime.specified=false");
    }

    @Test
    @Transactional
    public void getAllPaymentLogsByRequestBodyIsEqualToSomething() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where requestBody equals to DEFAULT_REQUEST_BODY
        defaultPaymentLogShouldBeFound("requestBody.equals=" + DEFAULT_REQUEST_BODY);

        // Get all the paymentLogList where requestBody equals to UPDATED_REQUEST_BODY
        defaultPaymentLogShouldNotBeFound("requestBody.equals=" + UPDATED_REQUEST_BODY);
    }

    @Test
    @Transactional
    public void getAllPaymentLogsByRequestBodyIsNotEqualToSomething() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where requestBody not equals to DEFAULT_REQUEST_BODY
        defaultPaymentLogShouldNotBeFound("requestBody.notEquals=" + DEFAULT_REQUEST_BODY);

        // Get all the paymentLogList where requestBody not equals to UPDATED_REQUEST_BODY
        defaultPaymentLogShouldBeFound("requestBody.notEquals=" + UPDATED_REQUEST_BODY);
    }

    @Test
    @Transactional
    public void getAllPaymentLogsByRequestBodyIsInShouldWork() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where requestBody in DEFAULT_REQUEST_BODY or UPDATED_REQUEST_BODY
        defaultPaymentLogShouldBeFound("requestBody.in=" + DEFAULT_REQUEST_BODY + "," + UPDATED_REQUEST_BODY);

        // Get all the paymentLogList where requestBody equals to UPDATED_REQUEST_BODY
        defaultPaymentLogShouldNotBeFound("requestBody.in=" + UPDATED_REQUEST_BODY);
    }

    @Test
    @Transactional
    public void getAllPaymentLogsByRequestBodyIsNullOrNotNull() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where requestBody is not null
        defaultPaymentLogShouldBeFound("requestBody.specified=true");

        // Get all the paymentLogList where requestBody is null
        defaultPaymentLogShouldNotBeFound("requestBody.specified=false");
    }
                @Test
    @Transactional
    public void getAllPaymentLogsByRequestBodyContainsSomething() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where requestBody contains DEFAULT_REQUEST_BODY
        defaultPaymentLogShouldBeFound("requestBody.contains=" + DEFAULT_REQUEST_BODY);

        // Get all the paymentLogList where requestBody contains UPDATED_REQUEST_BODY
        defaultPaymentLogShouldNotBeFound("requestBody.contains=" + UPDATED_REQUEST_BODY);
    }

    @Test
    @Transactional
    public void getAllPaymentLogsByRequestBodyNotContainsSomething() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where requestBody does not contain DEFAULT_REQUEST_BODY
        defaultPaymentLogShouldNotBeFound("requestBody.doesNotContain=" + DEFAULT_REQUEST_BODY);

        // Get all the paymentLogList where requestBody does not contain UPDATED_REQUEST_BODY
        defaultPaymentLogShouldBeFound("requestBody.doesNotContain=" + UPDATED_REQUEST_BODY);
    }


    @Test
    @Transactional
    public void getAllPaymentLogsByResponseTimeIsEqualToSomething() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where responseTime equals to DEFAULT_RESPONSE_TIME
        defaultPaymentLogShouldBeFound("responseTime.equals=" + DEFAULT_RESPONSE_TIME);

        // Get all the paymentLogList where responseTime equals to UPDATED_RESPONSE_TIME
        defaultPaymentLogShouldNotBeFound("responseTime.equals=" + UPDATED_RESPONSE_TIME);
    }

    @Test
    @Transactional
    public void getAllPaymentLogsByResponseTimeIsNotEqualToSomething() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where responseTime not equals to DEFAULT_RESPONSE_TIME
        defaultPaymentLogShouldNotBeFound("responseTime.notEquals=" + DEFAULT_RESPONSE_TIME);

        // Get all the paymentLogList where responseTime not equals to UPDATED_RESPONSE_TIME
        defaultPaymentLogShouldBeFound("responseTime.notEquals=" + UPDATED_RESPONSE_TIME);
    }

    @Test
    @Transactional
    public void getAllPaymentLogsByResponseTimeIsInShouldWork() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where responseTime in DEFAULT_RESPONSE_TIME or UPDATED_RESPONSE_TIME
        defaultPaymentLogShouldBeFound("responseTime.in=" + DEFAULT_RESPONSE_TIME + "," + UPDATED_RESPONSE_TIME);

        // Get all the paymentLogList where responseTime equals to UPDATED_RESPONSE_TIME
        defaultPaymentLogShouldNotBeFound("responseTime.in=" + UPDATED_RESPONSE_TIME);
    }

    @Test
    @Transactional
    public void getAllPaymentLogsByResponseTimeIsNullOrNotNull() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where responseTime is not null
        defaultPaymentLogShouldBeFound("responseTime.specified=true");

        // Get all the paymentLogList where responseTime is null
        defaultPaymentLogShouldNotBeFound("responseTime.specified=false");
    }

    @Test
    @Transactional
    public void getAllPaymentLogsByResponseBodyIsEqualToSomething() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where responseBody equals to DEFAULT_RESPONSE_BODY
        defaultPaymentLogShouldBeFound("responseBody.equals=" + DEFAULT_RESPONSE_BODY);

        // Get all the paymentLogList where responseBody equals to UPDATED_RESPONSE_BODY
        defaultPaymentLogShouldNotBeFound("responseBody.equals=" + UPDATED_RESPONSE_BODY);
    }

    @Test
    @Transactional
    public void getAllPaymentLogsByResponseBodyIsNotEqualToSomething() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where responseBody not equals to DEFAULT_RESPONSE_BODY
        defaultPaymentLogShouldNotBeFound("responseBody.notEquals=" + DEFAULT_RESPONSE_BODY);

        // Get all the paymentLogList where responseBody not equals to UPDATED_RESPONSE_BODY
        defaultPaymentLogShouldBeFound("responseBody.notEquals=" + UPDATED_RESPONSE_BODY);
    }

    @Test
    @Transactional
    public void getAllPaymentLogsByResponseBodyIsInShouldWork() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where responseBody in DEFAULT_RESPONSE_BODY or UPDATED_RESPONSE_BODY
        defaultPaymentLogShouldBeFound("responseBody.in=" + DEFAULT_RESPONSE_BODY + "," + UPDATED_RESPONSE_BODY);

        // Get all the paymentLogList where responseBody equals to UPDATED_RESPONSE_BODY
        defaultPaymentLogShouldNotBeFound("responseBody.in=" + UPDATED_RESPONSE_BODY);
    }

    @Test
    @Transactional
    public void getAllPaymentLogsByResponseBodyIsNullOrNotNull() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where responseBody is not null
        defaultPaymentLogShouldBeFound("responseBody.specified=true");

        // Get all the paymentLogList where responseBody is null
        defaultPaymentLogShouldNotBeFound("responseBody.specified=false");
    }
                @Test
    @Transactional
    public void getAllPaymentLogsByResponseBodyContainsSomething() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where responseBody contains DEFAULT_RESPONSE_BODY
        defaultPaymentLogShouldBeFound("responseBody.contains=" + DEFAULT_RESPONSE_BODY);

        // Get all the paymentLogList where responseBody contains UPDATED_RESPONSE_BODY
        defaultPaymentLogShouldNotBeFound("responseBody.contains=" + UPDATED_RESPONSE_BODY);
    }

    @Test
    @Transactional
    public void getAllPaymentLogsByResponseBodyNotContainsSomething() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where responseBody does not contain DEFAULT_RESPONSE_BODY
        defaultPaymentLogShouldNotBeFound("responseBody.doesNotContain=" + DEFAULT_RESPONSE_BODY);

        // Get all the paymentLogList where responseBody does not contain UPDATED_RESPONSE_BODY
        defaultPaymentLogShouldBeFound("responseBody.doesNotContain=" + UPDATED_RESPONSE_BODY);
    }


    @Test
    @Transactional
    public void getAllPaymentLogsByReturnCodeIsEqualToSomething() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where returnCode equals to DEFAULT_RETURN_CODE
        defaultPaymentLogShouldBeFound("returnCode.equals=" + DEFAULT_RETURN_CODE);

        // Get all the paymentLogList where returnCode equals to UPDATED_RETURN_CODE
        defaultPaymentLogShouldNotBeFound("returnCode.equals=" + UPDATED_RETURN_CODE);
    }

    @Test
    @Transactional
    public void getAllPaymentLogsByReturnCodeIsNotEqualToSomething() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where returnCode not equals to DEFAULT_RETURN_CODE
        defaultPaymentLogShouldNotBeFound("returnCode.notEquals=" + DEFAULT_RETURN_CODE);

        // Get all the paymentLogList where returnCode not equals to UPDATED_RETURN_CODE
        defaultPaymentLogShouldBeFound("returnCode.notEquals=" + UPDATED_RETURN_CODE);
    }

    @Test
    @Transactional
    public void getAllPaymentLogsByReturnCodeIsInShouldWork() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where returnCode in DEFAULT_RETURN_CODE or UPDATED_RETURN_CODE
        defaultPaymentLogShouldBeFound("returnCode.in=" + DEFAULT_RETURN_CODE + "," + UPDATED_RETURN_CODE);

        // Get all the paymentLogList where returnCode equals to UPDATED_RETURN_CODE
        defaultPaymentLogShouldNotBeFound("returnCode.in=" + UPDATED_RETURN_CODE);
    }

    @Test
    @Transactional
    public void getAllPaymentLogsByReturnCodeIsNullOrNotNull() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where returnCode is not null
        defaultPaymentLogShouldBeFound("returnCode.specified=true");

        // Get all the paymentLogList where returnCode is null
        defaultPaymentLogShouldNotBeFound("returnCode.specified=false");
    }
                @Test
    @Transactional
    public void getAllPaymentLogsByReturnCodeContainsSomething() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where returnCode contains DEFAULT_RETURN_CODE
        defaultPaymentLogShouldBeFound("returnCode.contains=" + DEFAULT_RETURN_CODE);

        // Get all the paymentLogList where returnCode contains UPDATED_RETURN_CODE
        defaultPaymentLogShouldNotBeFound("returnCode.contains=" + UPDATED_RETURN_CODE);
    }

    @Test
    @Transactional
    public void getAllPaymentLogsByReturnCodeNotContainsSomething() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where returnCode does not contain DEFAULT_RETURN_CODE
        defaultPaymentLogShouldNotBeFound("returnCode.doesNotContain=" + DEFAULT_RETURN_CODE);

        // Get all the paymentLogList where returnCode does not contain UPDATED_RETURN_CODE
        defaultPaymentLogShouldBeFound("returnCode.doesNotContain=" + UPDATED_RETURN_CODE);
    }


    @Test
    @Transactional
    public void getAllPaymentLogsByReturnMessageIsEqualToSomething() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where returnMessage equals to DEFAULT_RETURN_MESSAGE
        defaultPaymentLogShouldBeFound("returnMessage.equals=" + DEFAULT_RETURN_MESSAGE);

        // Get all the paymentLogList where returnMessage equals to UPDATED_RETURN_MESSAGE
        defaultPaymentLogShouldNotBeFound("returnMessage.equals=" + UPDATED_RETURN_MESSAGE);
    }

    @Test
    @Transactional
    public void getAllPaymentLogsByReturnMessageIsNotEqualToSomething() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where returnMessage not equals to DEFAULT_RETURN_MESSAGE
        defaultPaymentLogShouldNotBeFound("returnMessage.notEquals=" + DEFAULT_RETURN_MESSAGE);

        // Get all the paymentLogList where returnMessage not equals to UPDATED_RETURN_MESSAGE
        defaultPaymentLogShouldBeFound("returnMessage.notEquals=" + UPDATED_RETURN_MESSAGE);
    }

    @Test
    @Transactional
    public void getAllPaymentLogsByReturnMessageIsInShouldWork() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where returnMessage in DEFAULT_RETURN_MESSAGE or UPDATED_RETURN_MESSAGE
        defaultPaymentLogShouldBeFound("returnMessage.in=" + DEFAULT_RETURN_MESSAGE + "," + UPDATED_RETURN_MESSAGE);

        // Get all the paymentLogList where returnMessage equals to UPDATED_RETURN_MESSAGE
        defaultPaymentLogShouldNotBeFound("returnMessage.in=" + UPDATED_RETURN_MESSAGE);
    }

    @Test
    @Transactional
    public void getAllPaymentLogsByReturnMessageIsNullOrNotNull() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where returnMessage is not null
        defaultPaymentLogShouldBeFound("returnMessage.specified=true");

        // Get all the paymentLogList where returnMessage is null
        defaultPaymentLogShouldNotBeFound("returnMessage.specified=false");
    }
                @Test
    @Transactional
    public void getAllPaymentLogsByReturnMessageContainsSomething() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where returnMessage contains DEFAULT_RETURN_MESSAGE
        defaultPaymentLogShouldBeFound("returnMessage.contains=" + DEFAULT_RETURN_MESSAGE);

        // Get all the paymentLogList where returnMessage contains UPDATED_RETURN_MESSAGE
        defaultPaymentLogShouldNotBeFound("returnMessage.contains=" + UPDATED_RETURN_MESSAGE);
    }

    @Test
    @Transactional
    public void getAllPaymentLogsByReturnMessageNotContainsSomething() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where returnMessage does not contain DEFAULT_RETURN_MESSAGE
        defaultPaymentLogShouldNotBeFound("returnMessage.doesNotContain=" + DEFAULT_RETURN_MESSAGE);

        // Get all the paymentLogList where returnMessage does not contain UPDATED_RETURN_MESSAGE
        defaultPaymentLogShouldBeFound("returnMessage.doesNotContain=" + UPDATED_RETURN_MESSAGE);
    }


    @Test
    @Transactional
    public void getAllPaymentLogsByTransactionIdIsEqualToSomething() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where transactionId equals to DEFAULT_TRANSACTION_ID
        defaultPaymentLogShouldBeFound("transactionId.equals=" + DEFAULT_TRANSACTION_ID);

        // Get all the paymentLogList where transactionId equals to UPDATED_TRANSACTION_ID
        defaultPaymentLogShouldNotBeFound("transactionId.equals=" + UPDATED_TRANSACTION_ID);
    }

    @Test
    @Transactional
    public void getAllPaymentLogsByTransactionIdIsNotEqualToSomething() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where transactionId not equals to DEFAULT_TRANSACTION_ID
        defaultPaymentLogShouldNotBeFound("transactionId.notEquals=" + DEFAULT_TRANSACTION_ID);

        // Get all the paymentLogList where transactionId not equals to UPDATED_TRANSACTION_ID
        defaultPaymentLogShouldBeFound("transactionId.notEquals=" + UPDATED_TRANSACTION_ID);
    }

    @Test
    @Transactional
    public void getAllPaymentLogsByTransactionIdIsInShouldWork() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where transactionId in DEFAULT_TRANSACTION_ID or UPDATED_TRANSACTION_ID
        defaultPaymentLogShouldBeFound("transactionId.in=" + DEFAULT_TRANSACTION_ID + "," + UPDATED_TRANSACTION_ID);

        // Get all the paymentLogList where transactionId equals to UPDATED_TRANSACTION_ID
        defaultPaymentLogShouldNotBeFound("transactionId.in=" + UPDATED_TRANSACTION_ID);
    }

    @Test
    @Transactional
    public void getAllPaymentLogsByTransactionIdIsNullOrNotNull() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where transactionId is not null
        defaultPaymentLogShouldBeFound("transactionId.specified=true");

        // Get all the paymentLogList where transactionId is null
        defaultPaymentLogShouldNotBeFound("transactionId.specified=false");
    }
                @Test
    @Transactional
    public void getAllPaymentLogsByTransactionIdContainsSomething() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where transactionId contains DEFAULT_TRANSACTION_ID
        defaultPaymentLogShouldBeFound("transactionId.contains=" + DEFAULT_TRANSACTION_ID);

        // Get all the paymentLogList where transactionId contains UPDATED_TRANSACTION_ID
        defaultPaymentLogShouldNotBeFound("transactionId.contains=" + UPDATED_TRANSACTION_ID);
    }

    @Test
    @Transactional
    public void getAllPaymentLogsByTransactionIdNotContainsSomething() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where transactionId does not contain DEFAULT_TRANSACTION_ID
        defaultPaymentLogShouldNotBeFound("transactionId.doesNotContain=" + DEFAULT_TRANSACTION_ID);

        // Get all the paymentLogList where transactionId does not contain UPDATED_TRANSACTION_ID
        defaultPaymentLogShouldBeFound("transactionId.doesNotContain=" + UPDATED_TRANSACTION_ID);
    }


    @Test
    @Transactional
    public void getAllPaymentLogsByDebitBankCodeIsEqualToSomething() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where debitBankCode equals to DEFAULT_DEBIT_BANK_CODE
        defaultPaymentLogShouldBeFound("debitBankCode.equals=" + DEFAULT_DEBIT_BANK_CODE);

        // Get all the paymentLogList where debitBankCode equals to UPDATED_DEBIT_BANK_CODE
        defaultPaymentLogShouldNotBeFound("debitBankCode.equals=" + UPDATED_DEBIT_BANK_CODE);
    }

    @Test
    @Transactional
    public void getAllPaymentLogsByDebitBankCodeIsNotEqualToSomething() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where debitBankCode not equals to DEFAULT_DEBIT_BANK_CODE
        defaultPaymentLogShouldNotBeFound("debitBankCode.notEquals=" + DEFAULT_DEBIT_BANK_CODE);

        // Get all the paymentLogList where debitBankCode not equals to UPDATED_DEBIT_BANK_CODE
        defaultPaymentLogShouldBeFound("debitBankCode.notEquals=" + UPDATED_DEBIT_BANK_CODE);
    }

    @Test
    @Transactional
    public void getAllPaymentLogsByDebitBankCodeIsInShouldWork() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where debitBankCode in DEFAULT_DEBIT_BANK_CODE or UPDATED_DEBIT_BANK_CODE
        defaultPaymentLogShouldBeFound("debitBankCode.in=" + DEFAULT_DEBIT_BANK_CODE + "," + UPDATED_DEBIT_BANK_CODE);

        // Get all the paymentLogList where debitBankCode equals to UPDATED_DEBIT_BANK_CODE
        defaultPaymentLogShouldNotBeFound("debitBankCode.in=" + UPDATED_DEBIT_BANK_CODE);
    }

    @Test
    @Transactional
    public void getAllPaymentLogsByDebitBankCodeIsNullOrNotNull() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where debitBankCode is not null
        defaultPaymentLogShouldBeFound("debitBankCode.specified=true");

        // Get all the paymentLogList where debitBankCode is null
        defaultPaymentLogShouldNotBeFound("debitBankCode.specified=false");
    }
                @Test
    @Transactional
    public void getAllPaymentLogsByDebitBankCodeContainsSomething() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where debitBankCode contains DEFAULT_DEBIT_BANK_CODE
        defaultPaymentLogShouldBeFound("debitBankCode.contains=" + DEFAULT_DEBIT_BANK_CODE);

        // Get all the paymentLogList where debitBankCode contains UPDATED_DEBIT_BANK_CODE
        defaultPaymentLogShouldNotBeFound("debitBankCode.contains=" + UPDATED_DEBIT_BANK_CODE);
    }

    @Test
    @Transactional
    public void getAllPaymentLogsByDebitBankCodeNotContainsSomething() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where debitBankCode does not contain DEFAULT_DEBIT_BANK_CODE
        defaultPaymentLogShouldNotBeFound("debitBankCode.doesNotContain=" + DEFAULT_DEBIT_BANK_CODE);

        // Get all the paymentLogList where debitBankCode does not contain UPDATED_DEBIT_BANK_CODE
        defaultPaymentLogShouldBeFound("debitBankCode.doesNotContain=" + UPDATED_DEBIT_BANK_CODE);
    }


    @Test
    @Transactional
    public void getAllPaymentLogsByDebitBankAccountIsEqualToSomething() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where debitBankAccount equals to DEFAULT_DEBIT_BANK_ACCOUNT
        defaultPaymentLogShouldBeFound("debitBankAccount.equals=" + DEFAULT_DEBIT_BANK_ACCOUNT);

        // Get all the paymentLogList where debitBankAccount equals to UPDATED_DEBIT_BANK_ACCOUNT
        defaultPaymentLogShouldNotBeFound("debitBankAccount.equals=" + UPDATED_DEBIT_BANK_ACCOUNT);
    }

    @Test
    @Transactional
    public void getAllPaymentLogsByDebitBankAccountIsNotEqualToSomething() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where debitBankAccount not equals to DEFAULT_DEBIT_BANK_ACCOUNT
        defaultPaymentLogShouldNotBeFound("debitBankAccount.notEquals=" + DEFAULT_DEBIT_BANK_ACCOUNT);

        // Get all the paymentLogList where debitBankAccount not equals to UPDATED_DEBIT_BANK_ACCOUNT
        defaultPaymentLogShouldBeFound("debitBankAccount.notEquals=" + UPDATED_DEBIT_BANK_ACCOUNT);
    }

    @Test
    @Transactional
    public void getAllPaymentLogsByDebitBankAccountIsInShouldWork() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where debitBankAccount in DEFAULT_DEBIT_BANK_ACCOUNT or UPDATED_DEBIT_BANK_ACCOUNT
        defaultPaymentLogShouldBeFound("debitBankAccount.in=" + DEFAULT_DEBIT_BANK_ACCOUNT + "," + UPDATED_DEBIT_BANK_ACCOUNT);

        // Get all the paymentLogList where debitBankAccount equals to UPDATED_DEBIT_BANK_ACCOUNT
        defaultPaymentLogShouldNotBeFound("debitBankAccount.in=" + UPDATED_DEBIT_BANK_ACCOUNT);
    }

    @Test
    @Transactional
    public void getAllPaymentLogsByDebitBankAccountIsNullOrNotNull() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where debitBankAccount is not null
        defaultPaymentLogShouldBeFound("debitBankAccount.specified=true");

        // Get all the paymentLogList where debitBankAccount is null
        defaultPaymentLogShouldNotBeFound("debitBankAccount.specified=false");
    }
                @Test
    @Transactional
    public void getAllPaymentLogsByDebitBankAccountContainsSomething() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where debitBankAccount contains DEFAULT_DEBIT_BANK_ACCOUNT
        defaultPaymentLogShouldBeFound("debitBankAccount.contains=" + DEFAULT_DEBIT_BANK_ACCOUNT);

        // Get all the paymentLogList where debitBankAccount contains UPDATED_DEBIT_BANK_ACCOUNT
        defaultPaymentLogShouldNotBeFound("debitBankAccount.contains=" + UPDATED_DEBIT_BANK_ACCOUNT);
    }

    @Test
    @Transactional
    public void getAllPaymentLogsByDebitBankAccountNotContainsSomething() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where debitBankAccount does not contain DEFAULT_DEBIT_BANK_ACCOUNT
        defaultPaymentLogShouldNotBeFound("debitBankAccount.doesNotContain=" + DEFAULT_DEBIT_BANK_ACCOUNT);

        // Get all the paymentLogList where debitBankAccount does not contain UPDATED_DEBIT_BANK_ACCOUNT
        defaultPaymentLogShouldBeFound("debitBankAccount.doesNotContain=" + UPDATED_DEBIT_BANK_ACCOUNT);
    }


    @Test
    @Transactional
    public void getAllPaymentLogsByCreatedTimeIsEqualToSomething() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where createdTime equals to DEFAULT_CREATED_TIME
        defaultPaymentLogShouldBeFound("createdTime.equals=" + DEFAULT_CREATED_TIME);

        // Get all the paymentLogList where createdTime equals to UPDATED_CREATED_TIME
        defaultPaymentLogShouldNotBeFound("createdTime.equals=" + UPDATED_CREATED_TIME);
    }

    @Test
    @Transactional
    public void getAllPaymentLogsByCreatedTimeIsNotEqualToSomething() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where createdTime not equals to DEFAULT_CREATED_TIME
        defaultPaymentLogShouldNotBeFound("createdTime.notEquals=" + DEFAULT_CREATED_TIME);

        // Get all the paymentLogList where createdTime not equals to UPDATED_CREATED_TIME
        defaultPaymentLogShouldBeFound("createdTime.notEquals=" + UPDATED_CREATED_TIME);
    }

    @Test
    @Transactional
    public void getAllPaymentLogsByCreatedTimeIsInShouldWork() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where createdTime in DEFAULT_CREATED_TIME or UPDATED_CREATED_TIME
        defaultPaymentLogShouldBeFound("createdTime.in=" + DEFAULT_CREATED_TIME + "," + UPDATED_CREATED_TIME);

        // Get all the paymentLogList where createdTime equals to UPDATED_CREATED_TIME
        defaultPaymentLogShouldNotBeFound("createdTime.in=" + UPDATED_CREATED_TIME);
    }

    @Test
    @Transactional
    public void getAllPaymentLogsByCreatedTimeIsNullOrNotNull() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        // Get all the paymentLogList where createdTime is not null
        defaultPaymentLogShouldBeFound("createdTime.specified=true");

        // Get all the paymentLogList where createdTime is null
        defaultPaymentLogShouldNotBeFound("createdTime.specified=false");
    }
    /**
     * Executes the search, and checks that the default entity is returned.
     */
    private void defaultPaymentLogShouldBeFound(String filter) throws Exception {
        restPaymentLogMockMvc.perform(get("/api/payment-logs?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(paymentLog.getId().intValue())))
            .andExpect(jsonPath("$.[*].userName").value(hasItem(DEFAULT_USER_NAME)))
            .andExpect(jsonPath("$.[*].paymentMethod").value(hasItem(DEFAULT_PAYMENT_METHOD)))
            .andExpect(jsonPath("$.[*].orderId").value(hasItem(DEFAULT_ORDER_ID)))
            .andExpect(jsonPath("$.[*].amount").value(hasItem(DEFAULT_AMOUNT)))
            .andExpect(jsonPath("$.[*].apiName").value(hasItem(DEFAULT_API_NAME)))
            .andExpect(jsonPath("$.[*].requestTime").value(hasItem(DEFAULT_REQUEST_TIME.toString())))
            .andExpect(jsonPath("$.[*].requestBody").value(hasItem(DEFAULT_REQUEST_BODY)))
            .andExpect(jsonPath("$.[*].responseTime").value(hasItem(DEFAULT_RESPONSE_TIME.toString())))
            .andExpect(jsonPath("$.[*].responseBody").value(hasItem(DEFAULT_RESPONSE_BODY)))
            .andExpect(jsonPath("$.[*].returnCode").value(hasItem(DEFAULT_RETURN_CODE)))
            .andExpect(jsonPath("$.[*].returnMessage").value(hasItem(DEFAULT_RETURN_MESSAGE)))
            .andExpect(jsonPath("$.[*].transactionId").value(hasItem(DEFAULT_TRANSACTION_ID)))
            .andExpect(jsonPath("$.[*].debitBankCode").value(hasItem(DEFAULT_DEBIT_BANK_CODE)))
            .andExpect(jsonPath("$.[*].debitBankAccount").value(hasItem(DEFAULT_DEBIT_BANK_ACCOUNT)))
            .andExpect(jsonPath("$.[*].createdTime").value(hasItem(DEFAULT_CREATED_TIME.toString())));

        // Check, that the count call also returns 1
        restPaymentLogMockMvc.perform(get("/api/payment-logs/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(content().string("1"));
    }

    /**
     * Executes the search, and checks that the default entity is not returned.
     */
    private void defaultPaymentLogShouldNotBeFound(String filter) throws Exception {
        restPaymentLogMockMvc.perform(get("/api/payment-logs?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$").isArray())
            .andExpect(jsonPath("$").isEmpty());

        // Check, that the count call also returns 0
        restPaymentLogMockMvc.perform(get("/api/payment-logs/count?sort=id,desc&" + filter))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(content().string("0"));
    }


    @Test
    @Transactional
    public void getNonExistingPaymentLog() throws Exception {
        // Get the paymentLog
        restPaymentLogMockMvc.perform(get("/api/payment-logs/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updatePaymentLog() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        int databaseSizeBeforeUpdate = paymentLogRepository.findAll().size();

        // Update the paymentLog
        PaymentLog updatedPaymentLog = paymentLogRepository.findById(paymentLog.getId()).get();
        // Disconnect from session so that the updates on updatedPaymentLog are not directly saved in db
        em.detach(updatedPaymentLog);
        updatedPaymentLog
            .userName(UPDATED_USER_NAME)
            .paymentMethod(UPDATED_PAYMENT_METHOD)
            .orderId(UPDATED_ORDER_ID)
            .amount(UPDATED_AMOUNT)
            .apiName(UPDATED_API_NAME)
            .requestTime(UPDATED_REQUEST_TIME)
            .requestBody(UPDATED_REQUEST_BODY)
            .responseTime(UPDATED_RESPONSE_TIME)
            .responseBody(UPDATED_RESPONSE_BODY)
            .returnCode(UPDATED_RETURN_CODE)
            .returnMessage(UPDATED_RETURN_MESSAGE)
            .transactionId(UPDATED_TRANSACTION_ID)
            .debitBankCode(UPDATED_DEBIT_BANK_CODE)
            .debitBankAccount(UPDATED_DEBIT_BANK_ACCOUNT)
            .createdTime(UPDATED_CREATED_TIME);
        PaymentLogDTO paymentLogDTO = paymentLogMapper.toDto(updatedPaymentLog);

        restPaymentLogMockMvc.perform(put("/api/payment-logs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(paymentLogDTO)))
            .andExpect(status().isOk());

        // Validate the PaymentLog in the database
        List<PaymentLog> paymentLogList = paymentLogRepository.findAll();
        assertThat(paymentLogList).hasSize(databaseSizeBeforeUpdate);
        PaymentLog testPaymentLog = paymentLogList.get(paymentLogList.size() - 1);
        assertThat(testPaymentLog.getUserName()).isEqualTo(UPDATED_USER_NAME);
        assertThat(testPaymentLog.getPaymentMethod()).isEqualTo(UPDATED_PAYMENT_METHOD);
        assertThat(testPaymentLog.getOrderId()).isEqualTo(UPDATED_ORDER_ID);
        assertThat(testPaymentLog.getAmount()).isEqualTo(UPDATED_AMOUNT);
        assertThat(testPaymentLog.getApiName()).isEqualTo(UPDATED_API_NAME);
        assertThat(testPaymentLog.getRequestTime()).isEqualTo(UPDATED_REQUEST_TIME);
        assertThat(testPaymentLog.getRequestBody()).isEqualTo(UPDATED_REQUEST_BODY);
        assertThat(testPaymentLog.getResponseTime()).isEqualTo(UPDATED_RESPONSE_TIME);
        assertThat(testPaymentLog.getResponseBody()).isEqualTo(UPDATED_RESPONSE_BODY);
        assertThat(testPaymentLog.getReturnCode()).isEqualTo(UPDATED_RETURN_CODE);
        assertThat(testPaymentLog.getReturnMessage()).isEqualTo(UPDATED_RETURN_MESSAGE);
        assertThat(testPaymentLog.getTransactionId()).isEqualTo(UPDATED_TRANSACTION_ID);
        assertThat(testPaymentLog.getDebitBankCode()).isEqualTo(UPDATED_DEBIT_BANK_CODE);
        assertThat(testPaymentLog.getDebitBankAccount()).isEqualTo(UPDATED_DEBIT_BANK_ACCOUNT);
        assertThat(testPaymentLog.getCreatedTime()).isEqualTo(UPDATED_CREATED_TIME);
    }

    @Test
    @Transactional
    public void updateNonExistingPaymentLog() throws Exception {
        int databaseSizeBeforeUpdate = paymentLogRepository.findAll().size();

        // Create the PaymentLog
        PaymentLogDTO paymentLogDTO = paymentLogMapper.toDto(paymentLog);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restPaymentLogMockMvc.perform(put("/api/payment-logs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(paymentLogDTO)))
            .andExpect(status().isBadRequest());

        // Validate the PaymentLog in the database
        List<PaymentLog> paymentLogList = paymentLogRepository.findAll();
        assertThat(paymentLogList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deletePaymentLog() throws Exception {
        // Initialize the database
        paymentLogRepository.saveAndFlush(paymentLog);

        int databaseSizeBeforeDelete = paymentLogRepository.findAll().size();

        // Delete the paymentLog
        restPaymentLogMockMvc.perform(delete("/api/payment-logs/{id}", paymentLog.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<PaymentLog> paymentLogList = paymentLogRepository.findAll();
        assertThat(paymentLogList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
