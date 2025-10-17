import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
    int opc, s, f;
    s=0;
    boolean val;
    String a, b, c,d;
    Scanner teclado = new Scanner(System.in);
        List<Empresa> empresas = EmpresaCSV.cargarEmpresas();
        Estadisticas resultados = new Estadisticas();
        List<Candidato> candidatos =Historial.cargarHistorial();
        while(s==0){
        System.out.println("1.Inciar Sesion\n2.Registrarse");
        opc= teclado.nextInt();
        teclado.nextLine();
        switch(opc){
            case 1 -> {
                System.out.print("===============Inicio de sesion==============");
                System.out.print("Usuario: ");
                a=teclado.nextLine();
                System.out.print("Contrasena: ");
                b=teclado.nextLine();
                val=UsuarioCSV.validarLogin(a,b);
                if(val){
                    System.out.println("Bienvenido");
                    s=1;
                } else{
                    System.out.println("Usuario/Contrasena incorrecta");
                }
            }
                default -> System.out.println("Invalido");

            case 2 -> {
                System.out.print("===============Registro==============");
                System.out.print("Usuario: ");
                a=teclado.nextLine();
                System.out.print("Contrasena: ");
                b=teclado.nextLine();
                Login log= new Login(a,b);
                UsuarioCSV.guardarUsuario(log);
            }
        }
    }
    s=0;
    while(s==0){
    System.out.println("1.Estadisticas\n2.Empresas\n3.Buscar empleo\n4.Historial\n5.Terminar");
    opc= teclado.nextInt();
    teclado.nextLine();
         if (empresas.isEmpty()) {
            empresas.add(new Empresa("TechVision", "Visual", 40, "L-V", true, "Desarrollador de Software", 8500.00, "Ciudad de Guatemala", true));
            empresas.add(new Empresa("AudioPlus", "Auditiva", 35, "L-S", false, "Diseñador Gráfico", 7200.00, "Antigua Guatemala", true));
            empresas.add(new Empresa("MotrizCorp", "Motriz", 45, "L-V", true, "Asistente Administrativo", 6800.00, "Mixco", true));
            EmpresaCSV.guardarEmpresas(empresas);
        }
        switch (opc) {
            case 1 -> {
                System.out.println("Tipo de discapacidad");
                a=teclado.nextLine();
                System.out.println("Tiene presatación de Ley?");
                b=teclado.nextLine();
                System.out.println("Lugar");
                c=teclado.nextLine();
                resultados.ResultadosFiltrado(a,b,c);
            }
            case 2 -> {
                System.out.println("\n=== EMPRESAS REGISTRADAS ===");
                for (Empresa e : empresas) {
                    e.mostrarOfertas();}
            }
            case 3 -> {
                System.out.print("Género (Masculino/Femenino/Otro): ");
                a = teclado.nextLine();
                
                System.out.print("¿Tiene alguna discapacidad? (Sí/No): ");
                b = teclado.nextLine();
                
                System.out.print("¿Tiene experiencia laboral? (Sí/No): ");
                c = teclado.nextLine();
                
                System.out.print("Estado civil (Soltero/Casado/Divorciado): ");
                d = teclado.nextLine();
                
                System.out.print("Edad: ");
                f = teclado.nextInt();
                teclado.nextLine();
                
                Candidato nuevo = new Candidato(a, b, c, d, f);
                candidatos.add(nuevo);
                Historial.guardarCandidato(candidatos);
            }
            case 4 -> System.out.println(Historial.cargarHistorial());
            case 5 -> s=1;
                
        }
    }
    }
}
