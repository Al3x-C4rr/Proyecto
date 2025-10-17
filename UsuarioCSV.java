import java.io.*;

public class UsuarioCSV {
    private static final String ARCHIVO = "usuarios.csv";

    public static void guardarUsuario(Login usuario) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO, true))) {
            writer.write(usuario.getNombreUsuario() + "," + usuario.getContrasena());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("❌ Error al guardar el usuario: " + e.getMessage());
        }
    }

    public static boolean validarLogin(String usuarioIngresado, String contraIngresada) {
        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO))) {
            String linea;

            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 2) {
                    String usuarioArchivo = partes[0];
                    String contraArchivo = partes[1];

                    if (usuarioArchivo.equals(usuarioIngresado) && contraArchivo.equals(contraIngresada)) {
                        return true;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("❌ Error al leer el archivo: " + e.getMessage());
        }

        return false;
    }
}