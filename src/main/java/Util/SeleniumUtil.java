package Util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;




public final class SeleniumUtil {
    public SeleniumUtil() {
    }

    public static final WebElement getElementoPorCss(WebDriver driver, String css, int segundos) {
        return (WebElement)getDriverWaitByTime(driver, segundos).until(ExpectedConditions.elementToBeClickable(By.cssSelector(css)));
    }

    public static final WebElement getElementoVisivelPorId(WebDriver driver, String id, int segundos) {
        return (WebElement)getDriverWaitByTime(driver, segundos).until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
    }

    public static final String getNameElementoVisivelPorId(final WebDriver driver, final String id) {
        return getElementoVisivelPorId(driver, id, 30).getAttribute("name");
    }

    public static final WebElement getElementoVisivelPorXPath(WebDriver driver, String xpath, int segundos) {
        return (WebElement)getDriverWaitByTime(driver, segundos).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public static final String getNameElementoVisivelPorXPath(final WebDriver driver, final String xpath) {
        return getElementoVisivelPorXPath(driver, xpath, 30).getAttribute("name");
    }

    public static final WebElement getElementoClicavelPorId(WebDriver driver, String id, int segundos) {
        return (WebElement)getDriverWaitByTime(driver, segundos).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(By.id(id)));
    }

    public static final String getNameElementoClicavelPorId(final WebDriver driver, final String id) {
        return getElementoClicavelPorId(driver, id, 30).getAttribute("name");
    }

    public final static WebElement getElementoClicavelPorXPath(WebDriver driver, String xpath, int segundos) {
        return (WebElement)getDriverWaitByTime(driver, segundos).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }

    public  final String getNameElementoClicavelPorXPath(final WebDriver driver, String xpath) {
        return getElementoClicavelPorXPath(driver, xpath, 30).getAttribute("name");
    }

    public  final String getIdElementoClicavelPorXPath(final WebDriver driver, String xpath) {
        return getElementoClicavelPorXPath(driver, xpath, 30).getAttribute("id");
    }

    public static final WebElement getElementoClicavelPorWebElement(WebDriver driver, final WebElement elemento, int segundos) {
        return (WebElement)getDriverWaitByTime(driver, segundos).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(elemento));
    }

    public static final void aguardarAteIdNaoVisivel(WebDriver driver, String id, int segundos) {
        getDriverWaitByTime(driver, segundos).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(By.id(id))));
    }

    public static final void aguardarAteXpathNaoVisivel(WebDriver driver, String xpath, int segundos) {
        getDriverWaitByTime(driver, segundos).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))));
    }

    public static final void aguardarAteElementoNaoVisivel(WebDriver driver, WebElement elemento, int segundos) {
        getDriverWaitByTime(driver, segundos).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.not(ExpectedConditions.visibilityOf(elemento)));
    }

    public static WebElement aguardaElementoVisivel(WebDriver driver, WebElement elemento, int segundos) {
        return (WebElement)(new WebDriverWait(driver, (long)segundos)).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(elemento));
    }

    public static final WebElement elementoPresente(WebDriver driver, String xpath, int segundos) {
        WebElement ep = (WebElement)getDriverWaitByTime(driver, segundos).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        return ep;
    }

    public static final Boolean aguardarTextoEstarPresente(WebDriver driver, String xpath, String text, int segundos) {
        Boolean tx = (Boolean)getDriverWaitByTime(driver, segundos).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.textToBePresentInElementLocated(By.xpath(xpath), text));
        return tx;
    }

    public static final void elementoPresentPorId(final WebDriver driver, String id, int segundos) {
        getDriverWaitByTime(driver, segundos).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
    }

    public static final void verificarElementoNaoEstarPresente(WebDriver driver, String xpath, int segundos) {
        getDriverWaitByTime(driver, segundos).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.not(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))));
    }



    public static boolean existeElementoPorXpath(WebDriver driver, String xpath) {
        try {
            driver.findElement(By.xpath(xpath));
            return true;
        } catch (NoSuchElementException var3) {
            return false;
        }
    }

    public static void moveMouseToId(final WebDriver driver, final String id) {
        WebElement we = driver.findElement(By.id(id));
        moveMouseToWebElement(driver, we);
    }

    public static WebElement moveMouseToXPath(final WebDriver driver, final String xpath) {
        WebElement we = driver.findElement(By.xpath(xpath));
        return moveMouseToWebElement(driver, we);
    }

    public static WebElement moveMouseToWebElement(final WebDriver driver, final WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        return element;
    }

    public static void clickVerificaPorWebElement(final WebDriver driver, final WebElement elementoClick, final WebElement elementoVerificar) {
        elementoClick.click();

        try {
            getElementoClicavelPorWebElement(driver, elementoVerificar, 5);
        } catch (Exception var4) {
            elementoClick.click();
        }

    }


   

    public static void clickVerificaPorXPathNovo(final WebDriver driver, final WebElement elementoClick, final String xPathElementoVerificar) {
        elementoClick.click();
        aguardarTempo(1500);

        try {
            getElementoVisivelPorXPath(driver, xPathElementoVerificar, 30);
        } catch (Exception var4) {
            elementoClick.click();
        }

    }

    public  void clickVerificaFalha(final WebDriver driver, final WebElement elementoClick) {
        try {
            elementoClick.click();
        } catch (Exception var3) {
            aguardarTempo(1000);
            elementoClick.click();
        }

    }

    public static void scrollVerticallyUntilEnd(final WebDriver driver) {
        executeJavaScriptAndWait((JavascriptExecutor)driver, "window.scrollTo(0, document.body.scrollHeight)", 1);
    }

    public static void scrollPageDown(final WebDriver driver) {
        executeJavaScriptAndWait((JavascriptExecutor)driver, "window.scrollBy(0,500)", 1);
    }

    public static void scrollPageUp(final WebDriver driver) {
        executeJavaScriptAndWait((JavascriptExecutor)driver, "window.scrollBy(0,-500)", 1);
    }

    public static void scrollHorizontallyUntilEnd(final WebDriver driver) {
        executeJavaScriptAndWait((JavascriptExecutor)driver, "window.scrollTo(0, document.body.scrollWidth)", 1);
    }

    private static void executeJavaScriptAndWait(JavascriptExecutor driver, String script, int segundos) {
        try {
            driver.executeScript(script, new Object[0]);
            Thread.sleep((long)(1000 * segundos));
        } catch (InterruptedException var4) {
            throw new IllegalStateException(var4);
        }
    }

    public static WebDriverWait getDriverWaitByTime(WebDriver driver, int seconds) {
        return new WebDriverWait(driver, (long)seconds);
    }

    public static boolean possuiEssaClasseCss(final WebElement element, String cssClass) {
        String[] classes = element.getAttribute("class").split("\\s+");
        if (classes != null) {
            String[] var3 = classes;
            int var4 = classes.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                String classAttr = var3[var5];
                if (classAttr.equals(cssClass)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void aguardarTempo(int tempo) {
        try {
            Thread.sleep((long)tempo);
        } catch (InterruptedException var2) {
            throw new IllegalStateException(var2);
        }
    }

    public static void selecionaElementoComboByValue(final WebElement combo, String value) {
        Select select = new Select(combo);
        select.selectByValue(value);
    }

    public static void selecionaElementoComboByIndice(final WebElement combo, int indice) {
        Select select = new Select(combo);
        select.selectByIndex(indice);
    }

    public static void selecionaElementoComboByVisibleText(final WebElement combo, String text) {
        Select select = new Select(combo);
        List<WebElement> list = select.getOptions();
        Iterator var4 = list.iterator();

        while(var4.hasNext()) {
            WebElement option = (WebElement)var4.next();
            String fullText = option.getText();
            if (fullText.contains(text) || fullText.contains(text.toUpperCase())) {
                select.selectByVisibleText(fullText);
                break;
            }
        }

    }



    private static String getElementByXpathAndScrollIntoView(String xpath) {
        return "document.evaluate('" + xpath + "', document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.scrollIntoView();";
    }

    private static String getElementByByIdAndScrollIntoView(String id) {
        return "document.getElementById('" + id + "').scrollIntoView();";
    }

    public static void scrollToXpath(final WebDriver driver, String xpath, int segundos) {
        elementoPresente(driver, xpath, segundos);
        executeJavaScriptAndWait((JavascriptExecutor)driver, getElementByXpathAndScrollIntoView(xpath), 1);
    }

    public static void scrollToId(final WebDriver driver, String id, int segundos) {
        elementoPresentPorId(driver, id, segundos);
        executeJavaScriptAndWait((JavascriptExecutor)driver, getElementByByIdAndScrollIntoView(id), 1);
    }

    public  void aguarde(final WebDriver driver) {
        aguardarAteXpathNaoVisivel(driver, "//*[@class=\"bar\"]", 1200);
        aguardarTempo(500);
    }

    
}
