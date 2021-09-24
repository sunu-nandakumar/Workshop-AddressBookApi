package com.bridgelabz.addressBookApp.errorHandling;

import org.springframework.http.HttpStatus;

import lombok.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorMessage {
private HttpStatus status;
private String message;
}
