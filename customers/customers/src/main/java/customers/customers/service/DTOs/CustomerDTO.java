package customers.customers.service.DTOs;

public class CustomerDTO {
    private long customerNumber;
    private String name;
    private AddressDTO addressDTO;
    private ContactDTO contactDTO;

    public CustomerDTO(){}

    public CustomerDTO(long customerNumber, String name, AddressDTO addressDTO, ContactDTO contactDTO) {
        this.customerNumber = customerNumber;
        this.name = name;
        this.addressDTO = addressDTO;
        this.contactDTO = contactDTO;
    }

    public long getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(long customerNumber) {
        this.customerNumber = customerNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AddressDTO getAddressDTO() {
        return addressDTO;
    }

    public void setAddressDTO(AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
    }

    public ContactDTO getContactDTO() {
        return contactDTO;
    }

    public void setContactDTO(ContactDTO contactDTO) {
        this.contactDTO = contactDTO;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerNumber=" + customerNumber +
                ", name='" + name + '\'' +
                ", address=" + addressDTO +
                ", contact=" + contactDTO +
                '}';
    }
}
