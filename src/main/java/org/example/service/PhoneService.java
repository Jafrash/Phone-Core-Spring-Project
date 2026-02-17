package org.example.service;

import org.example.entity.Phone;

import java.util.List;

public interface PhoneService {
    List<Phone> findAll();
    void addPhone(Phone phone);
    void removePhone(int id);
    void sortByPrice();
    void sortPriceDescending();
    void sortByBrand();
    void sortByBrandDescending();
    void sortByModel();
    void sortByModelDescending();
    public void sortByReleaseDate();
    List<Phone>filterByBrand(String brand);
    List<Phone>filterByModel(String model);


}
