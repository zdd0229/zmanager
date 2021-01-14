package com.z.exception.handler;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
public class ApiError {

    private Integer status = HttpStatus.BAD_REQUEST.value();

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime timestamp;

    private String message;

    public ApiError(){
        timestamp=LocalDateTime.now();
    }

    public static ApiError error(String message){

        ApiError apiError = new ApiError();
        apiError.setMessage(message);

        return apiError;
    }

    public static ApiError error(Integer status,String message){

        ApiError apiError = ApiError.error(message);
        apiError.setStatus(status);

        return apiError;
    }

}
