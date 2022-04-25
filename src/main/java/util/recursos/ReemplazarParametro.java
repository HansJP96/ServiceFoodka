package util.recursos;

import java.util.regex.Pattern;

public interface ReemplazarParametro {

    String reemplazarParametro(String parametro);

    default String sustituirTexto(String valor,String parametro) {
        String regex = "\\{(\\w+)+}";
        return valor.replaceFirst(Pattern.compile(regex, Pattern.CASE_INSENSITIVE).pattern(), parametro);
    }
}
