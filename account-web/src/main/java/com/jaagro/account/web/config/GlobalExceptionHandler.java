package com.jaagro.account.web.config;

import com.jaagro.utils.BaseResponse;
import com.jaagro.utils.ResponseStatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author yj
 * 全局异常处理
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(value=MethodArgumentNotValidException.class)
    @ResponseBody
    private BaseResponse methodArgumentNotValidExceptionHandler(HttpServletRequest request, Exception ex){
        log.info("methodArgumentNotValidExceptionHandler",ex);
        //处理Validation异常
        StringBuffer errorMsg = new StringBuffer();
        MethodArgumentNotValidException c = (MethodArgumentNotValidException) ex;
        List<ObjectError> errors = c.getBindingResult().getAllErrors();
        for (ObjectError error : errors) {
            errorMsg.append(error.getDefaultMessage()).append(";");
        }
        return BaseResponse.errorInstance(ResponseStatusCode.QUERY_DATA_ERROR.getCode(), errorMsg.toString());
    }

    @ExceptionHandler(value=Exception.class)
    @ResponseBody
    private BaseResponse exceptionHandler(HttpServletRequest request, Exception ex){
        log.info("exceptionHandler",ex);
        return BaseResponse.errorInstance(ResponseStatusCode.SERVER_ERROR.getCode(), ex.getMessage());
    }

}