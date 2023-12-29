package pageobjects.common;

import core.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

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
    @Step("check list value of drop down date")
    public CommonPage checkListValueDate(){
        List<String> dates = listDate.stream().map(element -> element.getLocation().toString()).toList();
        int i = 0;
        for (String e : dates){
            Assert.assertEquals(e, DATE_SORT[i]);
            i++;
        }
        return this;
    }
    public CommonPage checkListTagTrendingDisplay(){
        for(WebElement element : listTagTrending){
            Assert.assertTrue(isDisplayElement(element));
        }
        return this;
    }
    public CommonPage checkDropdownListDateDisplay(){
        for(WebElement element : listDate){
            Assert.assertTrue(isDisplayElement(element));
        }
        return this;
    }
    public CommonPage checkFilterSectionOpen(){
        Assert.assertTrue(getElement(sectionFilterWhenOpen).isDisplayed());
        return this;
    }
    public CommonPage checkSectionFilterClose(){
        Assert.assertFalse(sectionFilter.isDisplayed());
        return this;
    }
    public boolean statusSectionFilter(){
        return sectionFilter.isDisplayed();
    }
    public CommonPage openFilterSection(){
        if(!statusSectionFilter()) clickButtonFilter();
        return this;
    }
    public CommonPage closeFilterSection(){
        if(statusSectionFilter()) clickButtonFilter();
        return this;
    }
    public CommonPage enterTextBoxSearch(String value){
        sendKeyElement(searchBox, value);
        return this;
    }
}