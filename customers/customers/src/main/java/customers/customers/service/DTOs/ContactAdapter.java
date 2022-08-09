package customers.customers.service.DTOs;

import customers.customers.domain.Contact;

public class ContactAdapter {
    public static Contact getContactFromContactDTO(ContactDTO contactDTO){
        return new Contact(contactDTO.getPhone(), contactDTO.getEmail());
    }

    public static ContactDTO getContactDTOFromContact(Contact contact){
        return new ContactDTO(contact.getPhone(), contact.getEmail());
    }
}
