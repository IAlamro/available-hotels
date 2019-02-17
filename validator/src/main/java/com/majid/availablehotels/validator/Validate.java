package com.majid.availablehotels.validator;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
public @interface Validate {

    Class<? extends Validator>[] value();
}
