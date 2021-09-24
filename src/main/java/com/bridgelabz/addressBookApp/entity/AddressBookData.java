package com.bridgelabz.addressBookApp.entity;

import javax.persistence.*;

//import com.bridgelabz.addressBookApp.dto.AddressBookDTO;

import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressBookData {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String email;
    private String phoneNo;
    
	
}
