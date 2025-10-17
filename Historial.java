import java.io.*;
import java.util.*;

public class Historial {
    private static final String CAN = "Historial.csv";
    public static void guardarCandidato(List<Candidato> candidatos) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(CAN))) {
            writer.println("genero, discapacidad, experiencia,EstadoCivil,edad");
            for (Candidato e : candidatos) {
                writer.println(String.join(",",
                        e.getGenero(),
                        e.getDiscapacidad(),
                        e.getExperiencia(),
                        e.getEstadoCivil(),
                        String.valueOf(e.getEdad())
                ));
            }

            System.out.println("Datos guardados correctamente en " + CAN);
        } catch (IOException ex) {
            System.out.println("Error al guardar el archivo CSV: " + ex.getMessage());
        }
    }

    
    public static List<Candidato> cargarHistorial() {
        List<Candidato> candidatos = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(CAN))) {
            String linea;
            reader.readLine(); // Saltar encabezado

            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");

                if (datos.length == 5) {
                    Candidato e = new Candidato(
                            datos[0],                     
                            datos[1],                     
                            datos[2],                               
                            datos[3],                     
                            Integer.parseInt(datos[4]));
                    candidatos.add(e);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo CSV. Se creará uno nuevo al guardar.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo CSV: " + e.getMessage());
        }

        return candidatos;
    }
}

