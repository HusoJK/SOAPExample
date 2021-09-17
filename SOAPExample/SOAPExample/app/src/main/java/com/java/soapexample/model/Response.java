package com.java.soapexample.model;

import java.io.Serializable;

public class Response implements Serializable {
    private int id;
    private String name;
    private String unit_name;
    private String barcode;
    private double saleprice;
    private boolean saleis_taxincluded;
    private String salecurrency_code;
    private double purchaseprice;
    private boolean purchaseeis_taxincluded;
    private String purchasecurrency_code;
    private double saletaxrate;
    private double purchasetaxrate;
    private double sale_recommendedprice;
    private String sale_recommendedcurrency_code;
    private double purchaserecommendedprice;
    private String purchase_recommendedcurrency_code;

    public Response(String name, double purchaseprice, String barcode, String unit_name, boolean purchaseeis_taxincluded, String purchase_recommendedcurrency_code) {
        this.barcode = barcode;
        this.name = name;
        this.unit_name = unit_name;
        this.purchaseprice = purchaseprice;
        this.purchaseeis_taxincluded = purchaseeis_taxincluded;
        this.purchase_recommendedcurrency_code = purchase_recommendedcurrency_code;
    }

    public Response(int id,String name, double purchaseprice,String barcode, String unit_name, boolean purchaseeis_taxincluded, String purchase_recommendedcurrency_code) {
        this.id = id;
        this.barcode = barcode;
        this.name = name;
        this.unit_name = unit_name;
        this.purchaseprice = purchaseprice;
        this.purchaseeis_taxincluded = purchaseeis_taxincluded;
        this.purchase_recommendedcurrency_code = purchase_recommendedcurrency_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnit_name() {
        return unit_name;
    }

    public void setUnit_name(String unit_name) {
        this.unit_name = unit_name;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public double getSaleprice() {
        return saleprice;
    }

    public void setSaleprice(double saleprice) {
        this.saleprice = saleprice;
    }

    public boolean isSaleis_taxincluded() {
        return saleis_taxincluded;
    }

    public void setSaleis_taxincluded(boolean saleis_taxincluded) {
        this.saleis_taxincluded = saleis_taxincluded;
    }

    public String getSalecurrency_code() {
        return salecurrency_code;
    }

    public void setSalecurrency_code(String salecurrency_code) {
        this.salecurrency_code = salecurrency_code;
    }

    public double getPurchaseprice() {
        return purchaseprice;
    }

    public void setPurchaseprice(double purchaseprice) {
        this.purchaseprice = purchaseprice;
    }

    public boolean isPurchaseeis_taxincluded() {
        return purchaseeis_taxincluded;
    }

    public void setPurchaseeis_taxincluded(boolean purchaseeis_taxincluded) {
        this.purchaseeis_taxincluded = purchaseeis_taxincluded;
    }

    public String getPurchasecurrency_code() {
        return purchasecurrency_code;
    }

    public void setPurchasecurrency_code(String purchasecurrency_code) {
        this.purchasecurrency_code = purchasecurrency_code;
    }

    public double getSaletaxrate() {
        return saletaxrate;
    }

    public void setSaletaxrate(double saletaxrate) {
        this.saletaxrate = saletaxrate;
    }

    public double getPurchasetaxrate() {
        return purchasetaxrate;
    }

    public void setPurchasetaxrate(double purchasetaxrate) {
        this.purchasetaxrate = purchasetaxrate;
    }

    public double getSale_recommendedprice() {
        return sale_recommendedprice;
    }

    public void setSale_recommendedprice(double sale_recommendedprice) {
        this.sale_recommendedprice = sale_recommendedprice;
    }

    public String getSale_recommendedcurrency_code() {
        return sale_recommendedcurrency_code;
    }

    public void setSale_recommendedcurrency_code(String sale_recommendedcurrency_code) {
        this.sale_recommendedcurrency_code = sale_recommendedcurrency_code;
    }

    public double getPurchaserecommendedprice() {
        return purchaserecommendedprice;
    }

    public void setPurchaserecommendedprice(double purchaserecommendedprice) {
        this.purchaserecommendedprice = purchaserecommendedprice;
    }

    public String getPurchase_recommendedcurrency_code() {
        return purchase_recommendedcurrency_code;
    }

    public void setPurchase_recommendedcurrency_code(String purchase_recommendedcurrency_code) {
        this.purchase_recommendedcurrency_code = purchase_recommendedcurrency_code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
