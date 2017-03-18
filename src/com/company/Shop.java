package com.company;

/**
 * Created by Андрей on 18.03.2017.
 */

import java.util.*;

public class Shop {
    private Map<SportEquipment, Integer> goods;

    public Shop(){
        goods=new HashMap<SportEquipment,Integer>();
    }

    public Shop(SportEquipment key,Integer value){
        goods=new HashMap<SportEquipment,Integer>();
        goods.put(key,value);
    }

    public void addSportEquipment(SportEquipment key,Integer count){
        if (goods.containsKey(key)) {
            Integer currentValue = goods.get(key);
            goods.put(key, currentValue + count);
        }
        else
            goods.put(key,count);
    }


    public void showAssortiment()
    {
        for (Map.Entry<SportEquipment,Integer> entry : goods.entrySet()) {
            System.out.println("id =  " + entry.getKey() + " count = " + entry.getValue());
        }
    }
}


