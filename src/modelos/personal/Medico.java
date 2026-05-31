package modelos.personal;

import modelos.Personal;

public class Medico extends Personal {
    private String especialidad;

    public Medico(int id, String nombre, String especialidad) {
        super(id, nombre);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() { return especialidad; }

    @Override
    public String toString() {
        return "[MÉDICO] " + super.toString() + " | Especialidad: " + especialidad;
    }
}