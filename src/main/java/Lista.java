import java.util.ArrayList;
import java.util.List;

public class Lista<T> {
    private List<T> lista;

    public Lista() {
        this.lista = new ArrayList<>();
    }

    public void add(T elemento) {
        this.lista.add(elemento);
    }

    public T get(int indice) {
        return this.lista.get(indice);
    }

    public int size() {
        return this.lista.size();
    }

    public List<T> getLista() {
        return this.lista;
    }
}