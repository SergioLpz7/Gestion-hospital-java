package modelos;

import enums.NivelGravedad;

public class PacienteUrgencia {

    private Paciente paciente;
    private NivelGravedad nivelGravedad;
    private long ordenLlegada;

    public PacienteUrgencia(Paciente paciente, NivelGravedad nivelGravedad, long ordenLlegada) {
        this.paciente = paciente;
        this.nivelGravedad = nivelGravedad;
        this.ordenLlegada = ordenLlegada;
    }

    public Paciente      getPaciente()      { return paciente; }
    public NivelGravedad getNivelGravedad() { return nivelGravedad; }
    public long          getOrdenLlegada()  { return ordenLlegada; }

    @Override
    public String toString() {
        return "[" + nivelGravedad + "] "
             + paciente.getNombre() + " " + paciente.getApellidos()
             + " (DNI: " + paciente.getDni() + ")";
    }
}