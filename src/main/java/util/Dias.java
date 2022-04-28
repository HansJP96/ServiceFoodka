package util;

public enum Dias {
    DIA1("2/2/2022"),
    DIA2("3/24/2022"),
    DIA3("4/11/2022"),
    DIA4("5/1/2022");

    private final String valor;

    Dias(String valor) {
        this.valor = valor;
    }

    public String obtenerValor() {
        return valor;
    }
}
