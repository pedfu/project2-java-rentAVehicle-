package services;

import entities.CarRental;
import entities.Invoice;

import java.util.concurrent.TimeUnit;

public class RentalServices {
    private Double pricePerHour;
    private Double pricePerDay;
    private TaxService taxService;

    public RentalServices(Double pricePerHour, Double pricePerDay, TaxService taxService) {
        this.pricePerHour = pricePerHour;
        this.pricePerDay = pricePerDay;
        this.taxService = taxService;
    }

    public void processInvoive(CarRental carRental) {
        long diff = carRental.getFinish().getTime() - carRental.getStart().getTime();
        double time = (double) diff / 1000 / 60 / 60;
        //pega horas

        double basicpayment = 0;
        if(time <= 12) {
            int hours = (int)Math.ceil(time);
            basicpayment = hours * pricePerHour;
        } else {
            int days = (int)Math.ceil(time / 24);
            basicpayment = days * pricePerDay;
        }
        double tax = taxService.tax(basicpayment);
        Invoice invoice = new Invoice(basicpayment, tax);
        carRental.setInvoice(invoice);
    }

    public Double getPricePerHour() {
        return pricePerHour;
    }

    public Double getPricePerDay() {
        return pricePerDay;
    }
}
