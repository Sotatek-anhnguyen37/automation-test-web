package core;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    private static final int TIME_OUT = 1;
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofMinutes(TIME_OUT));
        PageFactory.initElements(driver, this);
        action = new Actions(driver);
    }

    public WebDriver getDriver() {
        return driver;
    }
    public WebDriverWait getExplicitWait(){
        return wait;
    }

    public void clickToElement(WebElement e){
        getExplicitWait().until(ExpectedConditions.elementToBeClickable(e));
        action.moveToElement(e).build().perform();
        e.click();
    }
    public void sendKeyElement(WebElement e, String key){
        getExplicitWait().until(ExpectedConditions.visibilityOf(e));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getDriver();
        javascriptExecutor.executeScript("arguments[0].value='';", e);
        e.sendKeys(key);
    }
    public void clickEnter(WebElement e){
        e.sendKeys(Keys.ENTER);
    }
    public boolean isEnableElement(WebElement e){
        getExplicitWait().until(ExpectedConditions.visibilityOf(e));
        return e.isEnabled();
    }
    public boolean isSelectedElement(WebElement e){
        getExplicitWait().until(ExpectedConditions.visibilityOf(e));
        return e.isSelected();
    }
    public boolean isDisplayElement(WebElement e){
        return e.isDisplayed();
    }
    public WebElement getElement(WebElement e){
        return getExplicitWait().until(ExpectedConditions.visibilityOf(e));
    }
    public void waitUntilInvisibleElement(WebElement e){
        getExplicitWait().until(ExpectedConditions.invisibilityOf(e));
    }
    public void doubleClick(WebElement e){
        action.doubleClick(e).perform();
    }
}
