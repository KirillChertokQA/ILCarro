package tests;

import manager.ApplicationManager;
import org.testng.annotations.Test;
import pages.HomePage;

public class LoginTests extends ApplicationManager {

    @Test
    public void LoginPositiveTest(){
       new HomePage(getDriver()).clickBtnLoginHeader()
               .typeLoginForm("kirill@gmail.com", "Password123!").clickBtnLoginPositive();


    }

}
