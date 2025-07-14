package org.arya.banking.common.utils;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CommonUtils {

    public static <K, V> Map<K, V> convertListIntoMap(List<V> list, Function<V, K> keyExtractor) {

        return list.stream().collect(Collectors.toMap(keyExtractor, Function.identity()));
    }
}
