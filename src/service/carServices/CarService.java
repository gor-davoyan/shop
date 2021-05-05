package service.carServices;

import model.Car;
import service.MenuService;

public class CarService {

    public static void buyCar(String model, int number, Car[] cars) {
        for (Car car : cars) {
            if (car.getModel().equals(model) && car.getNumber() == number) {
                if (MenuService.user.getWalletBalance() >= car.getCost()) {
                    MenuService.user.setWalletBalance(MenuService.user.getWalletBalance() - car.getCost());
                    System.out.println("Congratulations on your new " + model + " car!");
                } else {
                    System.out.println("There is no enough money to buy a car!");
                }
                return;
            }
        }

        System.out.println("car not found!");
    }

    public static void carsWithWeightGreaterThan10000(Car[] cars) {
        for (Car car : cars) {
            if (car.getWeight() > 10000) {
                printCarInfo(car);
            }
        }
    }

    public static void allElectricCars(Car[] cars) {
        for (Car car : cars) {
            if (car.isElectric()) {
                printCarInfo(car);
            }
        }
    }

    public static void electricCarsWithCost20000to40000(Car[] cars) {
        for (Car car : cars) {
            if (car.isElectric() && car.getCost() > 20000 && car.getCost() < 40000) {
                printCarInfo(car);
            }
        }
    }

    public static void carWithMaxHorsePower(Car[] cars) {
        Car maxHorsePower = cars[0];
        for (int i = 1; i < cars.length; i++) {
            if (cars[i].getHorsePower() > maxHorsePower.getHorsePower()) {
                maxHorsePower = cars[i];
            }
        }

        printCarInfo(maxHorsePower);
    }

    public static void carWithMinCost(Car[] cars) {
        Car minCost = cars[0];
        for (int i = 1; i < cars.length; i++) {
            if (cars[i].getCost() < minCost.getCost()) {
                minCost = cars[i];
            }
        }

        printCarInfo(minCost);
    }

    public static void allCars2000to2020(Car[] cars) {
        for (Car car : cars) {
            if (car.getYear() >= 2000 && car.getYear() <= 2020) {
                printCarInfo(car);
            }
        }
    }

    public static void printAllCars(Car[] cars) {
        for (Car car : cars) {
            printCarInfo(car);
        }
    }

    public static void printCarInfo(Car car) {
        System.out.println("------------------------");
        System.out.println("model: " + car.getModel());
        System.out.println("weight: " + car.getWeight());
        System.out.println("year: " + car.getYear());
        System.out.println("cost: " + car.getCost());
        System.out.println("country: " + car.getCountry());
        System.out.println("horsepower: " + car.getHorsePower());
        System.out.println("isElectric: " + (car.isElectric() ? "Yes" : "No"));
        System.out.println("number: " + car.getNumber());
        System.out.println("------------------------");
    }
}
