package entities;

import services.BrazilTaxService;

public class Invoice {
    private Double basicPayment;
    private Double tax;
    private Double totalPayment;

    public Invoice() {
    }

    public Invoice(Double basicPayment, Double tax) {
        this.basicPayment = basicPayment;
        this.tax = tax;
    }

    public Double getTotalPayment() {
        return getBasicPayment() + getTax();
    }

    public Double getBasicPayment() {
        return basicPayment;
    }

    public Double getTax() {
        return tax;
    }

    public void setBasicPayment(Double basicPayment) {
        this.basicPayment = basicPayment;
    }

}
