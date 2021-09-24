package com.bridgelabz.addressBookApp.service;

import java.util.*;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.addressBookApp.dto.AddressBookDTO;
import com.bridgelabz.addressBookApp.entity.AddressBookData;
import com.bridgelabz.addressBookApp.repository.IAddressBookRepository;

@Service
public class AddressBookService implements IAddressBookService {
	@Autowired
	private IAddressBookRepository repository;
	@Autowired
	ModelMapper modelMapper;

	/**
	 * Purpose : Ability to insert person details in Address Book.
	 *
	 * @param addressBookDTO Object of AddressBookDTO which will validate user-input
	 *                       and once valid, will pass it to the AddressBook entity.
	 *                       Finally, the user-input details gets stored in the
	 *                       Database.
	 *
	 * @return addressBookDTO Object of AddressBookDTO.
	 */
	@Override
	public AddressBookDTO saveAddressBook(AddressBookDTO dto) {
		// TODO Auto-generated method stub
		AddressBookData entity = modelMapper.map(dto, AddressBookData.class);
		repository.save(entity);
		return dto;
	}

	/**
	 * Purpose : Ability to fetch all person details from Address Book.
	 *
	 * @return List<AddressBookDTO>.
	 */

	public List<AddressBookDTO> getAddressBook() { // TODO Auto-generated methodstub
		return repository.findAll().stream().map(addressBook -> modelMapper.map(addressBook, AddressBookDTO.class))
				.collect(Collectors.toList());
	}

	/**
	 * Purpose : Ability to fetch person details from Address Book based on a
	 * particular ID.
	 *
	 * @param id On providing ID, the user-input is matched with the id value of the
	 *           database. it returns the person details from Address Book.
	 *
	 * @return addressBookResponse Object of AddressBookDTO.
	 */

	@Override
	public AddressBookDTO getAddressBookById(int id) 
	{ // TODO Auto-generated method stub
		Optional<AddressBookData> entity = repository.findById(id);
		AddressBookDTO dto = modelMapper.map(entity, AddressBookDTO.class);
		return dto;
	}

	/**
	 * Purpose : Ability to update person details in Address Book based on a
	 * particular ID.
	 *
	 * @param id             On providing ID, the user-input is matched with the id
	 *                       value of the database.
	 * 
	 *
	 * @param addressBookDTO Object of AddressBookDTO which will validate user-input
	 *                       and once valid, will pass it to the AddressBook entity.
	 *                       Finally, the user-input details gets stored in the
	 *                       Database.
	 *
	 * @return addressBookResponse Object of AddressBookDTO.
	 */

	@Override
	public AddressBookDTO updateAddressBookByID(int id, AddressBookDTO dto) {
		AddressBookData entity = repository.findById(id).get();

		String[] ignoreFields = {"id","name"};
		 BeanUtils.copyProperties(dto, entity, ignoreFields);
		 repository.save(entity);
		 AddressBookDTO updatedDTO = modelMapper.map(entity, AddressBookDTO.class);
		 return updatedDTO;
		
	}

	/**
	 * Purpose : Ability to delete person details from Address Book based on a
	 * particular ID.
	 *
	 * @param id On providing ID, the user-input is matched with the id value of the
	 *           database. it deletes the person details from Address Book.
	 *
	 * @return addressBookResponse Object of AddressBookDTO.
	 */
	
	  @Override public AddressBookDTO deleteAddressbookByID(int id) { // TODO
	  repository.deleteById(id); 
	  return null;
	  
	  }

}
