/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteuno;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author bitxanax
 */
public class FilesHandler {

    static String workDirectory = System.getProperty("user.dir");
    static String inCaseOfNeededID = "";
    static ArrayList<String> entityProperties = new ArrayList<>();
    static String lastId;

    public void saveInFile(String fileName, String text, String appendOrWrite) throws IOException {
        File file = new File(workDirectory + "/datos/" + fileName);
        FileWriter fileWriter = null;
        BufferedWriter bufferWriter = null;

        if (file.exists()) {
            try {
                fileWriter = new FileWriter(file.getAbsolutePath(), true);
                bufferWriter = new BufferedWriter(fileWriter);

                if (appendOrWrite == "append") {
                    bufferWriter.append(text + "\n/\n");
                } else if (appendOrWrite == "write") {
                    fileWriter = new FileWriter(file.getAbsolutePath(), false);
                    bufferWriter.write(text + "\n");
                }
                bufferWriter.close();
                fileWriter.close();

            } catch (IOException e) {
                System.out.println("Fallo el ingreso de datos");
                e.printStackTrace();
            } finally {
                if (bufferWriter == null) {
                    bufferWriter.close();
                }
                if (fileWriter == null) {
                    fileWriter.close();
                }
            }
        } else {
            createFile(file, text);
        }
    }

    public void createFile(File file, String text) {
        try {
            file.createNewFile();
            saveInFile(file.getAbsolutePath(), text, "write");

        } catch (IOException e) {
            System.out.println(e.toString() + "\n Error al crear o "
                    + "guardar en el archivo.");
        }
    }

    public static void showFileData(String fileName, String[] alignFormat) throws IOException {
        
        FileReader fileReader = null;
        BufferedReader reader = null;
        try {
            String line = "";
            fileReader = new FileReader(workDirectory
                    + "/datos/" + fileName);
            reader = new BufferedReader(fileReader);

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fileReader.close();
            reader.close();

        }
    }
    ///datos/propietarios0/last_propietarios0ID.txt

    public static String getLastId(String fileName, boolean needsToBeModified) {
        FileReader fileReader = null;
        BufferedReader reader = null;

        try {
            String path = fileName + "/last_" + fileName + "ID.txt";

            String line = "";
            fileReader = new FileReader(workDirectory + "/datos/" + path);
            reader = new BufferedReader(fileReader);

            lastId = reader.readLine();
            int lastIdvalue = 0;

            if (needsToBeModified == true) {
                lastIdvalue = Integer.parseInt(lastId) + 1;
                lastId = Integer.toString(lastIdvalue);
                setLastId(path, lastId);
            } else {
                lastIdvalue = Integer.parseInt(lastId);
                lastId = Integer.toString(lastIdvalue);
            }

            return lastId;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void setLastId(String fileName, String id) throws IOException {
        FilesHandler filesHandler = new FilesHandler();
        filesHandler.saveInFile(fileName, id, "write");
    }

}
