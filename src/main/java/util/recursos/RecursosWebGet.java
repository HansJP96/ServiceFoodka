package util.recursos;

public enum RecursosWebGet implements ReemplazarParametro {
    GET_LISTA_RESERVAS("/api/reserva"),
    GET_UNA_RESERVA("/api/reserva/{id}"),
    GET_HORAS_DIA("/api/reserva/findByDia/{dia}");

    private final String valor;

    RecursosWebGet(String valor) {
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
