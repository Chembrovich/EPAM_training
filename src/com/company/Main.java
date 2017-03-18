package com.company;
import com.company.Category;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello!");
        SportEquipment ball=new SportEquipment(Category.FOOTBALL,"Football ball",35);
        SportEquipment ball1=new SportEquipment(Category.FOOTBALL,"Football ball",35);
        Shop shop = new Shop();
        shop.addSportEquipment(ball,2);
        shop.addSportEquipment(ball1,2);
        shop.showAssortiment();





    }
}
