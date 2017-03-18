package com.company.beans;

/**
 * Created by Андрей on 18.03.2017.
 */

import java.util.*;

public class Shop {
    private Map<SportEquipment, Integer> goods;
    private RentUnit rentUnit;

    public Shop() {
        goods = new HashMap<SportEquipment, Integer>();
        rentUnit = new RentUnit();
    }

    public Shop(SportEquipment key, Integer value) {
        rentUnit = new RentUnit();
        goods = new HashMap<SportEquipment, Integer>();
        goods.put(key, value);
    }

    public void addSportEquipment(SportEquipment key, Integer count) {
        if (goods.containsKey(key)) {
            Integer currentValue = goods.get(key);
            goods.put(key, currentValue + count);
        } else
            goods.put(key, count);
    }


    public void showAvailableEquipment() {
        int number = 1;
        for (Map.Entry<SportEquipment, Integer> entry : goods.entrySet()) {
            System.out.println(number + ") " + entry.getKey().getTitle() + "; count = " + entry.getValue());
            number++;
        }
    }

    public void showRentedEquipment() {
        rentUnit.showRentList();
    }
}


