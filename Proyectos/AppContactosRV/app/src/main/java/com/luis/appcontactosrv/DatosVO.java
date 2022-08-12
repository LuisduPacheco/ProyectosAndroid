package com.luis.appcontactosrv;

public class DatosVO {
    private String stringNombre, stringApellido, stringNumero;
    private Integer imagenContacto;

    public DatosVO() {
    }

    public DatosVO(String stringNombre, String stringApellido, String stringNumero, Integer imagenContacto) {
        this.stringNombre = stringNombre;
        this.stringApellido = stringApellido;
        this.stringNumero = stringNumero;
        this.imagenContacto = imagenContacto;
    }

    public String getStringNombre() {
        return stringNombre;
    }

    public void setStringNombre(String stringNombre) {
        this.stringNombre = stringNombre;
    }

    public String getStringApellido() {
        return stringApellido;
    }

    public void setStringApellido(String stringApellido) {
        this.stringApellido = stringApellido;
    }

    public String getStringNumero() {
        return stringNumero;
    }

    public void setStringNumero(String stringNumero) {
        this.stringNumero = stringNumero;
    }

    public Integer getImagenContacto() {
        return imagenContacto;
    }

    public void setImagenContacto(Integer imagenContacto) {
        this.imagenContacto = imagenContacto;
    }
}
