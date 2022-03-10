package schedulerscreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class HomeScreen extends BaseScreen {

    public HomeScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@resource-id='il.co.inetex.scheduler:id/fab_main']")
    MobileElement fabAdd;

    @FindBy(xpath = "//*[@resource-id='il.co.inetex.scheduler:id/fab_add_event']")
    MobileElement fabAddEvent;

    @FindBy(xpath = "//*[@content-desc = 'Open']")
    MobileElement burgerMenu;
    @FindBy(xpath = "//*[@resource-id = 'il.co.inetex.scheduler:id/nav_fr_logout']")
    MobileElement logout;

    public boolean isFabButtonPresent(){

        should(fabAdd, 20);
        return fabAdd.isDisplayed();
    }

    public HomeScreen openMenu(){
        burgerMenu.click();
        return this;
    }

    public LoginScreen logOut(){

        logout.click();
        return new LoginScreen(driver);
    }

    public EditCreateEventScreen initCreationEvent(){

        should(fabAdd, 30);
        fabAdd.click();
        fabAddEvent.click();

        return new EditCreateEventScreen(driver);
    }
}
