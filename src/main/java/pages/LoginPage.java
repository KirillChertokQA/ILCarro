package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver){
        setDriver(driver);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10),this);
    }

    @FindBy(xpath = "//input[@formcontrolname='email']")
    WebElement inputEmail;

    @FindBy(xpath = "//input[@formcontrolname='password']")
    WebElement inputPassword;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement btnYallaSubmit;

    public LoginPage typeLoginForm(String email, String password){
        inputEmail.sendKeys(email);
        inputPassword.sendKeys(password);
        return this;
    }

    public LoginPage clickBtnLoginPositive(){
        btnYallaSubmit.click();
        return new LoginPage(driver);
    }

    public boolean isElementYallaPresent(){
        return btnYallaSubmit.isDisplayed();
}
}
