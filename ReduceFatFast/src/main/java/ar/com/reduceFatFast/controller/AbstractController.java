/**
 * 
 */
package ar.com.reduceFatFast.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import ar.com.reduceFatFast.exception.ParametrosInvalidos;

/**
 * @author Matias
 *
 */
public class AbstractController extends ResponseEntityExceptionHandler {
	
    @ExceptionHandler(value = { ParametrosInvalidos.class })
    protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = ex.getMessage();
        
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.CONFLICT, request);
    }
    
    @ExceptionHandler(value = { ObjectOptimisticLockingFailureException.class })
    protected ResponseEntity<Object> handleConflictOptimisticLocking(RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "Se esta intentó modificar un objeto que ha sido modificado previamente. Intentelo nuevamente.";
        
        return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.I_AM_A_TEAPOT, request);
    }
    
}
