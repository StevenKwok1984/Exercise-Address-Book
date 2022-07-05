package src.main.java.com.sg.addressbook.dto;

public class Address {

    private String firstName;
    private String lastName;
    private String address;

    public Address() {

    }

    public Address(String lastName) {
        this.lastName = lastName;
    }


    // getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
