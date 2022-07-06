package src.test.java;

import org.junit.jupiter.api.*;
import src.main.java.com.sg.addressbook.dao.AddressBookDao;
import src.main.java.com.sg.addressbook.dao.AddressBookDaoFileImpl;

import java.io.FileWriter;
import java.io.IOException;

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
    public void testSomeMethod() {
        fail("The test case is a prototype.");
    }

}