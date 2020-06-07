package com.ydbzs.util;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidateUtils {
    public static Map<String,String> getError(BindingResult result){
        Map<String,String> allErr = new HashMap<>();
        List<FieldError> fieldErrors = result.getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            String field = fieldError.getField();
            String defaultMessage = fieldError.getDefaultMessage();
            allErr.put(field,defaultMessage);
        }
        return allErr;
    }
}
