package com.company;
import com.company.beans.Shop;
import com.company.beans.SportEquipment;
import com.company.enums.Category;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello!");
        SportEquipment ball=new SportEquipment(Category.FOOTBALL,"Football ball",35);
        SportEquipment ball1=new SportEquipment(Category.VOLLEYBALL,"Volleyball ball",25);
        SportEquipment ball2=new SportEquipment(Category.BASEBALL,"Baseball ball",10);

        Shop shop = new Shop();
        shop.addSportEquipment(ball,3);
        shop.addSportEquipment(ball1,2);
        shop.addSportEquipment(ball2,10);

        shop.showAvailableEquipment();
        System.out.println();
        shop.showRentedEquipment();
    }
}
