class Archivos implements Comparable<Archivos> {
    final String nombre;
    private final String ruta;

    public Archivos(String nombre, String ruta) {
        this.nombre = nombre;
        this.ruta = ruta;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Ruta: " + ruta;
    }

    @Override
    public int compareTo(Archivos otroArchivo) {
        return this.nombre.compareTo(otroArchivo.nombre);
    }
}
