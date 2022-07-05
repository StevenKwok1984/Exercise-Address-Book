package src.main.java.com.sg.addressbook.dao;

import src.main.java.com.sg.addressbook.dto.Address;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddressBookDaoFileImpl implements AddressBookDao{

    private Map<String, Address> addresses = new HashMap<>();

    @Override
    public Address addAddress(String lastName, Address address) {
        Address prevAddress = addresses.put(lastName, address);
        return prevAddress;
    }

    @Override
    public List<Address> getAllAddress() {
        return new HashMap<String, Address>(addresses.keySet(), addresses.values());
    }

    @Override
    public Address getAddress(String lastName) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Address removeStudent(String lastName) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Address> countAddress() {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
