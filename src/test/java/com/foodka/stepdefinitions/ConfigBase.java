package com.foodka.stepdefinitions;

import org.apache.log4j.PropertyConfigurator;

import java.util.Locale;

import static util.Log4j2Valores.*;

public class ConfigBase {
    protected static final String SERVICIOS_BASE_FOODKA = "https://app-restaurante-back-qa.herokuapp.com";

    protected void configGeneral() {
        configLog4j2();
    }

    private void configLog4j2() {
        String os = System.getProperty("os.name").toLowerCase(Locale.ROOT).substring(0, 3);
        switch (os) {
            case "win":
                PropertyConfigurator.configure(USER_DIR.obtenerValor().concat(LOG4J_PROPERTIES_FILE_PATH.obtenerValor()));
                break;

            case "lin":
                PropertyConfigurator.configure(USER_DIR.obtenerValor().concat(LOG4J_LINUX_PROPERTIES_FILE_PATH.obtenerValor()));
                break;
        }
    }

}
