package com.bridgelabz.addressBookApp.service;

import java.util.*;


import com.bridgelabz.addressBookApp.dto.AddressBookDTO;
import com.bridgelabz.addressBookApp.entity.AddressBookData;



public interface IAddressBookService {
	
	public AddressBookData saveAddressBook(AddressBookDTO abDTO);

	public List<AddressBookData> getAddressBook();

	public AddressBookData getAddressBookById(int id);

	public AddressBookData updateAddressBookByID(int id, AddressBookDTO dto);

	public AddressBookData deleteAddressbookByID(int id);




}
