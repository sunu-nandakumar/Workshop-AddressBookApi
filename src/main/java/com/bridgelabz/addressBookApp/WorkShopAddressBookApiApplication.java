package com.bridgelabz.addressBookApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class WorkShopAddressBookApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkShopAddressBookApiApplication.class, args);
		log.info("Welcome to AddressBook spring boot application.");
		
	}

}
