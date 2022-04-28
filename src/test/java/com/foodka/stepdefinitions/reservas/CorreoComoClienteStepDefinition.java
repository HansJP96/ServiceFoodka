package com.foodka.stepdefinitions.reservas;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

public class CorreoComoClienteStepDefinition {
    @Dado("que accedo al recurso web de los servicios para recibir un correo como cliente")
    public void queAccedoAlRecursoWebDeLosServiciosParaRecibirUnCorreoComoCliente() {
    }
    @Cuando("realizo una peticion exitosa de mi pedido")
    public void realizoUnaPeticionExitosaDeMiPedido() {
    }
    @Entonces("observo en mi correo un nuevo mensaje sobre el pedido")
    public void observoEnMiCorreoUnNuevoMensajeSobreElPedido() {
    }

    @Cuando("realizo una peticion exitosa con la actualizacion de mi pedido")
    public void realizoUnaPeticionExitosaConLaActualizacionDeMiPedido() {
    }
    @Entonces("observo en mi correo un nuevo mensaje sobre mi pedido modificado")
    public void observoEnMiCorreoUnNuevoMensajeSobreMiPedidoModificado() {
    }

    @Cuando("realizo una peticion exitosa cancelando mi pedido")
    public void realizoUnaPeticionExitosaCancelandoMiPedido() {
    }
    @Entonces("observo en mi correo un nuevo mensaje sobre mi pedido cancelado")
    public void observoEnMiCorreoUnNuevoMensajeSobreMiPedidoCancelado() {
    }
}
