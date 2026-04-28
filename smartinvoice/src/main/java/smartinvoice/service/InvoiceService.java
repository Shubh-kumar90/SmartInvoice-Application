package smartinvoice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import smartinvoice.entity.Invoice;
import smartinvoice.repository.InvoiceRepository;
import smartinvoice.dto.InvoiceDTO;
import java.util.List;
import java.util.Optional;

import smartinvoice.entity.InvoiceStatus;

@Service
public class InvoiceService {

    private Invoice convertToEntity(InvoiceDTO dto) {

        Invoice invoice = new Invoice();

        invoice.setInvoiceNumber(dto.getInvoiceNumber());
        invoice.setVendorName(dto.getVendorName());
        invoice.setAmount(dto.getAmount());
        invoice.setStatus(InvoiceStatus.PENDING);
        invoice.setCreatedDate(dto.getCreatedDate());
        invoice.setDueDate(dto.getDueDate());

        return invoice;
    }


    // Approve Invoice
public Invoice approveInvoice(Long id) {

    Invoice invoice =
            invoiceRepository.findById(id).orElse(null);

    if (invoice != null) {

        invoice.setStatus(InvoiceStatus.APPROVED);

        return invoiceRepository.save(invoice);
    }

    return null;
}

// Reject Invoice
public Invoice rejectInvoice(Long id) {

    Invoice invoice =
            invoiceRepository.findById(id).orElse(null);

    if (invoice != null) {

        invoice.setStatus(InvoiceStatus.REJECTED);

        return invoiceRepository.save(invoice);
    }

    return null;
}

    @Autowired
    private InvoiceRepository invoiceRepository;

    // Save Invoice
   public Invoice saveInvoice(InvoiceDTO dto) {

    Invoice invoice = convertToEntity(dto);

    return invoiceRepository.save(invoice);
}

    // Get All Invoices
    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    // Get Invoice By ID
    public Optional<Invoice> getInvoiceById(Long id) {
        return invoiceRepository.findById(id);
    }

    // Update Invoice
    public Invoice updateInvoice(Long id, Invoice updatedInvoice) {

        Invoice invoice = invoiceRepository.findById(id).orElse(null);

        if (invoice != null) {

            invoice.setInvoiceNumber(updatedInvoice.getInvoiceNumber());
            invoice.setVendorName(updatedInvoice.getVendorName());
            invoice.setAmount(updatedInvoice.getAmount());
            invoice.setStatus(updatedInvoice.getStatus());
            invoice.setCreatedDate(updatedInvoice.getCreatedDate());
            invoice.setDueDate(updatedInvoice.getDueDate());

            return invoiceRepository.save(invoice);
        }

        return null;
    }

    // Delete Invoice
    public String deleteInvoice(Long id) {

        invoiceRepository.deleteById(id);

        return "Invoice Deleted Successfully";
    }
}