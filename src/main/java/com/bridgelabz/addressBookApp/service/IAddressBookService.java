package com.bridgelabz.addressBookApp.service;

import java.util.*;


import com.bridgelabz.addressBookApp.dto.AddressBookDTO;
import com.bridgelabz.addressBookApp.entity.AddressBookData;
import com.bridgelabz.addressBookApp.errorHandling.AddressBookNotFound;




public interface IAddressBookService {
	
	public AddressBookData saveAddressBook(AddressBookDTO abDTO);

	public List<AddressBookData> getAddressBook();

	public AddressBookData getAddressBookById(int id) throws AddressBookNotFound;

	public AddressBookData updateAddressBookByID(int id, AddressBookDTO dto);

	public AddressBookData deleteAddressbookByID(int id);




}
