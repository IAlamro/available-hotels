package com.majid.availablehotels;

import lombok.*;

import java.util.Arrays;

public interface RestClient<R> {
    R sendRequest(QueryParameter... queryParameters);

    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    public static class QueryParameter {
        @Setter
        @Getter
        private String name;
        @Getter
        private Object[] values;

        public void setValues(Object... values) {
            this.values = values;
        }

        public String toString() {
            return name + "=" + Arrays.toString(values);
        }
    }
}
