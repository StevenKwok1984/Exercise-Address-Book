package src.main.java.com.sg.addressbook.dao;

import src.main.java.com.sg.addressbook.dto.Address;

import java.util.List;
import java.util.Map;

public interface AddressBookDao {

    Address addAddress(String lastName, Address address);


    List<Address> getAllAddresses();

    Address getAddress(String lastName);

    Address removeAddress(String lastName);

    int countAddress();
}
