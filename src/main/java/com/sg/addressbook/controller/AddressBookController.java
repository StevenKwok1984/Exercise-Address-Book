package src.main.java.com.sg.addressbook.controller;

import src.main.java.com.sg.addressbook.dao.AddressBookDao;
import src.main.java.com.sg.addressbook.dao.AddressBookDaoFileImpl;
import src.main.java.com.sg.addressbook.dto.Address;
import src.main.java.com.sg.addressbook.ui.AddressBookView;
import src.main.java.com.sg.addressbook.ui.UserIO;
import src.main.java.com.sg.addressbook.ui.UserIOConsoleImpl;

import java.util.List;

public class AddressBookController {

    private AddressBookView view;
    private AddressBookDao dao;;

    // Constructor
    public AddressBookController(AddressBookDao dao, AddressBookView view) {
        this.dao = dao;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        view.printInitialBanner();

        while (keepGoing) {

            menuSelection = getMenuSelection();

            switch (menuSelection) {
                case 1:
                    addAddress();
                    break;
                case 2:
                    removeAddress();
                    break;
                case 3:
                    viewAddress();
                    break;
                case 4:
                    displayNumOfAddress();
                    break;
                case 5:
                    listAddresses();
                    break;
                case 6:
                    keepGoing = false;
                    break;
                default:
                    unknownCommand();
            }

        }
        exitMessage();
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void addAddress() {
        view.displayAddAddressBanner();
        Address newAddress = view.getNewAddressInfo();
        dao.addAddress(newAddress.getLastName(), newAddress);
        view.displayAddSuccessBanner();
    }

    private void listAddresses() {
        view.displayAllAddressBanner();
        List<Address> addressList = dao.getAllAddresses();
        view.displayAddressList(addressList);
    }

    private void displayNumOfAddress() {
        view.displayCountAddressBanner();
        int num = dao.countAddress();
        view.displayAddressCount(num);
    }


    private void viewAddress() {
        view.displayFindAddressBanner();
        String lastName = view.getLastNameChoiceFind();
        Address address = dao.getAddress(lastName);
        view.displayStudent(address);
    }

    public void removeAddress() {
        view.displayRemoveAddressBanner();
        String lastName = view.getLastNameChoiceDelete();
        view.deleteOrNot();
        Address removedAddress = dao.removeAddress(lastName);
        view.displayRemoveResult(removedAddress);
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

}


