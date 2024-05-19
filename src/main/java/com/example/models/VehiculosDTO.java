/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.models;

/**
 *
 * @author Juan Pablo
 */
public class VehiculosDTO {
    
    private String placa;

    private String marca;

    private String modelo;

    private int capacidadCarga;

    private String tipocarroceria;
    
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(int capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    public String getTipocarroceria() {
        return tipocarroceria;
    }

    public void setTipocarroceria(String tipocarroceria) {
        this.tipocarroceria = tipocarroceria;
    }
}
