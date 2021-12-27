package ex3.pageObjects.nativePages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import ex3.TestData.User;

public class LoginPage {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[@enabled='true']")
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/login_email")
    private WebElement loginTextField;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[@enabled='true']")
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/login_pwd")
    private WebElement passwordTextField;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@enabled='true'][3]")
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/email_sign_in_button")
    private WebElement signInBtn;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeCell[@enabled='true'][4]")
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_button")
    private WebElement registerBtn;

    public LoginPage(AppiumDriver appiumDriver) {
        PageFactory.initElements( new AppiumFieldDecorator(appiumDriver), this);
    }

    public void fillLoginFields(User user) {
        loginTextField.sendKeys(user.getEmail());
        passwordTextField.sendKeys(user.getPassword());
    }

    public WebElement getLoginTextField() {
        return loginTextField;
    }

    public WebElement getPasswordTextField() {
        return passwordTextField;
    }

    public WebElement getSignInBtn() {
        return signInBtn;
    }

    public WebElement getRegisterBtn() {
        return registerBtn;
    }
}
