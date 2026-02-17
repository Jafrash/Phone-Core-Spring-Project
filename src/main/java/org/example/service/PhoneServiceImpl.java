package org.example.service;

import org.example.dao.PhoneDao;
import org.example.dao.PhoneDaoImpl;
import org.example.entity.Phone;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component(value="pser")
public class PhoneServiceImpl implements PhoneService{
    PhoneDao phoneDao;

    public PhoneServiceImpl(PhoneDao phoneDao) {
        this.phoneDao = phoneDao;
    }



    @Override
    public List<Phone> findAll() {
       return phoneDao.findAll();
    }

    @Override
    public void addPhone(Phone phone) {
        if(phone==null || phone.getBrand().isEmpty() || phone.getBrand()==null ||phone.getCategory().isEmpty() || phone.getCategory()==null || phone.getCost()<=0 || phone.getName().isEmpty() || phone.getName()==null || phone.getReleaseDate()==null || phone.getReleaseDate().isAfter(java.time.LocalDate.now())){
            System.out.println("Cannot addd invalid values to Database");
        }

        phoneDao.addPhone(phone);
    }

    @Override
    public void removePhone(int id) {
        if(id<=0){
            System.out.println("Cannot remove phone with invalid id");
            return;
        }

        if(id!=phoneDao.findAll().stream().filter(p->p.getId()==id).findFirst().orElse(null).getId()){
            System.out.println("Cannot remove phone with id that does not exist in database");
            return;
        }
        phoneDao.removePhone(id);
    }

    @Override
    public void sortByPrice() {
        phoneDao.findAll().stream().sorted((p1,p2)->Double.compare(p1.getCost(),p2.getCost())).forEach(p-> System.out.println(p.getName()+" "+p.getCost()+" "+p.getBrand()+" "+p.getCategory()+" "+p.getReleaseDate()));
    }

    @Override
    public void sortPriceDescending() {

        phoneDao.findAll().stream().sorted((p1,p2)->Double.compare(p2.getCost(),p1.getCost())).forEach(p-> System.out.println(p.getName()+" "+p.getCost()+" "+p.getBrand()+" "+p.getCategory()+" "+p.getReleaseDate()));

    }

    @Override
    public void sortByBrand() {
        phoneDao.findAll().stream().sorted((p1,p2)->p1.getBrand().compareTo(p2.getBrand())).forEach(p-> System.out.println(p.getName()+" "+p.getCost()+" "+p.getBrand()+" "+p.getCategory()+" "+p.getReleaseDate()));

    }

    @Override
    public void sortByBrandDescending() {
        phoneDao.findAll().stream().sorted((p1,p2)->p2.getBrand().compareTo(p1.getBrand())).forEach(p-> System.out.println(p.getName()+" "+p.getCost()+" "+p.getBrand()+" "+p.getCategory()+" "+p.getReleaseDate()));
    }

    @Override
    public void sortByModel() {
        phoneDao.findAll().stream().sorted((p1,p2)->p1.getName().compareTo(p2.getName())).forEach(p-> System.out.println(p.getName()+" "+p.getCost()+" "+p.getBrand()+" "+p.getCategory()+" "+p.getReleaseDate()));
    }

    @Override
    public void sortByModelDescending() {
        phoneDao.findAll().stream().sorted((p1,p2)->p2.getName().compareTo(p1.getName())).forEach(p-> System.out.println(p.getName()+" "+p.getCost()+" "+p.getBrand()+" "+p.getCategory()+" "+p.getReleaseDate()));
    }

    @Override
    public void sortByReleaseDate() {
        phoneDao.findAll().stream().sorted((p1,p2)->p1.getReleaseDate().compareTo(p2.getReleaseDate())).forEach(p-> System.out.println(p.getName()+" "+p.getCost()+" "+p.getBrand()+" "+p.getCategory()+" "+p.getReleaseDate()));
    }

    @Override
    public List<Phone> filterByBrand(String brand) {
        return phoneDao.findAll().stream().filter(p->p.getBrand().equalsIgnoreCase(brand)).toList();
    }

    @Override
    public List<Phone> filterByModel(String model) {
        return phoneDao.findAll().stream().filter(p->p.getCategory().equalsIgnoreCase(model)).toList();
    }
}
