/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteuno;

import java.io.IOException;
import java.util.Scanner;
import paquetecinco.Constructora;
import paquetecuatro.Ciudad;
import paquetedos.Propietario;
import paqueteseis.Casa;
import paqueteseis.Departamento;
import paquetetres.Ubicacion;
import static paqueteuno.AlignFormat.alignFormats;

/**
 *
 * @author bitxanax
 */
public class DataHandler {

    static FilesHandler dataController = new FilesHandler();
    static Scanner read = new Scanner(System.in);
    static String[] entities = new String[]{"propietarios", "ubicaciones", "ciudades",
        "constructoras", "casas", "departamentos"};

    public void saveEntityByOption(String option) throws IOException {
        switch (option) {
            case "1":
                Propietario propietario = createPropietario();
                break;
            case "2":
                Ubicacion ubicacion = createUbicacion();
                break;
            case "3":
                Ciudad ciudad = createCiudad();
                break;

            case "4":
                Constructora constructora = createConstructora();
                break;

            case "5":
                Casa casa = createCasa();
                break;

            case "6":
                Departamento departamento = createDepartamento();
                break;
        }
    }

    public void showEntityByOption(String option) throws IOException {

        switch (option) {
            case "1":
                showTable("utils/tables/propietariosTable.txt", null, null);
                showTable("propietarios.txt", alignFormats.get(0), "/getEntities");
                break;
            case "2":
                showTable("utils/tables/ubicacionesTable.txt", null, null);
                showTable("ubicaciones.txt", alignFormats.get(1), "/getEntities");
                break;
            case "3":
                showTable("utils/tables/ciudadesTable.txt", null, null);
                showTable("ciudades.txt", alignFormats.get(2), "/getEntities");
                break;

            case "4":
                showTable("utils/tables/constructorasTable.txt", null, null);
                showTable("constructoras.txt", alignFormats.get(3), "/getEntities");

                break;

            case "5":
                showTable("utils/tables/casasTable.txt", null, null);
                showTable("casas.txt", alignFormats.get(4), "/getEntities");

                break;

            case "6":
                showTable("utils/tables/departamentosTable.txt", null, null);
                showTable("casas.txt", alignFormats.get(5), "/getEntities");
                break;
            case "7":
                showAllTables();
                break;
            default:
                Ejecutor.showWrongOptionMessage();
                return;
        }
    }

    public Propietario createPropietario() throws IOException {
        System.out.println("Información del propietario:");

        System.out.print(" ■ Nombres -> ");
        String nombres = read.nextLine();
        System.out.print(" ■ Apellidos -> ");
        String apellidos = read.nextLine();

        String id = dataController.getLastID("utils/lastPropietarioID.txt");

        Propietario propietario = new Propietario(id, nombres, apellidos);

        saveEntity("propietarios.txt", propietario);

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

        String id = dataController.getLastID("utils/lastUbicacionID.txt");

        Ubicacion ubicacion = new Ubicacion(numCasa, barrio, referencia, id);
        saveEntity("ubicaciones.txt", ubicacion);

        return ubicacion;
    }

    public Constructora createConstructora() throws IOException {
        System.out.println("Información de la constructora: ");

        System.out.print(" ■ Nombre -> ");
        String nombreEmpresa = read.next();

        String id = dataController.getLastID("utils/lastConstructoraID.txt");

        Constructora constructora = new Constructora(id, nombreEmpresa);
        saveEntity("constructoras.txt", constructora);
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
        String numCasa = read.nextLine();

        System.out.print(" ■ Nombre ciudad-> ");
        String nombreCiudad = read.nextLine();

        System.out.print(" ■ ID de la constructora-> ");
        String constructoraID = read.nextLine();

        String id = dataController.getLastID("utils/lastCasaID.txt");

        Casa casa = new Casa(id, precioMetroCuadrado, metrosCuadrados, numeroCuartos,
                getPropietarioByID(propietarioID),
                getUbicacionByNumCasa(numCasa),
                getCiudadByNombre(nombreCiudad), getConstructoraByID(constructoraID));
        casa.calcularCostoFinal();

        saveEntity("casas.txt", casa);
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
        String numCasa = read.nextLine();

        System.out.print(" ■ Nombre ciudad-> ");
        String nombreCiudad = read.nextLine();

        System.out.print(" ■ ID de la constructora-> ");
        String constructoraID = read.nextLine();

        String id = dataController.getLastID("utils/lastDepartamentoID.txt");

        Departamento departamento = new Departamento(id,
                getPropietarioByID(propietarioID),
                precioMetroCuadrado, metrosCuadrados, precio, valorCuotaMensual,
                ubicacionEnEdificio, getUbicacionByNumCasa(numCasa), nombreEdificio,
                getCiudadByNombre(nombreCiudad),
                numeroCuartos, getConstructoraByID(constructoraID));

        departamento.calcularCostoFinal();

        saveEntity("departamentos.txt", departamento);

        return departamento;
    }

    public Ciudad createCiudad() throws IOException {
        System.out.println("Información de la ciudad: ");

        System.out.print(" ■ Nombre ciudad -> ");
        String nombreCiudad = read.nextLine();
        System.out.print(" ■ Nombre provincia -> ");
        String nombreProvincia = read.nextLine();

        String id = dataController.getLastID("utils/lastCiudadID.txt");

        Ciudad ciudad = new Ciudad(nombreCiudad, nombreProvincia, id);

        saveEntity("ciudades.txt", ciudad);
        return ciudad;
    }

    public Propietario getPropietarioByID(String id) throws IOException {
        String[] properties = new String[3];
        properties = dataController.getByFilter(properties, "propietarios.txt", id, 0);
        return new Propietario(properties[0], properties[1], properties[2]);
    }

    public Ubicacion getUbicacionByNumCasa(String numCasa) throws IOException {
        String[] properties = new String[4];
        properties = dataController.getByFilter(properties, "ubicaciones.txt", numCasa, 0);
        return new Ubicacion(Integer.parseInt(properties[0]), properties[1], properties[2],
                properties[3]);

    }

    public Ciudad getCiudadByNombre(String nombre) throws IOException {
        String[] properties = new String[3];
        properties = dataController.getByFilter(properties, "ciudades.txt", nombre, 0);
        return new Ciudad(properties[0], properties[1], properties[2]);
    }

    public Constructora getConstructoraByID(String id) throws IOException {
        String[] properties = new String[2];
        properties = dataController.getByFilter(properties, "constructoras.txt", id, 0);
        return new Constructora(properties[0], properties[1]);
    }

    public void showTable(String fileName, String[] leftAlignFormat, String command) throws IOException {
        FilesHandler.showFileData(fileName, command, leftAlignFormat, null, 0);
    }

    public void showAllTables() throws IOException {

        for (int i = 0; i < entities.length; i++) {
            showTable("utils/tables/" + entities[i] + "Table.txt", null, null);
            showTable(entities[i] + ".txt", alignFormats.get(i), "/getEntities");
            System.out.print("=============================================");
            System.out.print("=============================================");
        }

    }

    public static <E> void saveEntity(String filename, E entity) throws IOException {
        dataController.saveInFile(filename, entity.toString(), "append");
    }

}
