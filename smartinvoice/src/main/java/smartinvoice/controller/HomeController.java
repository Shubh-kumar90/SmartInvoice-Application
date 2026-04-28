package smartinvoice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import smartinvoice.entity.Invoice;
import smartinvoice.service.InvoiceService;
import org.springframework.security.access.prepost.PreAuthorize;
import java.util.List;
import java.util.Optional;
import smartinvoice.dto.InvoiceDTO;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/invoice")
public class HomeController {

    @Autowired
    private InvoiceService invoiceService;

    // Home API
    @GetMapping("/")
    public String home() {
        return "Smart Invoice & Payment Reconciliation System Running";
    }




    @PreAuthorize("hasRole('MANAGER')")
@PutMapping("/approve/{id}")
public Invoice approveInvoice(@PathVariable Long id) {

    return invoiceService.approveInvoice(id);
}

@PreAuthorize("hasRole('MANAGER')")
@PutMapping("/reject/{id}")
public Invoice rejectInvoice(@PathVariable Long id) {

    return invoiceService.rejectInvoice(id);
}
    // Create Invoice
    @PreAuthorize("hasRole('ACCOUNTANT')")
@PostMapping("/create")
   public Invoice createInvoice(@RequestBody InvoiceDTO invoiceDTO) {
    //    return invoiceService.saveInvoice(invoice);
    return invoiceService.saveInvoice(invoiceDTO);
    }

    // Get All Invoices
   @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
@GetMapping("/all")
    public List<Invoice> getAllInvoices() {
        return invoiceService.getAllInvoices();
    }

    // Get Invoice By ID
    @GetMapping("/{id}")
    public Optional<Invoice> getInvoiceById(@PathVariable Long id) {
        return invoiceService.getInvoiceById(id);
    }

    // Update Invoice
    @PutMapping("/update/{id}")
    public Invoice updateInvoice(@PathVariable Long id,
                             @Valid @RequestBody Invoice invoice) {

        return invoiceService.updateInvoice(id, invoice);
    }

    // Delete Invoice
@PreAuthorize("hasRole('ADMIN')")
@DeleteMapping("/delete/{id}")
    public String deleteInvoice(@PathVariable Long id) {

        return invoiceService.deleteInvoice(id);
    }
}