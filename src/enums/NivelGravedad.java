package enums;
public enum NivelGravedad {
    CRITICO(1),
    GRAVE(2),
    MODERADO(3),
    LEVE(4);

    private final int prioridad;

    NivelGravedad(int prioridad) {
        this.prioridad = prioridad;
    }

    public int getPrioridad() {
        return prioridad;
    }
}