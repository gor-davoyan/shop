package service.planeService;

import comparators.HoursComparator;
import model.Plane;
import service.MenuService;

import java.util.Collections;
import java.util.List;

public class PlaneService {
    public static void buyPlane(String model, int number, List<Plane> planes) {
        for (Plane plane : planes) {
            if (plane.getModel().equals(model) && plane.getNumber() == number) {
                if (MenuService.user.getWalletBalance() >= plane.getCost()) {
                    MenuService.user.setWalletBalance(MenuService.user.getWalletBalance() - plane.getCost());
                    System.out.println("Congratulations on your new " + model + " plane!");
                } else {
                    System.out.println("There is no enough money to buy a car!");
                }
                return;
            }
        }

        System.out.println("car not found!");
    }



    public static void planesInAscendingOrder(List<Plane> planes) {
        Collections.sort(planes);
        printAllPlanes(planes);
    }

    public static void planesWithWeightGreaterThan100000(List<Plane> planes) {
        for (Plane plane : planes) {
            if (plane.getWeight() > 100000) {
                printPlaneInfo(plane);
            }
        }
    }

    public static void allClassicPlanes(List<Plane> planes) {
        for (Plane plane : planes) {
            if (!plane.isMilitary()) {
                printPlaneInfo(plane);
            }
        }
    }

    public static void militaryPlanesWithCost400000to700000(List<Plane> planes) {
        for (Plane plane : planes) {
            if (plane.isMilitary() && plane.getCost() > 400000 && plane.getCost() < 700000) {
                printPlaneInfo(plane);
            }
        }
    }

    public static void planeWithMaxHours(List<Plane> planes) {
        printPlaneInfo(Collections.max(planes, new HoursComparator()));
    }

    public static void planeWithMinCost(List<Plane> planes) {
        printPlaneInfo(Collections.min(planes));
    }

    public static void allPlanes1900to2021(List<Plane> planes) {
        for (Plane plane:planes) {
            if(plane.getYear() >= 1900 && plane.getYear() <=2021) {
                printPlaneInfo(plane);
            }
        }
    }

    public static void printAllPlanes(List<Plane> planes) {
        for (Plane plane: planes) {
            printPlaneInfo(plane);
        }
    }

    public static void printPlaneInfo(Plane plane) {
        System.out.println("------------------------");
        System.out.println("model: " + plane.getModel());
        System.out.println("weight: " + plane.getWeight());
        System.out.println("year: " + plane.getYear());
        System.out.println("cost: " + plane.getCost());
        System.out.println("country: " + plane.getCountry());
        System.out.println("hours in sky: " + plane.getHoursInSky());
        System.out.println("isMilitary: " + (plane.isMilitary() ? "Yes" : "No"));
        System.out.println("number: " + plane.getNumber());
        System.out.println("------------------------");
    }
}
