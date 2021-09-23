package com.bridgelabz.addressBookApp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDTO {
	private String message;
	 private Object data;
}
