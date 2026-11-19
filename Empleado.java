
import java.util.Scanner;
import java.util.ArrayList;

public class Empleado {

    // Atributos
    private String nombre;
    private double salarioHora;
    private int horasTrabajadas;
    private double bonificacion;

    // Lista para almacenar empleados
    static ArrayList<Empleado> empleados = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // Constructor por defecto
    public Empleado() {
        nombre = "sin asignar";
        salarioHora = 10000;
        horasTrabajadas = 40;
        bonificacion = 0;
    }

    // Constructor con parametros
    public Empleado(String nombre, double salarioHora, int horasTrabajadas, double bonificacion) {
        this.nombre = nombre;
        setSalarioHora(salarioHora);
        setHorasTrabajadas(horasTrabajadas);
        setBonificacion(bonificacion);
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public double getSalarioHora() {
        return salarioHora;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public double getBonificacion() {
        return bonificacion;
    }

    // Setters
    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre;
        }
    }

    public void setSalarioHora(double salarioHora) {
        if (salarioHora > 0) {
            this.salarioHora = salarioHora;
        } else {
            System.out.println("Salario invalido");
        }
    }

    public void setHorasTrabajadas(int horasTrabajadas) {
        if (horasTrabajadas >= 0) {
            this.horasTrabajadas = horasTrabajadas;
        } else {
            System.out.println("Horas trabajadas invalidas");
        }
    }

    public void setBonificacion(double bonificacion) {
        if (bonificacion >= 0) {
            this.bonificacion = bonificacion;
        } else {
            System.out.println("Bonificacion invalida");
        }
    }

    // Metodo de comportamiento 1
    public double calcularSalario() {
        double salarioTotal;

        if (horasTrabajadas <= 40) {
            salarioTotal = horasTrabajadas * salarioHora;
        } else {
            int horasExtra = horasTrabajadas - 40;
            salarioTotal = (salarioHora * 40) +
                    (salarioHora * 1.5 * horasExtra);
        }

        salarioTotal += bonificacion;

        return salarioTotal;
    }

    // Metodo de comportamiento 2
    public double calcularSalarioMensual() {
        return calcularSalario() * 4;
    }

    // Metodo para seleccionar un empleado
    public static Empleado seleccionarEmpleado() {

        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados.");
            return null;
        }

        for (int i = 0; i < empleados.size(); i++) {
            System.out.println((i + 1) + ". " +
                    empleados.get(i).getNombre());
        }

        System.out.print("Seleccione el empleado: ");
        int posicion = sc.nextInt();
        sc.nextLine();

        if (posicion >= 1 && posicion <= empleados.size()) {
            return empleados.get(posicion - 1);
        }

        System.out.println("Seleccion invalida.");
        return null;
    }

    // Metodo principal
    public static void main(String[] args) {

        int opcion;

        do {
            System.out.println("\n===== GESTION DE SALARIOS =====");
            System.out.println("1. Crear objeto por defecto");
            System.out.println("2. Crear objeto con parametros");
            System.out.println("3. Modificar atributos del objeto");
            System.out.println("4. Visualizar objetos registrados");
            System.out.println("5. Ejecutar metodo calcular salario");
            System.out.println("6. Ejecutar metodo calcular salario mensual");
            System.out.println("7. Salir");

            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:
                    Empleado nuevo = new Empleado();
                    empleados.add(nuevo);
                    System.out.println("Empleado creado por defecto.");
                    break;

                case 2:
                    System.out.print("Ingrese el nombre: ");
                    String nombre = sc.nextLine();

                    System.out.print("Ingrese el salario por hora: ");
                    double salario = sc.nextDouble();

                    System.out.print("Ingrese las horas trabajadas: ");
                    int horas = sc.nextInt();

                    System.out.print("Ingrese la bonificacion: ");
                    double bonificacion = sc.nextDouble();
                    sc.nextLine();

                    if (nombre.trim().isEmpty() || salario <= 0 ||
                            horas < 0 || bonificacion < 0) {
                        System.out.println("Datos invalidos.");
                    } else {
                        Empleado empleado = new Empleado(
                                nombre, salario, horas, bonificacion);

                        empleados.add(empleado);
                        System.out.println("Empleado registrado correctamente.");
                    }
                    break;

                case 3:
                    Empleado modificar = seleccionarEmpleado();

                    if (modificar != null) {
                        System.out.println("1. Modificar nombre");
                        System.out.println("2. Modificar salario por hora");
                        System.out.println("3. Modificar horas trabajadas");
                        System.out.println("4. Modificar bonificacion");

                        System.out.print("Seleccione: ");
                        int cambio = sc.nextInt();
                        sc.nextLine();

                        switch (cambio) {
                            case 1:
                                System.out.print("Nuevo nombre: ");
                                modificar.setNombre(sc.nextLine());
                                break;

                            case 2:
                                System.out.print("Nuevo salario por hora: ");
                                modificar.setSalarioHora(sc.nextDouble());
                                sc.nextLine();
                                break;

                            case 3:
                                System.out.print("Nuevas horas trabajadas: ");
                                modificar.setHorasTrabajadas(sc.nextInt());
                                sc.nextLine();
                                break;

                            case 4:
                                System.out.print("Nueva bonificacion: ");
                                modificar.setBonificacion(sc.nextDouble());
                                sc.nextLine();
                                break;

                            default:
                                System.out.println("Opcion invalida.");
                        }
                    }
                    break;

                case 4:
                    if (empleados.isEmpty()) {
                        System.out.println("No hay empleados registrados.");
                    } else {
                        for (Empleado e : empleados) {
                            System.out.println("\n-------------------");
                            System.out.println("Nombre: " + e.getNombre());
                            System.out.println("Salario por hora: " + e.getSalarioHora());
                            System.out.println("Horas trabajadas: " + e.getHorasTrabajadas());
                            System.out.println("Bonificacion: " + e.getBonificacion());
                            System.out.println("Salario total: " + e.calcularSalario());
                        }
                    }
                    break;

                case 5:
                    Empleado calcular = seleccionarEmpleado();

                    if (calcular != null) {
                        System.out.println("Salario total: $" +
                                calcular.calcularSalario());
                    }
                    break;

                case 6:
                    Empleado mensual = seleccionarEmpleado();

                    if (mensual != null) {
                        System.out.println("Salario mensual aproximado: $" +
                                mensual.calcularSalarioMensual());
                    }
                    break;

                case 7:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }

        } while (opcion != 7);

        sc.close();
    }
}
