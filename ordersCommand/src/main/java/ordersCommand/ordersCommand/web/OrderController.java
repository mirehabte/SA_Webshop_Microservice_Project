package ordersCommand.ordersCommand.web;

import ordersCommand.ordersCommand.service.DTOs.OrderDTO;
import ordersCommand.ordersCommand.service.DTOs.OrdersDTO;
import ordersCommand.ordersCommand.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping
    public ResponseEntity<?> addOrder(@RequestBody OrderDTO orderDTO) {
        OrderDTO newOrderDTO = orderService.add(orderDTO);
        return new ResponseEntity<OrderDTO>(newOrderDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{orderNumber}")
    public ResponseEntity<?> deleteOrder(@PathVariable long orderNumber){
        OrderDTO orderDTO = orderService.getOrder(orderNumber);
        if(orderDTO == null) {
            return new ResponseEntity<CustomErrorType>(
                    new CustomErrorType("Order with : "+orderNumber+" not found !"),
                    HttpStatus.NOT_FOUND);
        }
        orderService.delete(orderNumber);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{orderNumber}")
    public ResponseEntity<?> updateOrder(@PathVariable long orderNumber, @RequestBody OrderDTO orderDTO){
        OrderDTO updateOrderDTO = orderService.getOrder(orderNumber);
        if(updateOrderDTO == null) {
            return new ResponseEntity<CustomErrorType>(
                    new CustomErrorType("Order with : "+orderNumber+" not found !"),
                    HttpStatus.NOT_FOUND);
        }
        orderService.update(orderNumber, orderDTO);
        return new ResponseEntity<OrderDTO>(orderDTO, HttpStatus.OK);
    }

    @GetMapping("/{orderNumber}")
    public ResponseEntity<?> getOrder(@PathVariable long orderNumber){
        OrderDTO orderDTO = orderService.getOrder(orderNumber);
        if(orderDTO == null) {
            return new ResponseEntity<CustomErrorType>(
                    new CustomErrorType("Order with : "+orderNumber+" not found !"),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<OrderDTO>(orderDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllOrders(){
        Collection<OrderDTO> orderDTOList = orderService.getAllOrders();
        OrdersDTO allOrders = new OrdersDTO(orderDTOList);
        return new ResponseEntity<OrdersDTO>(allOrders, HttpStatus.OK);
    }
}