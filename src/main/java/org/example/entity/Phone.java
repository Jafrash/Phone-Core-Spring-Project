package org.example.entity;

import java.time.LocalDate;

public class Phone {
    private int id;
    private String name;
    private String brand;
    private String category;
    private double cost;
    private LocalDate releaseDate;

    @Override
    public String toString() {
        return "Phone{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", category='" + category + '\'' +
                ", cost=" + cost +
                ", releaseDate=" + releaseDate +
                '}';
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }


    public Phone(int id, String name, String brand, String category, double cost, LocalDate releaseDate) {
        this.id = id;
        this.name = name;
        this.brand = brand;
        this.category = category;
        this.cost = cost;
        this.releaseDate = releaseDate;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
