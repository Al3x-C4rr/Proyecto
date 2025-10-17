import java.io.*;
import java.util.*;

public class EmpresaCSV {
    private static final String ARCHIVO = "DatosEmpresas.csv";

    // Guarda una lista de empresas en el archivo CSV
    public static void guardarEmpresas(List<Empresa> empresas) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(ARCHIVO))) {
            // Escribir encabezado
            writer.println("nombreEmpresa,tipoDiscapacidadAceptada,horasRequeridas,dias,ascensos,puesto,salario,lugar,prestacionDeLey");

            // Escribir datos
            for (Empresa e : empresas) {
                writer.println(String.join(",",
                        e.getNombreEmpresa(),
                        e.getTipoDiscapacidadAceptada(),
                        String.valueOf(e.getHorasRequeridas()),
                        e.getDias(),
                        String.valueOf(e.isAscensos()),
                        e.getPuesto(),
                        String.valueOf(e.getSalario()),
                        e.getLugar(),
                        String.valueOf(e.isPrestacionDeLey())
                ));
            }

            System.out.println("Datos guardados correctamente en " + ARCHIVO);
        } catch (IOException ex) {
            System.out.println("Error al guardar el archivo CSV: " + ex.getMessage());
        }
    }

    // Lee las empresas desde el archivo CSV y las devuelve como una lista
    public static List<Empresa> cargarEmpresas() {
        List<Empresa> empresas = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO))) {
            String linea;
            reader.readLine(); // Saltar encabezado

            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");

                if (datos.length == 9) {
                    Empresa e = new Empresa(
                            datos[0],                      // nombreEmpresa
                            datos[1],                      // tipoDiscapacidadAceptada
                            Integer.parseInt(datos[2]),    // horasRequeridas
                            datos[3],                      // dias
                            Boolean.parseBoolean(datos[4]),// ascensos
                            datos[5],                      // puesto
                            Double.parseDouble(datos[6]),  // salario
                            datos[7],                      // lugar
                            Boolean.parseBoolean(datos[8]) // prestacionDeLey
                    );
                    empresas.add(e);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo CSV. Se creará uno nuevo al guardar.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo CSV: " + e.getMessage());
        }

        return empresas;
    }
}
