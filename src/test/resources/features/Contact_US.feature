Feature: Página de Contacto de WebDrive Utility

  Scenario: Validar Envio correcto
    Given Yo entro al apartado de Contacto
    When Entro mi nombre
    And Entro mi apellido
    And Entro mi correo
    And Entro un comentario
    And Hago click al boton de enviar
    Then Deberia Presentarme un mensaje de que fue enviado correctamente.
