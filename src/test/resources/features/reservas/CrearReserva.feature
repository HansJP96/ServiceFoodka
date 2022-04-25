# new feature
# Tags: optional
# language:es
Característica: Crear nueva reserva
  Yo como comensal
  Requiero tener acceso al recurso de las reservas
  Para poder crear una nueva reserva

  Antecedentes: Acceso al recurso base de la pagina
    Dado que accedo al recurso web de los servicios para crear reserva

  Escenario: Creacion de reserva exitosa
    Cuando hago una peticion para crear una nueva reserva
    Entonces observo que los datos de mi reserva han sido creados