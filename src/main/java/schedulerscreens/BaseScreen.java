package schedulerscreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//ne opisuvaet ni odin screen, on bazovuj class
public class BaseScreen {

    AppiumDriver<MobileElement> driver;

    public BaseScreen(AppiumDriver<MobileElement> driver) //konstruktor po appium driver
    {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    public void type(MobileElement element, String text){
        if(text!=null){
            element.click();
            element.clear();
            element.sendKeys(text);
        }
    }

    public void should(MobileElement element, int time){
        new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOf(element));
    }
public void hideKeyBoard(){
        driver.hideKeyboard();//skritj klaviatyry
}
public void shouldHave(MobileElement element, String text, int time){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.textToBePresentInElement(element,text));
}

}