package smartinvoice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import smartinvoice.entity.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

}