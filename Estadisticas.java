import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.io.File;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.JFreeChart;

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

        // === NUEVO: generar gráfica con los filtros aplicados ===
        if (!filtradas.isEmpty()) {
            String mensajeGrafica = generarGraficaConteoPorPuesto(filtradas, tipo, lugar, "graficas/empresas_conteo_puesto.png");
            resultado.append("\n").append(mensajeGrafica).append("\n");
        } else {
            resultado.append("\nNo se generó gráfica porque no hay datos con esos filtros.\n");
        }

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

    // ========= NUEVO: método para generar la gráfica =========
    private String generarGraficaConteoPorPuesto(List<Empresa> empresas, String tipo, String lugar, String salidaRuta) {
        // Conteo por puesto con for simple (sin streams)
        Map<String, Integer> conteo = new HashMap<>();
        for (Empresa e : empresas) {
            String p = e.getPuesto();
            if (!conteo.containsKey(p)) {
                conteo.put(p, 0);
            }
            conteo.put(p, conteo.get(p) + 1);
        }

        if (conteo.isEmpty()) {
            return "No hay datos para graficar.";
        }

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (Map.Entry<String, Integer> entry : conteo.entrySet()) {
            dataset.addValue(entry.getValue(), "Ofertas", entry.getKey());
        }

        String titulo = "Ofertas por Puesto";
        if (tipo != null && !tipo.isBlank()) {
            titulo += " | Tipo: " + tipo;
        }
        if (lugar != null && !lugar.isBlank()) {
            titulo += " | Lugar: " + lugar;
        }

        JFreeChart chart = ChartFactory.createBarChart(
                titulo,
                "Puesto",
                "Cantidad de Ofertas",
                dataset
        );

        try {
            File out = new File(salidaRuta);
            File carpeta = out.getParentFile();
            if (carpeta != null && !carpeta.exists()) {
                carpeta.mkdirs();
            }
            ChartUtils.saveChartAsPNG(out, chart, 1100, 600);
            return "Gráfica generada: " + out.getAbsolutePath();
        } catch (Exception ex) {
            return "Error al generar la gráfica: " + ex.getMessage();
        }
    }
}

