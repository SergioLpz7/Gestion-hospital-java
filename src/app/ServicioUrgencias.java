package app;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import modelos.Paciente;
import modelos.PacienteUrgencia;

public class ServicioUrgencias {

    private final PriorityQueue<PacienteUrgencia> cola = new PriorityQueue<>(
            Comparator
                    .comparingInt((PacienteUrgencia pu) -> pu.getNivelGravedad().getPrioridad())
                    .thenComparingLong(PacienteUrgencia::getOrdenLlegada));
    private long contadorLlegada = 0;

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

        PacienteUrgencia pu = new PacienteUrgencia(p, Formato.leerNivelGravedad(), contadorLlegada++);
        cola.add(pu);
        System.out.println("Registrado en urgencias: " + pu);
    }

    public void mostrarEspera() {
        if (cola.isEmpty()) {
            System.out.println("No hay pacientes en urgencias.");
            return;
        }

        ArrayList<PacienteUrgencia> ordenada = new ArrayList<>(cola);
        ordenada.sort(
                Comparator
                        .comparingInt((PacienteUrgencia pu) -> pu.getNivelGravedad().getPrioridad())
                        .thenComparingLong(PacienteUrgencia::getOrdenLlegada));
        System.out.println("-- Lista de espera (por prioridad) --");
        int pos = 1;
        for (PacienteUrgencia pu : ordenada)
            System.out.println(pos++ + ". " + pu);
    }

    public void atenderSiguiente() {
        PacienteUrgencia pu = cola.poll();
        if (pu == null) {
            System.out.println("No hay pacientes en espera.");
            return;
        }
        System.out.println("Atendiendo a: " + pu);
    }
}