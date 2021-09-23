package com.bridgelabz.AddressBookApp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bridgelabz.AddressBookApp.dto.AddressBookDTO;
import com.bridgelabz.AddressBookApp.dto.ResponseDTO;




@RestController
@RequestMapping("/addressbookapp")
public class AdressBookController {
	/**
     * Purpose : Ability to insert person details in Address Book.
     *
     * @param addressBookDTO 
     *
     * @return responseDTO Object of ResponseDTO which returns the status of the POST Method.
     */
	@PostMapping("/create")
	public ResponseEntity<String>saveAddressBook(@RequestBody AddressBookDTO dto){
	
	
		
		 return new ResponseEntity<String>("AddressBook Entity saved " ,HttpStatus.CREATED );
	
	}
	/**
     * Purpose : Ability to fetch all person details from Address Book.
     *
     * @return responseDTO Object of ResponseDTO which returns the status of the GET Method.
     */
	@GetMapping("/getdetails")
	public ResponseEntity<String> getAddressBook(){
		
		
		return new ResponseEntity<String>(" Retrived all data from address book ",HttpStatus.OK);
	}
	 /**
     * Purpose : Ability to fetch person details from Address Book based on a particular ID.
     *
     * @param id On providing ID, the user-input is matched with the id value of the database.
     *          
     *
     * @return responseDTO Object of ResponseDTO which returns the status of the GET Method.
     */

	@GetMapping("/getdetails/{id}") 
	public ResponseEntity<String> getAddressBookByID(@PathVariable("id") int id){
	
		return new ResponseEntity<String>(" Retrived the data from address book ",HttpStatus.OK);
	}
	 /**
     * Purpose : Ability to update person details in Address Book based on a particular ID.
     *
     * @param id On providing ID, the user-input is matched with the id value of the database.
 
     *
     * @return responseDTO Object of ResponseDTO which returns the status of the PUT Method.
     */
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateAddressBookByID(@PathVariable("id")int id, @RequestBody AddressBookDTO dto){
	
		return new ResponseEntity<String>(" Updated the data from address book ",HttpStatus.OK);
		
	}
	/**
     * Purpose : Ability to delete person details from Address Book based on a particular ID.
     *
     * @param id On providing ID, the user-input is matched with the id value of the database.
     *           
     * @return responseDTO Object of ResponseDTO which returns the status of the DELETE Method.
     */

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteAddressbookByID(@PathVariable("id") int id){

		return new ResponseEntity<String>(" Deleted the data from address book ",HttpStatus.OK);
	}
	
}
