package customers.customers.service;

import customers.customers.service.DTOs.CustomerDTO;

import java.util.Collection;

public interface CustomerService {
    void add(CustomerDTO customerDTO);
    void delete(long customerNumber);
    void update(long customerNumber, CustomerDTO customerDTO);
    CustomerDTO getCustomer();
    Collection<CustomerDTO> getAllCustomers();
}
