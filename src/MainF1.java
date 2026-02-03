import java.io.*;
import java.util.*;

public class MainF1 {
    //Mapa, guardar el nombre y los datos de este
    private static Map<String, Piloto> mapaPilotos = new HashMap<>();

    //Método cargar pilotos --> leer los valores del fichero
    public static void cargarPilotos() {
        try (BufferedReader br = new BufferedReader(new FileReader("pilotos_f1.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(";"); //Dividir en un array para cada piloto
                if (partes.length == 3) { //Asegurarse que son tres cachos
                    String nombre = partes[0].trim();
                    String esc = partes[1].trim();
                    int puntuacion = Integer.parseInt(partes[2].trim()); //Usar ParseInt para guardar el número
                    mapaPilotos.put(nombre, new Piloto(nombre, esc, puntuacion)); //Introducir los datos en el mapa --> Nombre como clave
                }
            }
        } catch (IOException e) {
            System.out.println("Error de lectura del archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: Número no válido en el archivo.");
        }
    }

    //Método para mostrar los datos de los pilotos
    public static void mostrarPilotos() {
        System.out.println("\n---PILOTOS---");
        for (Map.Entry<String, Piloto> entry : mapaPilotos.entrySet()) {
            String nombre = entry.getKey();
            Piloto datos = entry.getValue();
            System.out.println("Piloto: " + nombre + " ||" + datos.toString());
        }
    }

    //Método para agregar un piloto
    public static void agregarPiloto() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa el nombre del piloto: ");
        String nombre = sc.nextLine();

        if (mapaPilotos.containsKey(nombre)) {
            System.out.println("El piloto ya existe");
        } else {
            System.out.println("Introduce la escudería: ");
            String esc = sc.nextLine();

            System.out.println("Introduce la puntuación: ");
            int pts = Integer.parseInt(sc.nextLine());

            mapaPilotos.put(nombre, new Piloto(nombre, esc, pts));
        }
    }
    //Método para buscar un piloto y mostrar su información
   public static void buscarPiloto() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa el nombre del piloto que busca: ");
        String nombre = sc.nextLine();
        if (mapaPilotos.containsKey(nombre)) {
            System.out.println("El piloto " + nombre + " existe.");
            System.out.println(nombre + " --> " + mapaPilotos.get(nombre).toString()); //Mostrar los datos con el toString
        } else {
            System.out.println("El piloto " + nombre + " no existe.");
        }
    }

    //Método para guardar los pilotos nuevos en el archivo
    public static void guardarPilotos() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("pilotos_f1.txt"))) {
            for (Map.Entry<String, Piloto> entry : mapaPilotos.entrySet()) {
                String nombre = entry.getKey();
                Piloto datos = entry.getValue();
                writer.write(nombre + ";" + datos.getEscuderia() + ";" + datos.getPuntos()); //Getters SOLO para escudería y puntuación
                writer.newLine();
            }
            System.out.println("Datos guardados.");

        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        cargarPilotos();
        int menu;
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("\nIngresa una opción del menu: ");
            System.out.println("1. Agregar Piloto.");
            System.out.println("2. Buscar Piloto.");
            System.out.println("3. Mostrar Pilotos.");
            System.out.println("4. Guardar nuevos pilotos.");
            System.out.println("0. Salir.");
            menu = sc.nextInt();
            switch (menu) {
                case 1:
                    agregarPiloto();
                    break;
                case 2:
                    buscarPiloto();
                    break;
                case 3:
                    mostrarPilotos();
                    break;
                case 4:
                    guardarPilotos();
                    break;
                case 0:
                    System.out.println("Salir.");
                    sc.close();
                    break;
                default:
                    System.out.println("Opción no correcta");
                    break;
            }
        } while (menu != 0);
    }
}




