/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Sach;

/**
 *
 * @author Admin
 */
public class SachDao {
    public List<Sach> getAllSachs(){
        List<Sach> sachs = new ArrayList<Sach>();
        Connection connection= JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM SACH ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Sach sach = new Sach();
                
                sach.setMasach(rs.getString("MASACH"));
                sach.setTensach(rs.getString("TENSACH"));
                sach.setTacgia(rs.getString("TACGIA"));
                sach.setNhaxuatban(rs.getString("TENXB"));
                sach.setNamxuatban(rs.getString("NAMXB"));
                
                
                
                sachs.add(sach);
            }
             
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sachs;
    }
     
     public Sach getSachByMasach(String masach){
         Connection connection= JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM SACH WHERE MASACH =?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, masach);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                Sach sach = new Sach();
                
                sach.setMasach(rs.getString("MASACH"));
                sach.setTensach(rs.getString("TENSACH"));
                sach.setTacgia(rs.getString("TACGIA"));
                sach.setNamxuatban(rs.getString("TENXB"));
                sach.setNamxuatban(rs.getString("NAMXB"));
                
               
                
                return sach;
            }
             
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addSach(Sach sach){
        Connection connection= JDBCConnection.getJDBCConnection();
        String sql = "INSERT INTO SACH(MASACH, TENSACH, TACCGIA,TENXB, NAMXB)"+ "VALUES(?,?,?,?,?) ";
       
      
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, sach.getMasach());
            preparedStatement.setString(2, sach.getTensach());
            preparedStatement.setString(3, sach.getTacgia());
            preparedStatement.setString(3, sach.getNhaxuatban());
            preparedStatement.setString(4, sach.getNamxuatban());
           
            
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
            
        } catch (SQLException ex) {
            Logger.getLogger(DocgiaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public void updateSach(Sach sach){
        Connection connection= JDBCConnection.getJDBCConnection();
        String sql = "UPDATE Sach SET TENSACH = ?, TACGIA = ?,TENXB=? , NAMXB = ? WHERE MASACH =?";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1, sach.getTensach());
            preparedStatement.setString(2, sach.getTacgia());
            preparedStatement.setString(3, sach.getNhaxuatban());
            preparedStatement.setString(4, sach.getNamxuatban());
            preparedStatement.setString(5, sach.getMasach());
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
            
        } catch (SQLException ex) {
            Logger.getLogger(DocgiaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    
    }
    
    public void deleteSach(String masach){
        Connection connection= JDBCConnection.getJDBCConnection();
        String sql = "delete from Sach where masach = ? ";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1,masach);
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
            
        } catch (SQLException ex) {
            Logger.getLogger(DocgiaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    
    }
}
