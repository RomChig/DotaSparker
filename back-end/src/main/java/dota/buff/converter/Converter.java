package dota.buff.converter;

import java.util.List;
import java.util.stream.Collectors;

public interface Converter<S, T> {
    /**
     * Convert the source object of type {@code S} to target type {@code T}.
     */
    T convert(S source);

    default List<T> convertList(List<S> sourceList) {
        return sourceList.stream()
                .map(this::convert)
                .collect(Collectors.toList());
    }
}
