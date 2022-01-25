package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegistriesPage extends BasePage{

    @FindBy(xpath = "//input[contains(@class,'gr-text gr-text')]")
    private WebElement registrantNameInputField;

    @FindBy(xpath = "//select[@name='searchUrl']")
    private WebElement typeOfRegistryDropdownMenu;

    @FindBy(xpath = "//button[contains(@class,'gr-btn gr-btn--rounded')]")
    private WebElement searchButton;

    @FindBy(xpath = "//div[contains(@class,'gr-search-registry-no-result-ti')]")
    private WebElement messageField;


    public RegistriesPage(WebDriver driver) {
        super(driver);
    }

    public boolean isRegistrantNameInputFieldVisible(){
        return registrantNameInputField.isDisplayed();
    }

    public void enterNameIntoRegistrantNameField(final String name){
        registrantNameInputField.sendKeys(name);
    }

    public void chooseBirthdayFromRegistryMenu(final String typeOfGift){
        Select birthday = new Select(typeOfRegistryDropdownMenu);
        birthday.selectByVisibleText(typeOfGift);
    }

    public void clickSearchButton(){
        searchButton.click();
    }

    public WebElement getMessageField(){
        return messageField;
    }

    public String getTextFromMessageField(){
        return messageField.getText();
    }

}
