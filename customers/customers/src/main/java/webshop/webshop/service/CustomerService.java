package webshop.webshop.service;

import webshop.webshop.kafka.CustomerDTO;

import java.util.Collection;

public interface CustomerService {
    void add(CustomerDTO customerDTO);
    void delete(long customerNumber);
    void update(long customerNumber, CustomerDTO customerDTO);
    CustomerDTO getCustomer(long customerNumber);
    Collection<CustomerDTO> getAllCustomers();
}
