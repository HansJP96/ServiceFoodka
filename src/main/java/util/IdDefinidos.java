package util;

public enum IdDefinidos {
    PRIMERO("86ae5c8d-d"),
    SEGUNDO("a2037d99-b"),
    TERCERO("ea873ed4-0"),
    CUARTO("66bfe726-0");

    private final String valor;

    IdDefinidos(String valor) {
        this.valor = valor;
    }

    public String obtenerValor() {
        return valor;
    }
}
