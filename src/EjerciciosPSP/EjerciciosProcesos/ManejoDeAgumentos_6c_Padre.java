package EjerciciosPSP.EjerciciosProcesos;

import java.io.IOException;
import java.util.Scanner;

public class ManejoDeAgumentos_6c_Padre {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("introduce un Argumento: ");
        String valorArgumento = sc.nextLine();
        /**Construimos el comando para lanzar el programa hijo */
        ProcessBuilder pb = new ProcessBuilder("java","-cp","out/production/PSP-Hugo",
                "EjerciciosPSP.EjerciciosProcesos.ManejoDeArgumentos_6_Hijo", valorArgumento);
        try{
            Process p = pb.start();
            int exitCode = p.waitFor();

            switch(exitCode){
                case 1:
                    System.out.println("No se recibio argumento ninguno");
                    break;
                case 2:
                    System.out.println("Se recibieron dos o mas argumentos");
                    break;
                case 3:
                    System.out.println("Se recibio argumento y no es numero entero");
                    break;
                case 4:
                    System.out.println("Serecibio argu,mento numero entero positivo");
                    break;
                case 5:
                    System.out.println("Se recibio argumento numero entero negativo");
            }

        } catch (IOException  | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
