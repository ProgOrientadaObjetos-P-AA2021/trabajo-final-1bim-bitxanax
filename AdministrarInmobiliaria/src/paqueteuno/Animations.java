/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteuno;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bitxanax
 */
public class Animations extends Thread {

    public void run() {

    }

    
    public void loadingBar() {
        System.out.print("Loading ");
        for (int i = 0; i < 26; i++) {
            System.out.print("□□");
            try {
                Thread.sleep(300 - i * 5);
            } catch (InterruptedException ex) {
                System.out.println("Error al cargar la animación... " + ex.toString());
            }
        }

    }

    public void showTable(String fileName, String [] leftAlignFormat, String command) throws IOException {
        FilesHandler.showFileData(fileName, command, leftAlignFormat, null, 0);
    }
}
