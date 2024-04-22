public class Archivo implements Comparable<ArchivoS> {
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
    public int compareTo(ArchivoS o) {
        return this.nombre.compareTo(o.getNombre());
    }

    @Override
    public String toString() {
        return nombre + " - " + ruta;
    }
}
