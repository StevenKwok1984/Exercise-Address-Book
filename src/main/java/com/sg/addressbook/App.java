package src.main.java.com.sg.addressbook;

import src.main.java.com.sg.addressbook.controller.AddressBookController;
import src.main.java.com.sg.addressbook.dao.AddressBookDao;
import src.main.java.com.sg.addressbook.dao.AddressBookDaoFileImpl;
import src.main.java.com.sg.addressbook.ui.AddressBookView;
import src.main.java.com.sg.addressbook.ui.UserIO;
import src.main.java.com.sg.addressbook.ui.UserIOConsoleImpl;

public class App {
    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        AddressBookView myView = new AddressBookView(myIo);
        AddressBookDao myDao = new AddressBookDaoFileImpl();
        AddressBookController controller =
                new AddressBookController(myDao, myView);
        controller.run();
    }
}
