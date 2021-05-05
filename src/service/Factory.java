package service;

import model.*;
import model.Vehicle;
import service.carServices.CarFileService;
import service.planeService.PlaneFileService;

import java.io.IOException;
import java.util.Scanner;

public class Factory {
    static Scanner s = new Scanner(System.in);
    static int numberC = 0;
    static int numberP = 0;

    public static void createProductAndAddToFile(Vehicle v) throws IOException {
        if (v instanceof Car) {
            System.out.println("Enter car year: ");
            int year = s.nextInt();
            System.out.println("Enter car weight: ");
            double weight = s.nextDouble();
            System.out.println("Enter car cost: ");
            long cost = s.nextLong();
            System.out.println("Enter car country: ");
            String country = s.next();
            v.setYear(year);
            v.setWeight(weight);
            v.setCost(cost);
            v.setCountry(country);

            CarFileService.writeWithAppend((Car) v);
        } else if (v instanceof Plane) {
            System.out.println("Enter plane model: ");
            String model = s.next();
            System.out.println("Enter plane year: ");
            int year = s.nextInt();
            System.out.println("Enter plane country: ");
            String country = s.next();
            System.out.println("Enter plane weight: ");
            double weight = s.nextDouble();
            System.out.println("Enter plane cost: ");
            long cost = s.nextLong();
            System.out.println("is plane military (yes/no): ");
            boolean isMilitary = s.next().charAt(0) == 'y';
            System.out.println("Enter plane cost: ");
            double hoursInSky = s.nextDouble();

            Plane plane = new Plane(model, year, country);
            plane.setWeight(weight);
            plane.setCost(cost);
            plane.setMilitary(isMilitary);
            plane.setHoursInSky(hoursInSky);
            plane.setNumber(++numberP);

            PlaneFileService.writeWithAppend(plane);
        }
    }
}
