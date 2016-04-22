/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.UML;

import java.util.ArrayList;
import java.util.Date;

public class Parte {
    private int idParte;
    private Date fecha;
    private int kmIni;
    private int kmFin;
    private int gastoPeaje;
    private int gastoGasolina;
    private int gastoAutopista;
    private int gastoOtros;
    private String descripcion;
    private ArrayList <Albaran> albaranes;
    
    public Parte() {
    }
    
    public Parte(int idParte, Date fecha, int kmIni) {
        this.idParte = idParte;
        this.fecha = fecha;
        this.kmIni = kmIni;
    }

    public int getIdParte() {
        return idParte;
    }

    public void setIdParte(int idParte) {
        this.idParte = idParte;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getKmIni() {
        return kmIni;
    }

    public void setKmIni(int kmIni) {
        this.kmIni = kmIni;
    }

    public int getKmFin() {
        return kmFin;
    }

    public void setKmFin(int kmFin) {
        this.kmFin = kmFin;
    }

    public int getGastoPeaje() {
        return gastoPeaje;
    }

    public void setGastoPeaje(int gastoPeaje) {
        this.gastoPeaje = gastoPeaje;
    }

    public int getGastoGasolina() {
        return gastoGasolina;
    }

    public void setGastoGasolina(int gastoGasolina) {
        this.gastoGasolina = gastoGasolina;
    }

    public int getGastoAutopista() {
        return gastoAutopista;
    }

    public void setGastoAutopista(int gastoAutopista) {
        this.gastoAutopista = gastoAutopista;
    }

    public int getGastoOtros() {
        return gastoOtros;
    }

    public void setGastoOtros(int gastoOtros) {
        this.gastoOtros = gastoOtros;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public ArrayList<Albaran> getAlbaranes() {
        return albaranes;
    }

    public void setAlbaranes(ArrayList<Albaran> albaranes) {
        this.albaranes = albaranes;
    }
    
    
}
