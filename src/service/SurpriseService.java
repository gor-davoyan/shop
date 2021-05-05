package service;

import model.Car;
import model.Plane;
import model.Vehicle;
import service.carServices.CarFileService;
import service.carServices.CarService;
import service.planeService.PlaneFileService;
import service.planeService.PlaneService;

import java.io.IOException;

public class SurpriseService {
    public static void surprise() {
        if (MenuService.user.isTrustedCustomer()) {
            Vehicle vehicle = null;

            int randomNum = (int) (Math.random() * 2) + 1;

            switch (randomNum) {
                case 1:
                    try {
                        vehicle = CarFileService.readCars("examples/Cars.txt")[(int) (Math.random() * 3) + 1];
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try {
                        vehicle = PlaneFileService.readPlanes("examples/Planes.txt").get((int) (Math.random() * 3) + 1);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;

            }

            assert vehicle != null;
            String[] split = vehicle.getClass().toString().split("\\.");
            System.out.println("Congrats your new " + split[split.length - 1]);
            if (vehicle instanceof Car) {
                CarService.printCarInfo((Car) vehicle);
            } else {
                PlaneService.printPlaneInfo((Plane) vehicle);
            }

            MenuService.user.setNumberOfPurchases(MenuService.user.getNumberOfPurchases() - 50);
        } else {
            System.out.println("You are not trusted customer yet!");
        }
    }
}
