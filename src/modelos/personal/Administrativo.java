package modelos.personal;

import modelos.Personal;

public class Administrativo extends Personal {
    private String departamento;

    public Administrativo(int id, String nombre, String departamento) {
        super(id, nombre);
        this.departamento = departamento;
    }

    public String getDepartamento() { return departamento; }

    @Override
    public String toString() {
        return "[ADMINISTRATIVO] " + super.toString() + " | Departamento: " + departamento;
    }
}