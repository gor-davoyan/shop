package service;

import model.User;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class FileService {


    public static void createFile(String path, String name) throws IOException {
        File folder = new File(path);

        if (!folder.exists()) {
            folder.mkdirs();
        }
        File file = new File(path + File.separator + name);
        file.createNewFile();
    }

    public static void write(ArrayList<User> users) throws IOException {

        ArrayList<String> u = new ArrayList<>();
        for (User user : users) {
            StringJoiner sj = new StringJoiner(",");

            sj.add(user.getFName())
                    .add(user.getLName())
                    .add(user.getPassword())
                    .add(String.valueOf(user.getYear()))
                    .add(user.getGmail())
                    .add(String.valueOf(user.getWalletBalance()))
                    .add(String.valueOf(user.isTrustedCustomer()))
                    .add(String.valueOf(user.getNumberOfPurchases()));

            u.add(sj.toString());
        }

        Files.write(Paths.get("examples/UsersInfo.txt"), u);
    }

    public static void register(User user) throws IOException {
        StringJoiner sj = new StringJoiner(",");

        sj.add(user.getFName())
                .add(user.getLName())
                .add(user.getPassword())
                .add(String.valueOf(user.getYear()))
                .add(user.getGmail())
                .add(String.valueOf(user.getWalletBalance()))
                .add(String.valueOf(user.isTrustedCustomer()))
                .add(String.valueOf(user.getNumberOfPurchases()));

        Files.write(Paths.get("examples/UsersInfo.txt"), (sj + "\n").getBytes(), StandardOpenOption.APPEND);
    }

    public static boolean login(String fName, String lName, String password) throws IOException {
        User u1 = new User(fName, lName, password);
        for (User user : readFile("examples/UsersInfo.txt")) {
            if (user.equals(u1)) {
                System.out.println("Successfully completed!");

                MenuService.user = user;
                return false;
            }
        }
        System.out.println("login failed!");
        return true;
    }

    static ArrayList<User> readFile(String path) throws IOException {
        List<String> read = Files.readAllLines(Paths.get(path));

        ArrayList<User> users = new ArrayList<>();

        for (String s : read) {
            String[] s1 = s.split(",");
            String fName = s1[0];
            String lName = s1[1];
            String password = s1[2];
            int year = Integer.parseInt(s1[3]);
            String gmail = s1[4];
            long walletBalance = Long.parseLong(s1[5]);
            boolean trustedCustomer = s1[6].charAt(0) == 't';
            int numberOfPurchases = Integer.parseInt(s1[7]);


            User u = new User(fName, lName, password);
            u.setYear(year);
            u.setGmail(gmail);
            u.setWalletBalance(walletBalance);
            u.setNumberOfPurchases(numberOfPurchases);
            u.setTrustedCustomer(trustedCustomer);
            users.add(u);
        }

        return users;
    }
}
