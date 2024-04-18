public class ListaParesEnteros extends Lista<Pareja<Integer>> {
    public ListaParesEnteros() {
        super();
    }

    public void add(int a, int b) {
        super.add(new Pareja<>(a, b));
    }

    public int minPrimero() {
        int min = Integer.MAX_VALUE;
        for (Pareja<Integer> pareja : this.getLista()) {
            min = Math.min(min, pareja.getPrimero());
        }
        return min;
    }
}