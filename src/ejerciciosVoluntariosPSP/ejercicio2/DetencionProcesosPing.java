package ejerciciosVoluntariosPSP.ejercicio2;



import java.time.Duration;
import java.util.Optional;
import java.util.Scanner;

public class DetencionProcesosPing {
    private static final Duration TIEMPO_DE_GRACIA = Duration.ofSeconds(3);

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*Pedir el PID por consola */

        System.out.println("Introduce el PID a gestionar");
        long pid = sc.nextLong();

        Optional<ProcessHandle> optionalProcessHandle = ProcessHandle.of(pid);
        if(optionalProcessHandle.isEmpty()){
            System.out.println("Error: No existe el processo con el PID: " + pid + ".");
            return;
        }

        ProcessHandle ph = optionalProcessHandle.get();
        /*Obtener la informaciond del proceso*/
        ProcessHandle.Info info =ph.info();
        System.out.println("Informacion del proceso: ");
        System.out.println("Comando :"+ info.command().orElse("Desconocido"));
        System.out.println("Usuasrio: "+ info.user().orElse("Desconocido"));
        System.out.println("Iniciado: "+ info.startInstant().orElse(null));

        /*Confirmar si el proceso esta vivo*/
        if(ph.isAlive()){
            System.out.println("El proceso esta activo. ¿Quieres terminarlo? (s/n)");
            String respuesta = sc.next().toLowerCase();
            if(respuesta.equals("s")){
                boolean terminado = ph.destroy();
                if (terminado) {
                    System.out.println("Proceso terminado correctamente. ");
                }else{
                    System.out.println("No se pudo terminar el proceso. Puede requerir permisos de admin. o estar protegido.");
                }
            }else{
                System.out.println("No se hizo nada el proceso sigue activo.");
            }
        }else{
            System.out.println("El proceso ya fue finalizado.");
        }




    }
}
