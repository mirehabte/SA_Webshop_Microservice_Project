package webshop.webshop.web;


import webshop.webshop.service.CustomerService;
import webshop.webshop.kafka.CustomerDTO;
import webshop.webshop.kafka.CustomersDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping
    public ResponseEntity<?> addCustomer(@RequestBody CustomerDTO customerDTO){
        customerService.add(customerDTO);
        return new ResponseEntity<>(customerDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{customerNumber}")
    public ResponseEntity<?> deleteCustomer(@PathVariable long customerNumber){
        CustomerDTO customerDTO = customerService.getCustomer(customerNumber);
        if(customerDTO == null) {
            return new ResponseEntity<CustomErrorType>(
                    new CustomErrorType("Customer with : "+customerNumber+" not found !"),
                    HttpStatus.NOT_FOUND);
        }
        customerService.delete(customerNumber);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{customerNumber}")
    public ResponseEntity<?> updateCustomer(@PathVariable long customerNumber, @RequestBody CustomerDTO customerDTO){
        CustomerDTO updateCustomerDTO = customerService.getCustomer(customerNumber);
        if(updateCustomerDTO == null) {
            return new ResponseEntity<CustomErrorType>(
                    new CustomErrorType("Customer with : "+customerNumber+" not found !"),
                    HttpStatus.NOT_FOUND);
        }
        customerService.update(customerNumber, customerDTO);
        return new ResponseEntity<CustomerDTO>(customerDTO, HttpStatus.OK);
    }

    @GetMapping("/{customerNumber}")
    public ResponseEntity<?> getCustomer(@PathVariable long customerNumber){
        CustomerDTO customerDTO = customerService.getCustomer(customerNumber);
        if(customerDTO == null) {
            return new ResponseEntity<CustomErrorType>(
                    new CustomErrorType("Customer with : "+customerNumber+" not found !"),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<CustomerDTO>(customerDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllCustomers(){
        Collection<CustomerDTO> customerDTOList = customerService.getAllCustomers();
        CustomersDTO allCustomers = new CustomersDTO(customerDTOList);
        return new ResponseEntity<CustomersDTO>(allCustomers, HttpStatus.OK);
    }
}
