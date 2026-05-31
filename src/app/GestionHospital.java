package app;

public class GestionHospital {

    private static final ServicioPacientes pacientes = new ServicioPacientes();
    private static final ServicioUrgencias urgencias = new ServicioUrgencias(pacientes);
    private static final ServicioPersonal personal = new ServicioPersonal();

    public static void main(String[] args) {
        boolean salir = false;
        while (!salir) {
            mostrarMenu();
            int op = Formato.leerEntero("Opción: ");
            switch (op) {
                case 1 -> menuPacientes();
                case 2 -> menuCitas();
                case 3 -> menuUrgencias();
                case 4 -> menuPersonal();
                case 0 -> {
                    System.out.println("Saliendo...");
                    salir = true;
                }
                default -> System.out.println("Opción no válida.");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("========= HOSPITAL =========");
        System.out.println(" 1. Pacientes");
        System.out.println(" 2. Citas");
        System.out.println(" 3. Urgencias");
        System.out.println(" 4. Personal Médico");
        System.out.println(" 0. Salir");
        System.out.println("============================");
    }

    private static void menuPacientes() {
        boolean volver = false;
        while (!volver) {
            System.out.println("--- Pacientes ---");
            System.out.println(" 1. Dar de alta");
            System.out.println(" 2. Mostrar todos");
            System.out.println(" 0. Volver");
            int op = Formato.leerEntero("Opción: ");
            switch (op) {
                case 1 -> pacientes.darAlta();
                case 2 -> { pacientes.mostrarTodos(); Formato.pausa(); }
                case 0 -> volver = true;
                default -> System.out.println("Opción no válida.");
            }
        }
    }

    private static void menuCitas() {
        boolean volver = false;
        while (!volver) {
            System.out.println("--- Citas ---");
            System.out.println(" 1. Crear cita");
            System.out.println(" 2. Citas de un paciente");
            System.out.println(" 3. Mostrar todas");
            System.out.println(" 0. Volver");
            int op = Formato.leerEntero("Opción: ");
            switch (op) {
                case 1 -> pacientes.crearCita();
                case 2 -> pacientes.mostrarCitasDePaciente();
                case 3 -> pacientes.mostrarTodasLasCitas();
                case 0 -> volver = true;
                default -> System.out.println("Opción no válida.");
            }
        }
    }

    private static void menuUrgencias() {
        boolean volver = false;
        while (!volver) {
            System.out.println("--- Urgencias ---");
            System.out.println(" 1. Registrar llegada");
            System.out.println(" 2. Ver lista de espera");
            System.out.println(" 3. Atender siguiente");
            System.out.println(" 0. Volver");
            int op = Formato.leerEntero("Opción: ");
            switch (op) {
                case 1 -> urgencias.registrarLlegada();
                case 2 -> urgencias.mostrarEspera();
                case 3 -> urgencias.atenderSiguiente();
                case 0 -> volver = true;
                default -> System.out.println("Opción no válida.");
            }
        }
    }

    private static void menuPersonal() {
        boolean volver = false;
        while (!volver) {
            System.out.println("--- Personal ---");
            System.out.println(" 1. Dar de alta");
            System.out.println(" 2. Mostrar todos");
            System.out.println(" 0. Volver");
            int op = Formato.leerEntero("Opción: ");
            switch (op) {
                case 1 -> personal.darAlta();
                case 2 -> personal.mostrarTodos();
                case 0 -> volver = true;
                default -> System.out.println("Opción no válida.");
            }
        }
    }
}