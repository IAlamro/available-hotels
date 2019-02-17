package com.majid.availablehotels.converter;

import com.sun.istack.internal.NotNull;

public interface Converter<T, R> {
    R convert(@NotNull T t);
}
