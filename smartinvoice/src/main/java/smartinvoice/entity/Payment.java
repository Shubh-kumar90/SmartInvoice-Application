package smartinvoice.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double paymentAmount;

    private String paymentReference;

    private LocalDate paymentDate;

    // Many Payments -> One Invoice
    @ManyToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;

    public Payment() {
    }

    public Payment(Long id,
                   Double paymentAmount,
                   String paymentReference,
                   LocalDate paymentDate,
                   Invoice invoice) {

        this.id = id;
        this.paymentAmount = paymentAmount;
        this.paymentReference = paymentReference;
        this.paymentDate = paymentDate;
        this.invoice = invoice;
    }

    public Long getId() {
        return id;
    }

    public Double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Double paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPaymentReference() {
        return paymentReference;
    }

    public void setPaymentReference(String paymentReference) {
        this.paymentReference = paymentReference;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}