package com.company;

import com.company.beans.Shop;
import com.company.beans.SportEquipment;
import com.company.beans.UserBill;
import com.company.enums.Category;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

    public static void main(String[] args) {
        SportEquipment ball = new SportEquipment(Category.FOOTBALL, "Football ball", 35);
        SportEquipment ball1 = new SportEquipment(Category.VOLLEYBALL, "Volleyball ball", 25);
        SportEquipment ball2 = new SportEquipment(Category.BASEBALL, "Baseball ball", 10);

        Shop shop = new Shop();
        shop.addSportEquipment(ball, 3);
        shop.addSportEquipment(ball1, 2);
        shop.addSportEquipment(ball2, 10);

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

        UserBill userBill=new UserBill(userMoney);
        shop.showMenu();

        boolean notExit = true;
        while (notExit) {
            System.out.print("\n Select menu item: ");
            String menuItem = new String();
            Scanner in = new Scanner(System.in);
            menuItem = in.nextLine();
            menuItem = menuItem.toLowerCase();
            switch (menuItem) {
                case "show menu":
                    shop.showMenu();
                    break;
                case "1":
                case "show available sport equipment":
                    shop.showAvailableEquipment();
                    break;
                case "2":
                    shop.showAvailableEquipment();
                    System.out.print("Enter number of item that you want to rent: ");
                    int numberOfItem=in.nextInt();
                    shop.rentSportEquipment(numberOfItem);
                    break;
                case "3":
                    shop.showRentedEquipment();
                    break;
                case "4":
                case "return sport equipment":
                    if (shop.showRentedEquipment() > 0) {
                        System.out.print("Enter number of item that you want to return: ");
                        shop.returnRentedSportEquipment(in.nextInt());
                    }
                    break;
                case "5":
                    userBill.showAmountOfMoney();
                    break;
                case "6":
                    int amountOfMoney = in.nextInt();
                    userBill.addMoney(amountOfMoney);
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
                default:
                    System.out.println("Unknown command!");
                    shop.showMenu();
                    break;
            }
        }
    }
}
