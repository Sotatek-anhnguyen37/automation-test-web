package tests.dashboard;

import base.BaseTest;
import constants.Constant;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.common.CommonPage;
import pageobjects.dashboardmywork.DashboardMyWorkPage;
import pageobjects.login.LoginPage;

import static constants.Constant.NAME_DASHBOARD_EXIST;
import static constants.Constant.NAME_DASHBOARD_NOT_EXIST;


public class DashboardListMyWorkTest extends BaseTest {
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
        int numberOfDashboardMyWork = dashboardMyWorkPage.getNumberDashboard();
        //check text box search default
        dashboardMyWorkPage.openFilterSection()
                .checkSearchBoxEmpty();
        //dashboard text box search have results
        dashboardMyWorkPage.enterTextBoxSearch(NAME_DASHBOARD_EXIST);
        Thread.sleep(3000);
        dashboardMyWorkPage.checkNameListDashboard(NAME_DASHBOARD_EXIST);
        //dashboard text box search with data not exist
        dashboardMyWorkPage.enterTextBoxSearch(NAME_DASHBOARD_NOT_EXIST)
                .checkHaveNotData();
        //check enter empty into search box
        dashboardMyWorkPage.enterTextBoxSearch("");
        Thread.sleep(2000);
        dashboardMyWorkPage.checkDisplayAllOfDashboard(numberOfDashboardMyWork);
        //check space empty into search box
        dashboardMyWorkPage.enterTextBoxSearch("   ");
        Thread.sleep(2000);
        dashboardMyWorkPage.checkDisplayAllOfDashboard(numberOfDashboardMyWork);
        //check name dashboard have space
        dashboardMyWorkPage.enterTextBoxSearch("  "+ NAME_DASHBOARD_EXIST);
        Thread.sleep(2000);
        dashboardMyWorkPage.checkNameListDashboard(NAME_DASHBOARD_EXIST);
    }
}
