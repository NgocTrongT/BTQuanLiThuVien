/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Dao.DocgiaDao;
import java.util.List;
import model.Docgia;

/**
 *
 * @author Admin
 */
public class DocgiaService {
    private DocgiaDao docgiaDao;
    public DocgiaService(){
        docgiaDao = new DocgiaDao();
    }
     public List<Docgia> getAllDocgias(){
        return docgiaDao.getAllDocgias();
     }
    public void addDocgia(Docgia docgia){
        docgiaDao.addDocgia(docgia);
    }
    public void deleteDocgia(String madocgia){
        docgiaDao.deleteDocgia(madocgia);
    }
    public Docgia getDocgiaById(String madocgia){
        return docgiaDao.getDocgiaByMadocgia(madocgia);
    }
    public void updateDocgia(Docgia docgia){
        docgiaDao.updateDocgia(docgia);
    }

}
