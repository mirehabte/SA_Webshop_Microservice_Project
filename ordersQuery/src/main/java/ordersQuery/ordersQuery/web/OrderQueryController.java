package ordersQuery.ordersQuery.web;


import ordersQuery.ordersQuery.service.DTOs.OrderDTO;
import ordersQuery.ordersQuery.service.DTOs.OrdersDTO;
import ordersQuery.ordersQuery.service.OrderQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/orders")
public class OrderQueryController {

    @Autowired
    OrderQueryService orderQueryService;

    @GetMapping("/{orderNumber}")
    public ResponseEntity<?> getOrder(@PathVariable long orderNumber){
        OrderDTO orderDTO = orderQueryService.getOrder(orderNumber);
        if(orderDTO == null) {
            return new ResponseEntity<CustomErrorType>(
                    new CustomErrorType("Order with : "+orderNumber+" not found !"),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<OrderDTO>(orderDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllOrders(){
        Collection<OrderDTO> orderDTOList = orderQueryService.getAllOrders();
        OrdersDTO allOrders = new OrdersDTO(orderDTOList);
        return new ResponseEntity<OrdersDTO>(allOrders, HttpStatus.OK);
    }
}
