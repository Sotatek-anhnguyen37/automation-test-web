package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BasePage {
    private static final int TIME_OUT = 1;
    private WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofMinutes(TIME_OUT));
        PageFactory.initElements(driver, this);
    }

    public WebDriver getDriver() {
        return driver;
    }
    public WebDriverWait getExplicitWait(){
        return wait;
    }

    public void clickToElement(WebElement e){
        getExplicitWait().until(ExpectedConditions.elementToBeClickable(e));
        e.click();
    }
    public void sendKeyElement(WebElement e, String key){
        getExplicitWait().until(ExpectedConditions.visibilityOf(e));
        e.sendKeys(key);
    }
    public boolean isEnableElement(WebElement e){
        getExplicitWait().until(ExpectedConditions.visibilityOf(e));
        return e.isEnabled();
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
}
