package com.bridgelabz.addressBookApp.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.addressBookApp.dto.AddressBookDTO;
import com.bridgelabz.addressBookApp.entity.AddressBookData;
import com.bridgelabz.addressBookApp.errorHandling.AddressBookNotFound;

import com.bridgelabz.addressBookApp.repository.IAddressBookRepository;

@Service
public class AddressBookService implements IAddressBookService {
	@Autowired
	private IAddressBookRepository repository;

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
	public AddressBookData saveAddressBook(AddressBookDTO dto) {
		// TODO Auto-generated method stub
		AddressBookData entity = new AddressBookData(dto);
		return repository.save(entity);
	}

	/**
	 * Purpose : Ability to fetch all person details from Address Book.
	 *
	 * @return List<AddressBookDTO>.
	 */
	public List<AddressBookData> getAddressBook() {
		// TODO Auto-generated method stub
		return repository.findAll();
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
	public AddressBookData getAddressBookById(int id) throws AddressBookNotFound {
		// TODO Auto-generated method stub
		Optional<AddressBookData> entity = repository.findById(id);
		if (!entity.isPresent()) {
			throw new AddressBookNotFound("Address book not found in the DB");
		}
		return entity.get();
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
	public AddressBookData updateAddressBookByID(int id, AddressBookDTO dto) {
		AddressBookData entity = repository.findById(id).get();

		if (Objects.nonNull(dto.getName()) && !"".equalsIgnoreCase(dto.getName())) {
			entity.setName(dto.getName());
		}

		if (Objects.nonNull(dto.getAddress()) && !"".equalsIgnoreCase(dto.getAddress())) {
			entity.setAddress(dto.getAddress());
		}

		if (Objects.nonNull(dto.getCity()) && !"".equalsIgnoreCase(dto.getCity())) {
			entity.setCity(dto.getCity());
		}

		if (Objects.nonNull(dto.getState()) && !"".equalsIgnoreCase(dto.getState())) {
			entity.setState(dto.getState());
		}

		if (Objects.nonNull(dto.getZip()) && !"".equalsIgnoreCase(dto.getZip()))
			entity.setZip(dto.getZip());

		if (Objects.nonNull(dto.getEmail()) && !"".equalsIgnoreCase(dto.getEmail()))
			entity.setEmail(dto.getEmail());

		if (Objects.nonNull(dto.getPhoneNo()) && !"".equalsIgnoreCase(dto.getPhoneNo()))
			entity.setPhoneNo(dto.getPhoneNo());

		return repository.save(entity);
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
	@Override
	public AddressBookData deleteAddressbookByID(int id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
		return null;

	}
}
