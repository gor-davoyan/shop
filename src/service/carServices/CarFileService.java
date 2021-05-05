package service.carServices;

import model.Car;
import model.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.StringJoiner;

public class CarFileService {

    public static void writeWithAppend(Car car) throws IOException {

        ArrayList<String> u = new ArrayList<>();
        StringJoiner sj = new StringJoiner(",");

        sj.add(car.getModel())
                .add(String.valueOf(car.getYear()))
                .add(String.valueOf(car.getWeight()))
                .add(String.valueOf(car.getCost()))
                .add(car.getCountry())
                .add(String.valueOf(car.getHorsePower()))
                .add(car.isElectric() ? "yes" : "no")
                .add(String.valueOf(car.getNumber()))
                .add("\n");

        u.add(sj.toString());


        Files.write(Paths.get("examples/Cars.txt"), u, StandardOpenOption.APPEND);
    }

    public static Car[] readCars(String path) throws IOException {
        String[] read = Files.readAllLines(Paths.get(path)).toArray(new String[0]);

        Car[] cars = new Car[read.length];

        for (int i = 0; i < cars.length; i++) {
            String[] str = read[i].split(",");
            String model = str[0];
            int year = Integer.parseInt(str[1]);
            double weight = Double.parseDouble(str[2]);
            long cost = Long.parseLong(str[3]);
            String country = str[4];
            int horsePower = Integer.parseInt(str[5]);
            boolean isElectric = str[6].charAt(0) == 'y';
            int number = Integer.parseInt(str[7]);

            Car car = new Car(model, horsePower, isElectric, number);
            car.setYear(year);
            car.setWeight(weight);
            car.setCost(cost);
            car.setCountry(country);

            cars[i] = car;
        }

        return cars;
    }
}
