public class Pareja<T, U> {
    private T clave;
    private U valor;

    public Pareja(T clave, U valor) {
        this.clave = clave;
        this.valor = valor;
    }

    public T getClave() {
        return clave;
    }

    public U getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return "Clave: " + clave + ", Valor: " + valor;
    }



}
