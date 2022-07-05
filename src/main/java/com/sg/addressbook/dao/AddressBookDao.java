package src.main.java.com.sg.addressbook.dao;

import src.main.java.com.sg.addressbook.dto.Address;

import java.util.List;
import java.util.Map;

public interface AddressBookDao {

    Address addAddress(String lastName, Address address) throws AddressBookDaoException;


    List<Address> getAllAddresses() throws AddressBookDaoException;

    Address getAddress(String lastName) throws AddressBookDaoException;

    Address removeAddress(String lastName) throws AddressBookDaoException;

    int countAddress() throws AddressBookDaoException;
}
