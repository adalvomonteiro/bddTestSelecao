package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Action.AutomobileInsuranceAction;
import PageObject.EnterVehicleDataPage;
import Util.SeleniumUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FormSteps  {
	
	WebDriver driver = null;
	EnterVehicleDataPage dadosVeiculo = new EnterVehicleDataPage();
	AutomobileInsuranceAction automobileAction = new AutomobileInsuranceAction();
	

	
	@Given("^Usuario preencher todas as informacoes do formulario$")
	public void usuario_preencher_todas_as_informacoes_do_formulario() {
		System.setProperty("webdriver.gecko.driver","src/test/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        
	}

	@When("^Usuario acessar a url do formulario$")
	public void usuario_acessar_a_url_do_formulario() {
		automobileAction.acessarAplicacao(driver);
		
	}

	@When("^Usuario preencher todos os campos existentes no formulario$")
	public void usuario_preencher_todos_os_campos_existentes_no_formulario() {
		automobileAction.preencherCamposTelaEnterVehicleData(driver);
		automobileAction.preencherCamposTelaEnterInsurantData(driver);
		automobileAction.preencherCamposTelaEnterProductData(driver);
		automobileAction.selecionarOpcaoPlanoUltimate(driver);
		automobileAction.preencherCamposTelaSendQuote(driver);
	   
	}

	@And("^Usuario clicar no botao enviar$")
	public void usuario_clicar_no_botao_enviar() {
		automobileAction.clicarParaEnviarProposta(driver);
	}

	@Then("^Usuario vera a mensagem:Sending e-mail success!$")
	public void usuario_vera_a_mensagem_Sending_e_mail_success() {
		automobileAction.verificarMensagem(driver);
	  
		driver.close();;
	}

}
