package com.luis.apprecyclerviewtoolbar;

public class DatosVO {
    private String stringVocal;
    private Integer integerImagen;

    public DatosVO() {
    }

    public DatosVO(String stringVocal, Integer integerImagen) {
        this.stringVocal = stringVocal;
        this.integerImagen = integerImagen;
    }

    public String getStringVocal() {
        return stringVocal;
    }

    public void setStringVocal(String stringVocal) {
        this.stringVocal = stringVocal;
    }

    public Integer getIntegerImagen() {
        return integerImagen;
    }

    public void setIntegerImagen(Integer integerImagen) {
        this.integerImagen = integerImagen;
    }
}
