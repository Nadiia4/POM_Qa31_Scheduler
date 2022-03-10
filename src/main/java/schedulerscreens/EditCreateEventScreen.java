package schedulerscreens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.Event;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EditCreateEventScreen extends BaseScreen {
    public EditCreateEventScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    //@FindBy(how = How.XPATH, using = "//*[resource-id='il.co.inetex.scheduler:id/info_title_input']")
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.EditText[1]")
    MobileElement title;

    //@FindBy(how = How.XPATH, using = "//*[resource-id='il.co.inetex.scheduler:id/info_type_input']")
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.EditText[2]")
    MobileElement type;

   // @FindBy(how = How.XPATH, using = "//*[resource-id='il.co.inetex.scheduler:id/info_break_plus_btn']")
    @FindBy(xpath = "//android.widget.ImageView[@content-desc='Add break']")
    MobileElement breaksPlusBtn;

    //@FindBy(how = How.XPATH, using = "//*[resource-id='il.co.inetex.scheduler:id/info_wage_edit']")
    @FindBy(xpath = "//android.widget.ImageView[@content-desc='Edit wage']")
    MobileElement wageEdit;

    //@FindBy(how = How.XPATH, using = "//*[resource-id='il.co.inetex.scheduler:id/info_wage_input']")
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.widget.EditText")
    MobileElement wageInput;

    //@FindBy(how = How.XPATH, using = "//*[resource-id='il.co.inetex.scheduler:id/info_wage_save']")
    @FindBy(xpath = "//android.widget.ImageView[@content-desc='Save wage']")
    MobileElement wageSave;

    //@FindBy(how = How.XPATH, using = "//*[resource-id='il.co.inetex.scheduler:id/info_save_btn']")
    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.Button")
    MobileElement confirmCreation;

    public HomeScreen createNewEvent(Event event) {
        //fill form + click addButton ---> HomeScreen

        should(title,25);
        type(title,event.getTitle());
        type(type, event.getType());
        hideKeyBoard();//zakrit klaviatyry

        int breaks = event.getBreaks();

        if(breaks >0 && breaks<5){
            for (int i = 0; i < breaks; i++) {
        breaksPlusBtn.click();
            }
        }

        wageEdit.click();
        type(wageInput, String.valueOf(event.getWage()));
        wageSave.click();
        confirmCreation.click();

        return new HomeScreen(driver);
    }
}
