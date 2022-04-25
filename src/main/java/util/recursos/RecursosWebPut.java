package util.recursos;

public enum RecursosWebPut implements ReemplazarParametro {
    PUT_MODIFICAR_RESERVA("/api/reserva/{id}");

    private final String valor;

    RecursosWebPut(String valor) {
        this.valor = valor;
    }

    public String obtenerValor() {
        return valor;
    }

    @Override
    public String reemplazarParametro(String parametro) {
        return sustituirTexto(valor,parametro);
    }
}
