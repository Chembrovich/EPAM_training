package com.company;

import com.company.beans.Shop;

import java.io.*;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {
        Shop shop = new Shop();

        try (ObjectInputStream objInputStream = new ObjectInputStream(new FileInputStream("src/com/company/shop.dat"))) {
            shop = (Shop) objInputStream.readObject();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        int userMoney = 0;
        boolean userMoneyIsCorrect = false;

        System.out.print("Enter the amount of money in your bill: ");

        while (!userMoneyIsCorrect) {
            try {
                Scanner in = new Scanner(System.in);
                userMoney = in.nextInt();
                if (userMoney < 0) {
                    throw new InputMismatchException();
                } else {
                    userMoneyIsCorrect = true;
                }
            } catch (InputMismatchException ex) {
                System.out.println("Incorrect value! Try again:");
            }
        }

        shop.initializeUserBill(userMoney);
        shop.showMenu();

        boolean notExit = true;
        while (notExit) {
            System.out.print("\n Select menu item: ");
            String menuItem;
            Scanner in = new Scanner(System.in);
            menuItem = in.nextLine();
            menuItem = menuItem.toLowerCase();

            switch (menuItem) {
                case "1":
                    shop.showAvailableEquipment();
                    break;
                case "2":
                    shop.showAvailableEquipment();
                    System.out.print("Enter number of item that you want to rent: ");
                    try {
                        shop.rentSportEquipment(in.nextInt());
                    } catch (InputMismatchException ex) {
                        System.out.println("Incorrect value!");
                    } catch (ArrayIndexOutOfBoundsException ex) {
                        System.out.println("There is no such item.");
                    }
                    break;
                case "3":
                    shop.showRentedEquipment();
                    break;
                case "4":
                    if (shop.showRentedEquipment() > 0) {
                        System.out.print("Enter number of item that you want to return: ");
                        try {
                            shop.returnRentedSportEquipment(in.nextInt());
                        } catch (InputMismatchException ex) {
                            System.out.println("Incorrect value!");
                        } catch (ArrayIndexOutOfBoundsException ex) {
                            System.out.println("There is no such item.");
                        }
                    }
                    break;
                case "5":
                    shop.showUserBill();
                    break;
                case "6":
                    System.out.print("Enter amount of money that you want to add: ");
                    int amountOfMoney;
                    try {
                        amountOfMoney = in.nextInt();
                        shop.addMoneyToUserBill(amountOfMoney);
                    } catch (InputMismatchException ex) {
                        System.out.println("Invalid value!");
                    }
                    break;
                case "7":
                    System.out.print("Enter title: ");
                    String findTitle = new String(in.nextLine());
                    shop.findSportEquipmentByTitle(findTitle);
                    break;
                case "8":
                case "exit":
                    notExit = false;
                    break;
                case "9":
                case "show menu":
                    shop.showMenu();
                    break;
                default:
                    System.out.println("Unknown command!");
                    shop.showMenu();
                    break;
            }
        }
    }
}
