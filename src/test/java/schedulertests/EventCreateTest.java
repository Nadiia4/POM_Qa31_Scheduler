package schedulertests;

import models.Auth;
import models.Event;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import scheduler.SSConfiguration;
import schedulerscreens.HomeScreen;
import schedulerscreens.LoginScreen;

public class EventCreateTest extends SSConfiguration {

    @BeforeMethod
    public void preCondition(){
//login
//        new LoginScreen(driver)
//                .complexLogin(Auth.builder()
//                        .email("wick@gmail.com")
//                        .password("Ww12345$")
//                        .build());


        boolean isFabButtonPresent = new LoginScreen(driver)
                .fillEmail("wick@gmail.com")
                .fillPassword("Ww12345$")
                .clickLoginBtn()
                .skipWizard()
                .isFabButtonPresent();
        Assert.assertTrue(isFabButtonPresent);

    }


    @Test
    public void createNewEventTest(){
       boolean isEventCreated =  new HomeScreen(driver)
        .initCreationEvent()////otobrazitj formy
        .createNewEvent(Event.builder()
                .title("Event")
                .type("WWWW")
                .breaks(2)
                .wage(44).build())
                .isFabButtonPresent();

        Assert.assertTrue(isEventCreated);

    }

}
