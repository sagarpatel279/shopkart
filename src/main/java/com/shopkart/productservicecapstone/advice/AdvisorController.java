package com.shopkart.productservicecapstone.advice;

import com.shopkart.productservicecapstone.dtos.ErrorDto;
import com.shopkart.productservicecapstone.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.View;

@ControllerAdvice
public class AdvisorController {

    public AdvisorController(View error) {
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDto> generalizeError(){
        ErrorDto errorDto=new ErrorDto();
        errorDto.setMessage("Something went wrong");
        ResponseEntity<ErrorDto> responseEntity=new ResponseEntity<>(errorDto,HttpStatus.BAD_GATEWAY);
        return responseEntity;
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDto> productNotFoundException(ProductNotFoundException productNotFoundException){
        ErrorDto errorDto=new ErrorDto();
        errorDto.setMessage(productNotFoundException.getMessage());
        ResponseEntity<ErrorDto> responseEntity=new ResponseEntity<>(errorDto,HttpStatus.NOT_FOUND);
        return responseEntity;
    }
}
