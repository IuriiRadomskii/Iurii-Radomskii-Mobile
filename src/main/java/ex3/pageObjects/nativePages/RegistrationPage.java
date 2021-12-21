package ex3.pageObjects.nativePages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import ex3.TestData.User;

public class RegistrationPage {

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[1]")
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_email")
    private WebElement emailTextField;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeTextField[2]")
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_username")
    private WebElement usernameTextField;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[1]")
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_password")
    private WebElement pswdTextField;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSecureTextField[2]")
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_confirm_password")
    private WebElement confirmPswdTextField;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeSwitch[@value='0']")
    @AndroidFindBy(className = "android.widget.CheckedTextView")
    private WebElement agreements;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@value='Register new account']")
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_new_account_button")
    private WebElement registerBtn;

    @iOSXCUITFindBy(xpath = "")
    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_cancel_button")
    private WebElement cancelBtn;

    private AppiumDriver appiumDriver;

    public RegistrationPage(AppiumDriver appiumDriver) {
        PageFactory.initElements( new AppiumFieldDecorator(appiumDriver), this);
        this.appiumDriver = appiumDriver;
    }

    public void fillRegistrationFields(User user) {
        appiumDriver.hideKeyboard();
        emailTextField.sendKeys(user.getEmail());
        usernameTextField.sendKeys(user.getUserName());
        pswdTextField.sendKeys(user.getPassword());
        confirmPswdTextField.sendKeys(user.getPassword());
        agreements.click();
    }

    public WebElement getEmailTextField() {
        return emailTextField;
    }

    public WebElement getUsernameTextField() {
        return usernameTextField;
    }

    public WebElement getPswdTextField() {
        return pswdTextField;
    }

    public WebElement getConfirmPswdTextField() {
        return confirmPswdTextField;
    }

    public WebElement getRegisterBtn() {
        return registerBtn;
    }

    public WebElement getCancelBtn() {
        return cancelBtn;
    }
}
