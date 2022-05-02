/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;


import Dao.SachDao;
import java.util.List;
import model.Sach;

/**
 *
 * @author Admin
 */
public class SachService {
    private SachDao sachDao;
    public SachService(){
        sachDao = new SachDao();
    }
     public List<Sach> getAllSachs(){
        return sachDao.getAllSachs();
     }
    public void addSach(Sach sach){
        sachDao.addSach(sach);
    }
    public void deleteSach(String masach){
        sachDao.deleteSach(masach);
    }
    public Sach getSachById(String masach){
        return sachDao.getSachByMasach(masach);
    }
    public void updateSach(Sach sach){
        sachDao.updateSach(sach);
    }

}
