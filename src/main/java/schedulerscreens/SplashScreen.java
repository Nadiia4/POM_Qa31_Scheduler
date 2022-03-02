package schedulerscreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class SplashScreen extends BaseScreen {

    public SplashScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id = 'il.co.inetex.scheduler:id/app_version_res']")
    MobileElement versionTextView;

    public String getCurrencyVersion() {

        return versionTextView.getText();
    }

    public LoginScreen checkVersion(String version) {
        shouldHave(versionTextView,version,20);
        return new LoginScreen(driver);
    }
}



