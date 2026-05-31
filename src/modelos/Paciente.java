package modelos;
public class Paciente {
    
    private String nombre, apellidos, dni, numHistorial;
    private int edad;


    public Paciente(String nombre, String apellidos, String dni, String numHistorial, int edad){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.numHistorial = numHistorial;
        this.edad = edad;
    }


    public String getNombre() {return nombre;}
    public String getApellidos() { return apellidos;}
    public String getDni() {return dni;}
    public String getNumHistorial() {return numHistorial;}
    public int getEdad() {return edad;}

   @Override
    public String toString(){
    return nombre + " " + apellidos + 
        " | DNI: " + dni + 
        " | Historial: " + numHistorial + 
        " | Edad: " + edad;
    }
}

    