/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package managementparksystems.business.concretes;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import managementparksystems.business.abstracts.ConnectionService;
import managementparksystems.connections.DbConnection;


/**
 *
 * @author Volkan
 */
public class ConnectionManager implements ConnectionService{
      protected Connection connection;
      protected DbConnection helper;
      protected Statement kmt;
      protected ResultSet resultSet;
      
      public ConnectionManager(){
          this.connection = null;
          this.helper = new DbConnection();
          this.kmt = null;
          this.resultSet = null;
      
      }
    
}
