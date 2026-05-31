package modelos.personal;

import modelos.Personal;

public class Enfermero extends Personal {
    private String planta;

    public Enfermero(int id, String nombre, String planta) {
        super(id, nombre);
        this.planta = planta;
    }

    public String getPlanta() { return planta; }

    @Override
    public String toString() {
        return "[ENFERMERO] " + super.toString() + " | Planta: " + planta;
    }
}