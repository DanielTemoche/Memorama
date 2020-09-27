package com.kytom.memorama.Entidades;

//aqui creamos el crud con los metodos get y set para nombre, puntje y tiempo de cada jugador, esta es la que utilizamos
//para mostrar informacion una vez finalizada una partida
public class PuntajesVo {
    String nombre, puntaje, tiempo;

    public PuntajesVo(String nombre, String puntaje, String tiempo) {
        this.nombre = nombre;
        this.puntaje = puntaje;
        this.tiempo = tiempo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(String puntaje) {
        this.puntaje = puntaje;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }
}