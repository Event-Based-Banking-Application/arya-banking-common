package org.arya.banking.common.utils;

import org.apache.commons.codec.digest.DigestUtils;

import java.math.BigDecimal;
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
        }
        return false;
    }

    public static String generateSHA256hash(String hashValue) {
        return DigestUtils.sha256Hex(hashValue);
    }
}
