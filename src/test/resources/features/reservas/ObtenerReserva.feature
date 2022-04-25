# new feature
# Tags: optional
# language: es

Característica: Obtener reservas
  Yo como comensal
  Quiero tener acceso al recurso de las reservas
  Para obtener la informacion relacionada con la reserva

  Antecedentes: Acceso al recurso base de la pagina
    Dado que accedo al recurso web de los servicios

  Escenario: Consulta de reserva exitosa
    Cuando hago una peticion para consultar una reserva existente
    Entonces recibo la informacion de la reserva

  Escenario: Consulta de reserva inexistente
    Cuando hago una peticion para consultar una reserva inexistente
    Entonces no recibo informacion alguna y obtengo una respuesta acorde

