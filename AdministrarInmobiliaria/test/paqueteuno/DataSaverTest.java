/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteuno;

import java.io.IOException;
import org.testng.annotations.Test;

/**
 *
 * @author bitxanax
 */
public class DataSaverTest {

    @Test
    public void tryx() throws IOException {
        /*FilesHandler data = new FilesHandler();
      String[] properties = new String [4];
      properties = data.getByFilter(properties, "ubicaciones.txt", "1", 0);
      
      for(String i:properties) {
          System.out.println(i);
      }
        /*
      /*    
          public String[] getByFilter(String[] properties, String fileName, String filter,
            int filterPosition) throws IOException {

        showFileData(fileName, "/getEntityByFilter", null, filter, filterPosition);
        for (int i = 0; i < entityProperties.size(); i++) {
            properties[i] = entityProperties.get(i);
        }
        System.out.println(properties[0]);

        return properties;
    }

         */
        int[][] xd = {
            {1, 4,3, 4},
            {2, 3,3 , 4},
            {3, 5, 6,5}};

        for (int i = 0; i < xd.length; i++) {
            for (int j = 0; j < xd[i].length; j++) {
                System.out.println(xd[j][i]);
            }
            System.out.println("");
          }
    }

}
