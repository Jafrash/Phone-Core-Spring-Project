package org.example.dao;

import org.example.entity.Phone;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component(value="pdao")
public class PhoneDaoImpl implements PhoneDao {
    String uname="postgres";
    String pass="";
    String url="jdbc:postgresql://localhost:5433/demo";


    @Override
    public List<Phone> findAll() {
        String sql="select * from Phone";
        List<Phone>list=new ArrayList();

        try(Connection con=DriverManager.getConnection(url,uname,pass)){
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");
                String brand=rs.getString("brand");
                String category=rs.getString("category");
                double cost=rs.getDouble("cost");
                Date releaseDate=rs.getDate("releaseDate");

                Phone phone=new Phone(id,name,brand,category,cost,releaseDate.toLocalDate());
                list.add(phone);
            }

        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public void addPhone(Phone phone) {

        String sql="insert into Phone(id,name,brand,category,cost,releaseDate) values(?,?,?,?,?,?)";
        List<Phone>list=new ArrayList<>();
        try(Connection con = DriverManager.getConnection(url,uname,pass)){
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1,phone.getId());
            ps.setString(2,phone.getName());
            ps.setString(3,phone.getBrand());
            ps.setString(4,phone.getCategory());
            ps.setDouble(5,phone.getCost());
            ps.setDate(6,java.sql.Date.valueOf(phone.getReleaseDate()));
            list.add(phone);
            int rowsAffected=ps.executeUpdate();
            System.out.println("Number of rows affected "+rowsAffected);

        }catch(SQLException e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public void removePhone(int id) {
        String sql="delete from Phone where id=?";

        try(Connection con = DriverManager.getConnection(url,uname,pass)){
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            int rowsAffected=ps.executeUpdate();
            System.out.println("Number of rows affected "+rowsAffected);
            System.out.println("Phone with ID "+id+" removed successfully");

        }catch(SQLException e){
            throw new RuntimeException(e);
        }

    }


    @Override
    public void sortByPrice() {
        String sql="select * from Phone order by cost";

        try(Connection con=DriverManager.getConnection(url,uname,pass)){
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");
                String brand=rs.getString("brand");
                String category=rs.getString("category");
                double cost=rs.getDouble("cost");
                Date releaseDate=rs.getDate("releaseDate");

                Phone phone=new Phone(id,name,brand,category,cost,releaseDate.toLocalDate());
                System.out.println(phone);
            }

        }catch(SQLException e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public void sortPriceDescending() {


        String sql="select * from Phone order by cost desc";

        try(Connection con=DriverManager.getConnection(url,uname,pass)){
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");
                String brand=rs.getString("brand");
                String category=rs.getString("category");
                double cost=rs.getDouble("cost");
                Date releaseDate=rs.getDate("releaseDate");

                Phone phone=new Phone(id,name,brand,category,cost,releaseDate.toLocalDate());
                System.out.println(phone);
            }

        }catch(SQLException e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public void sortByBrand() {
        String sql="select * from Phone order by brand";

        try(Connection con=DriverManager.getConnection(url,uname,pass)){
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");
                String brand=rs.getString("brand");
                String category=rs.getString("category");
                double cost=rs.getDouble("cost");
                Date releaseDate=rs.getDate("releaseDate");

                Phone phone=new Phone(id,name,brand,category,cost,releaseDate.toLocalDate());
                System.out.println(phone);
            }

        }catch(SQLException e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public void sortByBrandDescending() {

        String sql="select * from Phone order by brand desc";

        try(Connection con=DriverManager.getConnection(url,uname,pass)){
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");
                String brand=rs.getString("brand");
                String category=rs.getString("category");
                double cost=rs.getDouble("cost");
                Date releaseDate=rs.getDate("releaseDate");

                Phone phone=new Phone(id,name,brand,category,cost,releaseDate.toLocalDate());
                System.out.println(phone);
            }

        }catch(SQLException e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public void sortByModel() {

        String sql="select * from Phone order by category";

        try(Connection con=DriverManager.getConnection(url,uname,pass)){
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");
                String brand=rs.getString("brand");
                String category=rs.getString("category");
                double cost=rs.getDouble("cost");
                Date releaseDate=rs.getDate("releaseDate");

                Phone phone=new Phone(id,name,brand,category,cost,releaseDate.toLocalDate());
                System.out.println(phone);
            }

        }catch(SQLException e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public void sortByModelDescending() {

        String sql="select * from Phone order by category desc";

        try(Connection con=DriverManager.getConnection(url,uname,pass)){
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");
                String brand=rs.getString("brand");
                String category=rs.getString("category");
                double cost=rs.getDouble("cost");
                Date releaseDate=rs.getDate("releaseDate");

                Phone phone=new Phone(id,name,brand,category,cost,releaseDate.toLocalDate());
                System.out.println(phone);
            }

        }catch(SQLException e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public void sortByReleaseDate() {

        String sql="select * from Phone order by releaseDate";

        try(Connection con=DriverManager.getConnection(url,uname,pass)){
            PreparedStatement ps=con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");
                String brand=rs.getString("brand");
                String category=rs.getString("category");
                double cost=rs.getDouble("cost");
                Date releaseDate=rs.getDate("releaseDate");

                Phone phone=new Phone(id,name,brand,category,cost,releaseDate.toLocalDate());
                System.out.println(phone);
            }

        }catch(SQLException e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Phone> filterByBrand(String brand) {
        List<Phone>list= new ArrayList<>();
        String sql="select * from Phone where brand=?";

        try(Connection con=DriverManager.getConnection(url,uname,pass)){
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,brand);
            ResultSet rs=ps.executeQuery();

            while(rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");
                String brand1=rs.getString("brand");
                String category=rs.getString("category");
                double cost=rs.getDouble("cost");
                Date releaseDate=rs.getDate("releaseDate");

                Phone phone=new Phone(id,name,brand1,category,cost,releaseDate.toLocalDate());
                list.add(phone);

            }


        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public List<Phone> filterByModel(String model) {
        String sql="select * from Phone where category=?";
        List<Phone>list=new ArrayList<>();

        try(Connection con=DriverManager.getConnection(url,uname,pass)){
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setString(1,model);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                int id=rs.getInt("id");
                String name=rs.getString("name");
                String brand=rs.getString("brand");
                String category=rs.getString("category");
                double cost=rs.getDouble("cost");
                Date releaseDate=rs.getDate("releaseDate");

                Phone phone=new Phone(id,name,brand,category,cost,releaseDate.toLocalDate());
                list.add(phone);
            }

        }catch(SQLException e){
            throw new RuntimeException(e);
        }
        return list;
    }
}
