import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IndexadorArchivos {

    private List<Archivo> archivos = new ArrayList<>();

    public void indexarDirectorio(String rutaDirectorio) {
        File directorio = new File(rutaDirectorio);
        File[] archivosEnDirectorio = directorio.listFiles();
        if (archivosEnDirectorio != null) {
            for (File Archivo : archivosEnDirectorio) {
                if (Archivo.isFile()) {
                    archivos.add(new Archivo(Archivo.getName(), Archivo.getAbsolutePath()));
                } else if (Archivo.isDirectory()) {
                    indexarDirectorio(Archivo.getAbsolutePath());
                }
            }
        }
    }

    public void mostrarArchivosOrdenados() {
        Collections.sort(archivos);
        for (archivo archivo : archivos) {
            System.out.println(archivo);
        }
    }

    public static void main(String[] args) {
        IndexadorArchivos indexador = new IndexadorArchivos();
        indexador.indexarDirectorio("/Users/adrianareyesmorera/Desktop/VentasPersonas.txt");
        indexador.mostrarArchivosOrdenados();
    }
}
