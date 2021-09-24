package com.bridgelabz.addressBookApp.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;



import lombok.*;;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressBookDTO {
	
	private int id;
	@NotEmpty(message = "Person Name cannot be null")
	@Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$", message = "Person Name Invalid")
	private String name;
	@NotEmpty(message = "Address cannot be null")
	private String address;
	@NotEmpty(message = "City cannot be null")
	private String city;
	@NotEmpty(message = "State cannot be null")
	private String state;
	@NotEmpty(message = "Zip cannot be null")
	@Pattern(regexp = "^[0-9]{6}$", message = "Person Zip Invalid")
	private String zip;
	@NotEmpty(message = " Email cannot be null")
	@Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Person Email Invaild")
	private String email;
	@NotEmpty(message = "PhoneNo cannot be null")
	@Pattern(regexp = "^[0-9]{10}$", message = "Person PhoneNo Invalid")
	private String phoneNo;
	
	

}
