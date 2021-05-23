/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteuno;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author bitxanax
 */
public class Ejecutor {

    public static void main(String[] args) throws IOException {
        try {
            showMenu();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public static void showMenu() throws InterruptedException, IOException {

        DataHandler objectsManager = new DataHandler();

        Scanner read = new Scanner(System.in);
        String option;
        boolean exit = false;

        while (exit == false) {
            showFileMenu("/menu_text.txt");
            System.out.print("\n► Opción: ");
            option = read.nextLine();
            option.replaceAll(" ", "");

            switch (option) {
                case "1":
                    showFileMenu("/entity_menu.txt");
                    System.out.print("\n► Opción: ");
                    option = read.nextLine();
                    objectsManager.showEntityByOption(option);

                    break;
                case "2":
                    showFileMenu("/entityMenuInsertion.txt");
                    System.out.print("\n► Opción: ");
                    option = read.nextLine();
                    objectsManager.saveEntityByOption(option);

                    break;

                case "3":
                    showFileMenu("/info.txt");
                    break;

                case "4":
                    showFileMenu("/bye.txt");
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
            FilesHandler.showFileData("/utils/" + fileName, null);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
