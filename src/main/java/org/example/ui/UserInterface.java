package org.example.ui;

import org.example.dao.PhoneDao;
import org.example.dao.PhoneDaoImpl;
import org.example.entity.Phone;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class UserInterface {
    public static void main(String[] args) {
        PhoneDao phoneDao=new PhoneDaoImpl();
        /*
        phoneDao.addPhone(new Phone(1,"iPhone 13","Apple","Smartphone",999.99, LocalDate.parse("2021-09-24")));
        phoneDao.addPhone(new Phone(2,"Galaxy S21","Samsung","Smartphone",799.99, LocalDate.parse("2021-01-29")));
        phoneDao.addPhone(new Phone(3,"Pixel 6","Google","Smartphone",599.99, LocalDate.parse("2021-10-28")));
        phoneDao.addPhone(new Phone(4,"OnePlus 9","OnePlus","Smartphone",729.99, LocalDate.parse("2021-03-23")));
        phoneDao.addPhone(new Phone(5,"Xperia 1 III","Sony","Smartphone",1299.99, LocalDate.parse("2021-08-19")));
        List<Phone>list= phoneDao.findAll();
        list.stream().forEach((p)-> System.out.println("ID : "+p.getId()+" - Name : "+p.getName()+" - Brand : "+p.getBrand()+" - Category : "+p.getCategory()+" - Cost : "+p.getCost()+" - Release Date : "+p.getReleaseDate()));
         */

       // phoneDao.removePhone(5);

        //List<Phone>list= phoneDao.findAll();
        //list.stream().forEach((p)-> System.out.println("ID : "+p.getId()+" - Name : "+p.getName()+" - Brand : "+p.getBrand()+" - Category : "+p.getCategory()+" - Cost : "+p.getCost()+" - Release Date : "+p.getReleaseDate()));

        // phoneDao.sortByReleaseDate();

        List<Phone>list= phoneDao.filterByBrand("Samsung");
        list.stream().forEach((p)-> System.out.println("ID : "+p.getId()+" - Name : "+p.getName()+" - Brand : "+p.getBrand()+" - Category : "+p.getCategory()+" - Cost : "+p.getCost()+" - Release Date : "+p.getReleaseDate()));
    }
}