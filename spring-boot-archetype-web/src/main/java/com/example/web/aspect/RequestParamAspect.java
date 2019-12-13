package com.example.web.aspect;

import com.example.common.validation.MyValidator;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

/**
 * this class used to validate parameters in spring controllers.
 *
 * to make sure it works, you must use @Validated annotations and declare a BindingResult Object.
 * for example :
 * public ResponseDTO query(@Validated({ValidationMarker.SelectGroup.class}) AppInfoRequestDTO requestDTO, BindingResult result) {
 *
 * }
 *
 * @date 2017/7/24
 * @author netyjq@gmail.com
 */
@Aspect
@Component
public class RequestParamAspect {

    /**
     * 对切面 BindingResult类型参数进行校验，基于Hibernate MyValidator
     * @throws Throwable exception
     */
    @Before("execution(* com.example.web.controller.*.*(..))")
    public void doBefore(JoinPoint joinPoint) {
        Object [] args = joinPoint.getArgs();
        for (Object object : args) {
            if (object instanceof BindingResult) {
                BindingResult result = (BindingResult) object;
                MyValidator.validateBindResult(result);
            }
        }
    }
}
