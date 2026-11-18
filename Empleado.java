public class Empleado {

    // Atributos
    private String nombre;
    private double salarioHora;
    private int horasTrabajadas;
    private double bonificacion;

    // metodo constructor por defecto
    public Empleado() {
        nombre = "sin asignar";
        salarioHora = 10000;
        horasTrabajadas = 40;
        bonificacion = 0;
    }

    // metodo constructor con parametros
    public Empleado(String nombre, double salarioHora, int horasTrabajadas, double bonificacion) {
        this.nombre = nombre;
        this.salarioHora = salarioHora;
        this.horasTrabajadas = horasTrabajadas;
        this.bonificacion = bonificacion;
    }

    // getters-obterner
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

    // setters-asignar
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
            System.out.println("Bonificación invalida");
        }
    }

    public double calcularSalario() {
        double salarioTotal;

        if (horasTrabajadas <= 40) {
            salarioTotal = horasTrabajadas * salarioHora;
        } else {
            int horasExtra = horasTrabajadas - 40;

            salarioTotal = (salarioHora * 40) + (salarioHora * 1.5 * horasExtra);
        }

        salarioTotal += bonificacion;

        return salarioTotal;
    }

}