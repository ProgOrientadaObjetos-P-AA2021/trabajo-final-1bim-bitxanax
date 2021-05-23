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
public class AnimationsTest {
        
    @Test
    public void table() throws IOException {
        String[] propietariosLeftAlignFormat = new String[]{"%10s", "%35s", "%38s"};
        String[] casasAlignFormat = new String[]{"%5s", "%12s", "%12s", "%12s", 
            "%12s", "%15s", "%16s", "%15s", "%14s"};
        String[] ciudadesAlignFormat = new String[]{"%16s", "%23s", "%12s"};
        
        Animation animation = new Animation();
        //animation.showTable("utils/tables/casasTable.txt", null, null);
        //animation.showTable("casas.txt", casasAlignFormat, "/getEntities");
        
        /*
            public String[] getByFilter(String[] properties, String fileName, String filter,
            int filterPosition) throws IOException {
         */
        //FilesHandler fileHandler = new FilesHandler();
    }
}
