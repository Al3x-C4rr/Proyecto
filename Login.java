public class Login {
    private String nombreUsuario;
    private String contrasena;
    public Login(){
        this.nombreUsuario = "";
        this.contrasena = "";
    }

    public Login(String nombreUsuario, String contrasena) {
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }
}
