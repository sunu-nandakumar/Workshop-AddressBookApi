package com.bridgelabz.addressBookApp.exceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.bridgelabz.addressBookApp.dto.ResponseDTO;
import java.util.List;
import java.util.stream.Collectors;


@ControllerAdvice
public class AddressBookExceptionHandler {

	 /**
     * Purpose : Ability to handle RuntimeException.
     * @param exception
     * @return
     */

    @ExceptionHandler(AddressBookException.class)
    public ResponseEntity<ResponseDTO> handleAddressBookException(AddressBookException exception) {
       
        ResponseDTO responseDTO = new ResponseDTO("Exception while processing REST Request",
                                                                                            exception.getMessage());
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }
    /**
     * Purpose : Ability to handle Exception when the argument value is not passed properly.
     * @param exception
     * @return
     */

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> handleMethodArgumentNotValidException (MethodArgumentNotValidException exception) {
       
        List<ObjectError> errorList = exception.getBindingResult().getAllErrors();
        List<String> errMsg = errorList.stream()
                .map(objErr -> objErr.getDefaultMessage())
                .collect(Collectors.toList());
        ResponseDTO responseDTO = new ResponseDTO("Exception while processing REST Request", errMsg);
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }
}
