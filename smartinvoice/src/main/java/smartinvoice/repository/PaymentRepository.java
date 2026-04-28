package smartinvoice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import smartinvoice.entity.Payment;

public interface PaymentRepository
        extends JpaRepository<Payment, Long> {

}