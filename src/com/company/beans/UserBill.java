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
            System.out.printf("Is not enough money in the bill! Need %d$", cost-userMoney);
            return false;
        } else {
            userMoney -= cost;
            return true;
        }
    }

    public void addMoney(int amountOfMoney) {
        if (amountOfMoney<1){
            System.out.println("Value must be positive!");
        }else {
            userMoney += amountOfMoney;
        }
    }
    public void showAmountOfMoney(){
        System.out.println("There is "+userMoney+"$ in your bill.");
    }
}
