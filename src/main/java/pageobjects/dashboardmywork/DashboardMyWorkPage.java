package pageobjects.dashboardmywork;

import com.beust.ah.A;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pageobjects.common.CommonPage;

import java.util.List;

public class DashboardMyWorkPage extends CommonPage {
    @FindBy(xpath = "//span[text()='My Work']")
    private WebElement tabMyWork;

    @FindBy(xpath = "//div[contains(@class, 'app-select__btn-select')]//div[contains(@class, 'icon')]/following-sibling::p")
    private WebElement selectTypeMyWork;

    @FindBy(xpath = "//div[contains(@class, 'app-select__menu')]//div[contains(@class, 'app-select__menu-item')]/p")
    private List<WebElement> listTypes;

    @FindBy(xpath = "//table//div[contains(@class, 'article-row')]/a")
    private List<WebElement> listDashboard;

    @FindBy(xpath = "//table//div[contains(@class, 'article-row')]/a//div[contains(@class, 'article-name')]")
    private List<WebElement> listDashboardName;

    @FindBy(xpath = "//table//div[contains(@class, 'article-row')]/a//p[contains(@class, 'article-creator')]")
    private List<WebElement> listDashboardCreatorName;

    @FindBy(xpath = "//table//div[contains(@class, 'article-row')]/a//p[contains(@class, 'article-date')]")
    private List<WebElement> listDashboardCreateDate;

    @FindBy(xpath = "//input[contains(@class, 'dashboard-filter__search__input')]")
    private WebElement searchBox;

    public DashboardMyWorkPage(WebDriver driver){
        super(driver);
    }
    @Step("click tab my work")
    public DashboardMyWorkPage clickTabMyWork(){
        clickToElement(tabMyWork);
        return this;
    }
    @Step("click to selection dashboard")
    public DashboardMyWorkPage clickToSelectionDashboard(){
        clickToElement(selectTypeMyWork);
        return this;
    }
    @Step("verify default value of selection dashboard")
    public DashboardMyWorkPage verifyDefaultValueOfSelectionDashboard(String defaultValue){
        Assert.assertEquals(selectTypeMyWork.getText(), defaultValue);
        return this;
    }
    @Step("verify dropdown list Type")
    public DashboardMyWorkPage verifyDropDownListType(){
        for (WebElement element : listTypes){
            Assert.assertTrue(element.getText().contains("Dashboard") || element.getText().contains("Queries"));
        }
        return this;
    }
    @Step("click display type dashboard")
    public DashboardMyWorkPage clickDisplayTypeDashboard(){
        clickToElement(listTypes.get(0));
        return this;
    }
    @Step("check name list dashboard")
    public DashboardMyWorkPage checkNameListDashboard(String name){
        for(WebElement element : listDashboardName){
            Assert.assertTrue(element.getText().toUpperCase().contains(name.toUpperCase()));
        }
        return this;
    }
    @Step("get number of dashboard")
    public int getNumberDashboard(){
        return listDashboard.size();
    }
    @Step("check display all of dashboard")
    public DashboardMyWorkPage checkDisplayAllOfDashboard(int number){
        Assert.assertEquals(listDashboard.size(), number);
        return this;
    }
}