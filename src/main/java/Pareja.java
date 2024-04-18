import java.util.Objects;

public class Pareja<S, D extends Number> implements Comparable<Pareja<S, Number>> {
    private Comparable primero;
    private Comparable segundo;

    public Pareja(Comparable primero, Comparable segundo) {
        this.primero = primero;
        this.segundo = segundo;
    }

    public Comparable getPrimero() {
        return primero;
    }

    public Comparable getSegundo() {
        return segundo;
    }

    @Override
    public int compareTo(Pareja<S, Number> o) {
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
        Pareja<S, Number> pareja = (Pareja<S, Number>) o;
        return Objects.equals(getPrimero(), pareja.getPrimero()) &&
                Objects.equals(getSegundo(), pareja.getSegundo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPrimero(), getSegundo());
    }

    public double getValor() {
        return ((Number) this.primero).doubleValue() + ((Number) this.segundo).doubleValue();
    }
}