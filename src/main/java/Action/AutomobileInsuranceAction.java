package Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import PageObject.EnterInsurantDataPage;
import PageObject.EnterProductDataPage;
import PageObject.EnterVehicleDataPage;
import PageObject.SendQuotePage;
import Util.SeleniumUtil;

public class AutomobileInsuranceAction {
	EnterVehicleDataPage dadosVeiculo = new EnterVehicleDataPage();
	EnterInsurantDataPage dadosSeguro = new EnterInsurantDataPage();
	EnterProductDataPage dadosProduto = new EnterProductDataPage();
	SendQuotePage dadosCota = new SendQuotePage();

	public void acessarAplicacao(WebDriver driver) {
		driver.get("http://sampleapp.tricentis.com/101/app.php");
		WebElement selectComboBoxMake = SeleniumUtil.getElementoClicavelPorXPath(driver, dadosVeiculo.XPATH_COMBO_MAKE,
				60);
		SeleniumUtil.aguardaElementoVisivel(driver, selectComboBoxMake, 25);
		SeleniumUtil.getElementoClicavelPorId(driver, dadosVeiculo.ID_AUTOMOBILE_INSURANCE, 20).click();
		SeleniumUtil.aguardarTempo(3000);

	}

	public void preencherCamposTelaEnterVehicleData(WebDriver driver) {
		WebElement selectComboBoxMake = SeleniumUtil.getElementoClicavelPorXPath(driver, dadosVeiculo.XPATH_COMBO_MAKE,
				60);
		SeleniumUtil.selecionaElementoComboByVisibleText(selectComboBoxMake, "BMW");
		SeleniumUtil.getElementoClicavelPorId(driver, dadosVeiculo.ID_ENGINER_PERFOMANCE, 60).sendKeys("200");
		SeleniumUtil.getElementoClicavelPorId(driver, dadosVeiculo.ID_DATE_OF_MANUFACTURE, 60).sendKeys("10/03/2020");
		WebElement selectComboNS = SeleniumUtil.getElementoClicavelPorId(driver, dadosVeiculo.ID_NUMBER_OF_SEATS, 60);
		SeleniumUtil.selecionaElementoComboByValue(selectComboNS, "4");
		WebElement selectComboFuel = SeleniumUtil.getElementoClicavelPorId(driver, dadosVeiculo.ID_FUEL, 60);
		SeleniumUtil.selecionaElementoComboByVisibleText(selectComboFuel, "Diesel");
		SeleniumUtil.getElementoClicavelPorId(driver, dadosVeiculo.ID_LIST_PRICE, 60).sendKeys("50000");
		SeleniumUtil.getElementoClicavelPorId(driver, dadosVeiculo.ID_LICENSE, 60).sendKeys("5454154");
		SeleniumUtil.getElementoClicavelPorId(driver, dadosVeiculo.ID_ANNUAL_MILEAGE, 60).sendKeys("3000");
		SeleniumUtil.aguardarTempo(3000);
		SeleniumUtil.getElementoClicavelPorId(driver, dadosVeiculo.ID_NEXTER_INSURANT, 20).click();

	}

	public void preencherCamposTelaEnterInsurantData(WebDriver driver) {
		SeleniumUtil.aguardarTempo(2000);
		SeleniumUtil.getElementoClicavelPorId(driver, dadosSeguro.ID_FIST_NAME, 60).sendKeys("ROBERTO");
		SeleniumUtil.getElementoClicavelPorId(driver, dadosSeguro.ID_LAST_NAME, 60).sendKeys("CARLOS");
		SeleniumUtil.getElementoClicavelPorId(driver, dadosSeguro.ID_BIRT_DATE, 60).sendKeys("12/11/1987");
		SeleniumUtil.moveMouseToXPath(driver, dadosSeguro.XPATH_GENDER_MALE).click();
		SeleniumUtil.getElementoClicavelPorId(driver, dadosSeguro.ID_STREET_ADDRESS, 60).sendKeys("Rua das Mães");
		WebElement selectComboCountry = SeleniumUtil.getElementoClicavelPorId(driver, dadosSeguro.ID_COUNTRY, 60);
		SeleniumUtil.selecionaElementoComboByVisibleText(selectComboCountry, "Brazil");
		SeleniumUtil.getElementoClicavelPorId(driver, dadosSeguro.ID_ZIP_CODE, 60).sendKeys("74465270");
		SeleniumUtil.getElementoClicavelPorId(driver, dadosSeguro.ID_CITY, 60).sendKeys("Goiânia");
		WebElement selectComboOccupation = SeleniumUtil.getElementoClicavelPorId(driver, dadosSeguro.ID_OCCUPATION, 60);
		SeleniumUtil.selecionaElementoComboByVisibleText(selectComboOccupation, "Employee");
		SeleniumUtil.scrollPageDown(driver);
		SeleniumUtil.getElementoClicavelPorXPath(driver, dadosSeguro.XPATH_HOBBIE, 20).click();

		SeleniumUtil.getElementoClicavelPorId(driver, dadosSeguro.ID_WEBSITE, 60).sendKeys("www.teste.com.br");
		SeleniumUtil.aguardarTempo(3000);
		SeleniumUtil.getElementoClicavelPorId(driver, dadosSeguro.ID_NEXT_PRODUCT, 25).click();
		;

	}

	public void preencherCamposTelaEnterProductData(WebDriver driver) {
		SeleniumUtil.getElementoClicavelPorId(driver, dadosProduto.ID_START_DATE, 5).sendKeys("01/01/2022");
		WebElement selectComboInsurance = SeleniumUtil.getElementoClicavelPorId(driver, dadosProduto.ID_INSURANCE_SUM,
				60);
		SeleniumUtil.selecionaElementoComboByValue(selectComboInsurance, "5000000");
		WebElement selectComboMerite = SeleniumUtil.getElementoClicavelPorId(driver, dadosProduto.ID_MERIT, 60);
		SeleniumUtil.selecionaElementoComboByValue(selectComboMerite, "Bonus 2");
		WebElement selectComboDamage = SeleniumUtil.getElementoClicavelPorId(driver, dadosProduto.ID_DAMAGE_INSURANCE,
				60);
		SeleniumUtil.selecionaElementoComboByValue(selectComboDamage, "No Coverage");
		SeleniumUtil.getElementoClicavelPorXPath(driver, dadosProduto.XPATH_OPTIONAL_PRODUCTS, 25).click();
		WebElement selectComboCourtesy = SeleniumUtil.getElementoClicavelPorId(driver, dadosProduto.ID_COURTESY_CAR,
				60);
		SeleniumUtil.selecionaElementoComboByVisibleText(selectComboCourtesy, "Yes");
		SeleniumUtil.aguardarTempo(3000);
		SeleniumUtil.getElementoClicavelPorId(driver, dadosProduto.ID_BUTTON_NEXT_SELECT_PRICE, 25).click();

	}

	public void selecionarOpcaoPlanoUltimate(WebDriver driver) {
		SeleniumUtil.aguardarTempo(1000);
		SeleniumUtil.getElementoClicavelPorXPath(driver, dadosProduto.XPATH_RADIO_ULTIMATE, 25).click();
		SeleniumUtil.aguardarTempo(1000);
		SeleniumUtil.getElementoClicavelPorId(driver, dadosProduto.ID_BUTTON_NEXT_SEND_QUOTE, 25).click();
		SeleniumUtil.aguardarTempo(3000);

	}

	public void preencherCamposTelaSendQuote(WebDriver driver) {
		SeleniumUtil.getElementoClicavelPorId(driver, dadosCota.ID_E_MAIL, 5).sendKeys("teste@teste.com.br");
		SeleniumUtil.getElementoClicavelPorId(driver, dadosCota.ID_PHONE, 5).sendKeys("62999998820");
		SeleniumUtil.getElementoClicavelPorId(driver, dadosCota.ID_USERNAME, 5).sendKeys("QATESTE");
		SeleniumUtil.getElementoClicavelPorId(driver, dadosCota.ID_PASSWORD, 5).sendKeys("Qateste123");
		SeleniumUtil.getElementoClicavelPorId(driver, dadosCota.ID_CONFIRM_PASSWORD, 5).sendKeys("Qateste123");
		SeleniumUtil.getElementoClicavelPorId(driver, dadosCota.ID_COMMENTS, 5).sendKeys("OBRIGADO PELA OPORTUNIDADE");

	}

	public void clicarParaEnviarProposta(WebDriver driver) {
		SeleniumUtil.getElementoClicavelPorId(driver, dadosCota.ID_BUTTON_SEND_MAIL, 5).click();
		SeleniumUtil.aguardarTempo(10000);

	}

	public void verificarMensagem(WebDriver driver) {
		driver.switchTo().activeElement().findElement(By.xpath("//div[@class='sweet-alert showSweetAlert visible']"));
		WebElement mensagem = driver.findElement(By.xpath(dadosCota.XPATH_MESSAGE));
		SeleniumUtil.aguardarTextoEstarPresente(driver, dadosCota.XPATH_MESSAGE, mensagem.getText(), 20);

	}

}
