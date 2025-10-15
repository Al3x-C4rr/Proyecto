import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HistorialDeBusquedaEmpleo {

    private int idHistorial;                  
    private int idCandidato;                  
    private List<String> empresasConsultadas; 
    private List<String> ofertasAplicadas;    
    private Date fechaRegistro;

    public HistorialDeBusquedaEmpleo(int idHistorial, int idCandidato) {
        this.idHistorial = idHistorial;
        this.idCandidato = idCandidato;
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
    
    public List<String> getEmpresasConsultadas() {
        return empresasConsultadas;
    }
    
    public List<String> getOfertasAplicadas() {
        return ofertasAplicadas;
    }
    
    public int getIdHistorial() {
        return idHistorial;
    }
    
    public int getIdCandidato() {
        return idCandidato;
    }
    
    public Date getFechaRegistro() {
        return fechaRegistro;
    }
    
    public String toString() {
        return "HistorialDeBusquedaEmpleo{" +
               "idHistorial=" + idHistorial +
               ", idCandidato=" + idCandidato +
               ", empresasConsultadas=" + empresasConsultadas +
               ", ofertasAplicadas=" + ofertasAplicadas +
               ", fechaRegistro=" + fechaRegistro +
               '}';
    }
}
