public class Candidato {
    private String genero;
    private String discapacidad;
    private String experiencia;
    private String estadoCivil;
    private int edad;
    private Empresa empresa; 

    public Candidato(){
        this.genero = "";
        this.discapacidad = "";
        this.experiencia = "";
        this.estadoCivil = "";
        this.edad = 0;
    }

    public void completarPerfil(String genero, String discapacidad, String experiencia, String estadoCivil, int edad) {
        this.genero = genero;
        this.discapacidad = discapacidad;
        this.experiencia = experiencia;
        this.estadoCivil = estadoCivil;
        this.edad = edad;
    }

    public void buscarEmpresas(List<Empresa> empresas) {
        System.out.println("Empresas que coinciden con tu perfil:");
        for (Empresa empresa : empresas) {
            if (empresa.aceptaCandidato(this)) {
                System.out.println("- " + empresa.getNombre());
            }
        }
    }

    public String getGenero() {
        return genero;
    }

    public String getDiscapacidad() {
        return discapacidad;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public int getEdad() {
        return edad;
    }
}
