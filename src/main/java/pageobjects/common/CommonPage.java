package pageobjects.common;

import core.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import utils.WaitUtil;

import java.util.List;

import static constants.Constant.DATE_SORT;

public class CommonPage extends BasePage {
    @FindBy(xpath = "//div[contains(@class, 'filter')]/p")
    private WebElement btnFilter;

    @FindBy(xpath = "//input[contains(@class, 'dashboard-filter__search__input')]")
    private WebElement searchBox;

    @FindBy(xpath = "//button[normalize-space()='Create']")
    private WebElement btnCreate;

    @FindBy(xpath = "//div[contains(@class, 'app-select__btn-select')]//p[contains(text(), 'Date')]")
    private WebElement dropDownListDate;

    @FindBy(xpath = "//div[contains(@class, 'app-select__menu')]/p")
    private List<WebElement> listDate;

    @FindBy(xpath = "//div[contains(@class, 'chakra-input__group')]/following-sibling::div/div")
    private List<WebElement> listTagTrending;

    @FindBy(xpath = "//input[contains(@class, 'dashboard-filter__search__input')]/ancestor::div[contains(@style, 'block')]")
    private WebElement sectionFilterWhenOpen;

    @FindBy(xpath = "//input[contains(@class, 'dashboard-filter__search__input')]/ancestor::div[contains(@style, 'none')]")
    private WebElement sectionFilterWhenClose;

    @FindBy(xpath = "//div[contains(@class, 'dashboard-filter')]//div[contains(@class, 'chakra-collapse')]")
    private WebElement sectionFilter;

    @FindBy(xpath = "//div[text()='No data...']")
    private WebElement noData;

    @FindBy(xpath = "(//div[contains(@class, 'chakra-alert__desc')]/parent::div/following-sibling::button)[1]")
    private WebElement btnCloseToastMessage;

    @FindBy(xpath = "(//div[text()='Successfully']/parent::div)[1]")
    private WebElement toastMessageSuccessfully;

    @FindBy(xpath = "(//div[text()='Copied']/parent::div/div)[1]")
    private WebElement toastMessageCopied;

    @FindBy(xpath = "//div[normalize-space()='Create New']")
    private WebElement titlePopupCreateNew;

    @FindBy(xpath = "//div[contains(@class, 'content-create-modal')]/p[text()='Dashboard']")
    private WebElement optionCreateDashboard;

    @FindBy(xpath = "//div[contains(@class, 'content-create-modal')]/p[text()='Query']")
    private WebElement optionCreateQuery;

    @FindBy(xpath = "//div[normalize-space()='Create Dashboard']")
    private WebElement titlePopupCreateDashboard;

    @FindBy(xpath = "//input[@placeholder='My dashboard']")
    private WebElement inputDashboardTitle;

    @FindBy(xpath = "//input[@placeholder='tag1, tag2, tag3']")
    private WebElement inputTagsDashboard;

    @FindBy(xpath = "//button[text()='Cancel']")
    private WebElement btnCancel;

    @FindBy(xpath = "//button[text()='Add']")
    private WebElement btnAdd;

    @FindBy(xpath = "//div[normalize-space()='Create Dashboard']/ancestor::section/div[contains(@class, 'modal__btn-close')]")
    private WebElement btnClosePopUpCreateDashboard;

    @FindBy(xpath = "//div[normalize-space()='Create New']/ancestor::section/div[contains(@class, 'modal__btn-close')]")
    private WebElement btnClosePopUpCreateNew;

    @FindBy(xpath = "//ul//div[text()='Create new dashboard successfully!']")
    private WebElement toastMessageCreateNewDashboardSuccessfully;

    @FindBy(xpath = "//a[text()='Insights']")
    private WebElement tabInsights;

    public CommonPage(WebDriver driver){
        super(driver);
    }
    @Step("click button filter")
    public CommonPage clickButtonFilter(){
        clickToElement(btnFilter);
        return this;
    }
    @Step("check button filter display")
    public CommonPage checkButtonFilterDisplay(){
        Assert.assertTrue(isDisplayElement(btnFilter));
        return this;
    }
    @Step("check button filter enable")
    public CommonPage checkButtonFilterEnable(){
        Assert.assertTrue(isEnableElement(btnFilter));
        return this;
    }
    @Step("check search box empty")
    public CommonPage checkSearchBoxEmpty(){
        Assert.assertEquals(searchBox.getText(), "");
        return this;
    }
    @Step("check button create enable")
    public void checkButtonCreateEnable(){
        Assert.assertTrue(isEnableElement(btnCreate));
    }
    @Step("click button create")
    public CommonPage clickButtonCreate(){
        clickToElement(btnCreate);
        return this;
    }
    @Step("check value default of drop down list date")
    public CommonPage checkValueDefaultDropDownListDate(){
        Assert.assertEquals(dropDownListDate.getText(), DATE_SORT[0]);
        return this;
    }
    @Step("click to drop down list Date")
    public CommonPage clickDropDownListDate(){
        clickToElement(dropDownListDate);
        return this;
    }
    @Step("check list tag trending display")
    public CommonPage checkListTagTrendingDisplay(){
        for(WebElement element : listTagTrending){
            Assert.assertTrue(isDisplayElement(element));
        }
        return this;
    }
    @Step("check drop down list date display")
    public CommonPage checkDropdownListDateDisplay(){
        for(WebElement element : listDate){
            Assert.assertTrue(isDisplayElement(element));
        }
        return this;
    }
    @Step("check filter section open")
    public CommonPage checkFilterSectionOpen(){
        Assert.assertTrue(WaitUtil.waitForElementVisible(sectionFilterWhenOpen).isDisplayed());
        return this;
    }
    @Step("check section filter close")
    public CommonPage checkSectionFilterClose(){
        getExplicitWait().until(ExpectedConditions.invisibilityOf(sectionFilterWhenOpen));
        Assert.assertFalse(sectionFilter.isDisplayed());
        return this;
    }
    @Step("status section filter")
    public boolean statusSectionFilter(){
        return sectionFilter.isDisplayed();
    }
    @Step("open filter section")
    public CommonPage openFilterSection(){
        if(!statusSectionFilter()) clickButtonFilter();
        return this;
    }
    @Step("close filter section")
    public CommonPage closeFilterSection(){
        if(statusSectionFilter()) clickButtonFilter();
        return this;
    }
    @Step("enter text box search")
    public CommonPage enterTextBoxSearch(String value){
        sendKeyElement(searchBox, value);
        return this;
    }
    @Step("check have not data")
    public CommonPage checkHaveNotData() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(noData.isDisplayed());
        return this;
    }
    @Step("check drop down list date display")
    public CommonPage selectDateLowToHigh(){
        clickToElement(listDate.get(0));
        return this;
    }
    @Step("close toast message Welcome to Blocklens")
    public CommonPage closeToastMessage(){
        clickToElement(btnCloseToastMessage);
        return this;
    }
    @Step("verify toast message successfully display")
    public CommonPage verifyToastMessageSuccessfullyDisplay(){
        WaitUtil.waitForElementVisible(toastMessageSuccessfully);
        return this;
    }
    @Step("verify toast message copied display")
    public CommonPage verifyToastMessageCopiedDisplay(){
        WaitUtil.waitForElementVisible(toastMessageCopied);
        return this;
    }
    @Step("check information default of pop up create new")
    public void checkInfoDefaultPopupCreateNew(){
        Assert.assertTrue(isEnableElement(btnClosePopUpCreateNew));
        Assert.assertTrue(isDisplayElement(titlePopupCreateNew));
        Assert.assertTrue(isEnableElement(optionCreateDashboard));
        Assert.assertTrue(isEnableElement(optionCreateQuery));
    }
    @Step("click option create dashboard")
    public CommonPage clickOptionCreateDashboard(){
        clickToElement(optionCreateDashboard);
        return this;
    }
    @Step("check information of pop up create dashboad")
    public void checkInfoPopUpCreateDashboard(){
        Assert.assertTrue(isEnableElement(btnClosePopUpCreateDashboard));
        Assert.assertTrue(isDisplayElement(titlePopupCreateDashboard));
        Assert.assertEquals(inputDashboardTitle.getText(), "");
        Assert.assertEquals(inputDashboardTitle.getAttribute("placeholder"), "My dashboard");
        Assert.assertEquals(inputTagsDashboard.getText(), "");
        Assert.assertEquals(inputTagsDashboard.getAttribute("placeholder"), "tag1, tag2, tag3");
        Assert.assertTrue(isEnableElement(btnCancel));
        Assert.assertFalse(isEnableElement(btnAdd));
    }
    @Step("click button cancel on pop up create dashboard")
    public CommonPage clickButtonCancel(){
        clickToElement(btnCancel);
        return this;
    }
    @Step("check pop up create dashboard already closed")
    public CommonPage checkPopUpCreateDashboardClosed(){
        WaitUtil.waitForElementInvisible(titlePopupCreateDashboard);
        return this;
    }
    @Step("create new dashboard")
    public CommonPage createNewDashboard(){
        sendKeyElement(inputDashboardTitle, "aAAAAA");
        sendKeyElement(inputTagsDashboard, "tag1");
        return this;
    }
    @Step("click button add new dashboard")
    public CommonPage clickButtonAddNewDashboard(){
        WaitUtil.waitForElementClickable(btnAdd);
        clickToElement(btnAdd);
        return this;
    }
    @Step("check action click button add successfully")
    public void checkActionClickButtonAddSuccessfully(){
        WaitUtil.waitForElementInvisible(titlePopupCreateDashboard);
        WaitUtil.waitForElementVisible(toastMessageCreateNewDashboardSuccessfully);
    }
    @Step("click button close")
    public CommonPage clickButtonClose(){
        clickToElement(btnClosePopUpCreateDashboard);
        return this;
    }
    @Step("click tab insights")
    public CommonPage clickTabInsights(){
        clickToElement(tabInsights);
        return this;
    }
}
