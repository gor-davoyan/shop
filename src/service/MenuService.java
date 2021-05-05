package service;

import model.User;
import model.Car;
import model.Plane;
import service.carServices.CarFileService;
import service.carServices.CarService;
import service.planeService.PlaneFileService;
import service.planeService.PlaneService;
import model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuService {
    static Scanner s = new Scanner(System.in);
    public static User user;


    private static void planeStoreMenu(boolean isActive) {
        List<Plane> planes = new ArrayList<>();
        try {
            planes = PlaneFileService.readPlanes("examples/Planes.txt");
            PlaneService.printAllPlanes(planes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (isActive) {
            System.out.println("1. print all planes with year from 1900 to 2021");
            System.out.println("2. print the plane with minimal cost");
            System.out.println("3. print the plane with maximal hours in sky");
            System.out.println("4. print military planes with coast from 400000$ to 700000$");
            System.out.println("5. print all classic planes");
            System.out.println("6. print planes with weight greater then 100000kg");
            System.out.println("7. print planes in ascending form order by year");
            System.out.println("8. Buy");

            int command = s.nextInt();

            switch (command) {
                case 1 -> PlaneService.allPlanes1900to2021(planes);
                case 2 -> PlaneService.planeWithMinCost(planes);
                case 3 -> PlaneService.planeWithMaxHours(planes);
                case 4 -> PlaneService.militaryPlanesWithCost400000to700000(planes);
                case 5 -> PlaneService.allClassicPlanes(planes);
                case 6 -> PlaneService.planesWithWeightGreaterThan100000(planes);
                case 7 -> PlaneService.planesInAscendingOrder(planes);
                case 8 -> {
                    System.out.println("Enter plane's model: ");
                    String model = s.next();
                    System.out.println("Enter plan's number: ");
                    int number = s.nextInt();
                    PlaneService.buyPlane(model, number, planes);
                    user.setNumberOfPurchases(user.getNumberOfPurchases() + 1);
                    isActive = false;
                }
            }
        }
    }

    public static void carStoreMenu(boolean isActive) {
        Car[] cars = new Car[0];
        try {
            cars = CarFileService.readCars("examples/Cars.txt");
            CarService.printAllCars(cars);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (isActive) {
            System.out.println("1. print all cars with year from 2000 to 2020");
            System.out.println("2. print the car with minimal cost");
            System.out.println("3. print the car with maximal horsePower");
            System.out.println("4. print electric cars with coast from 20000$ to 50000$");
            System.out.println("5. print all electric cars");
            System.out.println("6. print cars with weight greater then 10000kg");
            System.out.println("7. Buy");

            int command = s.nextInt();

            switch (command) {
                case 1 -> CarService.allCars2000to2020(cars);
                case 2 -> CarService.carWithMinCost(cars);
                case 3 -> CarService.carWithMaxHorsePower(cars);
                case 4 -> CarService.electricCarsWithCost20000to40000(cars);
                case 5 -> CarService.allElectricCars(cars);
                case 6 -> CarService.carsWithWeightGreaterThan10000(cars);
                case 7 -> {
                    System.out.println("Enter car's model: ");
                    String model = s.next();
                    System.out.println("Enter car's number: ");
                    int number = s.nextInt();
                    CarService.buyCar(model, number, cars);
                    user.setNumberOfPurchases(user.getNumberOfPurchases() + 1);
                    isActive = false;
                }
            }
        }
    }

    public static void storesMenu(boolean isActive) {
        while (isActive) {
            System.out.println("1. car store");
            System.out.println("2. plane store");
            System.out.println("3. surprise(random item)");
            System.out.println("4. exit");

            user.setTrustedCustomer(user.getNumberOfPurchases() >= 50);

            int command = s.nextInt();

            switch (command) {
                case 1 -> carStoreMenu(true);
                case 2 -> planeStoreMenu(true);
                case 3 -> SurpriseService.surprise();
                case 4 -> isActive = false;
            }
        }
    }

    public static void balanceMenu(boolean isActive) {
        while (isActive) {
            System.out.println("1. view wallet balance");
            System.out.println("2. add money from card");
            System.out.println("3. shop");
            System.out.println("4. exit");

            int command = s.nextInt();

            switch (command) {
                case 1:
                    System.out.println("wallet balance: " + user.getWalletBalance() + " USD");
                    break;
                case 2:
                    System.out.println("Enter credit card number: ");
                    String card = s.next();
                    System.out.println("Enter the amount: ");
                    long money = s.nextLong();
                    user.setWalletBalance(user.getWalletBalance() + money);
                    System.out.println("Your account has been added " + money + " USD");
                    break;
                case 3:
                    storesMenu(true);
                    break;
                case 4:
                    isActive = false;
                    System.out.println("Bye!");
            }

        }
    }

    public static void start(boolean isActive) throws IOException {
        while (isActive) {
            System.out.println("Enter command number: ");
            System.out.println("1. Admin");
            System.out.println("2. User");

            int command = s.nextInt();

            switch (command) {
                case 1:
                    System.out.println("1. create car");
                    System.out.println("2. create plane");
                    System.out.println("3. exit");

                    int command2 = s.nextInt();

                    if (command2 == 1) {
                        System.out.println("Enter car model: ");
                        String model = s.next();
                        System.out.println("Enter car horsePower: ");
                        int horsePower = s.nextInt();
                        System.out.println("is car electric (yes/no): ");
                        boolean isElectric = s.next().charAt(0) == 'y';

                        Factory.createProductAndAddToFile(new Car(model, horsePower, isElectric, ++Factory.numberC));
                    } else if (command2 == 2) {
                        System.out.println("Enter plane model: ");
                        String model = s.next();
                        System.out.println("Enter plane year: ");
                        int year = s.nextInt();
                        System.out.println("Enter plane country: ");
                        String country = s.next();

                        Factory.createProductAndAddToFile(new Plane(model, year, country));
                    }
                case 2:
                    loginRegisterMenu(true);
                case 3:
                    isActive = false;
            }
        }
    }

    public static void loginRegisterMenu(boolean isActive) {

        while (isActive) {
            System.out.println("Enter command number: ");
            System.out.println("1. login");
            System.out.println("2. register");

            int command = s.nextInt();

            switch (command) {
                case 1:
                    System.out.println("Enter your first name: ");
                    String fName = s.next();
                    System.out.println("Enter your last name: ");
                    String lName = s.next();
                    System.out.println("Enter your password: ");
                    String password = s.next();
                    try {
                        isActive = FileService.login(fName, lName, password);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try {
                        User u = UserService.createUser();
                        FileService.register(u);
                        user = u;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    System.out.println("invalid command!");
            }
        }
    }
}
