package ejerciciosVoluntariosPSP.ejercicio4;

import java.io.IOException;
import java.util.Scanner;

public class ApagadoSistema {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Que accion quiere realizar: ([A]pagar, [R]einiciar, [S]uspender");
        String accion = sc.nextLine().trim().toLowerCase();
        char opcion = accion.charAt(0);

        if(opcion == 'a'){
            ProcessBuilder pb = new ProcessBuilder("shutdown", "-h", "now");
            System.out.println("Se apagara en  en 5 segundos...");
            try {
                /*Cuenta Atras*/
                for (int i = 5; i > 0; i--) {
                    System.out.println(i + "...");
                    Thread.sleep(1000);
                }
                Process proceso = pb.start();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }else if(opcion == 'r'){
            ProcessBuilder pb = new ProcessBuilder("shutdown", "-r", "now");
            System.out.println("Se reiniciara en  en 5 segundos...");

            try {
                /*Cuenta Atras*/
                for (int i = 5; i > 0; i--) {
                    System.out.println(i + "...");
                    Thread.sleep(1000);
                }
                Process proceso = pb.start();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }else if(opcion == 's'){
            ProcessBuilder pb = new ProcessBuilder("systemctl", "suspend");
            System.out.println("Se suspendera en  en 5 segundos...");
            try {
                /*Cuenta Atras*/
                for (int i = 5; i > 0; i--) {
                    System.out.println(i + "...");
                    Thread.sleep(1000);
                }
                Process proceso = pb.start();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }else {
            System.out.println("Accion no valida.");
        }

    }
}
