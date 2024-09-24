package tests;

import dto.CarDto;
import manager.ApplicationManager;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LetTheCarWorkPage;
import utils.HeaderMenuItem;

import static pages.BasePage.clickButtonsOnHeader;

public class AddNewCarTests extends ApplicationManager {

    LetTheCarWorkPage letTheCarWorkPage;
    @BeforeMethod
    public void startAddCar(){
        new HomePage(getDriver());
        letTheCarWorkPage = clickButtonsOnHeader((HeaderMenuItem.LET_THE_CAR_WORK));
    }

    @Test
    public void addNewCarPositiveTest(){
        CarDto car = CarDto.builder()
                .city("Tel ")
                .manufacture("Toyota")
                .model("Prius.jpg")
                .year("2019")
                .fuel("")
                .seats(5)
                .carClass("C-class")
                .serialNumber("1222")
                .pricePerDay(1000)
                .about("text")
                //.carPhotoPath("Prius.jpg")
                .build();
        letTheCarWorkPage.typeAddNewCarForm(car);
    }
}
