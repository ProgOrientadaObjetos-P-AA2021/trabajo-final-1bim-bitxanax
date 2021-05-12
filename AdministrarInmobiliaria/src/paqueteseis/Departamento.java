/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteseis;

import java.io.Serializable;
import paquetecinco.Constructora;
import paquetecuatro.Ciudad;
import paquetedos.Propietario;
import paquetetres.Ubicacion;

/**
 *
 * @author reroes
 */
public class Departamento implements Serializable {

    private String id;
    private Propietario propietario;
    private double precioMetroCuadrado;
    private double metrosCuadrados;
    private double costoFinal;
    private double precio;
    private double valorCuotaMensual;
    private String ubicacionEnEdificio;
    private Ubicacion ubicacion;
    private String nombreEdificio;
    private Ciudad ciudad;
    private int numeroCuartos;
    private Constructora constructora;

    public Departamento(String id, Propietario propietario, double precioMetroCuadrado, double metrosCuadradados, double precio, double valorCuotaMensual, String ubicacionEnEdificio, Ubicacion ubicacion, String nombreEdificio, Ciudad ciudad, int numeroCuartos, Constructora constructora) {
        this.id = id;
        this.propietario = propietario;
        this.precioMetroCuadrado = precioMetroCuadrado;
        this.metrosCuadrados = metrosCuadradados;
        this.precio = precio;
        this.valorCuotaMensual = valorCuotaMensual;
        this.ubicacionEnEdificio = ubicacionEnEdificio;
        this.ubicacion = ubicacion;
        this.nombreEdificio = nombreEdificio;
        this.ciudad = ciudad;
        this.numeroCuartos = numeroCuartos;
        this.constructora = constructora;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUbicacionEnEdificio() {
        return ubicacionEnEdificio;
    }

    public void setUbicacionEnEdificio(String ubicacionEnEdificio) {
        this.ubicacionEnEdificio = ubicacionEnEdificio;
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

    public void setMetrosCuadrados(double metrosCuadrados) {
        this.metrosCuadrados = metrosCuadrados;
    }

    public double getCostoFinal() {
        return costoFinal;
    }

    public void calcularCostoFinal() {
        this.costoFinal = (metrosCuadrados * precioMetroCuadrado) + valorCuotaMensual * 12;
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

    public Departamento() {
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getValorCuotaMensual() {
        return valorCuotaMensual;
    }

    public void setValorCuotaMensual(double valorCuotaMensual) {
        this.valorCuotaMensual = valorCuotaMensual;
    }

    public String getNombreEdificio() {
        return nombreEdificio;
    }

    public void setNombreEdificio(String nombreEdificio) {
        this.nombreEdificio = nombreEdificio;
    }

    @Override
    public String toString() {
        return id + "\n" + precioMetroCuadrado + "\n" + nombreEdificio + "\n"
                + metrosCuadrados + "\n" + costoFinal + "\n" + precio + "\n"
                + valorCuotaMensual + "\n" + ubicacion.getNombreBarrio()
                + "\n" + ubicacionEnEdificio + "\n" + propietario.getId() + "\n"
                + ciudad.getId() + "\n" + numeroCuartos + "\n"
                + constructora.getId() + "\n" + ubicacion.getId();
    }

}
