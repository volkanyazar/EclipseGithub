/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package managementparksystems.business.concretes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


import managementparksystems.business.abstracts.PersonelService;
import managementparksystems.entities.concretes.Personel;


/**
 *
 * @author Volkan
 */
public class PersonelManager extends ConnectionManager implements PersonelService{
     
    
    
    @Override
    public void getAllPersonel(){
       
        
            /*
            
            Statement statement = null;
            ResultSet resultSet;
           try {
            connection = helper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from personel");
            ArrayList<Personel> personels = new ArrayList<>();
            while (resultSet.next()) {
                personels.add(new Personel(
                        resultSet.getInt("id"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("tcNo"),
                        resultSet.getString("memberNo"),
                        resultSet.getString("workPosition"),
                        resultSet.getString("year"),
                        resultSet.getString("salary")));
            }
            System.out.println(personels.size());
        } catch (SQLException ex) {
            Logger.getLogger(PersonelManager.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(PersonelManager.class.getName()).log(Level.SEVERE, null, ex);
                }
           }*/
    }
    @Override
    public List<Personel> getAll(){
      
        List<Personel> datas = new ArrayList<Personel>();
        try{
        connection = helper.getConnection();
        kmt = connection.createStatement();
        resultSet = kmt.executeQuery("select * from personel");
        while (resultSet.next()) {
                datas.add(new Personel(
                        resultSet.getInt("id"),
                        resultSet.getString("firstName"),
                        resultSet.getString("lastName"),
                        resultSet.getString("tcNo"),
                        resultSet.getString("memberNo"),
                        resultSet.getString("workPosition"),
                        resultSet.getString("year"),
                        resultSet.getString("salary")));
            }
        }catch(SQLException s)
        {
        s.printStackTrace();
        }
        try{
            kmt.close();
            resultSet.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.exit(1);
        
        }
        
        return datas;
    }
    @Override
    public List<Personel> searchPersonel(String whatSrch,String srcKey){    
        List<Personel> datas = new ArrayList<Personel>();
        
        try{
        connection = helper.getConnection();
        kmt = connection.createStatement();
        resultSet = kmt.executeQuery("select * from personel where "+whatSrch+" LIKE '%"+srcKey+"%'");
        while(resultSet.next())
        {
        datas.add(new Personel(resultSet.getString("firstName"),resultSet.getString("lastName"),resultSet.getString("year")));
        
        }
        }catch(SQLException s)
        {
        s.printStackTrace();
        }
        try{
            kmt.close();
            resultSet.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            System.exit(1);
        
        }
        
        return datas;
    }
     @Override
     public String[] searchMember(String memberNo,String tcNo)
    {
        String [] members = new String[2];
        try {
            connection = helper.getConnection();
            kmt = connection.createStatement();
            resultSet = kmt.executeQuery("select firstName,lastName from personel where memberNo='"+memberNo+"' OR tcNo='"+tcNo+"'");
            while(resultSet.next())
            {
            members[0] = resultSet.getString("firstName");
            members[1] = resultSet.getString("lastName");
            }
        } catch (SQLException ex) {
            helper.showErrorMessage(ex);
        }
        return members;
    }
      @Override
      public int editMember(String tcNo,String firstName,String lastName){
        int i=0;
        try {    
            connection = helper.getConnection();
            kmt = connection.createStatement();
            i = kmt.executeUpdate("update personel set tcNo='"+tcNo+"',firstName='"+firstName+"',lastName='"+lastName+"' where tcNo='"+tcNo+"'");
        } catch (SQLException ex) {
            helper.showErrorMessage(ex);
        }
        return i;    
    }
      @Override
      public String[] alternateSearchMember(String memberNo)
    {
        String [] datas = new String[3];
        try {
            connection = helper.getConnection();
            kmt = connection.createStatement();
            resultSet = kmt.executeQuery("select firstName,lastName,tcNo from personel where memberNo='"+memberNo+"'");
            while(resultSet.next())
            {
            datas[0] = resultSet.getString("firstName");
            datas[1] = resultSet.getString("lastName");
            datas[2] = resultSet.getString("tcNo");
            }
        } catch (SQLException ex) {
            helper.showErrorMessage(ex);
        }
        return datas;
    }
      
      @Override
      public int addNewMember(String memberNo,String tcNo,String name,String surname){
 
        int i=0;
        try {    
            connection = helper.getConnection();
            kmt = connection.createStatement();
            i = kmt.executeUpdate("insert into personel(memberNo,tcNo,firstName,lastName) values ('"+memberNo+"','"+tcNo+"','"+name+"','"+surname+"')");
        } catch (SQLException ex) {
            helper.showErrorMessage(ex);
        }
        return i;
     
    }
      @Override
      public int deleteMemberWithTcNo(String tcNo,String name,String surname){
        int i=0;
        try {      
            connection = helper.getConnection();
            kmt = connection.createStatement();
            i = kmt.executeUpdate("DELETE FROM personel WHERE tcNo='"+tcNo+"'");
        } catch (SQLException ex) {
            helper.showErrorMessage(ex);
        }
        return i;
     
    }
}
