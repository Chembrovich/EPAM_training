package com.company.beans;

/**
 * Created by Андрей on 19.03.2017.
 */
public class UserBill {
    private int userMoney;

    public int getUserMoney() {
        return userMoney;
    }

    public void setUserMoney(int userMoney) {
        this.userMoney = userMoney;
    }

    public UserBill(int userMoney) {
        this.userMoney = userMoney;
    }

    public boolean withdrawMoney(int cost) {
        if (cost > userMoney) {
            System.out.println("Is not enough money on the bill!");
            return false;
        } else {
            userMoney -= cost;
            return true;
        }
    }

    public void addMoney(int amount) {
        if (amount<0){
            System.out.println("");
        }else {
            userMoney += amount;
        }
    }
    public void showAmountOfMoney(){
        System.out.println(userMoney);
    }
}
