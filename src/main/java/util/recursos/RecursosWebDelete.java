package util.recursos;

public enum RecursosWebDelete implements ReemplazarParametro {
    DELETE_RESERVA("/api/reserva/{id}");

    private final String valor;

    RecursosWebDelete(String valor) {
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
