package tests.dashboard;

import base.BaseTest;
import constants.Constant;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.common.CommonPage;
import pageobjects.dashboardmywork.DashboardMyWorkPage;
import pageobjects.login.LoginPage;


public class DashboardListMyWorkTest extends BaseTest {
    private String nameDashboardExist = "test_defalt_info123";
    @BeforeMethod(description = "login successfully")
    public void login(){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(Constant.EMAIL, Constant.PASSWORD);
    }
    @Test(description = "confirm initializing the screen my dashboard")
    public void confirmInitializingScreen() throws InterruptedException {
        DashboardMyWorkPage dashboardMyWorkPage = new DashboardMyWorkPage(getDriver());
        CommonPage commonPage = new CommonPage(getDriver());
        //check information default of dashboard my work
        dashboardMyWorkPage.clickTabMyWork()
                .verifyDefaultValueOfSelectionDashboard("Dashboard")
                .clickToSelectionDashboard()
                .verifyDropDownListType()
                .clickDisplayTypeDashboard()
                .checkButtonFilterEnable()
                .clickButtonFilter()
                .checkSearchBoxEmpty()
                .clickDropDownListDate()
                .checkValueDefaultDropDownListDate()
                .checkButtonCreateEnable();
        //check button filter
        dashboardMyWorkPage.checkButtonFilterDisplay()
                .openFilterSection()
                .checkListTagTrendingDisplay()
                .checkDropdownListDateDisplay()
                .checkFilterSectionOpen()
                .closeFilterSection()
                .checkSectionFilterClose();
        //check text box search
        dashboardMyWorkPage.openFilterSection()
                .checkSearchBoxEmpty()
                .enterTextBoxSearch(nameDashboardExist);
        dashboardMyWorkPage.checkNameListDashboard(nameDashboardExist);

    }
}
