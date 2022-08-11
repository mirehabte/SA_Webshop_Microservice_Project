package webshop.webshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class RestClientApplication implements CommandLineRunner {
	@Autowired
	private RestOperations restTemplate;

	@Value("${app.url}")
	String apiGateway;

	public static void main(String[] args) {
		SpringApplication.run(RestClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//1.Add Customer
		Address address1 = new Address("127st. 23Ave","Fairfield","5200");
		Address address2 = new Address("12st. 2Ave","Iowa City","2200");
		Contact contact1 = new Contact("5104545678","frank@gmail.com");
		Contact contact2 = new Contact("7135456679","john@gmail.com");
		CustomerDTO customerDTO1 = new CustomerDTO(12345, "Frank",address1, contact1);
		CustomerDTO customerDTO2 = new CustomerDTO(12346, "John",address2, contact2);

		restTemplate.postForLocation(apiGateway+"/customers", customerDTO1);
		restTemplate.postForLocation(apiGateway+"/customers", customerDTO2);

//		System.out.println("------------Customers---------");
//		System.out.println(restTemplate.getForObject(apiGateway+"/customers/12345", CustomerDTO.class));
//		System.out.println(restTemplate.getForObject(apiGateway+"/customers/12346", CustomerDTO.class));

     	//2.Add product
		Supplier supplier1 = new Supplier("Apple", "apple@org.com");
		Supplier supplier2 = new Supplier("Samsung", "samsung@eu.com");
		ProductDTO productDTO1 = new ProductDTO(123, "Iphone12",599.99,supplier1);
		ProductDTO productDTO2 = new ProductDTO(124, "Samsung A71",500.99, supplier2);
		restTemplate.postForLocation(apiGateway+"/products", productDTO1);
		restTemplate.postForLocation(apiGateway+"/products", productDTO2);

//		System.out.println("------------Products---------");
//		System.out.println(restTemplate.getForObject(apiGateway+"/products/123", ProductDTO.class));
//		System.out.println(restTemplate.getForObject(apiGateway+"/products/124", ProductDTO.class));

		//3.Add Order
		Product product1 = ProductAdapter.getProductFromProductDTO(productDTO1);
		Product product2 = ProductAdapter.getProductFromProductDTO(productDTO2);
		List<Product> cart1 = Arrays.asList(product1,product1,product2,product2,product2);
		Customer customer = CustomerAdapter.getCustomerFromCustomerDTO(customerDTO1);
		OrderDTO orderDTO = new OrderDTO(1243, LocalDate.now(), 0.0, cart1, customer);
		restTemplate.postForLocation(apiGateway+"/order", orderDTO);

		//4.Add Payment
		Payment payment = new Payment(12378,LocalDate.now(), orderDTO.getPrice(),
				orderDTO.getOrderNumber(), orderDTO.getCustomer().getCustomerNumber());

		PaymentDTO paymentDTO = PaymentAdapter.getPaymentDTOFromPayment(payment);


		restTemplate.postForLocation(apiGateway+"/payments", paymentDTO);
		//System.out.println("-------------Payments-----------");
		//System.out.println(restTemplate.getForObject(apiGateway+"/payments/12378", PaymentDTO.class));

		//5.Get Order Before Update
		System.out.println("-------------Orders Before Updated-----------");
		System.out.println(restTemplate.getForObject(apiGateway+"/orders/1243", OrderDTO.class));

		//6.Changing name of the product
		productDTO1.setName("Iphone13");
		productDTO2.setName("Samsung A72");

		restTemplate.put(apiGateway+"/products/123", productDTO1);
		restTemplate.put(apiGateway+"/products/124", productDTO2);

		//7. Change name of the customer
		customerDTO1.setName("Brown");
		restTemplate.put(apiGateway+"/customers/12345", customerDTO1);

		//8. Update amount of the payment
		paymentDTO.setAmount(599.99);
		restTemplate.put(apiGateway+"/payments/12378",paymentDTO);


		Thread.sleep(3000);
		//9. Get Order after Update
		System.out.println("-------------Orders After Updated-----------");
		System.out.println(restTemplate.getForObject(apiGateway+"/orders/1243", OrderDTO.class));

	}


	@Bean
	RestOperations restTemplate() {
		return new RestTemplate();
	}
}
