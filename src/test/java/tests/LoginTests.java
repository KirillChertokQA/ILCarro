package tests;

import dto.UserDto;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.HeaderMenuItem;
import utils.TestNGListener;

import static utils.PropertiesReader.getProperty;
import static utils.RandomUtils.*;

import static pages.BasePage.clickButtonsOnHeader;

@Listeners(TestNGListener.class)

public class LoginTests extends ApplicationManager {

    @Test
    public void LoginPositiveTest(){
        Assert.assertTrue(new HomePage(getDriver()).clickBtnLoginHeader()
                .typeLoginForm(getProperty("data.properties", "email"),
                        getProperty("data.properties", "password"))
                .clickBtnLoginPositive()
                .isTextInElementPresent_LoginSuccess());


    }

    @Test
    public void LoginNegativeTest_wrongEmailWOAt(){
        UserDto user = new UserDto(generateString(5), generateString(7),
                generateString(10), "Qwerty123!");
       Assert.assertTrue(new HomePage(getDriver()).clickBtnLoginHeader()
                .typeLoginForm(user)
                .isTextInElementPresent_ErrorEmail("It'snot look like email"));


    }

    @Test
    public void LoginNegativeTest_wrongEmailWOAt_Enum(){
        UserDto user = new UserDto(generateString(5), generateString(7),
                generateString(10), "Qwerty123!");
       new HomePage(getDriver());
        LoginPage loginPage = clickButtonsOnHeader(HeaderMenuItem.LOGIN);
                loginPage.typeLoginForm(user)
                .isTextInElementPresent_ErrorEmail("It'snot look like email");


    }

}
