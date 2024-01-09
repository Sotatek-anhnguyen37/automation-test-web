package tests.create_dashboard_my_work;

import base.BaseTest;
import constants.Constant;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.common.CommonPage;
import pageobjects.dashboard_mywork.CreateDashboardPage;
import pageobjects.login.LoginPage;

public class CreateDashboard extends BaseTest {
    @BeforeMethod(description = "login successfully")
    public void login(){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(Constant.EMAIL, Constant.PASSWORD);
    }
    @Test(description = "confirm initializing the screen create dashboard")
    public void ConfirmInitialScreen(){
        CreateDashboardPage createDashboardPage = new CreateDashboardPage(getDriver());

        // check information of pop up create new
        createDashboardPage.clickButtonCreate();
        createDashboardPage.checkInfoDefaultPopupCreateNew();
        createDashboardPage.clickOptionCreateDashboard()
                .checkInfoPopUpCreateDashboard();
        // check button cancel
        createDashboardPage.clickButtonCancel()
                .checkPopUpCreateDashboardClosed()
                .clickOptionCreateDashboard()
                .checkInfoPopUpCreateDashboard();
        //check button add
        createDashboardPage.createNewDashboard()
                .clickButtonAddNewDashboard()
                .checkActionClickButtonAddSuccessfully();
        //check button close
        createDashboardPage.clickTabInsights()
                .clickButtonCreate();
        createDashboardPage
                .clickOptionCreateDashboard()
                .clickButtonClose()
                .checkPopUpCreateDashboardClosed()
                .clickOptionCreateDashboard()
                .checkInfoPopUpCreateDashboard();


    }
}
