/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteuno;

import java.io.IOException;
;
import org.testng.annotations.Test;
import paquetedos.Propietario;
import paqueteseis.Casa;
import paqueteseis.Departamento;
import paquetetres.Ubicacion;

/**
 *
 * @author bitxanax
 */


public class DataSaverTest {

    @Test
    public void tryx() throws IOException {
        Deserializer deserializer = new Deserializer();

        /*
        id + "\n" + precioMetroCuadrado + "\n" + nombreEdificio + "\n"
                + metrosCuadrados + "\n" + costoFinal + "\n" + precio + "\n"
                + valorCuotaMensual + "\n" + ubicacion.getNombreBarrio()
                + "\n" + ubicacionEnEdificio + "\n" + propietario.getId() + "\n"
                + ciudad.getId() + "\n" + numeroCuartos + "\n"
                + constructora.getId() + "\n" + ubicacion.getId();
         */
        Departamento c = (Departamento) deserializer.deserialize("departamentos", "1");
        System.out.println(c.getId());
        System.out.println(c.getNombreEdificio());
        System.out.println(c.getMetrosCuadrados());
        System.out.println(c.getCostoFinal());
        System.out.println(c.getPrecio());
        System.out.println(c.getValorCuotaMensual());
        System.out.println(c.getUbicacion().getNombreBarrio());
        System.out.println(c.getUbicacionEnEdificio());
        
        
        
        System.out.println(c.getPropietario().getId());
        System.out.println(c.getCiudad().getId());
        System.out.println(c.getNumeroCuartos());
        System.out.println(c.getConstructora().getId());
        System.out.println(c.getUbicacion().getId());

    }
}
