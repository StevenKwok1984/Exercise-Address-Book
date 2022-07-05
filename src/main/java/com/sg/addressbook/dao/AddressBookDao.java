package src.main.java.com.sg.addressbook.dao;

import src.main.java.com.sg.addressbook.dto.Address;

import java.util.List;

public interface AddressBookDao {

    Address addAddress(String lastName, Address address);

    List<Address> getAllAddress();

    Address getAddress(String lastName);

    Address removeStudent(String lastName);

    List<Address> countAddress();
}
