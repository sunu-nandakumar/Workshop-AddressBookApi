package com.bridgelabz.addressBookApp.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bridgelabz.addressBookApp.dto.AddressBookDTO;
import com.bridgelabz.addressBookApp.dto.ResponseDTO;
import com.bridgelabz.addressBookApp.entity.AddressBookData;
import com.bridgelabz.addressBookApp.exceptionHandling.AddressBookNotFound;
import com.bridgelabz.addressBookApp.service.IAddressBookService;


@RestController
@RequestMapping("/addressbook")
public class AddressBookController {
	
	@Autowired
	IAddressBookService service;
	;
	
	/**
     * Purpose : Ability to insert person details in Address Book.
     *
     * @param addressBookDTO 
     *
     * @return responseDTO Object of ResponseDTO which returns the status of the POST Method.
     */
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO>saveAddressBook(@Valid @RequestBody AddressBookDTO dto){
		AddressBookData entity = service.saveAddressBook(dto);
		ResponseDTO responseDTO = new ResponseDTO("AddressBook Entity saved ", entity);
		
		 return new ResponseEntity<ResponseDTO>(responseDTO , HttpStatus.CREATED );
	}
	/**
     * Purpose : Ability to fetch all person details from Address Book.
     *
     * @return responseDTO Object of ResponseDTO which returns the status of the GET Method.
     */
	@GetMapping("/getdetails")
	public ResponseEntity<ResponseDTO> getAddressBook(){
		List<AddressBookData> addressBookList = service.getAddressBook();
		ResponseDTO responseDTO = new ResponseDTO(" Retrived all data from address book ", addressBookList);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);}
	 /**
     * Purpose : Ability to fetch person details from Address Book based on a particular ID.
     *
     * @param id On providing ID, the user-input is matched with the id value of the database.
     *          
     *
     * @return responseDTO Object of ResponseDTO which returns the status of the GET Method.
     */

	@GetMapping("/getdetails/{id}") 
	public ResponseEntity<ResponseDTO> getAddressBookByID(@PathVariable("id") int id) throws AddressBookNotFound {
		AddressBookData entity = (AddressBookData)service.getAddressBookById(id);
		ResponseDTO responseDTO = new ResponseDTO(" Retrived the data from address book ", entity);
		return new ResponseEntity<>(responseDTO,HttpStatus.OK);
		}
	 /**
     * Purpose : Ability to update person details in Address Book based on a particular ID.
     *
     * @param id On providing ID, the user-input is matched with the id value of the database.
 
     *
     * @return responseDTO Object of ResponseDTO which returns the status of the PUT Method.
     */
	@PutMapping("/update/{id}")
	public ResponseEntity<ResponseDTO> updateAddressBookByID(@Valid @PathVariable("id")int id, @RequestBody AddressBookDTO dto){
	
		AddressBookData entity = (AddressBookData)  service.updateAddressBookByID(id, dto);
		ResponseDTO responseDTO = new ResponseDTO(" Updated the data from address book ", dto);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);

	
	}
	/**
     * Purpose : Ability to delete person details from Address Book based on a particular ID.
     *
     * @param id On providing ID, the user-input is matched with the id value of the database.
     *           
     * @return responseDTO Object of ResponseDTO which returns the status of the DELETE Method.
     */

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseDTO> deleteAddressbookByID(@PathVariable("id") int id){

		AddressBookData entity =  service.deleteAddressbookByID(id);
		ResponseDTO responseDTO = new ResponseDTO(" Deleted the data from address book ", entity);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);}
}
