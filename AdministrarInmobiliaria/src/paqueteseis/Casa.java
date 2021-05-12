/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteseis;

import paquetecinco.Constructora;
import paquetecuatro.Ciudad;
import paquetedos.Propietario;
import paquetetres.Ubicacion;

/**
 *
 * @author reroes
 */
public class Casa {

    private String id;
    private double precioMetroCuadrado;
    private double metrosCuadrados;
    private double costoFinal;
    private int numeroCuartos;
    private Propietario propietario;
    private Ubicacion ubicacion;
    private Ciudad ciudad;
    private Constructora constructora;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Casa(String id, double precioMetroCuadrado, double metrosCuadradados, int numeroCuartos, 
            Propietario propietario, Ubicacion ubicacion, Ciudad ciudad, Constructora constructora) {
        this.id = id;
        this.precioMetroCuadrado = precioMetroCuadrado;
        this.metrosCuadrados = metrosCuadradados;
        this.numeroCuartos = numeroCuartos;
        this.propietario = propietario;
        this.ubicacion = ubicacion;
        this.ciudad = ciudad;
        this.constructora = constructora;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public double getPrecioMetroCuadrado() {
        return precioMetroCuadrado;
    }

    public void setPrecioMetroCuadrado(double precioMetroCuadrado) {
        this.precioMetroCuadrado = precioMetroCuadrado;
    }

    public double getMetrosCuadrados() {
        return metrosCuadrados;
    }

    public void setMetrosCuadrados(double metrosCuadradados) {
        this.metrosCuadrados = metrosCuadradados;
    }

    public double getCostoFinal() {
        return costoFinal;
    }

    public void calcularCostoFinal() {
        this.costoFinal = metrosCuadrados * precioMetroCuadrado;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public int getNumeroCuartos() {
        return numeroCuartos;
    }

    public void setNumeroCuartos(int numeroCuartos) {
        this.numeroCuartos = numeroCuartos;
    }

    public Constructora getConstructora() {
        return constructora;
    }

    public void setConstructora(Constructora constructora) {
        this.constructora = constructora;
    }

    @Override
    public String toString() {
        return id + "\n" + metrosCuadrados + "\n" + costoFinal + "\n" + numeroCuartos
                + "\n" + precioMetroCuadrado + "\n" + propietario.getId() + "\n"
                + ubicacion.getId() + "\n" + ciudad.getNombreCiudad() + "\n" + constructora.getId();
    }
}
    