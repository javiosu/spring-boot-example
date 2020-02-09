package org.skh.config;

import org.skh.security.AESUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

/**
 * Properties specific to App Gateway.
 * <p>
 * Properties are configured in the {@code application.yml} file.
 * See {@link io.github.jhipster.config.JHipsterProperties} for a good example.
 */
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {
    public final AESConfiguration aes = new AESConfiguration();
    public final CaptchaSettings recaptcha = new CaptchaSettings();

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new FormHttpMessageConverter());
        return restTemplate;
    }

    public AESConfiguration getAes() {
        return aes;
    }

    public CaptchaSettings getRecaptcha() {
        return recaptcha;
    }

    @PostConstruct
    public void init() {
        AESUtils.setConfiguration(aes);
    }

    public static class AESConfiguration {

        private String iv;

        private String request;

        private String biometric;

        public String getIv() {
            return iv;
        }

        public void setIv(String iv) {
            this.iv = iv;
        }

        public String getRequest() {
            return request;
        }

        public void setRequest(String request) {
            this.request = request;
        }

        public String getBiometric() {
            return biometric;
        }

        public void setBiometric(String biometric) {
            this.biometric = biometric;
        }
    }

    public static class CaptchaSettings {
        private String androidSecret;
        private String checkboxSecret;
        private String verifyUrl;
        private String siteKey;

        public String getAndroidSecret() {
            return androidSecret;
        }

        public void setAndroidSecret(String androidSecret) {
            this.androidSecret = androidSecret;
        }

        public String getCheckboxSecret() {
            return checkboxSecret;
        }

        public void setCheckboxSecret(String checkboxSecret) {
            this.checkboxSecret = checkboxSecret;
        }

        public String getVerifyUrl() {
            return verifyUrl;
        }

        public void setVerifyUrl(String verifyUrl) {
            this.verifyUrl = verifyUrl;
        }

        public String getSiteKey() {
            return siteKey;
        }

        public void setSiteKey(String siteKey) {
            this.siteKey = siteKey;
        }
    }
}
