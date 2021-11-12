package application;

import entities.CarRental;

import java.util.concurrent.TimeUnit;

public class UI {
    public static double calcBasicPayment(CarRental carRental, TimeUnit timeUnit) {
        long diff = carRental.getFinish().getTime() - carRental.getStart().getTime();
        long time = timeUnit.convert(diff, TimeUnit.MILLISECONDS);
        return (Math.ceil(time));
    }
}
