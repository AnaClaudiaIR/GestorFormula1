public class Piloto {
    //Crear la clase con los atributos
    private String nombre;
    private String escuderia;
    private int puntos;

    //Constructor
    public Piloto(String nombre, String escuderia, int puntos) {
        this.nombre = nombre;
        this.escuderia = escuderia;
        this.puntos = puntos;
    }

    //getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEscuderia() {
        return escuderia;
    }

    public void setEscuderia(String escuderia) {
        this.escuderia = escuderia;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    //Método toString para mostrar los atributos del objeto --> Solo mostrar escudería y puntos, el nombre es la clave del map
    public String toString(){
        return " Escudería: " + escuderia + " - Puntos: " + puntos;
    }
}
