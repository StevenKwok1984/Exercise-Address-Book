package src.main.java.com.sg.addressbook.dao;

import src.main.java.com.sg.addressbook.dto.Address;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddressBookDaoFileImpl implements AddressBookDao{


    public static final String ADDRESS_FILE = "address.txt";
    public static final String DELIMITER = "::";

    @Override
    public Address addAddress(String lastName, Address address) {
        Address prevAddress = addresses.put(lastName, address);
        return prevAddress;
    }

    @Override
    public List<Address> getAllAddresses() {
        return new ArrayList<Address>(addresses.values());
    }

    @Override
    public Address getAddress(String lastName) {
        return addresses.get(lastName);
    }

    @Override
    public Address removeAddress(String lastName) {
        Address removedAddress = addresses.remove(lastName);
        return removedAddress;
    }

    @Override
    public int countAddress() {
        ArrayList<Address> addressArrayList = new ArrayList<Address>(addresses.values());
        int numOfAddress = addressArrayList.size();
        return numOfAddress;
    }

    private Address unmarshallStudent(String addressAsText){

        String[] studentTokens = addressAsText.split(DELIMITER);

        // Given the pattern above, the student Id is in index 0 of the array.
        String studentId = studentTokens[0];

        // Which we can then use to create a new Student object to satisfy
        // the requirements of the Student constructor.
        Student studentFromFile = new Student(studentId);

        // However, there are 3 remaining tokens that need to be set into the
        // new student object. Do this manually by using the appropriate setters.

        // Index 1 - FirstName
        studentFromFile.setFirstName(studentTokens[1]);

        // Index 2 - LastName
        studentFromFile.setLastName(studentTokens[2]);

        // Index 3 - Cohort
        studentFromFile.setCohort(studentTokens[3]);

        // We have now created a student! Return it!
        return studentFromFile;
    }


}
