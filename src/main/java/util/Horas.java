package util;

public enum Horas {
    DOCE("12:00"),
    DOS("14:00"),
    CUATRO("16:00"),
    SEIS("18:00"),
    OCHO("20:00"),
    DIEZ("22:00");

    private final String valor;

    Horas(String valor) {
        this.valor = valor;
    }

    public String obtenerValor() {
        return valor;
    }
}
