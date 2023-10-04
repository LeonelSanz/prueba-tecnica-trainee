import java.util.Scanner;

public class ReservaAsientos {

    public static void main(String[] args) {

        // Declaracion de variables
        char asientos [][] = new char [10][10];
        boolean bandera = false;
        Scanner teclado = new Scanner(System.in);
        int fila = 0, asiento = 0;
        String respuesta;
        String verMapa;
    
        // Cargamos la matriz de asientos
        for (int f = 0; f < 10; f++) {
            for (int c = 0; c < 10; c++) {
                asientos[f][c] = 'L';
            }
        }

        // Bienvenida al sistema
        System.out.println("---------Bienvenidos al sistema de reservas---------");
    
        // Reserva de asientos
        while (bandera != true) {
            // Visualizacion de mapa
            System.out.println("Desea ver los asientos disponibles? S: Si, Otro boton: No");
            verMapa = teclado.next();

            if (verMapa.equalsIgnoreCase("S")) {
                dibujarMapa(asientos);
            }

            // Reserva
            boolean estaOk = false;
            while(estaOk != true) {
                System.out.println("\n Ingrese Fila y Asiento a reservar");
                System.out.println("Fila (entre 0 y 9): ");
                fila = teclado.nextInt();
    
                System.out.println("Asiento (entre 0 y 9): ");
                asiento = teclado.nextInt();

                if (fila <= 9 && fila >= 0) {
                    if (asiento <= 9 && asiento >= 0) {
                        estaOk = true;
                    } else {
                    System.out.println("El numero de asiento no es valido");
                }
                } else {
                    System.out.println("El numero de fila no es valido");
                }
            }

            if (asientos[fila][asiento] == ('L')) {
                asientos[fila][asiento] = 'X';
                System.out.println("El asiento fue reservado correctamente");
            } else {
                System.out.println("El asiento esta ocupado. Por favor elija otro");
            }

            System.out.println("Desea finalizar la reserva? S: Si. Otro boton: No");
            respuesta = teclado.next();

            if (respuesta.equalsIgnoreCase("S")) {
                bandera = true;
            }
        }
    }

    static void dibujarMapa(char asientos[][]) {
        for (int f = 0; f < 10; f++) {
            System.out.print(f + " ");
            for (int c = 0; c < 10; c++) {
                System.out.print("[" + asientos[f][c] + "]");
            }
            System.out.println("");
        }
    }

}

