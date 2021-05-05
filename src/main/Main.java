package main;

import model.User;
import service.FileService;
import service.MenuService;
import service.UserService;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

//        try {
//            FileService.createFile("examples", "UsersInfo.txt");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        try {
            MenuService.start(true);
        } catch (IOException e) {
            e.printStackTrace();
        }

        boolean isActive = true;

        MenuService.balanceMenu(true);

        try {
            UserService.updateUser();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
