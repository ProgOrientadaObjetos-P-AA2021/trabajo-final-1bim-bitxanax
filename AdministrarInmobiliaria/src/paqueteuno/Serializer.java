/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteuno;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import static paqueteuno.FilesHandler.lastId;

/**
 *
 * @author bitxanax
 */
public class Serializer {

    final static String workDirectory = System.getProperty("user.dir");

    public void serialize(String fileName, Object entity) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(workDirectory + "/datos/" + fileName + "/" + fileName + lastId + ".data");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        try {
            objectOutputStream.writeObject(entity);
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}
