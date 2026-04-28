package smartinvoice.dto;

import java.time.LocalDate;

import smartinvoice.entity.InvoiceStatus;

public class InvoiceDTO {

    private String invoiceNumber;

    private String vendorName;

    private Double amount;

    private InvoiceStatus status;

    private LocalDate createdDate;

    private LocalDate dueDate;

    // Default Constructor
    public InvoiceDTO() {
    }

    // Parameterized Constructor
    public InvoiceDTO(String invoiceNumber,
                      String vendorName,
                      Double amount,
                      InvoiceStatus status,
                      LocalDate createdDate,
                      LocalDate dueDate) {

        this.invoiceNumber = invoiceNumber;
        this.vendorName = vendorName;
        this.amount = amount;
        this.status = status;
        this.createdDate = createdDate;
        this.dueDate = dueDate;
    }

    // Getters and Setters

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public InvoiceStatus getStatus() {
        return status;
    }

    public void setStatus(InvoiceStatus status) {
        this.status = status;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}