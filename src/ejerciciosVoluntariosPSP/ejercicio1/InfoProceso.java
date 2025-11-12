package ejerciciosVoluntariosPSP.ejercicio1;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class InfoProceso {

    private static final DateTimeFormatter FMT =
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                    .withZone(ZoneId.systemDefault());

    public static void main(String[] args) {

        System.out.print("--- (a) Proceso Actual ---\n");

        ProcessHandle actual = ProcessHandle.current();
        ProcessHandle.Info infoActual = actual.info();

        System.out.println(" Actual -> PID: " + actual.pid() + "| Vivo: " + actual.isAlive());
        System.out.println(" Comando: " + infoActual.command().orElse("(desconocido)"));
        System.out.println(" Args: " + infoActual.arguments().map(a -> String.join(" ", a)).orElse("(sin argumentos"));
        System.out.println(" Inicio: " + infoActual.startInstant().map(Object::toString).orElse("(inicio desconocido)"));
        System.out.println(" CPU total: " + infoActual.totalCpuDuration().map(d -> d.toMillis() + " ms").orElse("(CPU desconocida)"));

        System.out.println("--- (b) Proceso padre ---");

        actual.parent().ifPresentOrElse(padre -> {
            ProcessHandle.Info infoPadre = padre.info();

            System.out.println("Padre -> PID: " + padre.pid() + "| Vivo: " + padre.isAlive());
            System.out.println(" Comando: " + infoPadre.command().orElse("(desconocido)"));
            System.out.println(" Args: " + infoPadre.arguments().map(a -> String.join(" ", a)).orElse("(sin argumentos)"));
            System.out.println(" Usuario: " + infoPadre.user().orElse("(usuario desconocido)"));
            System.out.println(" Inicio: " + infoPadre.startInstant().map(Object::toString).orElse("(inicio desconocido)"));
            System.out.println(" CPU total: " + infoPadre.totalCpuDuration().map(d -> d + " ms").orElse("(CPU desconocida)"));

        }, () -> System.out.println("No hay proceso padre (o el sistema no lo expone)."));

        System.out.println("--- (c) Procesos hijo ---");

        var hijos = actual.children().toList();

        if (hijos.isEmpty()) {
            System.out.println("No hay procesos hijo del roceso actual.");
        } else {
            for (ProcessHandle h : hijos) {
                ProcessHandle.Info infoHijo = h.info();

                System.out.println("Hijo -> PID: " + h.pid() + " | Vivo: " + h.isAlive());
                System.out.println("   Comando: " + infoHijo.command().orElse("(desconocido)"));
                System.out.println("   Args: " + infoHijo.arguments().map(a -> String.join(" ", a)).orElse("(sin argumentos)"));
                System.out.println("   Usuario: " + infoHijo.user().orElse("(usuario desconocido)"));
                System.out.println("   Inicio: " + infoHijo.startInstant().map(Object::toString).orElse("(inicio desconocido)"));
                System.out.println("   CPU total: " + infoHijo.totalCpuDuration().map(d -> d.toMillis() + " ms").orElse("(CPU desconocida)"));

            }
        }
    }
}