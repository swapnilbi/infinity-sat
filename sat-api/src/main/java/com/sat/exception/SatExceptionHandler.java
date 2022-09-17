package com.sat.exception;

import com.sat.enums.RemarkType;
import com.sat.model.Remark;
import com.sat.model.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.LockedException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class SatExceptionHandler {

    private static Logger logger = LoggerFactory.getLogger(SatExceptionHandler.class);

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException exception) {
        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity(errors,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity handleBusinessException(BusinessException businessException) {
        logger.warn(businessException.getMessage());
        Response response = new Response();
        Remark remark = new Remark();
        remark.setMessage(businessException.getMessage());
        remark.setType(RemarkType.ERROR);
        response.setRemarks(Arrays.asList(remark));
        return new ResponseEntity(response,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(SecurityException.class)
    public ResponseEntity handleBadCredentialsException(SecurityException securityException) {
        logger.warn(securityException.getMessage());
        Response response = new Response();
        Remark remark = new Remark();
        remark.setMessage(securityException.getMessage());
        remark.setType(RemarkType.ERROR);
        response.setRemarks(Arrays.asList(remark));
        return new ResponseEntity(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(LockedException.class)
    public ResponseEntity handleAccessDeniedException(LockedException lockedException) {
        logger.warn(lockedException.getMessage());
        Response response = new Response();
        Remark remark = new Remark();
        remark.setMessage(lockedException.getMessage());
        remark.setType(RemarkType.ERROR);
        response.setRemarks(Arrays.asList(remark));
        return new ResponseEntity(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity handleAccessDeniedException(AccessDeniedException accessDeniedException) {
        logger.warn(accessDeniedException.getMessage());
        Response response = new Response();
        Remark remark = new Remark();
        remark.setMessage(accessDeniedException.getMessage());
        remark.setType(RemarkType.ERROR);
        response.setRemarks(Arrays.asList(remark));
        return new ResponseEntity(response,HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleGenericException(Exception businessException) {
        logger.error("Exception ",businessException);
        Response response = new Response();
        Remark remark = new Remark();
        remark.setMessage("Something went wrong. Please try again");
        remark.setType(RemarkType.ERROR);
        response.setRemarks(Arrays.asList(remark));
        return new ResponseEntity(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(SystemException.class)
    public ResponseEntity handleSystemException(SystemException systemException) {
        logger.error(systemException.getMessage());
        Response response = new Response();
        Remark remark = new Remark();
        remark.setMessage(systemException.getMessage());
        remark.setType(RemarkType.ERROR);
        response.setRemarks(Arrays.asList(remark));
        return new ResponseEntity(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
