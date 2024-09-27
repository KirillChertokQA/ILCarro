package tests;

import dto.CarDto;
import manager.ApplicationManager;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LetTheCarWorkPage;
import utils.Fuel;
import utils.HeaderMenuItem;

import java.util.Random;

import static pages.BasePage.clickButtonsOnHeader;

public class AddNewCarTests extends ApplicationManager {



    LetTheCarWorkPage letTheCarWorkPage;
    @BeforeMethod
    public void startAddCar(){
        new HomePage(getDriver()).clickBtnLoginHeader().typeLoginForm("kirill@gmail.com", "Password123!")
                .clickBtnLoginPositive();
        letTheCarWorkPage = clickButtonsOnHeader((HeaderMenuItem.LET_THE_CAR_WORK));
    }

    @Test
    public void addNewCarPositiveTest(){
        CarDto car = CarDto.builder()
                .city("Tel Aviv")
                .manufacture("Toyota")
                .model("Prius")
                .year("2019")
                .fuel(Fuel.DIESEL.getLocator())
                .seats(5)
                .carClass("C-class")
                .serialNumber("1225-"+new Random().nextInt(1000))
                .pricePerDay(1000)
                .about("text")
                .image("novi2.jpg")
                .build();
       letTheCarWorkPage.typeAddNewCarForm(car);
       letTheCarWorkPage.clickBtnSubmitPositive();
        Assert.assertTrue(letTheCarWorkPage.isTextInElementPresent_AddSuccess(car.getManufacture()+" "+car.getModel()+" added successful"));

    }
}
