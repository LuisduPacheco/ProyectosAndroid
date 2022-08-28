package com.luis.appcine;
//Recycler
public class DatosVO {
    private String stringTitulo, stringTiempo;
    private Integer integerImagen, integerSinop, integerProt, integerRec;

    public DatosVO() {
    }

    public DatosVO(String stringTitulo, String stringTiempo, Integer integerImagen) {
        this.stringTitulo = stringTitulo;
        this.stringTiempo = stringTiempo;
        this.integerImagen = integerImagen;
    }

    public DatosVO(Integer integerSinop, Integer integerProt, Integer integerRec) {
        this.integerSinop = integerSinop;
        this.integerProt = integerProt;
        this.integerRec = integerRec;
    }

    public String getStringTitulo() {
        return stringTitulo;
    }

    public void setStringTitulo(String stringTitulo) {
        this.stringTitulo = stringTitulo;
    }

    public String getStringTiempo() {
        return stringTiempo;
    }

    public void setStringTiempo(String stringTiempo) {
        this.stringTiempo = stringTiempo;
    }

    public Integer getIntegerImagen() {
        return integerImagen;
    }

    public void setIntegerImagen(Integer integerImagen) {
        this.integerImagen = integerImagen;
    }

    public Integer getIntegerSinop() {
        return integerSinop;
    }

    public void setIntegerSinop(Integer integerSinop) {
        this.integerSinop = integerSinop;
    }

    public Integer getIntegerProt() {
        return integerProt;
    }

    public void setIntegerProt(Integer integerProt) {
        this.integerProt = integerProt;
    }

    public Integer getIntegerRec() {
        return integerRec;
    }

    public void setIntegerRec(Integer integerRec) {
        this.integerRec = integerRec;
    }
}
