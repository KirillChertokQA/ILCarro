package pages;

import dto.CarDto;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.io.File;

public class LetTheCarWorkPage extends BasePage {

    public LetTheCarWorkPage(WebDriver driver) {
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(id = "pickUpPlace")
    WebElement inputLocation;
    @FindBy(id = "make")
    WebElement inputManufacture;
    @FindBy(id = "model")
    WebElement inputModel;
    @FindBy(id = "year")
    WebElement inputYear;
    @FindBy(id = "fuel")
    WebElement inputFuel;
    @FindBy(id = "seats")
    WebElement inputSeats;
    @FindBy(id = "class")
    WebElement inputCarClass;
    @FindBy(id = "serialNumber")
    WebElement inputSerialNumber;
    @FindBy(id = "price")
    WebElement inputPrice;
    @FindBy(id = "about")
    WebElement inputAbout;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement clickBtnSubmit;
    @FindBy(xpath = "//div[@class='dialog-container']/h2")
    WebElement textPopUp_AddSuccess;

    @FindBy(id = "photos")
    WebElement inputPhoto;

    @FindBy(xpath = "//div[@class='dialog-container']/h1" )
    WebElement textPopUp_AddFailed;

    public void typeAddNewCarForm(CarDto car) {
        inputLocation.sendKeys(car.getCity());
//        pause(2);
//        driver.findElement(By.xpath("//div[@class='pac-item']")).click();
        clickWait(By.xpath("//div[@class='pac-item']"), 3);
        inputManufacture.sendKeys(car.getManufacture());
        inputModel.sendKeys(car.getModel());
        inputYear.sendKeys(car.getYear());
        //------------------------
        inputFuel.click();
        clickWait(By.xpath(car.getFuel()),3);
        //-----------------------------
        //inputFuel.sendKeys(car.getFuel());
        //driver.findElement(By.xpath())
        inputSeats.sendKeys(String.valueOf(car.getSeats()));
        inputCarClass.sendKeys(car.getCarClass());
        inputSerialNumber.sendKeys(car.getSerialNumber());
        inputPrice.sendKeys(Double.toString(car.getPricePerDay()));
        inputAbout.sendKeys(car.getAbout());
        //----------------------------
        File file = new File("src/test/resources/"+car.getImage());
        System.out.println(file.getAbsolutePath());
        inputPhoto.sendKeys(file.getAbsolutePath());

    }

    public LetTheCarWorkPage clickBtnSubmitPositive() {
        clickWait(clickBtnSubmit, 3);
        return this;
    }

    public boolean isTextInElementPresent_AddSuccess(String text) {
        return isTextInElementPresent(textPopUp_AddSuccess, text);
    }

    public boolean clickBtnSubmitNegative() {
        return clickBtnSubmit.isEnabled();
    }

    public boolean isTextInElementPresent_AddFailed(String text) {
        return isTextInElementPresent(textPopUp_AddFailed, text);
    }
}