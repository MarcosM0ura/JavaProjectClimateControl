package com.example.javaproject_climatecontrol;

public class Equipamentos {
    private long id;
    private String marca;
    private String tipo;
    private String local;

    public Equipamentos(long id, String marca, String tipo, String local) {
        this.id = id;
        this.marca = marca;
        this.tipo = tipo;
        this.local = local;
    }

    public long getId() {
        return id;
    }

    public String getMarca() {
        return marca;
    }

    public String getTipo() {
        return tipo;
    }

    public String getLocal() {
        return local;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setLocal(String local) {
        this.local = local;
    }
}
