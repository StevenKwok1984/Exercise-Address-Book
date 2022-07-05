package src.main.java.com.sg.addressbook.ui;

import src.main.java.com.sg.addressbook.dto.Address;

import java.util.List;

public class AddressBookView {

    private UserIO io;

    // Constructor
    public AddressBookView(UserIO io) {
        this.io = io;
    }

    public void printInitialBanner(){
        io.print("==========");
    }

    public int printMenuAndGetSelection() {
        io.print("Initial Menu:");
        io.print("1. Add Address");
        io.print("2. Delete Address");
        io.print("3. Find Address");
        io.print("4. List Address Count");
        io.print("5. List All Addresses");
        io.print("6. Exit");

        return io.readInt("Please select the operation you wish to perform:", 1, 6);
    }

    public Address getNewAddressInfo() {
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


    public void displayAddSuccessBanner() {
        io.print(". \n. \n.");
        io.readString("Address added. Press enter to go to Main Menu.");
    }

    public void displayAddressList(List<Address> addressList) {
        for (Address currentAddress : addressList) {
            String addressInfo = String.format("%s %s \n %s",
                    currentAddress.getFirstName(),
                    currentAddress.getLastName(),
                    currentAddress.getAddress());
            io.print(addressInfo);
        }
        io.readString("Press enter to continue.");
    }

    public void displayAllAddressBanner() {
        io.print("List Addresses Menu:");
    }

    public void displayAddressCount(int numOfAddress) {
        io.print("There are " + numOfAddress + " addresses in the book.  ");
        io.readString("Press enter to continue.");
    }

    public void displayCountAddressBanner() {
        io.print("List Address Count Menu:");
    }


    public void displayFindAddressBanner () {
        io.print("Find Address Menu:");
    }

    public String getLastNameChoiceFind() {
        return io.readString("Please enter last name of address to find:");
    }

    public void displayStudent(Address address) {
        if (address != null) {
            io.print(address.getFirstName() + " " + address.getLastName());
            io.print("\n "+ address.getAddress());
            io.print("");
        } else {
            io.print("No such address.");
        }
        io.readString("Press enter to continue.");
    }

    public void displayRemoveAddressBanner () {
        io.print("Delete Address Menu:");
    }

    public String getLastNameChoiceDelete() {
        return io.readString("Please enter last name of address to delete:");
    }

    public void deleteOrNot() {
        io.print("Really Delete?");
    }

    public void displayRemoveResult(Address addressRecord) {
        if(addressRecord != null){
            io.print("Address Deleted.");
        }else{
            io.print("No such address.");
        }
        io.readString("Press enter to continue.");
    }

    public void displayExitBanner() {
        io.print("See You!!!");
    }

    public void displayUnknownCommandBanner() {
        io.print("Unknown Command!!!");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }

}
