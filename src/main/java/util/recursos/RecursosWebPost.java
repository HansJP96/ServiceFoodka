package util.recursos;

public enum RecursosWebPost  implements ReemplazarParametro{
    POST_CREAR_RESERVA("/api/reserva");

    private final String valor;

    RecursosWebPost(String valor) {
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
