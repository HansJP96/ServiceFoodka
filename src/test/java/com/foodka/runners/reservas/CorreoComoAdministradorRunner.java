package com.foodka.runners.reservas;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/reservas/CorreoComoAdministrador.feature"},
        glue = "com.foodka.stepdefinitions.reservas",
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class CorreoComoAdministradorRunner {
}
