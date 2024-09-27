package pages;

import dto.UserDto;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static java.awt.SystemColor.text;

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

    @FindBy(xpath = "//h2[@class='message']")
    WebElement textPopUp_LoginSuccess;

    @FindBy(xpath = "//input[@id='email']/..//div[@class='error']/div")
    WebElement errorMessageInputEmail;

    public LoginPage typeLoginForm(String email, String password){
        inputEmail.sendKeys(email);
        inputPassword.sendKeys(password);
        return this;
    }

    public LoginPage typeLoginForm(UserDto user){
        inputEmail.sendKeys(user.getEmail());
        inputPassword.sendKeys(user.getPassword());
        return this;
    }

    public LoginPage clickBtnLoginPositive(){
//        pause(3);
//        btnYallaSubmit.click();
        clickWait(btnYallaSubmit,3);
        return this;
    }

    public boolean isTextInElementPresent_LoginSuccess(){
        return isTextInElementPresent(textPopUp_LoginSuccess, "Logged in success");
    }

    public boolean isTextInElementPresent_ErrorEmail(String text){
        return isTextInElementPresent(errorMessageInputEmail, text);
    }


}
