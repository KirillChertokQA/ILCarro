package tests;

import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import utils.TestNGListener;

import java.util.Random;

import static utils.PropertiesReader.getProperty;

@Listeners(TestNGListener.class)

public class RegistrationTests extends ApplicationManager {

    @Test
    public void registrationPositiveTest(){
        int i = new Random().nextInt(1000);
        String email = "frodo_baggins" +i+"@gmail.com";
        Assert.assertTrue(new HomePage(getDriver()).clickBtnRegistration()
                .typeRegistrationForm("Kirill", "K",email,
                        getProperty("data.properties", "password"))
                .clickCheckBox()
                .clickBtnYalla().isTextInElementPresent_regSuccess());
    }
}
