package org.skh.web.rest;

import org.skh.AppDataApp;
import org.skh.domain.log.RegistrationLog;
import org.skh.repository.log.RegistrationLogRepository;
import org.skh.service.RegistrationLogService;
import org.skh.service.dto.RegistrationLogDTO;
import org.skh.service.mapper.RegistrationLogMapper;
import org.skh.web.rest.errors.ExceptionTranslator;

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
import java.time.ZonedDateTime;
import java.time.ZoneOffset;
import java.time.ZoneId;
import java.util.List;

import static org.skh.web.rest.TestUtil.sameInstant;
import static org.skh.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link RegistrationLogResource} REST controller.
 */
@SpringBootTest(classes = AppDataApp.class)
public class RegistrationLogResourceIT {

    private static final String DEFAULT_DEVICE_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_DEVICE_TYPE = "BBBBBBBBBB";

    private static final ZonedDateTime DEFAULT_CREATED_TIME = ZonedDateTime.ofInstant(Instant.ofEpochMilli(0L), ZoneOffset.UTC);
    private static final ZonedDateTime UPDATED_CREATED_TIME = ZonedDateTime.now(ZoneId.systemDefault()).withNano(0);

    private static final String DEFAULT_REQ_PERSONAL_NO = "AAAAAAAAAA";
    private static final String UPDATED_REQ_PERSONAL_NO = "BBBBBBBBBB";

    private static final String DEFAULT_REQ_BIRTHDAY = "AAAAAAAAAA";
    private static final String UPDATED_REQ_BIRTHDAY = "BBBBBBBBBB";

    private static final String DEFAULT_REQ_VISIT_DATE = "AAAAAAAAAA";
    private static final String UPDATED_REQ_VISIT_DATE = "BBBBBBBBBB";

    private static final String DEFAULT_REQ_SHIFT_CODE = "AAAAAAAAAA";
    private static final String UPDATED_REQ_SHIFT_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_REQ_DIVISION_CODE = "AAAAAAAAAA";
    private static final String UPDATED_REQ_DIVISION_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_REQ_CLINIC_CODE = "AAAAAAAAAA";
    private static final String UPDATED_REQ_CLINIC_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_REQ_DOCTOR_EMP_NO = "AAAAAAAAAA";
    private static final String UPDATED_REQ_DOCTOR_EMP_NO = "BBBBBBBBBB";

    private static final String DEFAULT_REQ_IS_PUBLIC_NAME = "AAAAAAAAAA";
    private static final String UPDATED_REQ_IS_PUBLIC_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_REQ_IS_BYPASS_FIRST_VISIT_CHECK = "AAAAAAAAAA";
    private static final String UPDATED_REQ_IS_BYPASS_FIRST_VISIT_CHECK = "BBBBBBBBBB";

    private static final String DEFAULT_RES_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_RES_STATUS = "BBBBBBBBBB";

    private static final String DEFAULT_RES_TITLE = "AAAAAAAAAA";
    private static final String UPDATED_RES_TITLE = "BBBBBBBBBB";

    private static final String DEFAULT_RES_PATH = "AAAAAAAAAA";
    private static final String UPDATED_RES_PATH = "BBBBBBBBBB";

    private static final String DEFAULT_RES_MESSAGE = "AAAAAAAAAA";
    private static final String UPDATED_RES_MESSAGE = "BBBBBBBBBB";

    private static final String DEFAULT_RES_BIRTHDAY = "AAAAAAAAAA";
    private static final String UPDATED_RES_BIRTHDAY = "BBBBBBBBBB";

    private static final String DEFAULT_RES_PATIENT_NAME = "AAAAAAAAAA";
    private static final String UPDATED_RES_PATIENT_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_RES_ID_NO = "AAAAAAAAAA";
    private static final String UPDATED_RES_ID_NO = "BBBBBBBBBB";

    private static final String DEFAULT_RES_MEDICAL_NOTE_NO = "AAAAAAAAAA";
    private static final String UPDATED_RES_MEDICAL_NOTE_NO = "BBBBBBBBBB";

    private static final String DEFAULT_RES_DIVISION_CODE = "AAAAAAAAAA";
    private static final String UPDATED_RES_DIVISION_CODE = "BBBBBBBBBB";

    private static final String DEFAULT_RES_DIVISION_NAME = "AAAAAAAAAA";
    private static final String UPDATED_RES_DIVISION_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_RES_DOCTOR_EMP_NO = "AAAAAAAAAA";
    private static final String UPDATED_RES_DOCTOR_EMP_NO = "BBBBBBBBBB";

    private static final String DEFAULT_RES_DOCTOR_NAME = "AAAAAAAAAA";
    private static final String UPDATED_RES_DOCTOR_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_RES_VISIT_DATE = "AAAAAAAAAA";
    private static final String UPDATED_RES_VISIT_DATE = "BBBBBBBBBB";

    private static final String DEFAULT_RES_DISPLAY_VISIT_DATE_SHIFT = "AAAAAAAAAA";
    private static final String UPDATED_RES_DISPLAY_VISIT_DATE_SHIFT = "BBBBBBBBBB";

    private static final String DEFAULT_RES_DISPLAY_CLINIC_NAME_CATEGORY = "AAAAAAAAAA";
    private static final String UPDATED_RES_DISPLAY_CLINIC_NAME_CATEGORY = "BBBBBBBBBB";

    private static final String DEFAULT_RES_VISIT_SEQ_NO = "AAAAAAAAAA";
    private static final String UPDATED_RES_VISIT_SEQ_NO = "BBBBBBBBBB";

    private static final String DEFAULT_RES_SUGGESTED_ARRIVAL_TIME = "AAAAAAAAAA";
    private static final String UPDATED_RES_SUGGESTED_ARRIVAL_TIME = "BBBBBBBBBB";

    @Autowired
    private RegistrationLogRepository registrationLogRepository;

    @Autowired
    private RegistrationLogMapper registrationLogMapper;

    @Autowired
    private RegistrationLogService registrationLogService;

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

    private MockMvc restRegistrationLogMockMvc;

    private RegistrationLog registrationLog;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final RegistrationLogResource registrationLogResource = new RegistrationLogResource(registrationLogService);
        this.restRegistrationLogMockMvc = MockMvcBuilders.standaloneSetup(registrationLogResource)
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
    public static RegistrationLog createEntity(EntityManager em) {
        RegistrationLog registrationLog = new RegistrationLog()
            .deviceType(DEFAULT_DEVICE_TYPE)
            .createdTime(DEFAULT_CREATED_TIME)
            .reqPersonalNo(DEFAULT_REQ_PERSONAL_NO)
            .reqBirthday(DEFAULT_REQ_BIRTHDAY)
            .reqVisitDate(DEFAULT_REQ_VISIT_DATE)
            .reqShiftCode(DEFAULT_REQ_SHIFT_CODE)
            .reqDivisionCode(DEFAULT_REQ_DIVISION_CODE)
            .reqClinicCode(DEFAULT_REQ_CLINIC_CODE)
            .reqDoctorEmpNo(DEFAULT_REQ_DOCTOR_EMP_NO)
            .reqIsPublicName(DEFAULT_REQ_IS_PUBLIC_NAME)
            .reqIsBypassFirstVisitCheck(DEFAULT_REQ_IS_BYPASS_FIRST_VISIT_CHECK)
            .resStatus(DEFAULT_RES_STATUS)
            .resTitle(DEFAULT_RES_TITLE)
            .resPath(DEFAULT_RES_PATH)
            .resMessage(DEFAULT_RES_MESSAGE)
            .resBirthday(DEFAULT_RES_BIRTHDAY)
            .resPatientName(DEFAULT_RES_PATIENT_NAME)
            .resIdNo(DEFAULT_RES_ID_NO)
            .resMedicalNoteNo(DEFAULT_RES_MEDICAL_NOTE_NO)
            .resDivisionCode(DEFAULT_RES_DIVISION_CODE)
            .resDivisionName(DEFAULT_RES_DIVISION_NAME)
            .resDoctorEmpNo(DEFAULT_RES_DOCTOR_EMP_NO)
            .resDoctorName(DEFAULT_RES_DOCTOR_NAME)
            .resVisitDate(DEFAULT_RES_VISIT_DATE)
            .resDisplayVisitDateShift(DEFAULT_RES_DISPLAY_VISIT_DATE_SHIFT)
            .resDisplayClinicNameCategory(DEFAULT_RES_DISPLAY_CLINIC_NAME_CATEGORY)
            .resVisitSeqNo(DEFAULT_RES_VISIT_SEQ_NO)
            .resSuggestedArrivalTime(DEFAULT_RES_SUGGESTED_ARRIVAL_TIME);
        return registrationLog;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static RegistrationLog createUpdatedEntity(EntityManager em) {
        RegistrationLog registrationLog = new RegistrationLog()
            .deviceType(UPDATED_DEVICE_TYPE)
            .createdTime(UPDATED_CREATED_TIME)
            .reqPersonalNo(UPDATED_REQ_PERSONAL_NO)
            .reqBirthday(UPDATED_REQ_BIRTHDAY)
            .reqVisitDate(UPDATED_REQ_VISIT_DATE)
            .reqShiftCode(UPDATED_REQ_SHIFT_CODE)
            .reqDivisionCode(UPDATED_REQ_DIVISION_CODE)
            .reqClinicCode(UPDATED_REQ_CLINIC_CODE)
            .reqDoctorEmpNo(UPDATED_REQ_DOCTOR_EMP_NO)
            .reqIsPublicName(UPDATED_REQ_IS_PUBLIC_NAME)
            .reqIsBypassFirstVisitCheck(UPDATED_REQ_IS_BYPASS_FIRST_VISIT_CHECK)
            .resStatus(UPDATED_RES_STATUS)
            .resTitle(UPDATED_RES_TITLE)
            .resPath(UPDATED_RES_PATH)
            .resMessage(UPDATED_RES_MESSAGE)
            .resBirthday(UPDATED_RES_BIRTHDAY)
            .resPatientName(UPDATED_RES_PATIENT_NAME)
            .resIdNo(UPDATED_RES_ID_NO)
            .resMedicalNoteNo(UPDATED_RES_MEDICAL_NOTE_NO)
            .resDivisionCode(UPDATED_RES_DIVISION_CODE)
            .resDivisionName(UPDATED_RES_DIVISION_NAME)
            .resDoctorEmpNo(UPDATED_RES_DOCTOR_EMP_NO)
            .resDoctorName(UPDATED_RES_DOCTOR_NAME)
            .resVisitDate(UPDATED_RES_VISIT_DATE)
            .resDisplayVisitDateShift(UPDATED_RES_DISPLAY_VISIT_DATE_SHIFT)
            .resDisplayClinicNameCategory(UPDATED_RES_DISPLAY_CLINIC_NAME_CATEGORY)
            .resVisitSeqNo(UPDATED_RES_VISIT_SEQ_NO)
            .resSuggestedArrivalTime(UPDATED_RES_SUGGESTED_ARRIVAL_TIME);
        return registrationLog;
    }

    @BeforeEach
    public void initTest() {
        registrationLog = createEntity(em);
    }

    @Test
    @Transactional
    public void createRegistrationLog() throws Exception {
        int databaseSizeBeforeCreate = registrationLogRepository.findAll().size();

        // Create the RegistrationLog
        RegistrationLogDTO registrationLogDTO = registrationLogMapper.toDto(registrationLog);
        restRegistrationLogMockMvc.perform(post("/api/registration-logs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(registrationLogDTO)))
            .andExpect(status().isCreated());

        // Validate the RegistrationLog in the database
        List<RegistrationLog> registrationLogList = registrationLogRepository.findAll();
        assertThat(registrationLogList).hasSize(databaseSizeBeforeCreate + 1);
        RegistrationLog testRegistrationLog = registrationLogList.get(registrationLogList.size() - 1);
        assertThat(testRegistrationLog.getDeviceType()).isEqualTo(DEFAULT_DEVICE_TYPE);
        assertThat(testRegistrationLog.getCreatedTime()).isEqualTo(DEFAULT_CREATED_TIME);
        assertThat(testRegistrationLog.getReqPersonalNo()).isEqualTo(DEFAULT_REQ_PERSONAL_NO);
        assertThat(testRegistrationLog.getReqBirthday()).isEqualTo(DEFAULT_REQ_BIRTHDAY);
        assertThat(testRegistrationLog.getReqVisitDate()).isEqualTo(DEFAULT_REQ_VISIT_DATE);
        assertThat(testRegistrationLog.getReqShiftCode()).isEqualTo(DEFAULT_REQ_SHIFT_CODE);
        assertThat(testRegistrationLog.getReqDivisionCode()).isEqualTo(DEFAULT_REQ_DIVISION_CODE);
        assertThat(testRegistrationLog.getReqClinicCode()).isEqualTo(DEFAULT_REQ_CLINIC_CODE);
        assertThat(testRegistrationLog.getReqDoctorEmpNo()).isEqualTo(DEFAULT_REQ_DOCTOR_EMP_NO);
        assertThat(testRegistrationLog.getReqIsPublicName()).isEqualTo(DEFAULT_REQ_IS_PUBLIC_NAME);
        assertThat(testRegistrationLog.getReqIsBypassFirstVisitCheck()).isEqualTo(DEFAULT_REQ_IS_BYPASS_FIRST_VISIT_CHECK);
        assertThat(testRegistrationLog.getResStatus()).isEqualTo(DEFAULT_RES_STATUS);
        assertThat(testRegistrationLog.getResTitle()).isEqualTo(DEFAULT_RES_TITLE);
        assertThat(testRegistrationLog.getResPath()).isEqualTo(DEFAULT_RES_PATH);
        assertThat(testRegistrationLog.getResMessage()).isEqualTo(DEFAULT_RES_MESSAGE);
        assertThat(testRegistrationLog.getResBirthday()).isEqualTo(DEFAULT_RES_BIRTHDAY);
        assertThat(testRegistrationLog.getResPatientName()).isEqualTo(DEFAULT_RES_PATIENT_NAME);
        assertThat(testRegistrationLog.getResIdNo()).isEqualTo(DEFAULT_RES_ID_NO);
        assertThat(testRegistrationLog.getResMedicalNoteNo()).isEqualTo(DEFAULT_RES_MEDICAL_NOTE_NO);
        assertThat(testRegistrationLog.getResDivisionCode()).isEqualTo(DEFAULT_RES_DIVISION_CODE);
        assertThat(testRegistrationLog.getResDivisionName()).isEqualTo(DEFAULT_RES_DIVISION_NAME);
        assertThat(testRegistrationLog.getResDoctorEmpNo()).isEqualTo(DEFAULT_RES_DOCTOR_EMP_NO);
        assertThat(testRegistrationLog.getResDoctorName()).isEqualTo(DEFAULT_RES_DOCTOR_NAME);
        assertThat(testRegistrationLog.getResVisitDate()).isEqualTo(DEFAULT_RES_VISIT_DATE);
        assertThat(testRegistrationLog.getResDisplayVisitDateShift()).isEqualTo(DEFAULT_RES_DISPLAY_VISIT_DATE_SHIFT);
        assertThat(testRegistrationLog.getResDisplayClinicNameCategory()).isEqualTo(DEFAULT_RES_DISPLAY_CLINIC_NAME_CATEGORY);
        assertThat(testRegistrationLog.getResVisitSeqNo()).isEqualTo(DEFAULT_RES_VISIT_SEQ_NO);
        assertThat(testRegistrationLog.getResSuggestedArrivalTime()).isEqualTo(DEFAULT_RES_SUGGESTED_ARRIVAL_TIME);
    }

    @Test
    @Transactional
    public void createRegistrationLogWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = registrationLogRepository.findAll().size();

        // Create the RegistrationLog with an existing ID
        registrationLog.setId(1L);
        RegistrationLogDTO registrationLogDTO = registrationLogMapper.toDto(registrationLog);

        // An entity with an existing ID cannot be created, so this API call must fail
        restRegistrationLogMockMvc.perform(post("/api/registration-logs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(registrationLogDTO)))
            .andExpect(status().isBadRequest());

        // Validate the RegistrationLog in the database
        List<RegistrationLog> registrationLogList = registrationLogRepository.findAll();
        assertThat(registrationLogList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllRegistrationLogs() throws Exception {
        // Initialize the database
        registrationLogRepository.saveAndFlush(registrationLog);

        // Get all the registrationLogList
        restRegistrationLogMockMvc.perform(get("/api/registration-logs?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(registrationLog.getId().intValue())))
            .andExpect(jsonPath("$.[*].deviceType").value(hasItem(DEFAULT_DEVICE_TYPE)))
            .andExpect(jsonPath("$.[*].createdTime").value(hasItem(sameInstant(DEFAULT_CREATED_TIME))))
            .andExpect(jsonPath("$.[*].reqPersonalNo").value(hasItem(DEFAULT_REQ_PERSONAL_NO)))
            .andExpect(jsonPath("$.[*].reqBirthday").value(hasItem(DEFAULT_REQ_BIRTHDAY)))
            .andExpect(jsonPath("$.[*].reqVisitDate").value(hasItem(DEFAULT_REQ_VISIT_DATE)))
            .andExpect(jsonPath("$.[*].reqShiftCode").value(hasItem(DEFAULT_REQ_SHIFT_CODE)))
            .andExpect(jsonPath("$.[*].reqDivisionCode").value(hasItem(DEFAULT_REQ_DIVISION_CODE)))
            .andExpect(jsonPath("$.[*].reqClinicCode").value(hasItem(DEFAULT_REQ_CLINIC_CODE)))
            .andExpect(jsonPath("$.[*].reqDoctorEmpNo").value(hasItem(DEFAULT_REQ_DOCTOR_EMP_NO)))
            .andExpect(jsonPath("$.[*].reqIsPublicName").value(hasItem(DEFAULT_REQ_IS_PUBLIC_NAME)))
            .andExpect(jsonPath("$.[*].reqIsBypassFirstVisitCheck").value(hasItem(DEFAULT_REQ_IS_BYPASS_FIRST_VISIT_CHECK)))
            .andExpect(jsonPath("$.[*].resStatus").value(hasItem(DEFAULT_RES_STATUS)))
            .andExpect(jsonPath("$.[*].resTitle").value(hasItem(DEFAULT_RES_TITLE)))
            .andExpect(jsonPath("$.[*].resPath").value(hasItem(DEFAULT_RES_PATH)))
            .andExpect(jsonPath("$.[*].resMessage").value(hasItem(DEFAULT_RES_MESSAGE)))
            .andExpect(jsonPath("$.[*].resBirthday").value(hasItem(DEFAULT_RES_BIRTHDAY)))
            .andExpect(jsonPath("$.[*].resPatientName").value(hasItem(DEFAULT_RES_PATIENT_NAME)))
            .andExpect(jsonPath("$.[*].resIdNo").value(hasItem(DEFAULT_RES_ID_NO)))
            .andExpect(jsonPath("$.[*].resMedicalNoteNo").value(hasItem(DEFAULT_RES_MEDICAL_NOTE_NO)))
            .andExpect(jsonPath("$.[*].resDivisionCode").value(hasItem(DEFAULT_RES_DIVISION_CODE)))
            .andExpect(jsonPath("$.[*].resDivisionName").value(hasItem(DEFAULT_RES_DIVISION_NAME)))
            .andExpect(jsonPath("$.[*].resDoctorEmpNo").value(hasItem(DEFAULT_RES_DOCTOR_EMP_NO)))
            .andExpect(jsonPath("$.[*].resDoctorName").value(hasItem(DEFAULT_RES_DOCTOR_NAME)))
            .andExpect(jsonPath("$.[*].resVisitDate").value(hasItem(DEFAULT_RES_VISIT_DATE)))
            .andExpect(jsonPath("$.[*].resDisplayVisitDateShift").value(hasItem(DEFAULT_RES_DISPLAY_VISIT_DATE_SHIFT)))
            .andExpect(jsonPath("$.[*].resDisplayClinicNameCategory").value(hasItem(DEFAULT_RES_DISPLAY_CLINIC_NAME_CATEGORY)))
            .andExpect(jsonPath("$.[*].resVisitSeqNo").value(hasItem(DEFAULT_RES_VISIT_SEQ_NO)))
            .andExpect(jsonPath("$.[*].resSuggestedArrivalTime").value(hasItem(DEFAULT_RES_SUGGESTED_ARRIVAL_TIME)));
    }

    @Test
    @Transactional
    public void getRegistrationLog() throws Exception {
        // Initialize the database
        registrationLogRepository.saveAndFlush(registrationLog);

        // Get the registrationLog
        restRegistrationLogMockMvc.perform(get("/api/registration-logs/{id}", registrationLog.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(registrationLog.getId().intValue()))
            .andExpect(jsonPath("$.deviceType").value(DEFAULT_DEVICE_TYPE))
            .andExpect(jsonPath("$.createdTime").value(sameInstant(DEFAULT_CREATED_TIME)))
            .andExpect(jsonPath("$.reqPersonalNo").value(DEFAULT_REQ_PERSONAL_NO))
            .andExpect(jsonPath("$.reqBirthday").value(DEFAULT_REQ_BIRTHDAY))
            .andExpect(jsonPath("$.reqVisitDate").value(DEFAULT_REQ_VISIT_DATE))
            .andExpect(jsonPath("$.reqShiftCode").value(DEFAULT_REQ_SHIFT_CODE))
            .andExpect(jsonPath("$.reqDivisionCode").value(DEFAULT_REQ_DIVISION_CODE))
            .andExpect(jsonPath("$.reqClinicCode").value(DEFAULT_REQ_CLINIC_CODE))
            .andExpect(jsonPath("$.reqDoctorEmpNo").value(DEFAULT_REQ_DOCTOR_EMP_NO))
            .andExpect(jsonPath("$.reqIsPublicName").value(DEFAULT_REQ_IS_PUBLIC_NAME))
            .andExpect(jsonPath("$.reqIsBypassFirstVisitCheck").value(DEFAULT_REQ_IS_BYPASS_FIRST_VISIT_CHECK))
            .andExpect(jsonPath("$.resStatus").value(DEFAULT_RES_STATUS))
            .andExpect(jsonPath("$.resTitle").value(DEFAULT_RES_TITLE))
            .andExpect(jsonPath("$.resPath").value(DEFAULT_RES_PATH))
            .andExpect(jsonPath("$.resMessage").value(DEFAULT_RES_MESSAGE))
            .andExpect(jsonPath("$.resBirthday").value(DEFAULT_RES_BIRTHDAY))
            .andExpect(jsonPath("$.resPatientName").value(DEFAULT_RES_PATIENT_NAME))
            .andExpect(jsonPath("$.resIdNo").value(DEFAULT_RES_ID_NO))
            .andExpect(jsonPath("$.resMedicalNoteNo").value(DEFAULT_RES_MEDICAL_NOTE_NO))
            .andExpect(jsonPath("$.resDivisionCode").value(DEFAULT_RES_DIVISION_CODE))
            .andExpect(jsonPath("$.resDivisionName").value(DEFAULT_RES_DIVISION_NAME))
            .andExpect(jsonPath("$.resDoctorEmpNo").value(DEFAULT_RES_DOCTOR_EMP_NO))
            .andExpect(jsonPath("$.resDoctorName").value(DEFAULT_RES_DOCTOR_NAME))
            .andExpect(jsonPath("$.resVisitDate").value(DEFAULT_RES_VISIT_DATE))
            .andExpect(jsonPath("$.resDisplayVisitDateShift").value(DEFAULT_RES_DISPLAY_VISIT_DATE_SHIFT))
            .andExpect(jsonPath("$.resDisplayClinicNameCategory").value(DEFAULT_RES_DISPLAY_CLINIC_NAME_CATEGORY))
            .andExpect(jsonPath("$.resVisitSeqNo").value(DEFAULT_RES_VISIT_SEQ_NO))
            .andExpect(jsonPath("$.resSuggestedArrivalTime").value(DEFAULT_RES_SUGGESTED_ARRIVAL_TIME));
    }

    @Test
    @Transactional
    public void getNonExistingRegistrationLog() throws Exception {
        // Get the registrationLog
        restRegistrationLogMockMvc.perform(get("/api/registration-logs/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateRegistrationLog() throws Exception {
        // Initialize the database
        registrationLogRepository.saveAndFlush(registrationLog);

        int databaseSizeBeforeUpdate = registrationLogRepository.findAll().size();

        // Update the registrationLog
        RegistrationLog updatedRegistrationLog = registrationLogRepository.findById(registrationLog.getId()).get();
        // Disconnect from session so that the updates on updatedRegistrationLog are not directly saved in db
        em.detach(updatedRegistrationLog);
        updatedRegistrationLog
            .deviceType(UPDATED_DEVICE_TYPE)
            .createdTime(UPDATED_CREATED_TIME)
            .reqPersonalNo(UPDATED_REQ_PERSONAL_NO)
            .reqBirthday(UPDATED_REQ_BIRTHDAY)
            .reqVisitDate(UPDATED_REQ_VISIT_DATE)
            .reqShiftCode(UPDATED_REQ_SHIFT_CODE)
            .reqDivisionCode(UPDATED_REQ_DIVISION_CODE)
            .reqClinicCode(UPDATED_REQ_CLINIC_CODE)
            .reqDoctorEmpNo(UPDATED_REQ_DOCTOR_EMP_NO)
            .reqIsPublicName(UPDATED_REQ_IS_PUBLIC_NAME)
            .reqIsBypassFirstVisitCheck(UPDATED_REQ_IS_BYPASS_FIRST_VISIT_CHECK)
            .resStatus(UPDATED_RES_STATUS)
            .resTitle(UPDATED_RES_TITLE)
            .resPath(UPDATED_RES_PATH)
            .resMessage(UPDATED_RES_MESSAGE)
            .resBirthday(UPDATED_RES_BIRTHDAY)
            .resPatientName(UPDATED_RES_PATIENT_NAME)
            .resIdNo(UPDATED_RES_ID_NO)
            .resMedicalNoteNo(UPDATED_RES_MEDICAL_NOTE_NO)
            .resDivisionCode(UPDATED_RES_DIVISION_CODE)
            .resDivisionName(UPDATED_RES_DIVISION_NAME)
            .resDoctorEmpNo(UPDATED_RES_DOCTOR_EMP_NO)
            .resDoctorName(UPDATED_RES_DOCTOR_NAME)
            .resVisitDate(UPDATED_RES_VISIT_DATE)
            .resDisplayVisitDateShift(UPDATED_RES_DISPLAY_VISIT_DATE_SHIFT)
            .resDisplayClinicNameCategory(UPDATED_RES_DISPLAY_CLINIC_NAME_CATEGORY)
            .resVisitSeqNo(UPDATED_RES_VISIT_SEQ_NO)
            .resSuggestedArrivalTime(UPDATED_RES_SUGGESTED_ARRIVAL_TIME);
        RegistrationLogDTO registrationLogDTO = registrationLogMapper.toDto(updatedRegistrationLog);

        restRegistrationLogMockMvc.perform(put("/api/registration-logs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(registrationLogDTO)))
            .andExpect(status().isOk());

        // Validate the RegistrationLog in the database
        List<RegistrationLog> registrationLogList = registrationLogRepository.findAll();
        assertThat(registrationLogList).hasSize(databaseSizeBeforeUpdate);
        RegistrationLog testRegistrationLog = registrationLogList.get(registrationLogList.size() - 1);
        assertThat(testRegistrationLog.getDeviceType()).isEqualTo(UPDATED_DEVICE_TYPE);
        assertThat(testRegistrationLog.getCreatedTime()).isEqualTo(UPDATED_CREATED_TIME);
        assertThat(testRegistrationLog.getReqPersonalNo()).isEqualTo(UPDATED_REQ_PERSONAL_NO);
        assertThat(testRegistrationLog.getReqBirthday()).isEqualTo(UPDATED_REQ_BIRTHDAY);
        assertThat(testRegistrationLog.getReqVisitDate()).isEqualTo(UPDATED_REQ_VISIT_DATE);
        assertThat(testRegistrationLog.getReqShiftCode()).isEqualTo(UPDATED_REQ_SHIFT_CODE);
        assertThat(testRegistrationLog.getReqDivisionCode()).isEqualTo(UPDATED_REQ_DIVISION_CODE);
        assertThat(testRegistrationLog.getReqClinicCode()).isEqualTo(UPDATED_REQ_CLINIC_CODE);
        assertThat(testRegistrationLog.getReqDoctorEmpNo()).isEqualTo(UPDATED_REQ_DOCTOR_EMP_NO);
        assertThat(testRegistrationLog.getReqIsPublicName()).isEqualTo(UPDATED_REQ_IS_PUBLIC_NAME);
        assertThat(testRegistrationLog.getReqIsBypassFirstVisitCheck()).isEqualTo(UPDATED_REQ_IS_BYPASS_FIRST_VISIT_CHECK);
        assertThat(testRegistrationLog.getResStatus()).isEqualTo(UPDATED_RES_STATUS);
        assertThat(testRegistrationLog.getResTitle()).isEqualTo(UPDATED_RES_TITLE);
        assertThat(testRegistrationLog.getResPath()).isEqualTo(UPDATED_RES_PATH);
        assertThat(testRegistrationLog.getResMessage()).isEqualTo(UPDATED_RES_MESSAGE);
        assertThat(testRegistrationLog.getResBirthday()).isEqualTo(UPDATED_RES_BIRTHDAY);
        assertThat(testRegistrationLog.getResPatientName()).isEqualTo(UPDATED_RES_PATIENT_NAME);
        assertThat(testRegistrationLog.getResIdNo()).isEqualTo(UPDATED_RES_ID_NO);
        assertThat(testRegistrationLog.getResMedicalNoteNo()).isEqualTo(UPDATED_RES_MEDICAL_NOTE_NO);
        assertThat(testRegistrationLog.getResDivisionCode()).isEqualTo(UPDATED_RES_DIVISION_CODE);
        assertThat(testRegistrationLog.getResDivisionName()).isEqualTo(UPDATED_RES_DIVISION_NAME);
        assertThat(testRegistrationLog.getResDoctorEmpNo()).isEqualTo(UPDATED_RES_DOCTOR_EMP_NO);
        assertThat(testRegistrationLog.getResDoctorName()).isEqualTo(UPDATED_RES_DOCTOR_NAME);
        assertThat(testRegistrationLog.getResVisitDate()).isEqualTo(UPDATED_RES_VISIT_DATE);
        assertThat(testRegistrationLog.getResDisplayVisitDateShift()).isEqualTo(UPDATED_RES_DISPLAY_VISIT_DATE_SHIFT);
        assertThat(testRegistrationLog.getResDisplayClinicNameCategory()).isEqualTo(UPDATED_RES_DISPLAY_CLINIC_NAME_CATEGORY);
        assertThat(testRegistrationLog.getResVisitSeqNo()).isEqualTo(UPDATED_RES_VISIT_SEQ_NO);
        assertThat(testRegistrationLog.getResSuggestedArrivalTime()).isEqualTo(UPDATED_RES_SUGGESTED_ARRIVAL_TIME);
    }

    @Test
    @Transactional
    public void updateNonExistingRegistrationLog() throws Exception {
        int databaseSizeBeforeUpdate = registrationLogRepository.findAll().size();

        // Create the RegistrationLog
        RegistrationLogDTO registrationLogDTO = registrationLogMapper.toDto(registrationLog);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restRegistrationLogMockMvc.perform(put("/api/registration-logs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(registrationLogDTO)))
            .andExpect(status().isBadRequest());

        // Validate the RegistrationLog in the database
        List<RegistrationLog> registrationLogList = registrationLogRepository.findAll();
        assertThat(registrationLogList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteRegistrationLog() throws Exception {
        // Initialize the database
        registrationLogRepository.saveAndFlush(registrationLog);

        int databaseSizeBeforeDelete = registrationLogRepository.findAll().size();

        // Delete the registrationLog
        restRegistrationLogMockMvc.perform(delete("/api/registration-logs/{id}", registrationLog.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<RegistrationLog> registrationLogList = registrationLogRepository.findAll();
        assertThat(registrationLogList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
