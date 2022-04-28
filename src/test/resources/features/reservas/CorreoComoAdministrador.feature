# new feature
# Tags: optional
#language: es
Característica: Correo para administrador
  Yo como administrador
  Requiero que me envien la información del pedido de un cliente al correo
  Para tener la información del pedido que hay que entregar

  Antecedentes: Recurso web para el envio de correo al administrador
    Dado que accedo al recurso web de los servicios para recibir un correo como administrador

  @manual
  @manual-result:passed
  @manual-last-tested:Sprint-1
  @manual-test-evidence:[Pedido_Creado]https://drive.google.com/drive/folders/1JZXnD3BvzNMX58eBMTZnJMOZktTUrpq1?usp=sharing
  Escenario: Correo de creacion de pedido enviado al administrador exitosamente
  Cuando el cliente hace una peticion para confirmar su pedido
  Entonces observo en mi correo un nuevo mensaje sobre el pedido a procesar

  @manual
  @manual-result:passed
  @manual-last-tested:Sprint-1
  @manual-test-evidence:[Pedido_Modificado]https://drive.google.com/drive/folders/180f1Y6wbqwtZZKC4MG1ZeBYX6UcsPIxl?usp=sharing
  Escenario: Correo de modificacion de pedido al administrador enviado exitosamente
    Cuando el cliente hace una peticion para confirmar la actualizacion de su pedido
    Entonces observo en mi correo un nuevo mensaje sobre el pedido modificado

  @manual
  @manual-result:passed
  @manual-last-tested:Sprint-1
  @manual-test-evidence:[Pedido_Cancelado]https://drive.google.com/drive/folders/1blAgbOsqJWG3RIrAdeEuD4bmL-QgVhox?usp=sharing
  Escenario: Correo de cancelacion de pedido al administrador enviado exitosamente
    Cuando el cliente hace una peticion para confirmar la cancelacion de su pedido
    Entonces observo en mi correo un nuevo mensaje sobre el pedido cancelado