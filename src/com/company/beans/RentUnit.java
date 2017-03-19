package com.company.beans;

/**
 * Created by Андрей on 18.03.2017.
 */

public class RentUnit {
    private SportEquipment[] units;

    public byte getCountOfRentedElements() {
        return countOfRentedElements;
    }

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

    /*public boolean removeFromRentList(int numberOfRentedElement) {
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
    } */

    public SportEquipment removeFromRentList(int numberOfRentedElement) {
        if (numberOfRentedElement > 3 || numberOfRentedElement < 0) {
            System.out.println("Please, select items from first to third!");
            return null;
        }
        if (countOfRentedElements == 0) {
            System.out.println("You haven't any rented items!");
            return null;
        } else {
            SportEquipment returnedEquipment=units[numberOfRentedElement - 1];
            units[numberOfRentedElement - 1] = null;
            System.arraycopy(units, numberOfRentedElement, units, numberOfRentedElement - 1, 3 - numberOfRentedElement);
            countOfRentedElements--;
            return returnedEquipment;
        }

    }

    public void showRentList() {
        if (countOfRentedElements == 0) {
            System.out.println("Rent list is empty");
        } else {
            int number = 1;
            for (int i = 0; i < countOfRentedElements; i++) {
                System.out.println(number + ") " + units[i].getTitle() + "; " + "price: " + units[i].getPrice());
                number++;
            }
        }
    }
}

