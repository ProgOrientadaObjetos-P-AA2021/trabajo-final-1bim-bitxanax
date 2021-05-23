package paqueteuno;

/**
 *
 * @author bitxanax
 */
public class Animation extends Thread {

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


}
