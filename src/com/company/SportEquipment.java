package com.company;

import com.company.Category;

/**
 * Created by Андрей on 18.03.2017.
 */

public class SportEquipment {
    private Category category;
    private String title;
    private int price;

    public SportEquipment(Category category, String title, int price) {
        this.category = category;
        this.title = title;
        this.price = price;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public Category getCategory() {
        return category;
    }



    public void setCategory(Category category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SportEquipment that = (SportEquipment) o;

        if (price != that.price) return false;
        if (category != that.category) return false;
        return title.equals(that.title);
    }

    @Override
    public int hashCode() {
        int result = category.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + price;
        return result;
    }
}


