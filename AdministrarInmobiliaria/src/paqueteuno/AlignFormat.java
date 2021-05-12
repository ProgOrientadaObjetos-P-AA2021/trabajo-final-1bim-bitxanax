/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteuno;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author bitxanax
 */
public class AlignFormat {

    static String[] propietariosAlignFormat = new String[]{"%10s", "%35s", "%38s"},
            ubicacionesAlignFormat = new String[]{"%7s", "%34s", "%43s", "%8s"},
            ciudadesAlignFormat = new String[]{"%16s", "%23s", "%12s"},
            constructorasAlignFormat = new String[]{"%9s", "%30s"},
            departamentosAlignFormat = new String[]{"%3s", "%10s", "%20s", "%13s",
                "%13s", "%14s", "%13s", "%20s", "%26s", "%22s", "%14s", "%13s", "%16s", "%16s"},
            casasAlignFormat = new String[]{"%5s", "%12s", "%12s", "%12s",
                "%12s", "%15s", "%16s", "%15s", "%14s"};

    final static ArrayList<String[]> alignFormats = new ArrayList(List.of(propietariosAlignFormat,
            ubicacionesAlignFormat, ciudadesAlignFormat, constructorasAlignFormat, casasAlignFormat,
            departamentosAlignFormat));

}
