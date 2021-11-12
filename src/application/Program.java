package application;

import entities.CarRental;
import entities.Invoice;
import entities.Vehicle;
import services.BrazilTaxService;
import services.RentalServices;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Program {
    public static void main(String[] args) throws FileNotFoundException {
        Locale.setDefault(Locale.US);
        Scanner scanner = null;
        TimeUnit timeUnit = TimeUnit.MINUTES;

        String[] test = readFile(scanner);
        scanner = new Scanner(System.in);

        System.out.println("Enter rental data");
        System.out.print("Car model: ");
        String carModel = /*scanner.nextLine();*/ test[0];

        System.out.print("Pickup (dd/MM/yyyy hh:mm): ");
        String pickupString = /*scanner.nextLine();*/ test[1];
        System.out.print("Return (dd/MM/yyyy hh:mm): ");
        String returnString = /*scanner.nextLine();*/ test[2];

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        Date pickupdate = null;
        Date returndate = null;

        try {
            pickupdate = sdf.parse(pickupString);
            returndate = sdf.parse(returnString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        CarRental carRental = new CarRental(pickupdate, returndate, new Vehicle(carModel));

        System.out.print("Enter price per hour: ");
        double pricePerHour = Double.parseDouble(test[3]);
        //double pricePerHour = scanner.nextDouble();
        System.out.print("Enter price per day: ");
        //double pricePerDay = scanner.nextDouble();
        double pricePerDay = Double.parseDouble(test[4]);

        RentalServices rs = new RentalServices(pricePerHour, pricePerDay, new BrazilTaxService());
        rs.processInvoive(carRental);

        System.out.println("Invoice:");
        System.out.printf("Basic payment: %.2f", carRental.getInvoice().getBasicPayment());
        System.out.printf("\nTax: %.2f", carRental.getInvoice().getTax());
        System.out.printf("\nTotal payment: %.2f", carRental.getInvoice().getTotalPayment());

        scanner.close();
    }

    public static String[] readFile(Scanner scanner) throws FileNotFoundException {
        String path = "C:\\Users\\pedyu\\Desktop\\auto.txt";
        File file = new File("C:\\Users\\pedyu\\Desktop\\auto.txt");
        scanner = new Scanner(file);
        ArrayList<String> palavras = new ArrayList<>();

        palavras.add(scanner.nextLine());
        while(scanner.hasNext()) {
            palavras.add(scanner.nextLine());
        }
        String[] arr = new String[palavras.size()];
        palavras.toArray(arr);
        return arr;
    }
}
