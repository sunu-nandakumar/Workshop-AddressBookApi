package com.bridgelabz.AddressBookApp.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.bridgelabz.AddressBookApp.DTO.AddressBookDTO;
import com.bridgelabz.AddressBookApp.DTO.ResponseDTO;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {
	/**
	 * Purpose : Ability to insert person details in Address Book.
	 *
	 * @param addressBookDTO
	 *
	 * @return responseDTO Object of ResponseDTO which returns the status of the
	 *         POST Method.
	 */
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> saveAddressBook(@RequestBody AddressBookDTO dto) {
		ResponseDTO responseDTO = new ResponseDTO("AddressBook Entity saved ", dto);
		return new ResponseEntity<ResponseDTO>(responseDTO , HttpStatus.CREATED);

	}

	/**
	 * Purpose : Ability to fetch all person details from Address Book.
	 *
	 * @return responseDTO Object of ResponseDTO which returns the status of the GET
	 *         Method.
	 */
	@GetMapping("/getdetails")
	public ResponseEntity<ResponseDTO> getAddressBook() {

		
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * Purpose : Ability to fetch person details from Address Book based on a
	 * particular ID.
	 *
	 * @param id On providing ID, the user-input is matched with the id value of the
	 *           database.
	 * 
	 *
	 * @return responseDTO Object of ResponseDTO which returns the status of the GET
	 *         Method.
	 */

	@GetMapping("/getdetails/{id}")
	public ResponseEntity<ResponseDTO> getAddressBookByID(@PathVariable("id") int id) {

		return new ResponseEntity<ResponseDTO>(HttpStatus.OK);
	}

	/**
	 * Purpose : Ability to update person details in Address Book based on a
	 * particular ID.
	 *
	 * @param id On providing ID, the user-input is matched with the id value of the
	 *           database.
	 *
	 * 
	 * @return responseDTO Object of ResponseDTO which returns the status of the PUT
	 *         Method.
	 */
	@PutMapping("/update/{id}")
	public ResponseEntity<ResponseDTO> updateAddressBookByID(@PathVariable("id") int id,
			@RequestBody AddressBookDTO dto) {
		ResponseDTO responseDTO = new ResponseDTO("AddressBook Entity saved ", dto);
		return new ResponseEntity<ResponseDTO>(responseDTO,HttpStatus.OK);

	}

	/**
	 * Purpose : Ability to delete person details from Address Book based on a
	 * particular ID.
	 *
	 * @param id On providing ID, the user-input is matched with the id value of the
	 *           database.
	 * 
	 * @return responseDTO Object of ResponseDTO which returns the status of the
	 *         DELETE Method.
	 */

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseDTO> deleteAddressbookByID(@PathVariable("id") int id) {

		return new ResponseEntity<ResponseDTO>(HttpStatus.OK);
	}

}
