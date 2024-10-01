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

import java.lang.reflect.Method;
import java.util.Random;

import static pages.BasePage.clickButtonsOnHeader;

public class AddNewCarTests extends ApplicationManager {



    LetTheCarWorkPage letTheCarWorkPage;
    @BeforeMethod
    public void startAddCar(){
        logger.info("start method --> startAddCar "+"user: "+"kirill@gmail.com");
        new HomePage(getDriver()).clickBtnLoginHeader().typeLoginForm("kirill@gmail.com", "Password123!")
                .clickBtnLoginPositive();
        letTheCarWorkPage = clickButtonsOnHeader((HeaderMenuItem.LET_THE_CAR_WORK));
    }

    @Test
    public void addNewCarPositiveTest(Method method){
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
        logger.info("start -->"+method.getName()+" with data:"+car.toString());
       letTheCarWorkPage.typeAddNewCarForm(car);
       letTheCarWorkPage.clickBtnSubmitPositive();
        Assert.assertTrue(letTheCarWorkPage.isTextInElementPresent_AddSuccess
                (car.getManufacture()+" "+car.getModel()+" added successful"));

    }

    @Test
    public void addNewCarNegativeTest_modelIsEmpty(Method method){
        CarDto car = CarDto.builder()
                .city("Tel Aviv")
                .manufacture("Toyota")
                .model("")
                .year("2019")
                .fuel(Fuel.DIESEL.getLocator())
                .seats(5)
                .carClass("C-class")
                .serialNumber("1225-"+new Random().nextInt(1000))
                .pricePerDay(1000)
                .about("text")
                .image("novi2.jpg")
                .build();
        logger.info("start --> "+method.getName()+" with data:"+car.toString());
        letTheCarWorkPage.typeAddNewCarForm(car);
       Assert.assertFalse(letTheCarWorkPage.clickBtnSubmitNegative());


    }

    @Test
    public void addNewCarNegativeTest_serialNumberExists(Method method){
        CarDto car = CarDto.builder()
                .city("Tel Aviv")
                .manufacture("Toyota")
                .model("Prius")
                .year("2019")
                .fuel(Fuel.DIESEL.getLocator())
                .seats(5)
                .carClass("C-class")
                .serialNumber("1225-")
                .pricePerDay(1000)
                .about("text")
                .image("novi2.jpg")
                .build();
        logger.info("start --> "+method.getName()+" with data:"+car.toString());
        letTheCarWorkPage.typeAddNewCarForm(car);
        letTheCarWorkPage.clickBtnSubmitPositive();
        letTheCarWorkPage.isTextInElementPresent_AddFailed(car.getManufacture()+" "+car.getModel()+" Car adding failed");
    }

    @Test
    public void addNewCarNegativeTest_tooMuchSeats(Method method){
        CarDto car = CarDto.builder()
                .city("Tel Aviv")
                .manufacture("Toyota")
                .model("")
                .year("2019")
                .fuel(Fuel.DIESEL.getLocator())
                .seats(50)
                .carClass("C-class")
                .serialNumber("1225-"+new Random().nextInt(1000))
                .pricePerDay(1000)
                .about("text")
                .image("novi2.jpg")
                .build();
        logger.info("start --> "+method.getName()+" with data:"+car.toString());
        letTheCarWorkPage.typeAddNewCarForm(car);
        Assert.assertFalse(letTheCarWorkPage.clickBtnSubmitNegative());


    }
}
