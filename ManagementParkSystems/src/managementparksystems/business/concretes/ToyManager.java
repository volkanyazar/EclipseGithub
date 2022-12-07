/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package managementparksystems.business.concretes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import managementparksystems.business.abstracts.ToyService;
import managementparksystems.entities.concretes.Toy;

/**
 *
 * @author Volkan
 */
public class ToyManager extends ConnectionManager implements ToyService{
    
    @Override
    public List<Toy> getEmptyToys(){
        List<Toy> toys = new ArrayList<Toy>();
        try{
        connection = helper.getConnection();
        kmt = connection.createStatement();
        resultSet = kmt.executeQuery("select * from toys where toyBelongsTo is null");
        while(resultSet.next())
        {
        toys.add(new Toy(resultSet.getInt("id"),resultSet.getString("toyName"),resultSet.getString("toyBelongsTo")));
        
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
        
        return toys;
    
    }
    @Override
    public String [] getToysForPersonel(String memberNo){    

        String [] data = new String[10];
        try{
        connection = helper.getConnection();
        kmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
        ResultSet.CONCUR_READ_ONLY);
        resultSet = kmt.executeQuery("select toyName from toys where toyBelongsTo='"+memberNo+"'");

        int i=0;
        while(resultSet.next())
        {
        data[i]=resultSet.getString("toyName"); 
        i++;
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
        
        return data;
}
    @Override
    public int removeToyFromPersonel(String toyName,String memberNo){
        int i=0;
        try {   
            connection = helper.getConnection();
            kmt = connection.createStatement();
            i = kmt.executeUpdate("update toys set toyBelongsTo=null where toyName='"+toyName+"'");
        } catch (SQLException ex) {
            helper.showErrorMessage(ex);
        }
        return i;    
    }
    @Override
    public int addToyToPersonel(String toyName,String memberNo){
        int i=0;
        try { 
            connection = helper.getConnection();
            kmt = connection.createStatement();
            i = kmt.executeUpdate("update toys set toyBelongsTo='"+memberNo+"' where toyName='"+toyName+"'");
        } catch (SQLException ex) {
            helper.showErrorMessage(ex);
        }
        return i;    
    } 
    
}
