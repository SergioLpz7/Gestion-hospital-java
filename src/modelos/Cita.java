package modelos;
import java.time.LocalDate;
import java.time.LocalTime;

import enums.EstadoCita;

public class Cita {

    private static int contadorId = 1;

    private int id;
    private LocalDate fecha;
    private LocalTime hora;
    private String especialidad;
    private EstadoCita estado;
    private Paciente paciente;

    public Cita(LocalDate fecha, LocalTime hora, String especialidad,
            EstadoCita estado, Paciente paciente) {
        this.id = contadorId++;
        this.fecha = fecha;
        this.hora = hora;
        this.especialidad = especialidad;
        this.estado = estado;
        this.paciente = paciente;
    }
    
    public int         getId()           { return id; }
    public LocalDate   getFecha()        { return fecha; }
    public LocalTime   getHora()         { return hora; }
    public String      getEspecialidad() { return especialidad; }
    public EstadoCita  getEstado()       { return estado; }
    public Paciente    getPaciente()     { return paciente; }
    
    @Override
    public String toString() {
        return "Cita #" + id
                + " | " + fecha + " " + hora
                + " | " + especialidad
                + " | Estado: " + estado
                + " | Paciente: " + paciente.getNombre() + " " + paciente.getApellidos()
                + " (DNI: " + paciente.getDni() + ")";
    }
}