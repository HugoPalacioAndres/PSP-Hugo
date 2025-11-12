package ejerciciosVoluntariosPSP.ejercicio3;

import java.util.Scanner;

public class LanzadorNavegador {
    static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe la URL que se quiere visitar: ");
        String url = sc.nextLine();
        /*Apertura del navegador en es direccion */
        ProcessBuilder pb = new ProcessBuilder("google-chrome", url );
        Process proceso = pb.start();
        System.out.println("Navegador abierto se cerrara en 5 segundos...");
        /*Cuenta Atras*/
        for (int i = 5; i > 0; i--) {
            System.out.println(i + "...");
            Thread.sleep(1000);
        }
        proceso.destroy();
        System.out.println("Navegador cerrado.");

    }
}
