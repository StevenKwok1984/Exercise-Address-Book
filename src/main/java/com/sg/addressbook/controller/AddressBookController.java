package src.main.java.com.sg.addressbook.controller;

import src.main.java.com.sg.addressbook.dao.AddressBookDao;
import src.main.java.com.sg.addressbook.dao.AddressBookDaoFileImpl;
import src.main.java.com.sg.addressbook.dto.Address;
import src.main.java.com.sg.addressbook.ui.AddressBookView;
import src.main.java.com.sg.addressbook.ui.UserIO;
import src.main.java.com.sg.addressbook.ui.UserIOConsoleImpl;

public class AddressBookController {

    private AddressBookView view = new AddressBookView();
    private UserIO io = new UserIOConsoleImpl();
    private AddressBookDao dao = new AddressBookDaoFileImpl();

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
                    io.print("Delete Address");
                    break;
                case 3:
                    io.print("Find Address");
                    break;
                case 4:
                    io.print("List Address Count");
                    break;
                case 5:
                    io.print("List All Count");
                case 6:
                    keepGoing = false;
                    break;
                default:
                    io.print("UNKNOWN COMMAND");
            }

        }
        io.print("SEE YOU!");
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


}


