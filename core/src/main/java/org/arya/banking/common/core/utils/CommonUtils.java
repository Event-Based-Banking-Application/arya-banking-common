package org.arya.banking.common.core.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.arya.banking.common.core.config.SpringContextHolder;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CommonUtils {

    public static <K, V> Map<K, V> convertListIntoMap(List<V> list, Function<V, K> keyExtractor) {

        return list.stream().collect(Collectors.toMap(keyExtractor, Function.identity()));
    }

    public static boolean isNotEmpty(Object value){
        return !isEmpty(value);
    }

    public static boolean isEmpty(Object value) {

        if(null == value) return true;
        else {
            if(value instanceof String s) return s.isBlank();
            if(value instanceof List<?> l) return l.isEmpty();
            if(value instanceof BigDecimal bc) return bc.toString().isBlank();
            if (value instanceof Map<?,?> mp) return mp.isEmpty();
        }
        return false;
    }

    public static String generateSHA256hash(String hashValue) {
        return DigestUtils.sha256Hex(hashValue);
    }

    public static String loadConfig(String path) throws IOException {

        Resource resource = SpringContextHolder.getResource("classpath:"+path);

        try (InputStream is = resource.getInputStream()){
            return new String(is.readAllBytes(), StandardCharsets.UTF_8);
        }
    }
}
