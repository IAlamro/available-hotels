package com.majid.availablehotels.aspect;

import com.majid.availablehotels.validator.Validate;
import com.majid.availablehotels.validator.Validator;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class ValidatorAspect {

    @Before("@annotation(validate)")
    public void before(ProceedingJoinPoint joinPoint, Validate validate){
        Class<? extends Validator>[] validators = validate.value();
        System.out.println(Arrays.toString(validators));

    }
}
