package tests;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class SearchCarTests extends ApplicationManager {

    HomePage homePage;

    @Description("positive method search car")
    @Owner("QA Kirill")
    @Test
    public void searchCarPositiveTest(){
        Allure.step("fill search car form");
        homePage = new HomePage(getDriver());
        homePage.fillSearchCarFormCalendar("Haifa", "3 Nov 2024", "23 Jun 2025");
        Assert.assertTrue(homePage.validateUrlContainsResults());
    }

    @Description("negative method search car")
    @Owner("QA-44")
    @Test(expectedExceptions = {org.openqa.selenium.NoSuchElementException.class})
    public void searchCarNegativeTest_wrongDate(){
        Allure.step("fill search car form");
        homePage = new HomePage(getDriver());
        Allure.step("create home page");
        homePage.fillSearchCarFormCalendar("Haifa", "3 Nov 2023", "23 Jun 2025");
    }

    @Test
    public void searchCarPositiveTestWOCalendar(){
        homePage = new HomePage(getDriver());
        homePage.fillInputDateWOCalendar("Tel-Aviv", "11/3/2024 - 6/23/2025");
        Assert.assertTrue(homePage.validateUrlContainsResults());
    }
}
