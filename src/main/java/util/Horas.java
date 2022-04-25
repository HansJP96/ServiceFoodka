package util;

public enum Horas {
    DOCE("12:00"),
    DOS("02:00"),
    CUATRO("04:00"),
    SEIS("06:00"),
    OCHO("08:00"),
    DIEZ("10:00");

    private final String valor;

    Horas(String valor) {
        this.valor = valor;
    }

    public String obtenerValor() {
        return valor;
    }
}
