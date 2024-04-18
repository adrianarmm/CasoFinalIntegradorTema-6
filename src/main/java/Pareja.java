import java.util.Objects;

public class Pareja<T extends Comparable<T>> implements Comparable<Pareja<T>> {
    private T primero;
    private T segundo;

    public Pareja(T primero, T segundo) {
        this.primero = primero;
        this.segundo = segundo;
    }

    public T getPrimero() {
        return primero;
    }

    public T getSegundo() {
        return segundo;
    }

    @Override
    public int compareTo(Pareja<T> o) {
        int cmp = this.primero.compareTo(o.primero);
        if (cmp == 0) {
            cmp = this.segundo.compareTo(o.segundo);
        }
        return cmp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pareja)) return false;
        Pareja<? extends T> pareja = (Pareja<? extends T>) o;
        return Objects.equals(getPrimero(), pareja.getPrimero()) &&
                Objects.equals(getSegundo(), pareja.getSegundo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPrimero(), getSegundo());
    }
}