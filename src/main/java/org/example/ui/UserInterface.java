package org.example.ui;

import org.example.dao.PhoneDao;
import org.example.dao.PhoneDaoImpl;
import org.example.entity.Phone;
import org.example.service.PhoneService;
import org.example.service.PhoneServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
@Configuration
@ComponentScan(basePackages = "org.example")

public class UserInterface {

   //Using @Bean annotation to define beans for PhoneDao and PhoneService
    /*
    @Bean
    public PhoneDao getPhoneDao(){
        return new PhoneDaoImpl();
    }

    @Bean
    public PhoneService getPhoneService(PhoneDao phoneDao){
        return new PhoneServiceImpl(phoneDao);
    }

     */
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
        /*

        List<Phone>list= phoneDao.filterByBrand("Samsung");
        list.stream().forEach((p)-> System.out.println("ID : "+p.getId()+" - Name : "+p.getName()+" - Brand : "+p.getBrand()+" - Category : "+p.getCategory()+" - Cost : "+p.getCost()+" - Release Date : "+p.getReleaseDate()));

         */


        /*
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        PhoneService phoneService = context.getBean("phoneService",PhoneService.class);
        phoneService.findAll().forEach(p-> System.out.println("ID : "+p.getId()+" - Name : "+p.getName()+" - Brand : "+p.getBrand()+" - Category : "+p.getCategory()+" - Cost : "+p.getCost()+" - Release Date : "+p.getReleaseDate()));
         */




        ApplicationContext context=new AnnotationConfigApplicationContext(UserInterface.class);
        PhoneService pService=(PhoneService)context.getBean(PhoneServiceImpl.class);
        pService.findAll().forEach(p-> System.out.println("ID : "+p.getId()+" - Name : "+p.getName()+" - Brand : "+p.getBrand()+" - Category : "+p.getCategory()+" - Cost : "+p.getCost()+" - Release Date : "+p.getReleaseDate()));



    }
}