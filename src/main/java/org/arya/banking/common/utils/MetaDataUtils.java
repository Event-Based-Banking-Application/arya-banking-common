package org.arya.banking.common.utils;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.arya.banking.common.metadata.ColumnMetadata;

import java.lang.reflect.Field;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MetaDataUtils {

    private static final String MAJOR = "MAJOR";
    private static final String MINOR = "MINOR";
    private static final String PATCH = "PATCH";

    public Map<String, Object> extractValidationRules(Field field) {

        Map<String, Object> validationRules = new HashMap<>();

        Arrays.stream(field.getAnnotations()).forEach(annotation -> {
            switch (annotation.annotationType().getSimpleName()) {
                case "NotNull", "Nullable":
                    validationRules.put(annotation.annotationType().getSimpleName(), "true");
                    break;
                case "Size":
                    Size sizeAnnotation = field.getAnnotation(Size.class);
                    validationRules.put("minLength", sizeAnnotation.min());
                    validationRules.put("maxLength", sizeAnnotation.max());
                    break;
                case "Email":
                    Email email = field.getAnnotation(Email.class);
                    validationRules.put("Email Pattern", email.regexp());
                    break;
                case "Pattern":
                    Pattern pattern = field.getAnnotation(Pattern.class);
                    validationRules.put("Regex Patter", pattern.regexp());
                    break;
            }
        });

        return validationRules;
    }

    public String generateHash(String schema) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hash = messageDigest.digest(schema.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

    }

    public String generateVersion(List<ColumnMetadata> newColumnMetaData, List<ColumnMetadata> oldColumnMetaData, String version, String oldSchemaHash, String newSchemaHash) {

        String[] versionParts = version.split("\\.");
        int major = Integer.parseInt(versionParts[0]);
        int minor = Integer.parseInt(versionParts[1]);
        int patch = Integer.parseInt(versionParts[2]);
        switch (getVersionString(newColumnMetaData, oldColumnMetaData, oldSchemaHash, newSchemaHash)) {
            case MAJOR:
                major++;
                minor = 0;
                patch = 0;
                break;
            case MINOR:
                minor++;
                patch = 0;
                break;
            case PATCH:
                patch++;
                break;
        }
        return major + "." + minor + "." + patch;
    }

    private String getVersionString(List<ColumnMetadata> newColumnMetaData, List<ColumnMetadata> oldColumnMetaData, String oldSchemaHash, String newSchemaHash) {

        Map<String, ColumnMetadata> newColumnMetaDataMap = CommonUtils.convertListIntoMap(newColumnMetaData, ColumnMetadata::getColumnName);
        Map<String, ColumnMetadata> oldColumnMetaDataMap = CommonUtils.convertListIntoMap(oldColumnMetaData, ColumnMetadata::getColumnName);

        boolean hasPatchChange = false;

        for(String key: oldColumnMetaDataMap.keySet()) {

            ColumnMetadata oldColumnData = oldColumnMetaDataMap.get(key);
            ColumnMetadata newColumnData = newColumnMetaDataMap.get(key);

            if(null == newColumnData || !newColumnData.getDataType().equals(oldColumnData.getDataType())) {
                return MAJOR;
            }

            if(Boolean.compare(newColumnData.isNullable(), oldColumnData.isNullable()) != 0) {
                hasPatchChange = true;
            }
        }

        for(String key: newColumnMetaDataMap.keySet()) {
            if (!oldColumnMetaDataMap.containsKey(key))
                return MINOR;
        }


        if(hasPatchChange || !oldSchemaHash.equals(newSchemaHash)) {
            return PATCH;
        } else {
            throw new RuntimeException("");
        }


    }
}
