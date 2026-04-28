package smartinvoice.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import smartinvoice.entity.Payment;
import org.springframework.security.access.prepost.PreAuthorize;
@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

   @PreAuthorize("hasAnyRole('ACCOUNTANT', 'MANAGER')")
@PostMapping("/add/{invoiceId}")
    public Payment addPayment(
            @PathVariable Long invoiceId,
            @RequestBody Payment payment) {

        return paymentService.addPayment(
                invoiceId,
                payment
        );
    }
}