Feature: Formulario Tricentis
  Como o usuario preenche o Formulario de Cadastro da Tricentis

  Scenario: Usuario preencher formulario completo com sucesso
    Given Usuario preencher todas as informacoes do formulario
    When  Usuario acessar a url do formulario
    And  Usuario preencher todos os campos existentes no formulario
    And   Usuario clicar no botao enviar
    Then Usuario vera a mensagem:Sending e-mail success!
    