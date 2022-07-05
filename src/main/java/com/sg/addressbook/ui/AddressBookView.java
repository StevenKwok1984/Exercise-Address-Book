package src.main.java.com.sg.addressbook.ui;

import src.main.java.com.sg.addressbook.dto.Address;

public class AddressBookView {

    private UserIO io = new UserIOConsoleImpl();

    public int printMenuAndGetSelection() {

        io.print("==========");
        io.print("Initial Menu:");
        io.print("1. Add Address");
        io.print("2. Delete Address");
        io.print("3. Find Address");
        io.print("4. List Address Count");
        io.print("5. List All Addresses");
        io.print("6. Exit");

        return io.readInt("Please select the operation you wish to perform:", 1, 6);
    }

    public Address getNewStudentInfo() {
        String firstName = io.readString("Please enter First Name");
        String lastName = io.readString("Please enter Last Name:");
        String address = io.readString("Please enter Street Address:");
        Address currentAddress = new Address(lastName);
        currentAddress.setFirstName(firstName);
        currentAddress.setAddress(address);
        return currentAddress;
    }

    public void displayAddAddressBanner() {
        io.print("Add Address Menu:");
    }

}
