package app;

import java.util.ArrayList;

import modelos.Paciente;
import modelos.PacienteUrgencia;

public class ServicioUrgencias {

    private final ArrayList<PacienteUrgencia> cola = new ArrayList<>();

    private final ServicioPacientes servicioPacientes;

    public ServicioUrgencias(ServicioPacientes servicioPacientes) {
        this.servicioPacientes = servicioPacientes;
    }

    public void registrarLlegada() {
        String dni = Formato.leerTextoNoVacio("DNI del paciente: ").toUpperCase();
        Paciente p = servicioPacientes.buscarPorDni(dni);
        if (p == null) {
            System.out.println("El paciente debe estar registrado previamente.");
            return;
        }

        PacienteUrgencia pu = new PacienteUrgencia(p, Formato.leerNivelGravedad());
        cola.add(pu);
        System.out.println("Registrado en urgencias: " + pu);
    }

    public void mostrarEspera() {
        if (cola.isEmpty()) {
            System.out.println("No hay pacientes en urgencias.");
            return;
        }

        // Copiamos la lista para mostrarla ordenada sin tocar la original.
        ArrayList<PacienteUrgencia> pendientes = new ArrayList<>(cola);
        System.out.println("-- Lista de espera (por prioridad) --");
        int pos = 1;
        while (!pendientes.isEmpty()) {
            int idx = indiceMasGrave(pendientes);
            System.out.println(pos++ + ". " + pendientes.get(idx));
            pendientes.remove(idx);
        }
    }

    public void atenderSiguiente() {
        if (cola.isEmpty()) {
            System.out.println("No hay pacientes en espera.");
            return;
        }
        int idx = indiceMasGrave(cola);
        PacienteUrgencia pu = cola.remove(idx);
        System.out.println("Atendiendo a: " + pu);
    }

    // Devuelve la posición del paciente más grave (menor número de prioridad).
    // Si hay empate, gana el que llegó antes (ocupa una posición anterior en la lista).
    private int indiceMasGrave(ArrayList<PacienteUrgencia> lista) {
        int idx = 0;
        for (int i = 1; i < lista.size(); i++) {
            int prioridadActual = lista.get(i).getNivelGravedad().getPrioridad();
            int prioridadMejor = lista.get(idx).getNivelGravedad().getPrioridad();
            if (prioridadActual < prioridadMejor) {
                idx = i;
            }
        }
        return idx;
    }
}
