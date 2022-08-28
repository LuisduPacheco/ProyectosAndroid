package com.luis.myappsqlite.basededatos;

public class BebidaVO {

    private Integer codigoBebida ;
    private String nombreBebida;
    private String saborBebida;
    private Integer presentacionBebida;
    private String tipoBebida;
    private Double precioBebida;

    public BebidaVO() {
    }

    public BebidaVO(Integer codigoBebida, String nombreBebida, String saborBebida, Integer presentacionBebida, String tipoBebida, Double precioBebida) {
        this.codigoBebida = codigoBebida;
        this.nombreBebida = nombreBebida;
        this.saborBebida = saborBebida;
        this.presentacionBebida = presentacionBebida;
        this.tipoBebida = tipoBebida;
        this.precioBebida = precioBebida;
    }

    public Integer getCodigoBebida() {
        return codigoBebida;
    }

    public void setCodigoBebida(Integer codigoBebida) {
        this.codigoBebida = codigoBebida;
    }

    public String getNombreBebida() {
        return nombreBebida;
    }

    public void setNombreBebida(String nombreBebida) {
        this.nombreBebida = nombreBebida;
    }

    public String getSaborBebida() {
        return saborBebida;
    }

    public void setSaborBebida(String saborBebida) {
        this.saborBebida = saborBebida;
    }

    public Integer getPresentacionBebida() {
        return presentacionBebida;
    }

    public void setPresentacionBebida(Integer presentacionBebida) {
        this.presentacionBebida = presentacionBebida;
    }

    public String getTipoBebida() {
        return tipoBebida;
    }

    public void setTipoBebida(String tipoBebida) {
        this.tipoBebida = tipoBebida;
    }

    public Double getPrecioBebida() {
        return precioBebida;
    }

    public void setPrecioBebida(Double precioBebida) {
        this.precioBebida = precioBebida;
    }
}
