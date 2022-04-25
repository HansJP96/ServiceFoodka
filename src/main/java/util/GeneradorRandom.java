package util;

import com.github.javafaker.Faker;
import models.Cliente;
import models.Reserva;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class GeneradorRandom {

    private static final List<Horas> HORAS = List.of(Horas.values());
    private static final int TAMANO_HORAS = HORAS.size();
    private static final Faker faker = new Faker();

    private GeneradorRandom() {
    }

    public static String crearReservaRandom() {
        SimpleDateFormat patronFecha = new SimpleDateFormat("dd/MM/yyyy");
        Cliente cliente = new Cliente();
        cliente.setNombre(faker.name().firstName());
        cliente.setApellido(faker.name().lastName());
        cliente.setEmail(faker.internet().safeEmailAddress());

        Reserva reserva = new Reserva();
        reserva.setCliente(cliente);
        reserva.setDia(patronFecha.format(faker.date().future(150, TimeUnit.DAYS)));
        reserva.setHora(HORAS.get(faker.random().nextInt(TAMANO_HORAS)).obtenerValor());
        reserva.setMensaje(faker.lorem().paragraph());
        return reserva.toJson();
    }
    public static String idRandom() {
        return faker.idNumber().invalid();
    }
}