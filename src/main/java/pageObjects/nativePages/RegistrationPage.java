package pageObjects.nativePages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pojos.User;

public class RegistrationPage {

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_email")
    private WebElement emailTextField;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_username")
    private WebElement usernameTextField;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_password")
    private WebElement pswdTextField;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_confirm_password")
    private WebElement confirmPswdTextField;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_new_account_button")
    private WebElement registerBtn;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_cancel_button")
    private WebElement cancelBtn;

    public RegistrationPage(AppiumDriver appiumDriver) {
        PageFactory.initElements( new AppiumFieldDecorator(appiumDriver), this);
    }

    public void fillRegistrationFields(User user) {
        emailTextField.sendKeys(user.getEmail());
        usernameTextField.sendKeys(user.getUserName());
        pswdTextField.sendKeys(user.getPassword());
        confirmPswdTextField.sendKeys(user.getPassword());
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
