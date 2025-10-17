import java.util.ArrayList;
import java.util.List;

public class Estadisticas {

    public String ResultadosFiltrado(String tipo, String prestacionStr, String lugar) {
        StringBuilder resultado = new StringBuilder();
        List<Empresa> empresas = EmpresaCSV.cargarEmpresas();
        List<Empresa> filtradas = new ArrayList<>(empresas);

        if (tipo != null && !tipo.isBlank()) {
            filtradas = filtrarEmpresasPorTipoDiscapacidad(filtradas, tipo);
            resultado.append("\nEmpresas que aceptan discapacidad del tipo: ").append(tipo).append("\n");
        }

        if (prestacionStr != null && (prestacionStr.equalsIgnoreCase("true") || prestacionStr.equalsIgnoreCase("false"))) {
            boolean requierePrestacion = Boolean.parseBoolean(prestacionStr);
            filtradas = filtrarEmpresasConPrestacionDeLey(filtradas, requierePrestacion);
            resultado.append("\nEmpresas con prestación de ley = ").append(requierePrestacion).append("\n");
        }

        if (lugar != null && !lugar.isBlank()) {
            filtradas = filtrarEmpresasPorLugar(filtradas, lugar);
            resultado.append("\nEmpresas ubicadas en: ").append(lugar).append("\n");
        }

        resultado.append(mostrarEmpresas(filtradas));
        return resultado.toString();
    }

    private List<Empresa> filtrarEmpresasPorTipoDiscapacidad(List<Empresa> lista, String tipo) {
        List<Empresa> resultado = new ArrayList<>();
        for (Empresa e : lista) {
            if (e.getTipoDiscapacidadAceptada().equalsIgnoreCase(tipo)) {
                resultado.add(e);
            }
        }
        return resultado;
    }

    private List<Empresa> filtrarEmpresasConPrestacionDeLey(List<Empresa> lista, boolean requiere) {
        List<Empresa> resultado = new ArrayList<>();
        for (Empresa e : lista) {
            if (e.isPrestacionDeLey() == requiere) {
                resultado.add(e);
            }
        }
        return resultado;
    }

    private List<Empresa> filtrarEmpresasPorLugar(List<Empresa> lista, String lugar) {
        List<Empresa> resultado = new ArrayList<>();
        for (Empresa e : lista) {
            if (e.getLugar().equalsIgnoreCase(lugar)) {
                resultado.add(e);
            }
        }
        return resultado;
    }

    private String mostrarEmpresas(List<Empresa> empresas) {
        if (empresas.isEmpty()) {
            return "No se encontraron empresas con los criterios dados.\n";
        } else {
            StringBuilder sb = new StringBuilder();
            for (Empresa e : empresas) {
                sb.append("----------------------------------------\n");
                sb.append("Empresa: ").append(e.getNombreEmpresa()).append("\n");
                sb.append("Discapacidad aceptada: ").append(e.getTipoDiscapacidadAceptada()).append("\n");
                sb.append("Horas requeridas: ").append(e.getHorasRequeridas()).append("\n");
                sb.append("Días: ").append(e.getDias()).append("\n");
                sb.append("Ascensos: ").append(e.isAscensos() ? "Sí" : "No").append("\n");
                sb.append("Puesto: ").append(e.getPuesto()).append("\n");
                sb.append("Salario: ").append(e.getSalario()).append("\n");
                sb.append("Lugar: ").append(e.getLugar()).append("\n");
                sb.append("Prestación de ley: ").append(e.isPrestacionDeLey() ? "Sí" : "No").append("\n");
            }
            return sb.toString();
        }
    }
}
