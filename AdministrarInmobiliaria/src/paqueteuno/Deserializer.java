/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteuno;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static paqueteuno.Serializer.workDirectory;

/**
 *
 * @author bitxanax
 */
public class Deserializer {
    
    public Object deserialize(String fileName, String id) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(workDirectory + "/datos/" + fileName + "/" + fileName + id + ".data");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Object responseEntity = null;

        try {
            responseEntity = objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {

            return responseEntity;
        }

    }


}
