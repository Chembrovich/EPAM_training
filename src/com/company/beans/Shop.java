package com.company.beans;

/**
 * Created by Андрей on 18.03.2017.
 */

import com.company.Main;
import sun.plugin.javascript.navig.Array;

import java.util.LinkedHashMap;
import java.util.Map;

public class Shop {
    private Map<SportEquipment, Integer> goods;
    private RentUnit rentUnit;
    private UserBill userBill;

    public Shop() {
        goods = new LinkedHashMap<SportEquipment, Integer>();
        rentUnit = new RentUnit();
        userBill=new UserBill(0);
    }

    public Shop(SportEquipment key, Integer value) {
        rentUnit = new RentUnit();
        goods = new LinkedHashMap<SportEquipment, Integer>();
        goods.put(key, value);
        userBill=new UserBill(0);
    }

    public void addSportEquipment(SportEquipment key, Integer count) {
        if (goods.containsKey(key)) {
            Integer currentValue = goods.get(key);
            goods.put(key, currentValue + count);
        } else
            goods.put(key, count);
    }

    public void removeSportEquipment(SportEquipment key) {
        if (goods.containsKey(key)) {
            Integer currentValue = goods.get(key);
            if (currentValue == 1) {
                goods.remove(key);
            } else {
                goods.put(key, currentValue - 1);
            }
        } else
            System.out.println("There is no such item in shop.");
    }


    public void showAvailableEquipment() {
        int number = 1;
        for (Map.Entry<SportEquipment, Integer> entry : goods.entrySet()) {
            System.out.println(number + ") " + entry.getKey().getTitle() + "; count = " + entry.getValue());
            number++;
        }
    }

    public byte showRentedEquipment() {
        rentUnit.showRentList();
        return rentUnit.getCountOfRentedElements();
    }

    public void rentSportEquipment(int number){
        SportEquipment[] availableSportEquipment;
        availableSportEquipment=goods.keySet().toArray(new SportEquipment[goods.size()]);

        SportEquipment rentedSportEquipment=availableSportEquipment[number-1];

        removeSportEquipment(rentedSportEquipment);
        rentUnit.addToRentList(rentedSportEquipment);

    }

    public void returnRentedSportEquipment(int numberOfRentedEquipment){
        addSportEquipment(rentUnit.removeFromRentList(numberOfRentedEquipment),1);
    }

    public void findSportEquipmentByTitle(String userString) {
        int number = 1;
        for (Map.Entry<SportEquipment, Integer> entry : goods.entrySet()) {
            if (entry.getKey().getTitle().indexOf(userString) != -1) {
                System.out.println(number + ") " + entry.getKey().getTitle() + "; count = " + entry.getValue());
                number++;
            }
        }
        if (number==1){
            System.out.println("There is no such item in shop.");
        }
    }

    public void showMenu(){
        System.out.println("\n Shop menu:");
        System.out.println("    1) Show available sport equipment.");
        System.out.println("    2) Rent sport equipment.");
        System.out.println("    3) Show rented sport equipment.");
        System.out.println("    4) Return sport equipment.");
        System.out.println("    5) Show amount of money.");
        System.out.println("    6) Add money.");
        System.out.println("    7) Find sport equipment by title.");
        System.out.println("    8) Exit.");
    }
}



