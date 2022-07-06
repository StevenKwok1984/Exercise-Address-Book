package src.test.java;

import org.junit.jupiter.api.*;
import src.main.java.com.sg.addressbook.dao.AddressBookDao;
import src.main.java.com.sg.addressbook.dao.AddressBookDaoException;
import src.main.java.com.sg.addressbook.dao.AddressBookDaoFileImpl;
import src.main.java.com.sg.addressbook.dto.Address;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// Strat the test
public class AddressBookDaoFileImplTest {

    AddressBookDao testDao;

    public AddressBookDaoFileImplTest() {

    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() throws IOException {
        String testFile = "addressTestFile.txt";
        // Use the FileWriter to quickly blank the file
        new FileWriter(testFile);
        testDao = new AddressBookDaoFileImpl(testFile);
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testAddGetStudent() throws AddressBookDaoException {
        // ARRANGE
        String lastName = "Trump";
        Address address = new Address(lastName);
        address.setFirstName("Marco");
        address.setAddress("17 Cauldeen Rd, Inverness IV2 4UQ");

        // ACT
        testDao.addAddress(lastName, address);
        Address retrievedAddress = testDao.getAddress(lastName);

        // ASSERT
        assertNotNull(retrievedAddress, "Error, we should get an object");
        assertEquals(address.getLastName(), retrievedAddress.getLastName(),
                "Error: the last name should be Trump");
        assertEquals(address.getFirstName(), retrievedAddress.getFirstName(),
                "Error: the first name should be Marco");
        assertEquals(address.getAddress(), retrievedAddress.getAddress(),
                "Error: the address should be '17 Cauldeen Rd, Inverness IV2 4UQ' ");
    }

    @Test
    public void testAddGetAllStudents() throws Exception {
        // ARRANGE
        // address 1
        Address firstAddress = new Address("Trump");
        firstAddress.setFirstName("Marco");
        firstAddress.setAddress("17 Cauldeen Rd, Inverness IV2 4UQ");
        // address 2
        Address secondAddress = new Address("Kong");
        secondAddress.setFirstName("Tommy");
        secondAddress.setAddress("110 St James Road, Glasgow, G4 0PS");

        // ACT
        testDao.addAddress(firstAddress.getLastName(), firstAddress);
        testDao.addAddress(secondAddress.getLastName(), secondAddress);
        List<Address> allAddresses = testDao.getAllAddresses();

        // ASSERT
        // check null or not
        assertNotNull(allAddresses, "The list of students must not null");
        // check if equals
        assertEquals(2, allAddresses.size(),"List of students should have 2 students.");

        // Then the specifics
        assertTrue(testDao.getAllAddresses().contains(firstAddress),
                "The list of students should include Trump.");
        assertTrue(testDao.getAllAddresses().contains(secondAddress),
                "The list of students should include Kong.");
    }

    @Test
    public void testAddGetCountStudents() throws Exception {
        // ARRANGE
        // address 1
        Address firstAddress = new Address("Trump");
        firstAddress.setFirstName("Marco");
        firstAddress.setAddress("17 Cauldeen Rd, Inverness IV2 4UQ");
        // address 2
        Address secondAddress = new Address("Kong");
        secondAddress.setFirstName("Tommy");
        secondAddress.setAddress("110 St James Road, Glasgow, G4 0PS");

        // ACT
        testDao.addAddress(firstAddress.getLastName(), firstAddress);
        testDao.addAddress(secondAddress.getLastName(), secondAddress);
        int numOfStudent = testDao.countAddress();

        // ASSERT
        // check if equals
        assertEquals(2, numOfStudent,"Number of student should be 2");
    }

    @Test
    public void testRemoveStudent() throws Exception {
        //ACT
        // address 1
        Address firstAddress = new Address("Trump");
        firstAddress.setFirstName("Marco");
        firstAddress.setAddress("17 Cauldeen Rd, Inverness IV2 4UQ");
        // address 2
        Address secondAddress = new Address("Kong");
        secondAddress.setFirstName("Tommy");
        secondAddress.setAddress("110 St James Road, Glasgow, G4 0PS");

        // ACT
        // Add both to the DAO
        testDao.addAddress(firstAddress.getLastName(), firstAddress);
        testDao.addAddress(secondAddress.getLastName(), secondAddress);
        // remove the first student - Trump
        Address removedAddress = testDao.removeAddress(firstAddress.getLastName());
        // Get all the address
        List<Address> allAddresses = testDao.getAllAddresses();

        //ASSERT
        // Check that the correct object was removed.
        assertEquals(removedAddress, firstAddress, "The removed student should be Ada.");
        // First check the general contents of the list
        assertNotNull(allAddresses, "All address list should be not null.");
        assertEquals( 1, allAddresses.size(), "All address should only have 1 address.");

        // Then the specifics
        assertFalse( allAddresses.contains(firstAddress), "All students should NOT include Trump.");
        assertTrue( allAddresses.contains(secondAddress), "All students should include Kong.");
    }


}