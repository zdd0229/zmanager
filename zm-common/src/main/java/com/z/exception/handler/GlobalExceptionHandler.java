package com.z.exception.handler;

import com.z.exception.BadRequestException;
import com.z.utils.ThrowableUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<ApiError> handleException(Throwable t){
        log.error(ThrowableUtil.getStackTrace(t));
        return this.buildErrorResponse(ApiError.error(HttpStatus.INTERNAL_SERVER_ERROR.value(),t.getMessage()));
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ApiError> handleBadRequestException(BadRequestException e){
        log.error(ThrowableUtil.getStackTrace(e));
        return this.buildErrorResponse(ApiError.error(HttpStatus.BAD_REQUEST.value(),e.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        log.error(ThrowableUtil.getStackTrace(e));
        BindingResult result = e.getBindingResult();
        StringBuilder errorMessage = new StringBuilder();
        if (result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            errors.forEach(p ->{
                FieldError fieldError = (FieldError) p;
                errorMessage.append(String.format("[%s]",fieldError.getDefaultMessage()));
            });
        }
        return this.buildErrorResponse(ApiError.error(HttpStatus.BAD_REQUEST.value(),errorMessage.toString()));
    }

    private ResponseEntity<ApiError> buildErrorResponse(ApiError error) {
        return new ResponseEntity<ApiError>(error, HttpStatus.valueOf(error.getStatus()));
    }

}
