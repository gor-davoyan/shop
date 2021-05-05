package service.planeService;

import model.Car;
import model.Plane;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class PlaneFileService {

    public static void writeWithAppend(Plane plane) throws IOException {

        ArrayList<String> u = new ArrayList<>();
        StringJoiner sj = new StringJoiner(",");

        sj.add(plane.getModel())
                .add(String.valueOf(plane.getYear()))
                .add(String.valueOf(plane.getWeight()))
                .add(plane.getCountry())
                .add(String.valueOf(plane.getCost()))
                .add(String.valueOf(plane.isMilitary()))
                .add(String.valueOf(plane.getHoursInSky()))
                .add(String.valueOf(plane.getNumber()))
                .add("\n");

        u.add(sj.toString());


        Files.write(Paths.get("examples/Planes.txt"), u, StandardOpenOption.APPEND);
    }

    public static List<Plane> readPlanes(String path) throws IOException {
        List<String> read = Files.readAllLines(Paths.get(path));

        List<Plane> planes = new ArrayList<>();
        for (String value : read) {
            String[] s = value.split(",");
            String model = s[0];
            int year = Integer.parseInt(s[1]);
            double weight = Double.parseDouble(s[2]);
            String country = s[3];
            long cost = Long.parseLong(s[4]);
            boolean isMilitary = Boolean.parseBoolean(s[5]);
            int hoursInSky = Integer.parseInt(s[6]);
            int number = Integer.parseInt(s[7]);

            Plane plane = new Plane(model, year, country);
            plane.setWeight(weight);
            plane.setCost(cost);
            plane.setMilitary(isMilitary);
            plane.setHoursInSky(hoursInSky);
            plane.setNumber(number);

            planes.add(plane);
        }

        return planes;
    }
}
