package org.example.converter;

import java.util.Optional;

public interface Converter<T, Z> {
    Optional<T> convert(Z value);
}
