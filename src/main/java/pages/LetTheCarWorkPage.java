package pages;

import dto.CarDto;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

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
    @FindBy(xpath = "//button[text()='Submit']")
    WebElement clickBtnSubmit;
    @FindBy(xpath = "//h1[text()='Car added']")
    WebElement textPopUp_AddSuccess;

    public void typeAddNewCarForm(CarDto car) {
        inputLocation.sendKeys(car.getCity());
        pause(2);
        driver.findElement(By.xpath("//div[@class='pac-item']")).click();
        inputManufacture.sendKeys(car.getManufacture());
        inputModel.sendKeys(car.getModel());
        inputYear.sendKeys(car.getYear());
        inputFuel.sendKeys(car.getFuel());
        //driver.findElement(By.xpath())
        inputSeats.sendKeys(String.valueOf(car.getSeats()));
        inputCarClass.sendKeys(car.getCarClass());
        inputSerialNumber.sendKeys(car.getSerialNumber());
        inputPrice.sendKeys(String.valueOf(car.getPricePerDay()));
        inputAbout.sendKeys(car.getAbout());

    }

    public LetTheCarWorkPage clickBtnSubmitPositive() {
        clickBtnSubmit.click();
        return this;
    }

    public boolean isTextInElementPresent_AddSuccess() {
        return isTextInElementPresent(textPopUp_AddSuccess, "Car added");
    }
}