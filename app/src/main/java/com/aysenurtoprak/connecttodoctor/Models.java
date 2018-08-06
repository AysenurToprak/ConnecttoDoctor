package com.aysenurtoprak.connecttodoctor;

import java.util.ArrayList;

/**
 * Created by aysenur toprak on 30/07/2018.
 */

public class Models {
}
class Kullanici{
    public Kullanici(){super();}

    private int id;
    private String adi;
    private String soyadi;
    private String mail;
    private int numara;
    private int tc;
    private String alani;
    private String uzmanligi;


    public Kullanici( int id,String adi, String soyadi,String mail,int numara,int tc,String alani,String uzmanligi){
        this.id = id;
        this.adi = adi;
        this.soyadi = soyadi;
        this.mail = mail;
        this.tc = tc;
        this.alani = alani;
        this.uzmanligi = uzmanligi;

    }



    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getSoyadi() {
        return soyadi;
    }

    public void setSoyadi(String soyadi) {
        this.soyadi = soyadi;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getNumara() {
        return numara;
    }

    public void setNumara(int numara) {
        this.numara = numara;
    }

    public int getTc() {
        return tc;
    }

    public void setTc(int tc) {
        this.tc = tc;
    }

    public String getAlani() {
        return alani;
    }

    public void setAlani(String alani) {
        this.alani = alani;
    }

    public String getUzmanligi() {
        return uzmanligi;
    }

    public void setUzmanligi(String uzmanligi) {
        this.uzmanligi = uzmanligi;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
class Bolum{
    public Bolum() {
        super();
    }

    private String bolumAdi;
    private int bolumID;


    public static ArrayList<Bolum> birimlerArrayList = new ArrayList<Bolum>();


    public Bolum( int bolumID, String bolumAdi){
        this.bolumAdi = bolumAdi;
        this.bolumID = bolumID;


    }

    public String getBolumAdi() {
        return bolumAdi;
    }

    public void setBolumAdi(String bolumAdi) {
        this.bolumAdi = bolumAdi;
    }

    public int getBolumID() {
        return bolumID;
    }

    public void setBolumID(int bolumID) {
        this.bolumID = bolumID;
    }
}
