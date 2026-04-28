package smartinvoice.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import smartinvoice.entity.Invoice;
import smartinvoice.entity.InvoiceStatus;
import smartinvoice.entity.Payment;

import smartinvoice.repository.InvoiceRepository;
import smartinvoice.repository.PaymentRepository;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private InvoiceRepository invoiceRepository;

    // Add Payment
    public Payment addPayment(Long invoiceId,
                              Payment payment) {

        Invoice invoice =
                invoiceRepository.findById(invoiceId)
                        .orElse(null);

        if (invoice != null) {

            payment.setInvoice(invoice);

            // Reconciliation Logic
            if (payment.getPaymentAmount()
                    >= invoice.getAmount()) {

                invoice.setStatus(InvoiceStatus.PAID);

                invoiceRepository.save(invoice);
            }

            return paymentRepository.save(payment);
        }

        return null;
    }
}