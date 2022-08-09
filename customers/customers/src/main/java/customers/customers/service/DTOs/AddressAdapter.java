package customers.customers.service.DTOs;

import customers.customers.domain.Address;

public class AddressAdapter {

    public static Address getAddressFromAddressDTO(AddressDTO addressDTO){
        return new Address(addressDTO.getStreet(), addressDTO.getCity(), addressDTO.getZip());
    }

    public static AddressDTO getAddressDTOFromAddress(Address address){
        return new AddressDTO(address.getStreet(), address.getCity(), address.getZip());
    }
}
