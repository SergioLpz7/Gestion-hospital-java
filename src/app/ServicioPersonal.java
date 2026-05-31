package app;

import java.util.ArrayList;

import modelos.personal.Administrativo;
import modelos.personal.Enfermero;
import modelos.personal.Medico;
import modelos.Personal;

public class ServicioPersonal {

    private final ArrayList<Personal> listaPersonal = new ArrayList<>();
    private int contadorId = 1;

    public void darAlta() {
        System.out.println("Tipo: 1-Médico  2-Enfermero  3-Administrativo");
        int tipo;
        while (true) {
            tipo = Formato.leerEntero("Tipo: ");
            if (tipo >= 1 && tipo <= 3)
                break;
            System.out.println("Introduce 1, 2 o 3.");
        }
        String nombre = Formato.leerSoloLetras("Nombre: ");
        int id = contadorId++;

        Personal p = switch (tipo) {
            case 1 -> new Medico(id, nombre, Formato.leerTextoNoVacio("Especialidad: "));
            case 2 -> new Enfermero(id, nombre, Formato.leerTextoNoVacio("Planta: "));
            default -> new Administrativo(id, nombre, Formato.leerTextoNoVacio("Departamento: "));
        };

        listaPersonal.add(p);
        System.out.println("Personal registrado: " + p);
    }

    public void mostrarTodos() {
        if (listaPersonal.isEmpty()) {
            System.out.println("No hay personal registrado.");
            return;
        }
        System.out.println("-- Personal registrado --");
        for (Personal p : listaPersonal) {
            System.out.println(p);
        }
    }
}