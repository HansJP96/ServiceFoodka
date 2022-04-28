package com.foodka.stepdefinitions.reservas;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

public class CorreoComoAdministradorStepDefinition {

    @Dado("que accedo al recurso web de los servicios para recibir un correo como administrador")
    public void queAccedoAlRecursoWebDeLosServiciosParaRecibirUnCorreoComoAdministrador() {
    }
    @Cuando("el cliente hace una peticion para confirmar su pedido")
    public void elClienteHaceUnaPeticionParaConfirmarSuPedido() {
    }
    @Entonces("observo en mi correo un nuevo mensaje sobre el pedido a procesar")
    public void observoEnMiCorreoUnNuevoMensajeSobreElPedidoAProcesar() {
    }

    @Cuando("el cliente hace una peticion para confirmar la actualizacion de su pedido")
    public void elClienteHaceUnaPeticionParaConfirmarLaActualizacionDeSuPedido() {
    }
    @Entonces("observo en mi correo un nuevo mensaje sobre el pedido modificado")
    public void observoEnMiCorreoUnNuevoMensajeSobreElPedidoModificado() {
    }

    @Cuando("el cliente hace una peticion para confirmar la cancelacion de su pedido")
    public void elClienteHaceUnaPeticionParaConfirmarLaCancelacionDeSuPedido() {
    }
    @Entonces("observo en mi correo un nuevo mensaje sobre el pedido cancelado")
    public void observoEnMiCorreoUnNuevoMensajeSobreElPedidoCancelado() {
    }
}
