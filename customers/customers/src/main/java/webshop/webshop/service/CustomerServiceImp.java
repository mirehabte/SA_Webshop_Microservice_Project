package webshop.webshop.service;

import webshop.webshop.domain.Customer;
import webshop.webshop.kafka.Sender;
import webshop.webshop.repository.CustomerRepository;
import webshop.webshop.kafka.CustomerAdapter;
import webshop.webshop.kafka.CustomerDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImp implements CustomerService{

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    Sender sender;

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
            sender.send(CustomerAdapter.getCustomerDTOFromCustomer(customer));
            System.out.println("Sending "+ customer);
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
