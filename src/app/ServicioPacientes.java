package app;

import java.util.ArrayList;

import modelos.Cita;
import modelos.Paciente;

public class ServicioPacientes {

    private final ArrayList<Paciente> listaPacientes = new ArrayList<>();
    private final ArrayList<Cita> listaCitas = new ArrayList<>();

    public void darAlta() {
        System.out.println("-- Alta de paciente --");
        String nombre = Formato.leerSoloLetras("Nombre: ");
        String apellidos = Formato.leerSoloLetras("Apellidos: ");
        String dni = leerDniNuevo();
        String numHistorial = Formato.leerTextoNoVacio("Número de historial: ");
        int edad = Formato.leerEdad();

        Paciente p = new Paciente(nombre, apellidos, dni, numHistorial, edad);
        listaPacientes.add(p);
        System.out.println("Paciente registrado: " + p);
    }

    public void mostrarTodos() {
        if (listaPacientes.isEmpty()) {
            System.out.println("No hay pacientes registrados.");
            return;
        }
        System.out.println("-- Pacientes registrados --");
        for (Paciente p : listaPacientes) System.out.println(p);
    }

    // ===== CITAS =====

    public void crearCita() {
        if (listaPacientes.isEmpty()) {
            System.out.println("No hay pacientes registrados. Da de alta uno primero.");
            return;
        }
        String dni = Formato.leerTextoNoVacio("DNI del paciente: ").toUpperCase();
        Paciente p = buscarPorDni(dni);
        if (p == null) { System.out.println("No existe ningún paciente con ese DNI."); return; }

        Cita c = new Cita(
            Formato.leerFecha(),
            Formato.leerHora(),
            Formato.leerTextoNoVacio("Especialidad: "),
            Formato.leerEstadoCita(),
            p
        );
        listaCitas.add(c);
        System.out.println("Cita creada: " + c);
    }

    public void mostrarCitasDePaciente() {
        String dni = Formato.leerTextoNoVacio("DNI del paciente: ").toUpperCase();
        Paciente p = buscarPorDni(dni);
        if (p == null) { System.out.println("No existe ningún paciente con ese DNI."); return; }

        System.out.println("-- Citas de " + p.getNombre() + " " + p.getApellidos() + " --");
        boolean alguna = false;
        for (Cita c : listaCitas) {
            if (c.getPaciente().getDni().equalsIgnoreCase(dni)) {
                System.out.println(c);
                alguna = true;
            }
        }
        if (!alguna) System.out.println("Este paciente no tiene citas.");
    }

    public void mostrarTodasLasCitas() {
        if (listaCitas.isEmpty()) { System.out.println("No hay citas registradas."); return; }
        System.out.println("-- Todas las citas --");
        for (Cita c : listaCitas) System.out.println(c);
    }

    // ===== UTILIDAD =====

    public Paciente buscarPorDni(String dni) {
        for (Paciente p : listaPacientes)
            if (p.getDni().equalsIgnoreCase(dni)) return p;
        return null;
    }

    private String leerDniNuevo() {
        while (true) {
            String dni = Formato.leerTextoNoVacio("DNI (8 números + 1 letra): ").toUpperCase();
            if (!dni.matches("\\d{8}[A-Z]")) {
                System.out.println("Formato incorrecto. Debe tener 8 dígitos y 1 letra.");
                continue;
            }
            if (buscarPorDni(dni) != null) {
                System.out.println("Ya existe un paciente con ese DNI.");
                continue;
            }
            return dni;
        }
    }
}