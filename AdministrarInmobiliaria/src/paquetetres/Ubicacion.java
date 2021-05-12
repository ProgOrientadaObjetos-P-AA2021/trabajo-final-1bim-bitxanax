/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetetres;

import java.io.Serializable;

/**
 *
 * @author reroes
 */
public class Ubicacion implements Serializable {

    private String id;
    private String nombreBarrio;
    private String referencia;
    private int numeroCasa;

    public Ubicacion(int numeroCasa,  String nombreBarrio, String referencia, String id) {
        this.id = id;
        this.nombreBarrio = nombreBarrio;
        this.referencia = referencia;
        this.numeroCasa = numeroCasa;
    }

    public int getNumeroCasa() {
        return numeroCasa;
    }

    public void setNumeroCasa(int numeroCasa) {
        this.numeroCasa = numeroCasa;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getNombreBarrio() {
        return nombreBarrio;
    }

    public void setNombreBarrio(String nombreBarrio) {
        this.nombreBarrio = nombreBarrio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return numeroCasa + "\n" + nombreBarrio + "\n" + referencia + "\n" + id;
    }
    
}
    