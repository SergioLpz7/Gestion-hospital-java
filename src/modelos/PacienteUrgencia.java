package modelos;

import enums.NivelGravedad;

public class PacienteUrgencia {

    private Paciente paciente;
    private NivelGravedad nivelGravedad;

    public PacienteUrgencia(Paciente paciente, NivelGravedad nivelGravedad) {
        this.paciente = paciente;
        this.nivelGravedad = nivelGravedad;
    }

    public Paciente      getPaciente()      { return paciente; }
    public NivelGravedad getNivelGravedad() { return nivelGravedad; }

    @Override
    public String toString() {
        return "[" + nivelGravedad + "] "
             + paciente.getNombre() + " " + paciente.getApellidos()
             + " (DNI: " + paciente.getDni() + ")";
    }
}