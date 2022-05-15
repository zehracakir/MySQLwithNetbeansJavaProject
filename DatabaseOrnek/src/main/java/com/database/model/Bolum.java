/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.database.model;

/**
 *
 * @author zehra
 */
public class Bolum {
    private int BID;
    private String BAdi; 

    public Bolum() {
    }

    public Bolum(int BID, String BAdi) {
        this.BID = BID;
        this.BAdi = BAdi;
    }

    public int getBID() {
        return BID;
    }

    public void setBID(int BID) {
        this.BID = BID;
    }

    public String getBAdi() {
        return BAdi;
    }

    public void setBAdi(String BAdi) {
        this.BAdi = BAdi;
    }
    
    
    
}
