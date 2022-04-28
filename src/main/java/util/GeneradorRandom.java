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
    private static final List<IdDefinidos> IDS = List.of(IdDefinidos.values());
    private static final int TAMANO_IDS = IDS.size();
    private static final List<Dias> DIAS = List.of(Dias.values());
    private static final int TAMANO_DIAS = DIAS.size();
    private static final Faker faker = new Faker();

    private GeneradorRandom() {
    }

    public static String idDefinidoRandom() {
        return IDS.get(faker.random().nextInt(TAMANO_IDS)).obtenerValor();
    }

    public static String idRandom() {
        return faker.idNumber().invalid();
    }

    public static String diaRandom(){
        SimpleDateFormat patronFecha = new SimpleDateFormat("M/d/yyyy");
        return patronFecha.format(faker.date().future(150, TimeUnit.DAYS));
    }

    public static String diaDefinidoRandom(){
        return DIAS.get(faker.random().nextInt(TAMANO_DIAS)).obtenerValor();
    }

    public static String horaRandom() {
        return HORAS.get(faker.random().nextInt(TAMANO_HORAS)).obtenerValor();
    }

    public static String mensajeRandom() {
        return faker.food().dish() + " " + faker.food().fruit() + " " + faker.food().vegetable();
    }

    public static String crearReservaRandom() {
        Cliente cliente = new Cliente();
        cliente.setNombre(faker.name().firstName());
        cliente.setApellido(faker.name().lastName());
        cliente.setEmail(faker.internet().safeEmailAddress());

        Reserva reserva = new Reserva();
        reserva.setCliente(cliente);
        reserva.setDia(diaRandom());
        reserva.setHora(horaRandom());
        reserva.setTelefono(faker.number().digits(10));
        reserva.setCantidadPersonas(faker.number().numberBetween(1,10));
        reserva.setMensaje(mensajeRandom());
        return reserva.toJson();
    }

    public static String crearReservaRandomConId() {
        Cliente cliente = new Cliente();
        cliente.setNombre(faker.name().firstName());
        cliente.setApellido(faker.name().lastName());
        cliente.setEmail(faker.internet().safeEmailAddress());

        Reserva reserva = new Reserva();
        reserva.setId("aaaaaaa-a");
        reserva.setCliente(cliente);
        reserva.setDia(diaRandom());
        reserva.setHora(horaRandom());
        reserva.setTelefono(faker.number().digits(10));
        reserva.setCantidadPersonas(faker.number().numberBetween(1,10));
        reserva.setMensaje(mensajeRandom());
        return reserva.toJson();
    }

    public static void main(String[] args) {
        System.out.println(crearReservaRandom());
    }
}
