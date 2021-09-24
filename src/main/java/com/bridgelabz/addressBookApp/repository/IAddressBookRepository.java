package com.bridgelabz.addressBookApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.addressBookApp.dto.AddressBookDTO;
import com.bridgelabz.addressBookApp.entity.AddressBookData;


@Repository
public interface IAddressBookRepository extends JpaRepository<AddressBookData, Integer> {

}
