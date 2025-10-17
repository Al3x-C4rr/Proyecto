// Clase Empresa
public class Empresa {
    // Atributos
    private String nombreEmpresa;
    private String tipoDiscapacidadAceptada; // Ejemplo: "Visual", "Auditiva", "Motriz", "Cualquiera"
    private int horasRequeridas;             // Horas de trabajo requeridas para el puesto
    private String dias;                     // Días laborales requeridos (ejemplo: "L-V", "L-S")
    private boolean ascensos;                // Indica si hay oportunidades de ascenso
    private String puesto;                   // Nombre del puesto disponible
    private double salario;                  // Salario ofrecido para el puesto
    private String lugar;                    // Ubicación del empleo
    private boolean prestacionDeLey;        // Indica si ofrece prestaciones de ley

    // Constructor
    public Empresa(String nombreEmpresa, String tipoDiscapacidadAceptada, int horasRequeridas, String dias,
                   boolean ascensos, String puesto, double salario, String lugar, boolean prestacionDeLey) {
        this.nombreEmpresa = nombreEmpresa;
        this.tipoDiscapacidadAceptada = tipoDiscapacidadAceptada;
        this.horasRequeridas = horasRequeridas;
        this.dias = dias;
        this.ascensos = ascensos;
        this.puesto = puesto;
        this.salario = salario;
        this.lugar = lugar;
        this.prestacionDeLey = prestacionDeLey;
    }

    public void registrarOferta() {
        System.out.println("=== Registro de Oferta Laboral ===");
        System.out.println("Empresa: " + nombreEmpresa);
        System.out.println("Puesto: " + puesto);
        System.out.println("Salario: $" + String.format("%.2f", salario));
        System.out.println("Tipo de Discapacidad Aceptada: " + tipoDiscapacidadAceptada);
        System.out.println("Horas Requeridas: " + horasRequeridas + " horas");
        System.out.println("Días Laborales: " + dias);
        System.out.println("Oportunidades de Ascenso: " + (ascensos ? "Sí" : "No"));
        System.out.println("Lugar: " + lugar);
        System.out.println("Prestaciones de Ley: " + (prestacionDeLey ? "Sí" : "No"));
        System.out.println("Oferta registrada exitosamente.\n");
    }


    public void mostrarOfertas() {
        System.out.println("=== Ofertas de " + nombreEmpresa + " ===");
        System.out.println("Puesto: " + puesto);
        System.out.println("Salario: $" + String.format("%.2f", salario));
        System.out.println("Tipo de Discapacidad Aceptada: " + tipoDiscapacidadAceptada);
        System.out.println("Horas Requeridas: " + horasRequeridas + " horas");
        System.out.println("Días Laborales: " + dias);
        System.out.println("Oportunidades de Ascenso: " + (ascensos ? "Sí" : "No"));
        System.out.println("Lugar: " + lugar);
        System.out.println("Prestaciones de Ley: " + (prestacionDeLey ? "Sí" : "No"));
        System.out.println();
    }

     public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public String getTipoDiscapacidadAceptada() {
        return tipoDiscapacidadAceptada;
    }

    public int getHorasRequeridas() {
        return horasRequeridas;
    }

    public String getDias() {
        return dias;
    }

    public boolean isAscensos() {
        return ascensos;
    }

    public String getPuesto() {
        return puesto;
    }

    public double getSalario() {
        return salario;
    }

    public String getLugar() {
        return lugar;
    }

    public boolean isPrestacionDeLey() {
        return prestacionDeLey;
    }

 
    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public void setTipoDiscapacidadAceptada(String tipoDiscapacidadAceptada) {
        this.tipoDiscapacidadAceptada = tipoDiscapacidadAceptada;
    }

    public void setHorasRequeridas(int horasRequeridas) {
        this.horasRequeridas = horasRequeridas;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }

    public void setAscensos(boolean ascensos) {
        this.ascensos = ascensos;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public void setPrestacionDeLey(boolean prestacionDeLey) {
        this.prestacionDeLey = prestacionDeLey;
    }
}

    public void setPrestacionDeLey(boolean prestacionDeLey) {
        this.prestacionDeLey = prestacionDeLey;
    }
}
