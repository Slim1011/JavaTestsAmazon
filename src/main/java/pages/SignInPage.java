package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage{

    @FindBy(xpath = "//a[@id='createAccountSubmit']")
    private WebElement signInButton;


    public SignInPage(WebDriver driver) {
        super(driver);
    }

    public void clickSignInButton(){
        signInButton.click();
    }

}
