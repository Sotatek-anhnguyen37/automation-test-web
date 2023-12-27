package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BasePage {
    private static final int TIME_OUT = 10;
    private WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(TIME_OUT, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Duration.ofMinutes(10));
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
    public void navigationTo(String url){
        getDriver().get(url);
    }
}
