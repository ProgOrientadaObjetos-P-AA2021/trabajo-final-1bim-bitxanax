/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteuno;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author reroes
 */
public class Ejecutor {

    public static void main(String[] args) throws IOException {
        try {
            showMenu();
        } catch (InterruptedException ex) {
            Logger.getLogger(Ejecutor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void showMenu() throws InterruptedException, IOException {
        /*Animations animation = new Animations();
        animation.loadingBar();*/
        DataHandler objectsManager = new DataHandler();

        Scanner read = new Scanner(System.in);
        String option;
        boolean exit = false;

        while (exit == false) {
            showFileMenu("utils/menu_text.txt");
            System.out.print("\n► Opción: ");
            option = read.nextLine();
            option.replaceAll(" ", "");
            
            switch (option) {
                case "1":
                    showFileMenu("utils/entity_menu.txt");
                    System.out.print("\n► Opción: ");
                    option = read.nextLine();
                    objectsManager.showEntityByOption(option);

                    break;
                case "2":
                    showFileMenu("utils/entityMenuInsertion.txt");
                    System.out.print("\n► Opción: ");
                    option = read.nextLine();
                    objectsManager.saveEntityByOption(option);

                    break;

                case "3":
                    showFileMenu("utils/info.txt");
                    break;

                case "4":
                    showFileMenu("utils/bye.txt");
                    exit = true;
                    break;

                default:
                    showWrongOptionMessage();
                    break;
            }
        }

    }

    public static void showWrongOptionMessage() {
        String ANSI_RED = "\u001B[31m", ANSI_RESET = "\u001B[0m";
        System.out.println(ANSI_RED + "❎ OPCION INVÁLIDA ( ´•̥̥̥︵•̥̥̥`)" + ANSI_RESET);
    }

    public static void showFileMenu(String fileName) {
        try {
            FilesHandler.showFileData(fileName, null, new String[0], "", 0);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
