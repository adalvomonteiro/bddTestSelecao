$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/Features/tricentis.feature");
formatter.feature({
  "name": "Formulario Tricentis",
  "description": "  Como o usuario preenche o Formulario de Cadastro da Tricentis",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Usuario preencher formulario completo com sucesso",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "Usuario preencher todas as informacoes do formulario",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinitions.FormSteps.usuario_preencher_todas_as_informacoes_do_formulario()"
});
formatter.result({
  "error_message": "io.cucumber.java.PendingException: TODO: implement me\r\n\tat StepDefinitions.FormSteps.usuario_preencher_todas_as_informacoes_do_formulario(FormSteps.java:14)\r\n\tat ✽.Usuario preencher todas as informacoes do formulario(file:///C:/Users/Adalvo/eclipse-workspace/CucumberJava/src/test/resources/Features/tricentis.feature:5)\r\n",
  "status": "pending"
});
formatter.step({
  "name": "Usuario acessar a url do formulario",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinitions.FormSteps.usuario_acessar_a_url_do_formulario()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Usuario preencher todos os campos existentes no formulario",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.FormSteps.usuario_preencher_todos_os_campos_existentes_no_formulario()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Usuario clicar no botao enviar",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinitions.FormSteps.usuario_clicar_no_botao_enviar()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Usuario vera a mensagem:Sending e-mail success!",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinitions.FormSteps.usuario_vera_a_mensagem_Sending_e_mail_success()"
});
formatter.result({
  "status": "skipped"
});
});