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
import model.Docgia;

/**
 *
 * @author Admin
 */
public class DocgiaDao {
    public List<Docgia> getAllDocgias(){
        List<Docgia> docgias = new ArrayList<Docgia>();
        Connection connection= JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM DOCGIA";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                Docgia docgia = new Docgia();
                
                docgia.setMadocgia(rs.getString("MADOCGIA"));
                docgia.setTendocgia(rs.getString("TENDOCGIA"));
                docgia.setTendangnhap(rs.getString("TENDANGNHAP"));
                docgia.setMatkhau(rs.getString("MATKHAU"));
                docgia.setNamsinh(rs.getString("NAMSINH"));
                docgia.setGioitinh(rs.getString("GIOITINH"));
                docgia.setLop(rs.getString("LOP"));
                
                
                docgias.add(docgia);
            }
             
        } catch (Exception e) {
            e.printStackTrace();
        }
        return docgias;
    }
     
     public Docgia getDocgiaByMadocgia(String madocgia){
         Connection connection= JDBCConnection.getJDBCConnection();
        String sql = "SELECT * FROM DOCGIA WHERE MADOCGIA =?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, madocgia);
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
                Docgia docgia = new Docgia();
                
                docgia.setMadocgia(rs.getString("MADOCGIA"));
                docgia.setTendocgia(rs.getString("TENDOCGIA"));
                docgia.setTendangnhap(rs.getString("TENDANGNHAP"));
                docgia.setMatkhau(rs.getString("MATKHAU"));
                docgia.setNamsinh(rs.getString("NAMSINH"));
                docgia.setGioitinh(rs.getString("GIOITINH"));
                docgia.setLop(rs.getString("LOP"));
               
                
                return docgia;
            }
             
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addDocgia(Docgia docgia){
        Connection connection= JDBCConnection.getJDBCConnection();
        String sql = "INSERT INTO DOCGIA(MADOCGIA, TENDOCGIA, TENDANGNHAP, MATKHAU, NAMSINH, GIOI TINH , LOP)"+ "VALUES(?,?,?,?,?,?,?) ";
       
      
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, docgia.getMadocgia());
            preparedStatement.setString(2, docgia.getTendocgia());
            preparedStatement.setString(3, docgia.getTendangnhap());
            preparedStatement.setString(4, docgia.getMatkhau());
            preparedStatement.setString(5,docgia.getNamsinh());
            preparedStatement.setString(6, docgia.getGioitinh());
            preparedStatement.setString(7, docgia.getLop());
            
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
            
        } catch (SQLException ex) {
            Logger.getLogger(DocgiaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
    
    public void updateDocgia(Docgia docgia){
        Connection connection= JDBCConnection.getJDBCConnection();
        String sql = "UPDATE Docgia SET TENDOCGIA = ?, TENDANGNHAP = ?, MATKHAU = ?, NAMSINH = ?, GIOITINH=?,"+"LOP = ?  WHERE MADOCGIA =?";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, docgia.getTendocgia());
            preparedStatement.setString(2, docgia.getTendangnhap());
            preparedStatement.setString(3, docgia.getMatkhau());
            preparedStatement.setString(4,docgia.getNamsinh());
   
            preparedStatement.setString(5, docgia.getGioitinh());
            preparedStatement.setString(6, docgia.getLop());
            preparedStatement.setString(7, docgia.getMadocgia());
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
            
        } catch (SQLException ex) {
            Logger.getLogger(DocgiaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    
    }
    
    public void deleteDocgia(String madocgia){
        Connection connection= JDBCConnection.getJDBCConnection();
        String sql = "delete from Docgia where madocgia = ? ";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            
            preparedStatement.setString(1,madocgia);
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
            
        } catch (SQLException ex) {
            Logger.getLogger(DocgiaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    
    }
}
