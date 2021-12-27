package scenarios.ex2;

import ex2.TestData.Data;
import org.testng.Assert;
import org.testng.annotations.Test;
import ex2.pageObjects.nativePages.BudgetActivityPage;
import ex2.pageObjects.nativePages.LoginPage;
import ex2.pageObjects.nativePages.RegistrationPage;
import ex2.pojos.User;
import ex2.setup.BaseTest;

public class nativeMobileTests extends BaseTest {

    @Test(groups = {"native"}, description = "Register new user, login and assert that Budget Page is opened",
          dataProviderClass = Data.class, dataProvider = "getTestUser")
    public void simpleNativeTest(User user) {
        LoginPage loginPage = (LoginPage) getPageObject().getEntryPageObject();
        loginPage.getRegisterBtn().click();

        RegistrationPage registrationPage = new RegistrationPage(getDriver());
        registrationPage.fillRegistrationFields(user);
        registrationPage.getRegisterBtn().click();

        loginPage.fillLoginFields(user);
        loginPage.getSignInBtn().click();
        BudgetActivityPage budgetActivityPage = new BudgetActivityPage(getDriver());
        Assert.assertTrue(budgetActivityPage.getAddExpenseBtn().isDisplayed());
        System.out.println("Budget activity page is opened");
    }
}
