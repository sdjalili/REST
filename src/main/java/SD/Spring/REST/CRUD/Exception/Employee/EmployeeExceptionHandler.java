package SD.Spring.REST.CRUD.Exception.Employee;

import SD.Spring.REST.CRUD.Entity.EmployeeErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class EmployeeExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handelException(EmployeeNotFoundException exp){
        EmployeeErrorResponse error = new EmployeeErrorResponse();
        error.setTimestampe(System.currentTimeMillis());
        error.setMessage(exp.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handelArgumentException(MethodArgumentTypeMismatchException exp){
        EmployeeErrorResponse error = new EmployeeErrorResponse();
        error.setTimestampe(System.currentTimeMillis());
        error.setMessage(exp.getErrorCode());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
}
