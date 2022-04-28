# new feature
# Tags: optional
# language: es

Característica: Correo para cliente
  Yo como comensal
  Requiero que me envien la información de mi pedido al correo
  Para tener la información de mi pedido almacenada

  Antecedentes: Recurso web para el envio de correo a cliente
    Dado que accedo al recurso web de los servicios para recibir un correo como cliente

  @manual
  @manual-result:passed
  @manual-last-tested:Sprint-1
  @manual-test-evidence:[Pedido_Creado]https://drive.google.com/drive/folders/1wy8uHWs8adFFuao14v1TU7akVa6K550K?usp=sharing
  Escenario: Correo de creacion de pedido enviado a cliente exitosamente
    Cuando realizo una peticion exitosa de mi pedido
    Entonces observo en mi correo un nuevo mensaje sobre el pedido

  @manual
  @manual-result:passed
  @manual-last-tested:Sprint-1
  @manual-test-evidence:[Pedido_Modificado]https://drive.google.com/drive/folders/1tWH7KGJXTH58b09BFvD1PhZPPV3J0p9j?usp=sharing
  Escenario: Correo de modificacion de pedido a cliente enviado exitosamente
    Cuando realizo una peticion exitosa con la actualizacion de mi pedido
    Entonces observo en mi correo un nuevo mensaje sobre mi pedido modificado

  @manual
  @manual-result:passed
  @manual-last-tested:Sprint-1
  @manual-test-evidence:[Pedido_Cancelado]https://drive.google.com/drive/folders/1yL5QwMhnp3rln6VbFzBhwhqYeHNSDx4h?usp=sharing
  Escenario: Correo de cancelacion de pedido a cliente enviado exitosamente
    Cuando realizo una peticion exitosa cancelando mi pedido
    Entonces observo en mi correo un nuevo mensaje sobre mi pedido cancelado






