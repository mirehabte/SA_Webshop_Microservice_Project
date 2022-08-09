package customers.customers.service;

import customers.customers.repository.CustomerRepository;
import customers.customers.service.DTOs.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CustomerServiceImp implements CustomerService{

    @Autowired
    CustomerRepository customerRepository;


    @Override
    public void add(CustomerDTO customerDTO) {

    }

    @Override
    public void delete(long customerNumber) {

    }

    @Override
    public void update(long customerNumber, CustomerDTO customerDTO) {

    }

    @Override
    public CustomerDTO getCustomer() {
        return null;
    }

    @Override
    public Collection<CustomerDTO> getAllCustomers() {
        return null;
    }
}
