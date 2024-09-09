package com.example.springFirst1.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.springFirst1.dtos.ExceptionsDto;
import com.example.springFirst1.extensions.ProductNotFoundException;

//Global exception handler
@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ExceptionsDto> handleArithmeticException(Exception e) {
        ExceptionsDto exceptionsDto = new ExceptionsDto();
        exceptionsDto.setMessage("Arithmetic Exception");
        exceptionsDto.setResolution("Check the division by zero");
        ResponseEntity<ExceptionsDto> responseEntity = new ResponseEntity<>(exceptionsDto,HttpStatus.INTERNAL_SERVER_ERROR);
        return responseEntity;
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<ExceptionsDto> handleArrayIndexOutOfBoundsException(Exception e) {
        ExceptionsDto exceptionsDto = new ExceptionsDto();
        exceptionsDto.setMessage("Array Index Out Of Bounds Exception");
        exceptionsDto.setResolution("Check the array index");
        ResponseEntity<ExceptionsDto> responseEntity = new ResponseEntity<>(exceptionsDto,HttpStatus.SERVICE_UNAVAILABLE);
        return responseEntity;
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionsDto> handleProductNotFoundException(ProductNotFoundException e) {
        //is we want we can pass seperate Dto for each exception like ProductNotFoundExceptionDto
        ExceptionsDto exceptionsDto = new ExceptionsDto();
        exceptionsDto.setMessage("Exception: Product with id: "+e.getId()+" Not Found ");
        exceptionsDto.setResolution("Check the product id");
        ResponseEntity<ExceptionsDto> responseEntity = new ResponseEntity<>(exceptionsDto,HttpStatus.SERVICE_UNAVAILABLE);
        return responseEntity;
    }

    //VVI:: default exception handler
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionsDto> handleHttpClientErrorException(Exception e) {
        ExceptionsDto exceptionsDto = new ExceptionsDto();
        exceptionsDto.setMessage("Default  Error Exception");
        exceptionsDto.setResolution("Check the Code");
        ResponseEntity<ExceptionsDto> responseEntity = new ResponseEntity<>(exceptionsDto,HttpStatus.SERVICE_UNAVAILABLE);
        return responseEntity;
    }
    
    
}
