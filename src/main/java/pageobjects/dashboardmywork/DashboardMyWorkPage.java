package pageobjects.dashboardmywork;

import core.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardMyWorkPage extends BasePage {
    @FindBy(xpath = "//span[text()='My Work']")
    private WebElement tabMyWork;
    public DashboardMyWorkPage(WebDriver driver){
        super(driver);
    }

    @Step("click tab my work")
    public DashboardMyWorkPage clickTabMyWork(){
        clickToElement(tabMyWork);
        return this;
    }
}
