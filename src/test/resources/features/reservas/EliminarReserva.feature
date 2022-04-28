# new feature
# Tags: optional
# language: es
Característica: Eliminar reserva
  Yo como comensal
  Requiero acceder al recurso web de los servicios
  Para poder cancelar una reserva que he hecho

  Antecedentes: Acceso al recurso base de la pagina
    Dado que accedo al recurso web de los servicios para eliminar


  Escenario: Cancelacion de reserva exitosa
    Cuando hago una peticion para cancelar una reserva
    Entonces observo que mi reserva ha sido eliminada

  Escenario: Cancelacion de reserva inexistente
    Cuando hago una peticion para cancelar una reserva que no existe
    Entonces no observo ningun cambio y obtengo una respuesta acorde
