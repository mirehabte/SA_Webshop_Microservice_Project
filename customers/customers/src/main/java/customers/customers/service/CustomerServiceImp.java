package customers.customers.service;

import customers.customers.domain.Customer;
import customers.customers.repository.CustomerRepository;
import customers.customers.service.DTOs.CustomerAdapter;
import customers.customers.service.DTOs.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImp implements CustomerService{

    @Autowired
    CustomerRepository customerRepository;


    @Override
    public void add(CustomerDTO customerDTO) {
        Customer customer = CustomerAdapter.getCustomerFromCustomerDTO(customerDTO);
        customerRepository.save(customer);
    }

    @Override
    public void delete(long customerNumber) {
        customerRepository.deleteById(customerNumber);
    }

    @Override
    public void update(long customerNumber, CustomerDTO customerDTO) {
        Optional<Customer> optionalCustomer = customerRepository.findById(customerNumber);
        if (optionalCustomer.isPresent()){
            Customer customer = CustomerAdapter.getCustomerFromCustomerDTO(customerDTO);
            customerRepository.save(customer);
        }
    }

    @Override
    public CustomerDTO getCustomer(long customerNumber) {
        Customer customer = customerRepository.findById(customerNumber).get();
        if(customer == null){
            System.out.println("No Customer found with this "+customerNumber+" id.");
        }
        return CustomerAdapter.getCustomerDTOFromCustomer(customer);
    }

    @Override
    public Collection<CustomerDTO> getAllCustomers() {
        List<Customer> customerList = customerRepository.findAll();
        return CustomerAdapter.getCustomerDTOListFromCustomerList(customerList);
    }
}