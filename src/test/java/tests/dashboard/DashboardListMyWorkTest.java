package tests.dashboard;

import base.BaseTest;
import constants.Constant;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjects.login.LoginPage;

public class DashboardListMyWorkTest extends BaseTest {
    @BeforeMethod(description = "login successfully")
    public void login(){
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.login(Constant.EMAIL, Constant.PASSWORD);
    }
    @Test(description = "check information default of dashboard my work")
    public void checkInformationDefault(){

    }
}
