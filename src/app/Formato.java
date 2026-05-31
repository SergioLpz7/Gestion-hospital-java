package app;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import enums.EstadoCita;
import enums.NivelGravedad;

public class Formato {

    private static final Scanner sc = new Scanner(System.in);

    public static String leerTextoNoVacio(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            if (!s.isEmpty())
                return s;
            System.out.println("El valor no puede estar vacío.");
        }
    }

    public static String leerSoloLetras(String prompt) {
        while (true) {
            String s = leerTextoNoVacio(prompt);
            if (s.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                return s;
            }
            System.out.println("Solo se permiten letras y espacios.");
        }
    }

    public static int leerEntero(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Introduce un número entero válido.");
            }
        }
    }

    public static int leerEdad() {
        while (true) {
            int edad = leerEntero("Edad (0-120): ");
            if (edad >= 0 && edad <= 120)
                return edad;
            System.out.println("La edad debe estar entre 0 y 120 años.");
        }
    }

    public static LocalDate leerFecha() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true) {
            String s = leerTextoNoVacio("Fecha (dd/MM/yyyy): ");
            try {
                return LocalDate.parse(s, df);
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha incorrecto.");
            }
        }
    }

    public static LocalTime leerHora() {
        DateTimeFormatter tf = DateTimeFormatter.ofPattern("HH:mm");
        while (true) {
            String s = leerTextoNoVacio("Hora (HH:mm): ");
            try {
                return LocalTime.parse(s, tf);
            } catch (DateTimeParseException e) {
                System.out.println("Formato de hora incorrecto.");
            }
        }
    }

    public static EstadoCita leerEstadoCita() {
        while (true) {
            String s = leerTextoNoVacio("Estado (PENDIENTE / ATENDIDA / CANCELADA): ").toUpperCase();
            try {
                return EstadoCita.valueOf(s);
            } catch (IllegalArgumentException e) {
                System.out.println("Estado no válido.");
            }
        }
    }

    public static NivelGravedad leerNivelGravedad() {
        while (true) {
            String s = leerTextoNoVacio("Gravedad (LEVE / MODERADO / GRAVE / CRITICO): ").toUpperCase();
            try {
                return NivelGravedad.valueOf(s);
            } catch (IllegalArgumentException e) {
                System.out.println("Nivel no válido.");
            }
        }
    }

    public static void pausa() {
        System.out.print("Pulsa ENTER para continuar...");
        sc.nextLine();
    }
}