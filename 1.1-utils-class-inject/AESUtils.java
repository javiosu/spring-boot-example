package org.skh.security;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.skh.config.ApplicationProperties;
import org.skh.utils.JacksonUtils;
import org.springframework.stereotype.Component;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@Slf4j
@Component
public final class AESUtils {

    private static final String CIPHER_ALGORITHM_CBC = "AES/CBC/PKCS5Padding";
    private static final String DEFAULT_PROPERTY = "info";
    private static ApplicationProperties.AESConfiguration configuration;
    private static IvParameterSpec iv;

    private AESUtils() {
    }

    public static void setConfiguration(ApplicationProperties.AESConfiguration configuration) {
        AESUtils.configuration = configuration;
        iv = new IvParameterSpec(AESUtils.configuration.getIv().getBytes(StandardCharsets.UTF_8));
    }

    public static Map<String, String> encryptToResponse(Object result) {
        Map encryptedObject = new HashMap();
        AESUtils.encrypt(JacksonUtils.toJson(result).orElse(""), AESUtils.Type.REQUEST)
            .ifPresent(
                response -> encryptedObject.put(DEFAULT_PROPERTY, response)
            );
        return encryptedObject;
    }

    public static Optional<String> encrypt(String sSrc, Type type) {
        Optional<String> key = getKey(type);
        if (key.isPresent()) {
            return encrypt(sSrc, key.get());
        } else {
            return Optional.empty();
        }
    }

    private static Optional<String> getKey(Type type) {
        Optional<String> key;
        if (type == Type.BIOMETRIC) {
            key = Optional.ofNullable(configuration.getBiometric());
        } else {
            key = Optional.ofNullable(configuration.getRequest());
        }
        return key;
    }

    public static Optional<String> encrypt(String sSrc, String sKey) {
        try {
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM_CBC);
            cipher.init(Cipher.ENCRYPT_MODE, getSecretKeySpec(sKey), iv);
            byte[] encrypted = cipher.doFinal(sSrc.getBytes(StandardCharsets.UTF_8));
            return Optional.of(new Base64().encodeToString(encrypted));
        } catch (NoSuchAlgorithmException | InvalidKeyException | InvalidAlgorithmParameterException | NoSuchPaddingException | IllegalBlockSizeException | BadPaddingException e) {
            log.error("encrypt failed", e);
            return Optional.empty();
        }
    }

    public static Optional<String> decrypt(String sSrc, Type type) {
        Optional<String> key = getKey(type);
        if (key.isPresent()) {
            return decrypt(sSrc, key.get());
        } else {
            return Optional.empty();
        }
    }

    public static Optional<String> decrypt(String sSrc, String sKey) {
        try {
            SecretKeySpec secretKeySpec = getSecretKeySpec(sKey);
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM_CBC);
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, iv);
            byte[] encrypted1 = new Base64().decode(sSrc);
            byte[] original = cipher.doFinal(encrypted1);
            return Optional.of(new String(original, StandardCharsets.UTF_8));
        } catch (Exception ex) {
            log.error("decrypt failed.", ex);
            return Optional.empty();
        }
    }

    private static SecretKeySpec getSecretKeySpec(String sKey) {
        byte[] raw = sKey.getBytes(StandardCharsets.UTF_8);
        return new SecretKeySpec(raw, "AES");
    }

    public enum Type {
        REQUEST, BIOMETRIC
    }
}
