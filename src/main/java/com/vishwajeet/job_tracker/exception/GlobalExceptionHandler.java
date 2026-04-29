package com.vishwajeet.job_tracker.exception;

import org.springframework.web.bind.annotation.*;
import com.vishwajeet.job_tracker.response.ApiResponse;
import java.util.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ApiResponse<String> handleException(ResourceNotFoundException ex) {
        return new ApiResponse<>(false, ex.getMessage(), null);
    }
}
