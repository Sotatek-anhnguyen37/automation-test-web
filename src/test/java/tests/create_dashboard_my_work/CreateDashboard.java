package tests.create_dashboard_my_work;

import base.BaseTest;
import constants.Constant;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.common.CommonPage;
import pageobjects.login.LoginPage;

public class CreateDashboard extends BaseTest {
    @BeforeMethod(description = "login successfully")
    public void login(){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(Constant.EMAIL, Constant.PASSWORD);
    }
    @Test(description = "confirm initializing the screen create dashboard")
    public void ConfirmInitialScreen(){
        CommonPage commonPage = new CommonPage(getDriver());

        // check information of pop up create new
        commonPage.clickButtonCreate()
                .checkInfoDefaultPopupCreateNew();
        commonPage.clickOptionCreateDashboard()
                .checkInfoPopUpCreateDashboard();
        // check button cancel
        commonPage.clickButtonCancel()
                .checkPopUpCreateDashboardClosed()
                .clickOptionCreateDashboard()
                .checkInfoPopUpCreateDashboard();
        //check button add
        commonPage.createNewDashboard()
                .clickButtonAddNewDashboard()
                .checkActionClickButtonAddSuccessfully();
        //check button close
        commonPage.clickTabInsights()
                .clickButtonCreate()
                .clickOptionCreateDashboard()
                .clickButtonClose()
                .checkPopUpCreateDashboardClosed()
                .clickOptionCreateDashboard()
                .checkInfoPopUpCreateDashboard();
    }
}
