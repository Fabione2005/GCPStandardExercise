package com.standard.gcp.controller.exceptionHandler;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.standard.gcp.exception.BusinessException;
import com.standard.gcp.exception.GenericException;
import com.standard.gcp.exception.InvalidInfoException;
import com.standard.gcp.exception.RegisterNotFoundException;
import com.standard.gcp.model.generic.BaseResult;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = { GenericException.class, InvalidInfoException.class,RegisterNotFoundException.class
			,Exception.class })
	protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
		BaseResult resultMessage = new BaseResult();
		HttpStatus httpStatus = null;
		if (ex instanceof BusinessException) {
			GenericException exceptionResult = (GenericException) ex;
			httpStatus = exceptionResult.getStatus();
			resultMessage = new BaseResult(exceptionResult.getMessage());
		}else if (ex instanceof TransactionSystemException) {
			if (ex.getCause() instanceof ConstraintViolationException) {
				ConstraintViolationException constraintViolationException = (ConstraintViolationException) ex
						.getCause();
				httpStatus = HttpStatus.BAD_REQUEST;
				resultMessage = new BaseResult(constraintViolationException.getMessage());
			}

		}else {
			resultMessage = new BaseResult("UNKNOWN SERVER ERROR");
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return handleExceptionInternal(ex, resultMessage, new HttpHeaders(), httpStatus, request);
	}
	
	 @ExceptionHandler(TransactionSystemException.class)
	  ResponseEntity<?> handleConstraintViolationException(TransactionSystemException e) {
		  List<BaseResult> errorList = new ArrayList<>();
		  
		  if (e.getRootCause() instanceof ConstraintViolationException) {
		        ConstraintViolationException constraintViolationException = (ConstraintViolationException) e.getRootCause();
		        
		        constraintViolationException.getConstraintViolations().stream()
		        .forEach(item -> {
		        	errorList.add(new BaseResult(item.getMessage()));
		        });
		        logger.error(e.getMessage());
		        
		  }
		
		 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorList);
	  }
}
