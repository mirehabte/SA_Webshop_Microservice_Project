package payments.payments.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import payments.payments.service.DTOs.PaymentDTO;
import payments.payments.service.DTOs.PaymentsDTO;
import payments.payments.service.PaymentService;

import java.util.Collection;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    PaymentService paymentService;

    @PostMapping
    public ResponseEntity<?> addPayment(@RequestBody PaymentDTO paymentDTO) {
        paymentService.add(paymentDTO);
        return new ResponseEntity<>(paymentDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{paymentNumber}")
    public ResponseEntity<?> deletePayment(@PathVariable long paymentNumber){
        PaymentDTO paymentDTO = paymentService.getPayment(paymentNumber);
        if(paymentDTO == null) {
            return new ResponseEntity<CustomErrorType>(
                    new CustomErrorType("Payment with : "+paymentNumber+" not found !"),
                    HttpStatus.NOT_FOUND);
        }
        paymentService.delete(paymentNumber);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{paymentNumber}")
    public ResponseEntity<?> updatePayment(@PathVariable long paymentNumber, @RequestBody PaymentDTO paymentDTO){
        PaymentDTO updatePaymentDTO = paymentService.getPayment(paymentNumber);
        if(updatePaymentDTO == null) {
            return new ResponseEntity<CustomErrorType>(
                    new CustomErrorType("Payment with : "+paymentNumber+" not found !"),
                    HttpStatus.NOT_FOUND);
        }
        paymentService.update(paymentNumber, paymentDTO);
        return new ResponseEntity<PaymentDTO>(paymentDTO, HttpStatus.OK);
    }

    @GetMapping("/{paymentNumber}")
    public ResponseEntity<?> getPayment(@PathVariable long paymentNumber){
        PaymentDTO paymentDTO = paymentService.getPayment(paymentNumber);
        if(paymentDTO == null) {
            return new ResponseEntity<CustomErrorType>(
                    new CustomErrorType("Payment with : "+paymentNumber+" not found !"),
                    HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<PaymentDTO>(paymentDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllPayments(){
        Collection<PaymentDTO> paymentDTOList = paymentService.getAllPayments();
        PaymentsDTO allPayments = new PaymentsDTO(paymentDTOList);
        return new ResponseEntity<PaymentsDTO>(allPayments, HttpStatus.OK);
    }
}
