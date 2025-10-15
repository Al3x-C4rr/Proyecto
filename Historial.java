import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HistorialDeBusquedaEmpleo {
    
    private int idHistorial;
    private Candidato candidato;o
    private List<String> empresasConsultadas;
    private List<String> ofertasAplicadas;
    private Date fechaRegistro;
    
    public HistorialDeBusquedaEmpleo(int idHistorial, Candidato candidato) {
        this.idHistorial = idHistorial;
        this.candidato = candidato;
        this.empresasConsultadas = new ArrayList<>();
        this.ofertasAplicadas = new ArrayList<>();
        this.fechaRegistro = new Date();
    }
    
    public void agregarEmpresaConsultada(String empresa) {
        empresasConsultadas.add(empresa);
    }
    
    public void agregarOfertaAplicada(String oferta) {
        ofertasAplicadas.add(oferta);
    }
    

    public int getIdHistorial() {
        return idHistorial;
    }
    
    public Candidato getCandidato() {
        return candidato;
    }
    
    public List<String> getEmpresasConsultadas() {
        return empresasConsultadas;
    }
    
    public List<String> getOfertasAplicadas() {
        return ofertasAplicadas;
    }
    
    public Date getFechaRegistro() {
        return fechaRegistro;
    }
    
    public String getNombreCandidato() {
        return candidato.getNombre();
    }

    public int getEdadCandidato() {
        return candidato.getEdad();
    }

    public String getDiscapacidadCandidato() {
        return candidato.getDiscapacidad();
    }

    public String getGeneroCandidato() {
        return candidato.getGenero();
    }

    public String toString() {
        return "HistorialDeBusquedaEmpleo{" +
               "idHistorial=" + idHistorial +
               ", candidato=" + candidato +
               ", empresasConsultadas=" + empresasConsultadas +
               ", ofertasAplicadas=" + ofertasAplicadas +
               ", fechaRegistro=" + fechaRegistro +
               '}';
    }
}

