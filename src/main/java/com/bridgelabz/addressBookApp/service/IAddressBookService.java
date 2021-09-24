package com.bridgelabz.addressBookApp.service;

import java.util.*;

import javax.validation.Valid;

import com.bridgelabz.addressBookApp.dto.AddressBookDTO;





public interface IAddressBookService {
	
	public AddressBookDTO saveAddressBook(@Valid AddressBookDTO dto);

	public List<AddressBookDTO> getAddressBook();

	public AddressBookDTO getAddressBookById(int id) ;

	public AddressBookDTO updateAddressBookByID(int id, AddressBookDTO dto);

	public AddressBookDTO deleteAddressbookByID(int id);




}
