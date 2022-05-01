/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class JDBCConnection {
     public static Connection getJDBCConnection(){
        final String url = "jdbc:sqlserver://localhost:1433; database=quanlythuvien;";
        final String user = "sa";
        final String password = "123451234512345";
        
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JDBCConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    } 
    
    public static void main(String[] args){
        Connection connection = getJDBCConnection();
        
        if (connection != null){
            System.out.println("Thanh Cong");
        }
        else{
            System.out.println("that bai");
        }
    }
    
}
