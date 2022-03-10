package schedulerscreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class WizardScreen extends BaseScreen {
    public WizardScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='il.co.inetex.scheduler:id/wizard_settings_skip_container']")
    MobileElement skipButton;


    public HomeScreen skipWizard() {

        if(isDisplayedWithExp(skipButton)) {
            skipButton.click();//perehodim na HomeScreen
        }
        return new HomeScreen(driver);
    }
}
