package entities;

import java.util.Date;

public class CarRental {
    private Date start;
    private Date finish;
    private Invoice invoice;
    private Vehicle vehicle;

    public CarRental(Date start, Date finish, Vehicle vehicle) {
        this.start = start;
        this.finish = finish;
        this.vehicle = vehicle;
    }

    public Date getStart() {
        return start;
    }

    public Date getFinish() {
        return finish;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}
