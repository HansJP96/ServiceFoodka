# new feature
# Tags: optional
# language: es

Característica: Modificar informacion de reservas
  Yo como comensal
  Quiero tener acceso al recurso de reservas
  Para poder modificar los datos de mis reservas

  Antecedentes: Acceso al recurso base de la pagina
    Dado que accedo al recurso web de los servicios para modificar

  Escenario: Actualizar datos de reserva exitosamente
    Cuando quiero modificar alguno de los datos de mi reserva
    Entonces obtengo como respuesta mis datos actualizados

  Escenario: Actualizar datos a reserva inexistente
    Cuando quiero modificar alguno de una reserva que no existe
    Entonces no obtengo informacion alguna actualizada
