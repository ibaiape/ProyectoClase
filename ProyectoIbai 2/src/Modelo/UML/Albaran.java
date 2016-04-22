/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.UML;

public class Albaran {
    private int idAlbaran;
    private String matricula;
    private String horaSalida;
    private String horaLLegada;
    private Parte parte;
    
    public Albaran(){
    }
    
    public Albaran(Parte parte,int idAlbaran, String matricula, String horaSalida, String horaLLegada) {
        this.idAlbaran = idAlbaran;
        this.matricula = matricula;
        this.horaSalida = horaSalida;
        this.horaLLegada = horaLLegada;
        this.parte= parte;
    }

    public int getIdAlbaran() {
        return idAlbaran;
    }

    public void setIdAlbaran(int idAlbaran) {
        this.idAlbaran = idAlbaran;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getHoraLLegada() {
        return horaLLegada;
    }

    public void setHoraLLegada(String horaLLegada) {
        this.horaLLegada = horaLLegada;
    }

    public Parte getParte() {
        return parte;
    }

    public void setParte(Parte parte) {
        this.parte = parte;
    }
    
    
}
