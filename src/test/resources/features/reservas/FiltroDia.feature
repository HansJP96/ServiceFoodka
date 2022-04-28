# new feature
# Tags: optional
# language: es

Característica: Obtener fecha con horas ocupadas
  Yo como comensal
  Requiero ver que horarios hay disponibles
  Para poder agendar correctamente mi reserva

  Escenario: Listar horas ocupadas de un dia especifico
    Dado que accede al recurso web que proporciona las horas ocupadas
    Cuando realizo la peticion para escoger la hora de un dia seleccionado
    Entonces observo que existen horarios seleccionados para ese dia