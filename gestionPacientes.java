import java.util.ArrayList;
import java.util.Scanner;

public class gestionPacientes {
    private static ArrayList<Paciente> listaPacientes = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("===============================");

            System.out.println("ELIJA UNA OPCIÓN");

            System.out.println("===============================");
            System.out.println("1- Dar de alta un Paciente");
            System.out.println("2- Mostrar lista de pacientes registrados");
            System.out.println("3- Salir del programa");
            System.out.println("===============================");

            if (sc.hasNextInt()) {
                int op = sc.nextInt();
                sc.nextLine();
                if (op == 1)
                    darAlta(sc);
                else if (op == 2)
                    mostrarLista();
                else if (op == 3) {
                    System.out.println("Saliendo...");
                    break;
                } else {
                    System.out.println("Error, numero no correcto");
                }
            }
        }
        sc.close();
    }

    private static void darAlta(Scanner sc) {
        System.out.println("Introduzca el Nombre del paciente");
        String nombre = sc.nextLine();
        System.out.println("Introduzca los Apellidos del paciente");
        String apellidos = sc.nextLine();
        System.out.println("Introduzca el DNI del paciente");

        String dni = sc.nextLine();
        System.out.println("Introduzca el Número de Historial del paciente");
        String numHistorial = sc.nextLine();
        System.out.println("Introduzca la Edad del paciente");
        int edad = sc.nextInt();
        sc.nextLine();
        Paciente p = new Paciente(nombre, apellidos, dni, numHistorial, edad);
        listaPacientes.add(p);
        System.out.println("Paciente registrado: " + p.toString());
    }

    private static void mostrarLista() {

        if (listaPacientes.size() <= 0)
            System.out.println("No hay ningun paciente.");

        for (Paciente p : listaPacientes) {
            System.out.println(p);
        }

    }

}
