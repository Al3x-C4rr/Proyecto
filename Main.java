import java.util.List;
public class Main {
    public static void main(String[] args) {
        // 1️⃣ Cargar empresas existentes (si el CSV ya existe)
        List<Empresa> empresas = EmpresaCSV.cargarEmpresas();

        // 2️⃣ Agregar nuevas empresas
        empresas.add(new Empresa("TechVision", "Visual", 40, "L-V", true, "Desarrollador de Software", 8500.00, "Ciudad de Guatemala", true));
        empresas.add(new Empresa("AudioPlus", "Auditiva", 35, "L-S", false, "Diseñador Gráfico", 7200.00, "Antigua Guatemala", true));
        empresas.add(new Empresa("MotrizCorp", "Motriz", 45, "L-V", true, "Asistente Administrativo", 6800.00, "Mixco", true));

        // 3️⃣ Guardar en CSV
        EmpresaCSV.guardarEmpresas(empresas);

        // 4️⃣ Mostrar todas las empresas cargadas
        System.out.println("\n=== EMPRESAS REGISTRADAS ===");
        for (Empresa e : empresas) {
            e.mostrarOfertas();
        }
    }
}
