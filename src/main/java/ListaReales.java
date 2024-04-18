public class ListaReales extends Lista<Double> {
    public ListaReales() {
        super();
    }

    public void add(Double real) {
        super.add(real);
    }

    public double sumatorio() {
        double sum = 0;
        for (Double real : this.getLista()) {
            sum += real;
        }
        return sum;
    }
}