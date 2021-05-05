package service;

import model.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringJoiner;

public class UserService {

    public static void updateUser() throws IOException {
        User user = MenuService.user;
        ArrayList<User> users = FileService.readFile("examples/UsersInfo.txt");
        users.removeIf(user1 -> user1.equals(user));
        users.add(user);

        FileService.write(users);
    }

    public static User createUser() {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter user first name: ");
        String fName = s.next();

        System.out.println("Enter user last name: ");
        String lName = s.next();

        System.out.println("Enter user password: ");
        String password = s.next();

        System.out.println("Enter user year: ");
        int year = s.nextInt();

        System.out.println("Enter user gmail: ");
        String gmail = s.next();

        User user = new User(fName,lName,password);
        user.setGmail(gmail);
        user.setYear(year);
        user.setWalletBalance(0);
        user.setTrustedCustomer(false);
        user.setNumberOfPurchases(0);

        return user;
    }
}
