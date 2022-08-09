package customers.customers.service.DTOs;

import customers.customers.domain.Customer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomerAdapter {

    public static Customer getCustomerFromCustomerDTO(CustomerDTO customerDTO){
        return new Customer(customerDTO.getCustomerNumber(), customerDTO.getName(),
               customerDTO.getAddress(), customerDTO.getContact());
    }

    public static CustomerDTO getCustomerDTOFromCustomer(Customer customer){
        return new CustomerDTO(customer.getCustomerNumber(), customer.getName(),
               customer.getAddress(), customer.getContact());
    }

    public static Collection<CustomerDTO> getCustomerDTOListFromCustomerList(List<Customer> customerList){
        List<CustomerDTO> customerDTOS = new ArrayList<>();
        for(Customer customer: customerList){
            customerDTOS.add(getCustomerDTOFromCustomer(customer));
        }
        return customerDTOS;
    }
}
