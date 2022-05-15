
package com.database.controller;

import com.database.model.Bolum;
import com.databes.dao.BolumDAO;
import java.util.List;

/**
 *
 * merhaba yeni editör yufus
 */
public class BolumController {
 private BolumDAO bolumDAO;

    public BolumController() {
        bolumDAO = new BolumDAO();
    }
    
    public void addOrUpdateBolum(Bolum bolum){
        if(bolum.getBID() == 0)
            bolumDAO.addBolum(bolum);
        else
            bolumDAO.updateBolum(bolum);
    }
    
    public void deleteBolum(Bolum bolum){
        bolumDAO.deleteBolum(bolum);
    }
    
    public Bolum getBolumById(int bid){
        return bolumDAO.getBolumById(bid);
    }
    
    public List<Bolum> getBolumler(){
        return bolumDAO.getAllBolum();
    }}
