package EjerciciosPSP.EjerciciosProcesos;

public class ManejoDeArgumentos_6_Hijo {
     public static void main(String[] args) {
        if(args.length == 0){
//            System.out.println("No se a recibido ningun argumento");
            System.exit(1);
        }else if (args.length > 1){
//            System.out.println("Se han recibido dos o mas argumentos.");
            System.exit(2);

        }else{
            String arg = args[0];
            try {
                int valorArg = Integer.parseInt(arg);
                if (valorArg > 0) {
//                    System.out.println("Argumento es un numero entero positivo");
                    System.exit(4);
                }else if(valorArg < 0){
//                    System.out.println("Argumento es un numero entero negativo");
                    System.exit(5);
                }else{
//                    System.out.println("Argumento es el numero entero positivo 0");
                    System.exit(4);
                }
            }catch (NumberFormatException e){
//                System.out.println("El argumento recibido no es un numero entero");
                System.exit(3);
            }
        }
    }
}
