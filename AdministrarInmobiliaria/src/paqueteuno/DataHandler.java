/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteuno;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import paquetecinco.Constructora;
import paquetecuatro.Ciudad;
import paquetedos.Propietario;
import paqueteseis.Casa;
import paqueteseis.Departamento;
import paquetetres.Ubicacion;
import static paqueteuno.FilesInfo.alignFormats;

/**
 *
 * @author bitxanax
 */
public class DataHandler {

    static ArrayList<Propietario> propietarios = new ArrayList<>();
    static ArrayList<Ubicacion> ubicaciones = new ArrayList<>();
    static ArrayList<Casa> casas = new ArrayList<>();
    static ArrayList<Departamento> departamentos = new ArrayList<>();
    static ArrayList<Constructora> constructoras = new ArrayList<>();
    static ArrayList<Ciudad> ciudades = new ArrayList<>();
    static FilesHandler dataController = new FilesHandler();
    static Serializer serializer = new Serializer();
    static Deserializer deserializer = new Deserializer();
    static Scanner read = new Scanner(System.in);
    static Animation animation = new Animation();
    
    public void saveEntityByOption(String option) throws IOException {
        switch (option) {
            case "1":
                Propietario propietario = createPropietario();
                saveEntity("propietarios", propietario);
                break;

            case "2":
                Ubicacion ubicacion = createUbicacion();
                saveEntity("ubicaciones", ubicacion);
                break;

            case "3":
                Ciudad ciudad = createCiudad();
                saveEntity("ciudades", ciudad);
                break;

            case "4":
                Constructora constructora = createConstructora();
                saveEntity("constructoras", constructora);
                break;

            case "5":
                Casa casa = createCasa();
                saveEntity("casas", casa);
                break;

            case "6":
                Departamento departamento = createDepartamento();
                saveEntity("departamentos", departamento);
                break;
        }
    }

    public void showEntityByOption(String option) throws IOException {
        animation.loadingBar();
        switch (option) {
            case "1":
                showPropietarios();
                break;
            case "2":
                showUbicaciones();
                break;
            case "3":
                showCiudades();
                break;
            case "4":
                showConstructoras();
                break;

            case "5":
                showCasas();
                break;

            case "6":
                showDepartamentos();
                break;
            case "7":
                showAll();
                break;
            default:
                Ejecutor.showWrongOptionMessage();
                return;
        }
    }

    public void showAll() throws IOException {
        showPropietarios();
        showUbicaciones();
        showCiudades();
        showConstructoras();
        showCasas();
        showDepartamentos();
    }

    public void showPropietarios() throws IOException {
        String[] format;
        showTable("/propietariosTable.txt", null);
        format = alignFormats.get(0);
        loadPropietarios();

        for (int i = 0; i < propietarios.size(); i++) {
            Propietario propietario = propietarios.get(i);
            ArrayList<Object> properties = new ArrayList<>(List.of(propietario.getId(),
                    propietario.getNombres(), propietario.getApellidos()));
            for (int j = 0; j < format.length; j++) {
                System.out.printf(format[j], properties.get(j));
            }
            System.out.println("");

        }
        propietarios = new ArrayList<>();
    }

    public void showUbicaciones() throws IOException {
        String[] format;
        showTable("/ubicacionesTable.txt", null);
        format = alignFormats.get(1);
        loadUbicaciones();

        for (int i = 0; i < ubicaciones.size(); i++) {
            Ubicacion ubicacion = ubicaciones.get(i);
            ArrayList<Object> properties = new ArrayList<>(List.of(ubicacion.getId(),
                    ubicacion.getNombreBarrio(), ubicacion.getReferencia(),
                    ubicacion.getNumeroCasa()));
            for (int j = 0; j < format.length; j++) {
                System.out.printf(format[j], properties.get(j));
            }
            System.out.println("");
        }

        ubicaciones = new ArrayList<>();
    }

    public void showDepartamentos() throws IOException {
        String[] format;
        showTable("/departamentosTable.txt", null);
        format = alignFormats.get(5);
        loadDepartamentos();

        for (int i = 0; i < departamentos.size(); i++) {
            Departamento departamento = departamentos.get(i);
            ArrayList<Object> properties = new ArrayList<>(List.of(
                    departamento.getId(), departamento.getPrecioMetroCuadrado(),
                    departamento.getNombreEdificio(), departamento.getMetrosCuadrados(),
                    departamento.getCostoFinal(), departamento.getPrecio(),
                    departamento.getValorCuotaMensual(),
                    departamento.getUbicacion().getNombreBarrio(),
                    departamento.getUbicacionEnEdificio(),
                    departamento.getPropietario().getId(),
                    departamento.getCiudad().getId(), departamento.getNumeroCuartos(),
                    departamento.getConstructora().getId(),
                    departamento.getUbicacion().getId()));
            for (int j = 0; j < format.length; j++) {
                System.out.printf(format[j], properties.get(j));
            }
            System.out.println("");
        }
        departamentos = new ArrayList<>();
    }

    public void showCiudades() throws IOException {
        String[] format;
        showTable("/ciudadesTable.txt", null);
        format = alignFormats.get(2);
        loadCiudades();

        for (int i = 0; i < ciudades.size(); i++) {
            Ciudad ciudad = ciudades.get(i);
            ArrayList<Object> properties = new ArrayList<>(List.of(
                    ciudad.getNombreCiudad(), ciudad.getNombreProvincia(),
                    ciudad.getId()));
            for (int j = 0; j < format.length; j++) {
                System.out.printf(format[j], properties.get(j));
            }
            System.out.println("");
        }
        ciudades = new ArrayList<>();
    }

    public void showConstructoras() throws IOException {
        String[] format;
        showTable("/constructorasTable.txt", null);
        format = alignFormats.get(3);
        loadConstructoras();

        for (int i = 0; i < constructoras.size(); i++) {
            Constructora constructora = constructoras.get(i);
            ArrayList<Object> properties = new ArrayList<>(List.of(constructora.getId(),
                    constructora.getNombre()));
            for (int j = 0; j < format.length; j++) {
                System.out.printf(format[j], properties.get(j));
            }
            System.out.println("");
        }

        constructoras = new ArrayList<>();
    }

    public void showCasas() throws IOException {
        String[] format;
        showTable("/casasTable.txt", null);
        format = alignFormats.get(4);
        loadCasas();
        for (int i = 0; i < casas.size(); i++) {
            Casa casa = casas.get(i);

            ArrayList<Object> properties = new ArrayList<>(List.of(casa.getId(),
                    casa.getMetrosCuadrados(), casa.getCostoFinal(), casa.getNumeroCuartos(),
                    casa.getPrecioMetroCuadrado(), casa.getPropietario().getId(),
                    casa.getUbicacion().getNumeroCasa(), casa.getCiudad().getNombreCiudad(),
                    casa.getConstructora().getId()));

            for (int j = 0; j < format.length; j++) {
                System.out.printf(format[j], properties.get(j));
            }
            System.out.println("");
        }

        casas = new ArrayList<>();

    }

    public Propietario createPropietario() throws IOException {
        System.out.println("Información del propietario:");

        System.out.print(" ■ Nombres -> ");
        String nombres = read.nextLine();
        System.out.print(" ■ Apellidos -> ");
        String apellidos = read.nextLine();

        String id = FilesHandler.getLastId("propietarios", true);

        Propietario propietario = new Propietario(id, nombres, apellidos);

        return propietario;
    }

    public Ubicacion createUbicacion() throws IOException {
        System.out.println("Información de la ubicación: ");

        System.out.print(" ■ Barrio ->  ");
        String barrio = read.nextLine();
        System.out.print(" ■ Referencia -> ");
        String referencia = read.nextLine();
        System.out.print(" ■ Número de casa: ");
        int numCasa = Integer.parseInt(read.nextLine());

        String id = FilesHandler.getLastId("ubicaciones", true);

        Ubicacion ubicacion = new Ubicacion(numCasa, barrio, referencia, id);
        saveEntity("ubicaciones", ubicacion);

        return ubicacion;
    }

    public Constructora createConstructora() throws IOException {
        System.out.println("Información de la constructora: ");

        System.out.print(" ■ Nombre -> ");
        String nombreEmpresa = read.nextLine();

        String id = FilesHandler.getLastId("constructoras", true);

        Constructora constructora = new Constructora(id, nombreEmpresa);
        return constructora;
    }

    public Casa createCasa() throws IOException {
        System.out.println("Información de la casa: ");

        System.out.print(" ■ Metros cuadrados -> ");
        double metrosCuadrados = Double.parseDouble(read.nextLine());

        System.out.print(" ■ Precio m² -> ");
        double precioMetroCuadrado = Double.parseDouble(read.nextLine());

        System.out.print(" ■ Número cuartos -> ");
        int numeroCuartos = Integer.parseInt(read.nextLine());

        System.out.print(" ■ ID del propietario-> ");
        String propietarioID = read.nextLine();

        System.out.print(" ■ Número de Casa-> ");
        int numCasa = Integer.parseInt(read.nextLine());

        System.out.print(" ■ Nombre ciudad-> ");
        String nombreCiudad = read.nextLine();

        System.out.print(" ■ ID de la constructora-> ");
        String constructoraID = read.nextLine();

        String id = FilesHandler.getLastId("casas", true);

        Casa casa = new Casa(id, precioMetroCuadrado, metrosCuadrados, numeroCuartos,
                getPropietarioByID(propietarioID),
                getUbicacionByNumCasa(numCasa),
                getCiudadByNombre(nombreCiudad), getConstructoraByID(constructoraID));
        casa.calcularCostoFinal();

        return casa;

    }

    public Departamento createDepartamento() throws IOException {
        System.out.println("Información del departamento: ");

        System.out.print(" ■ Precio m² -> ");
        double precioMetroCuadrado = Double.parseDouble(read.nextLine());

        System.out.print(" ■ Número m² -> ");
        double metrosCuadrados = Double.parseDouble(read.nextLine());;

        System.out.print(" ■ Cuota mensual -> ");
        double valorCuotaMensual = Double.parseDouble(read.nextLine());

        System.out.print(" ■ Precio ->");
        double precio = Double.parseDouble(read.nextLine());

        System.out.print(" ■ Nombre del edificio -> ");
        String nombreEdificio = read.nextLine();

        System.out.print(" ■ Número Cuartos -> ");
        int numeroCuartos = Integer.parseInt(read.nextLine());

        System.out.print(" ■ Ubicación en el eficio -> ");
        String ubicacionEnEdificio = read.nextLine();

        System.out.print(" ■ ID del propietario-> ");
        String propietarioID = read.nextLine();

        System.out.print(" ■ Número de Casa-> ");
        int numCasa = Integer.parseInt(read.nextLine());

        System.out.print(" ■ Nombre ciudad-> ");
        String nombreCiudad = read.nextLine();

        System.out.print(" ■ ID de la constructora-> ");
        String constructoraID = read.nextLine();

        String id = FilesHandler.getLastId("departamentos", true);

        Departamento departamento = new Departamento(id,
                getPropietarioByID(propietarioID),
                precioMetroCuadrado, metrosCuadrados, precio, valorCuotaMensual,
                ubicacionEnEdificio, getUbicacionByNumCasa(numCasa), nombreEdificio,
                getCiudadByNombre(nombreCiudad),
                numeroCuartos, getConstructoraByID(constructoraID));

        departamento.calcularCostoFinal();

        return departamento;
    }

    public Ciudad createCiudad() throws IOException {
        System.out.println("Información de la ciudad: ");

        System.out.print(" ■ Nombre ciudad -> ");
        String nombreCiudad = read.nextLine();
        System.out.print(" ■ Nombre provincia -> ");
        String nombreProvincia = read.nextLine();

        String id = FilesHandler.getLastId("ciudades", true);

        Ciudad ciudad = new Ciudad(nombreCiudad, nombreProvincia, id);

        return ciudad;
    }

    public Propietario getPropietarioByID(String id) throws IOException {
        loadPropietarios();
        Propietario propietario = null;

        for (Propietario p : propietarios) {
            if (p.getId().equals(id)) {
                propietario = p;
            }
        }
        return propietario;
    }

    public Ubicacion getUbicacionByNumCasa(int numCasa) throws IOException {
        loadUbicaciones();
        Ubicacion ubicacion = null;

        for (Ubicacion ub : ubicaciones) {
            if (ub.getNumeroCasa() == numCasa) {
                ubicacion = ub;
            }
        }

        return ubicacion;
    }

    public Ciudad getCiudadByNombre(String nombre) throws IOException {
        loadCiudades();
        Ciudad ciudad = null;
        for (Ciudad c : ciudades) {
            if (c.getNombreCiudad().equals(nombre)) {
                ciudad = c;
            }
        }
        return ciudad;
    }

    public Constructora getConstructoraByID(String id) throws IOException {
        loadConstructoras();
        Constructora constructora = null;
        for (Constructora con : constructoras) {
            if (con.getId().equals(id)) {
                System.out.println("found");
                constructora = con;
            }
        }
        return constructora;
    }

    public void loadConstructoras() throws IOException {
        Constructora constructora = null;
        int cantidadConstructoras = Integer.parseInt(FilesHandler.getLastId("constructoras", false));

        int idIndex = 1;

        for (int i = 0; i < cantidadConstructoras; i++) {
            constructora = (Constructora) deserializer.deserialize("constructoras",
                    Integer.toString((idIndex < cantidadConstructoras) ? idIndex++ : idIndex));
            constructoras.add(constructora);
        }

    }

    public void loadCiudades() throws IOException {
        Ciudad ciudad = null;

        int cantidadCiudades = Integer.parseInt(FilesHandler.getLastId("ciudades",
                false));
        int idIndex = 1;
        for (int i = 0; i < cantidadCiudades; i++) {
            ciudad = (Ciudad) deserializer.deserialize("ciudades",
                    Integer.toString((idIndex < cantidadCiudades) ? idIndex++ : idIndex));
            ciudades.add(ciudad);
        }
    }

    public void loadUbicaciones() throws IOException {
        Ubicacion ubicacion = null;
        int cantidadUbicaciones = Integer.parseInt(FilesHandler.getLastId("ubicaciones",
                false));

        int idIndex = 1;

        for (int i = 0; i < cantidadUbicaciones; i++) {
            ubicacion = (Ubicacion) deserializer.deserialize("ubicaciones",
                    Integer.toString((idIndex < cantidadUbicaciones) ? idIndex++ : idIndex));
            ubicaciones.add(ubicacion);
        }
    }

    public void loadPropietarios() throws IOException {
        Propietario propietario = null;
        int cantidadPropietarios = Integer.parseInt(FilesHandler.getLastId("propietarios",
                false));

        int idIndex = 1;

        for (int i = 0; i < cantidadPropietarios; i++) {

            propietario = (Propietario) deserializer.deserialize("propietarios",
                    Integer.toString((idIndex < cantidadPropietarios) ? idIndex++ : idIndex));
            propietarios.add(propietario);
        }
    }

    public void loadDepartamentos() throws IOException {
        Departamento departamento = null;
        int cantidadDepartamentos = Integer.parseInt(FilesHandler.getLastId("departamentos",
                false));

        int idIndex = 1;

        for (int i = 0; i < cantidadDepartamentos; i++) {
            departamento = (Departamento) deserializer.deserialize("departamentos",
                    Integer.toString((idIndex < cantidadDepartamentos) ? idIndex++ : idIndex));
            departamentos.add(departamento);
        }

    }

    public void loadCasas() throws IOException {
        Casa casa = null;
        int cantidadCasas = Integer.parseInt(FilesHandler.getLastId("casas", false));

        int idIndex = 1;

        for (int i = 0; i < cantidadCasas; i++) {
            casa = (Casa) deserializer.deserialize("casas",
                    Integer.toString((idIndex < cantidadCasas) ? idIndex++ : idIndex));

            casas.add(casa);
        }
    }

    public void showTable(String fileName, String[] alignFormat) throws IOException {
        FilesHandler.showFileData("/utils/tables" + fileName, alignFormat);
    }

    public static <E> void saveEntity(String filename, E entity) throws IOException {
        serializer.serialize(filename, entity);
    }

}
