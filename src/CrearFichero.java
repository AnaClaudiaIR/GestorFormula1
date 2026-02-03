import java.io.*;
import java.util.Scanner;

public class CrearFichero {
    public static void main(String[] args) throws IOException{
        crearFichero();
    }
    public static void crearFichero(){
        try (BufferedWriter wr = new BufferedWriter(new FileWriter("datos_pilotos.txt",true))) {
            Scanner sc = new Scanner(System.in);
            boolean seguir = true;

            System.out.println("Introduce los datos ('fin' para salir): ");
            while(seguir){
                System.out.print("Introduce el nombre: ");
                String nombre = sc.nextLine();

                if(nombre.equals("fin")){
                    seguir = false;
                    break;
                } else {
                    System.out.println("Introduce la escudería: ");
                    String escuderia = sc.nextLine();
                    System.out.println("Introduce la puntos: ");
                    int puntos = sc.nextInt();
                    sc.nextLine();
                    wr.write(nombre + ";" + escuderia + ";" + puntos);
                    wr.newLine();
                }
            }
            System.out.println("Líneas escritas en el archivo.");
        } catch (IOException e) {
            System.out.println("Error de lectura del fichero: " + e.getMessage());
        }
    }
}
