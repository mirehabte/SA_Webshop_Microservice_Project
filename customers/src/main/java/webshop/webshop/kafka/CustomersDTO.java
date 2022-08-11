package webshop.webshop.kafka;

import java.util.ArrayList;
import java.util.Collection;

public class CustomersDTO {
    private Collection<CustomerDTO> customersDTO = new ArrayList<>();
    public CustomersDTO(){}

    public CustomersDTO(Collection<CustomerDTO> customersDTO) {
        this.customersDTO = customersDTO;
    }

    public Collection<CustomerDTO> getCustomers() {
        return customersDTO;
    }

    public void setCustomers(Collection<CustomerDTO> customersDTO) {
        this.customersDTO = customersDTO;
    }

    @Override
    public String toString() {
        return "Customers{" +
                "customers=" + customersDTO +
                '}';
    }
}
