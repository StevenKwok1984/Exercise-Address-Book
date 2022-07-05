package src.main.java.com.sg.addressbook.dao;

import src.main.java.com.sg.addressbook.dto.Address;

import java.io.*;
import java.util.*;

public class AddressBookDaoFileImpl implements AddressBookDao{


    public static final String ADDRESS_FILE = "address.txt";
    public static final String DELIMITER = "::";

    Map<String, Address> addresses = new HashMap<String, Address>();

    @Override
    public Address addAddress(String lastName, Address address) throws AddressBookDaoException {
        loadAddress();
        Address newAddress = addresses.put(lastName, address);
        writeAddress();
        return newAddress;
    }

    @Override
    public List<Address> getAllAddresses() throws AddressBookDaoException {
        loadAddress();
        return new ArrayList<Address>(addresses.values());
    }

    @Override
    public Address getAddress(String lastName) throws AddressBookDaoException {
        loadAddress();
        return addresses.get(lastName);
    }

    @Override
    public Address removeAddress(String lastName) throws AddressBookDaoException {
        loadAddress();
        Address removedAddress = addresses.remove(lastName);
        writeAddress();
        return removedAddress;
    }

    @Override
    public int countAddress() throws AddressBookDaoException {
        loadAddress();
        ArrayList<Address> addressArrayList = new ArrayList<Address>(addresses.values());
        int numOfAddress = addressArrayList.size();
        return numOfAddress;
    }

    private Address unmarshallAddress(String addressAsText){

        String[] studentTokens = addressAsText.split(DELIMITER);

        String lastName = studentTokens[1];

        Address addressFromFile = new Address(lastName);

        addressFromFile.setFirstName(studentTokens[0]);

        addressFromFile.setAddress(studentTokens[2]);

        return addressFromFile;
    }

    private void loadAddress() throws AddressBookDaoException {
        Scanner scanner;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(ADDRESS_FILE)));
        } catch (FileNotFoundException e) {
            throw new AddressBookDaoException(
                    "-_- Could not load roster data into memory.", e);
        }
        // currentLine holds the most recent line read from the file
        String currentLine;
        // currentStudent holds the most recent student unmarshalled
        Address currentAddress;
        // Go through ROSTER_FILE line by line, decoding each line into a
        // Student object by calling the unmarshallStudent method.
        // Process while we have more lines in the file
        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // unmarshall the line into a Student
            currentAddress = unmarshallAddress(currentLine);

            // We are going to use the student id as the map key for our student object.
            // Put currentStudent into the map using student id as the key
            addresses.put(currentAddress.getLastName(), currentAddress);
        }
        // close scanner
        scanner.close();
    }

    private String marshallAddress(Address anAddress){

        String addressAsText = anAddress.getFirstName() + DELIMITER;

        addressAsText += anAddress.getLastName() + DELIMITER;

        addressAsText += anAddress.getAddress();

        return addressAsText;
    }

    /**
     * Writes all students in the roster out to a ROSTER_FILE.  See loadRoster
     * for file format.
     *
     * @throws  if an error occurs writing to the file
     */
    private void writeAddress() throws AddressBookDaoException {
        // NOTE FOR APPRENTICES: We are not handling the IOException - but
        // we are translating it to an application specific exception and
        // then simple throwing it (i.e. 'reporting' it) to the code that
        // called us.  It is the responsibility of the calling code to
        // handle any errors that occur.
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ADDRESS_FILE));
        } catch (IOException e) {
            throw new AddressBookDaoException(
                    "Could not save student data.", e);
        }

        // Write out the Student objects to the roster file.
        // NOTE TO THE APPRENTICES: We could just grab the student map,
        // get the Collection of Students and iterate over them but we've
        // already created a method that gets a List of Students so
        // we'll reuse it.
        String addressAsText;
        List<Address> addressList = this.getAllAddresses();
        for (Address currentAddress : addressList) {
            // turn a Student into a String
            addressAsText = marshallAddress(currentAddress);
            // write the Student object to the file
            out.println(addressAsText);
            // force PrintWriter to write line to the file
            out.flush();
        }
        // Clean up
        out.close();
    }

}
