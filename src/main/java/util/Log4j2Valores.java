package util;

public enum Log4j2Valores {
    LOG4J_PROPERTIES_FILE_PATH("\\src\\main\\resources\\log4j.properties"),
    LOG4J_LINUX_PROPERTIES_FILE_PATH("/src/main/resources/log4j.properties"),
    USER_DIR(System.getProperty("user.dir"));

    private final String valor;

    Log4j2Valores(String valor) {
        this.valor = valor;
    }

    public String obtenerValor() {
        return valor;
    }
}
