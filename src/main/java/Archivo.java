public class Archivo implements Comparable<archivo> {
    private String nombre;
    private String ruta;

    public Archivo(String nombre, String ruta) {
        this.nombre = nombre;
        this.ruta = ruta;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRuta() {
        return ruta;
    }

    @Override
    public int compareTo(archivo o) {
        return this.nombre.compareTo(o.getNombre());
    }

    @Override
    public String toString() {
        return nombre + " - " + ruta;
    }
}
