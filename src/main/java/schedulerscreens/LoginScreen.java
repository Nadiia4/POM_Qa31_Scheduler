package schedulerscreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.Auth;
import org.openqa.selenium.support.FindBy;

public class LoginScreen extends BaseScreen {

    public LoginScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }//konstryktor super classa

    // @FindBy(xpath = "//*[resource-id='il.co.inetex.scheduler:id/log_email_input']")
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[1]")
    MobileElement emailEditText;
    // @FindBy(xpath = "//*[resource-id='il.co.inetex.scheduler:id/log_password_input']")
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText[2]")
    MobileElement passwordEditText;
    //  @FindBy(xpath = "//*[resource-id='il.co.inetex.scheduler:id/login_btn']")
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.Button")
    MobileElement loginButton;
    @FindBy(xpath = "//*[@resource-id='android:id/message']")
    MobileElement errorMessage;
    @FindBy(xpath = "//*[@resource-id='android:id/button1']")
    MobileElement okBtn;

    public LoginScreen fillEmail(String email) {
        //wait + fill email
        should(emailEditText, 30);
        type(emailEditText, email);
        return this;
    }

    public LoginScreen fillPassword(String password) {
        //fill password
        type(passwordEditText, password);
        return this;

    }

    public WizardScreen clickLoginBtn() {
        //click
        hideKeyBoard();//skritj klaviatyry
        loginButton.click();
        return new WizardScreen(driver);
    }

    public WizardScreen complexLogin(Auth auth) {
        should(emailEditText, 30);
        type(emailEditText, auth.getEmail());
        type(passwordEditText, auth.getPassword());
        hideKeyBoard();//skritj klaviatyry
        loginButton.click();

        return new WizardScreen(driver);

    }

    public boolean isLoginButton() {

        return loginButton.isDisplayed();
    }

    public LoginScreen complexLoginWithErrorMessage(Auth auth) {

        should(emailEditText, 30);
        type(emailEditText, auth.getEmail());
        type(passwordEditText, auth.getPassword());
        hideKeyBoard();//skritj klaviatyry
        loginButton.click();

        return this;
    }

    public LoginScreen checkErrorMessage(String text) {

        shouldHave(errorMessage, text, 15);
        return this;
    }

    public LoginScreen confirmErrorMessage(){

        okBtn.click();
        return  this;
    }
}