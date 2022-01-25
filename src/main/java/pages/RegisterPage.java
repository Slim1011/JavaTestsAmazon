package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends BasePage{


    @FindBy(xpath = "//input[@name='customerName']")
    private WebElement yourNameField;

    @FindBy(xpath = "//input[@id='ap_password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='ap_password_check']")
    private WebElement reenterPasswordField;

    @FindBy(xpath = "//input[@id='continue']")
    private WebElement continueButton;

    @FindBy(xpath = "//div[contains(text(),'Enter your email')]")
    private WebElement emailFieldErrorMessage;


    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void enterNameIntoYourNameField(final String name){
        yourNameField.clear();
        yourNameField.sendKeys(name);
    }

    public void enterPasswordIntoPasswordField(final String password){
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void enterPasswordIntoReenterPasswordField(final String password){
        reenterPasswordField.clear();
        reenterPasswordField.sendKeys(password);
    }

    public void clickContinueButton(){
        continueButton.click();
    }

    public String getTextFromEmailErrorMessage(){
       return emailFieldErrorMessage.getText();
    }

}


