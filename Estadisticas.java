import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Collectors;

public class Estadisticas {

    private final List<Empresa> empresas;

    public Estadisticas() {
        this.empresas = new ArrayList<>();
    }
    public Estadisticas(List<Empresa> empresas) {
        this.empresas = new ArrayList<>();
        if (empresas != null) {
            this.empresas.addAll(empresas.stream()
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList()));
        }
    }
    public void agregarEmpresa(Empresa empresa) {
        if (empresa != null) {
            this.empresas.add(empresa);
        }
    }
    public void agregarEmpresas(List<Empresa> nuevas) {
        if (nuevas != null) {
            nuevas.stream().filter(Objects::nonNull).forEach(this.empresas::add);
        }
    }
    public List<Empresa> getEmpresas() {
        return Collections.unmodifiableList(empresas);
    }
    public List<Empresa> filtrarEmpresasPorTipoDiscapacidad(String tipo) {
        if (tipo == null || tipo.isBlank()) return List.of();

        final String needle = normalizar(tipo);

        return empresas.stream()
                .filter(Objects::nonNull)
                .filter(e -> {
                    String raw = e.getTipoDiscapacidadAceptada();
                    if (raw == null) return false;
                    String[] partes = raw.split(",");
                    for (String p : partes) {
                        if (normalizar(p).equals(needle)) return true;
                    }
                    return normalizar(raw).contains(needle);
                })
                .collect(Collectors.toList());
    }
    public List<Empresa> filtrarEmpresasConPrestacionDeLey(boolean requierePrestacion) {
        return empresas.stream()
                .filter(Objects::nonNull)
                .filter(e -> e.isPrestacionDeLey() == requierePrestacion)
                .collect(Collectors.toList());
    }

    public List<Empresa> filtrarEmpresasPorLugar(String lugar) {
        if (lugar == null || lugar.isBlank()) return List.of();

        final String needle = normalizar(lugar);

        return empresas.stream()
                .filter(Objects::nonNull)
                .filter(e -> {
                    String l = e.getLugar();
                    return l != null && normalizar(l).contains(needle);
                })
                .collect(Collectors.toList());
    }
    private static String normalizar(String s) {
        return s == null ? "" : s.trim().toLowerCase(Locale.ROOT);
    }
}