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

    public void saveInFile(String fileName, String text, String appendOrWrite) throws IOException {
        // directory from where the program was launched
        File file = new File(workDirectory + "/datos/" + fileName);
        FileWriter fileWriter = null;
        BufferedWriter bufferWriter = null;

        if (file.exists()) {
            try {
                fileWriter = new FileWriter(file.getAbsolutePath(), true);
                bufferWriter = new BufferedWriter(fileWriter);

                if (appendOrWrite == "append") {
                    bufferWriter.append(text + "\n/\n");
                } else {
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

    public static void showFileData(String fileName, String command,
            String[] alignFormat, String filter, int filterPosition) throws IOException {

        FileReader fileReader = null;
        BufferedReader reader = null;
        try {
            String line = "";
            fileReader = new FileReader(workDirectory
                    + "/datos/" + fileName);
            reader = new BufferedReader(fileReader);

            if (command == "/catchID") {
                inCaseOfNeededID = reader.readLine();
                int lastID = Integer.parseInt(inCaseOfNeededID) + 1;
                inCaseOfNeededID = Integer.toString(lastID);
                FilesHandler dataSaver = new FilesHandler();
                dataSaver.saveInFile(fileName, inCaseOfNeededID, "write");
                return;
            } else if (command == "/getEntities") {

                int index = 0;
                String lineBefore = "";
                while ((line = reader.readLine()) != null) {
                    //line = reader.readLine();
                    //System.out.print("line: " + line);
                    if (!line.equals("/")) {
                        //System.out.print(" index: " + index);
                        System.out.printf(alignFormat[index], line);
                        index++;
                    } else {
                        System.out.println("\n");
                        index = 0;
                    }

                    if (line == null) {
                        break;
                    }

                }
                return;
            } else if (command == "/getEntityByFilter") {
                String lineBefore = "";
                int lineIndex = 0;

                while (line != null) {
                    //System.out.println("index" + lineIndex);
                    //System.out.println("filter position: " + filterPosition);

                    line = reader.readLine();
                    lineBefore = (line == null) ? "" : line;
                    //System.out.println("lineIndex == filterPosition: " + (lineIndex == filterPosition));
                    //System.out.println("filter.equals(line)" + (filter.equals(line)) + " ->" + line);

                    if (lineIndex == filterPosition && filter.equals(line)) {
                        while (!line.equals("/")) {
                            entityProperties.add(line);
                            line = reader.readLine();
                        }
                        return;
                    }

                    if (lineBefore.equals("/")) {
                        lineIndex = 0;
                    } else {
                        lineIndex += 1;
                    }
                }
                return;
            }

            //Mostrar un archivo normal
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fileReader.close();
            reader.close();
            /*if (fileReader == null) {
                fileReader.close();
            }
            if (reader == null) {
                reader.close();
            }*/
        }
    }

    public String getLastID(String fileName) throws IOException {
        showFileData(fileName, "/catchID", null, null, 0);

        return inCaseOfNeededID;

    }

    public String[] getByFilter(String[] properties, String fileName, String filter,
            int filterPosition) throws IOException {

        showFileData(fileName, "/getEntityByFilter", null, filter, filterPosition);
        for (int i = 0; i < entityProperties.size(); i++) {
            properties[i] = entityProperties.get(i);
        }
        entityProperties = new ArrayList<>();
//        System.out.println(properties[0]);
        
        return properties;
    }

}
