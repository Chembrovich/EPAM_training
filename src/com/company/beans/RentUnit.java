package com.company.beans;

/**
 * Created by Андрей on 18.03.2017.
 */

public class RentUnit {
    private SportEquipment[] units;
    private byte countOfRentedElements;

    public RentUnit() {
        countOfRentedElements = 0;
        units = new SportEquipment[3];
    }

    public boolean addToRentList(SportEquipment sportEquipment) {
        if (countOfRentedElements == 3) {
            System.out.println("You can not rent more than 3 goods!");
            return false;
        } else {
            units[countOfRentedElements] = sportEquipment;
            countOfRentedElements++;
        }
        return true;
    }

    public boolean removeFromRentList(int numberOfRentedElement) {
        if (numberOfRentedElement > 3 || numberOfRentedElement < 0) {
            System.out.println("Please, select items from first to third!");
            return false;
        }
        if (countOfRentedElements == 0) {
            System.out.println("You haven't any rented items!");
            return false;
        } else {
            units[numberOfRentedElement - 1] = null;
            System.arraycopy(units, numberOfRentedElement, units, numberOfRentedElement - 1, 3 - numberOfRentedElement);
            countOfRentedElements--;
        }
        return true;
    }

    public void showRentList() {
        if (countOfRentedElements == 0) {
            System.out.println("Rent list is empty");
        } else {
            int number = 0;
            for (SportEquipment rentItem : units) {
                System.out.println(number + ") " + rentItem.getTitle() + ";" + " price: " + rentItem.getPrice());
            }
        }
    }
}

