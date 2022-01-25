package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CustomerPreferencesPage extends BasePage{


    @FindBy(xpath = "//span[@data-action='a-dropdown-button']")
    private WebElement currencyDropdownMenu;

    @FindBy(xpath = "//input[@class='a-button-input']")
    private WebElement saveChangesButton;

    @FindBy(xpath = "//li[@class='a-dropdown-item']")
    private List<WebElement> currencySettingsDropdownMenu;

    @FindBy(xpath = "//select[@id='icp-dropdown']")
    private WebElement countriesDropdownMenu;

    @FindBy(xpath = "//input[@class='a-button-input']")
    private WebElement goToWebsiteButton;

    @FindBy(xpath = "//span[@class='a-label a-radio-label']")
    private List<WebElement> languagesList;


    Actions action = new Actions(driver) ;

    public CustomerPreferencesPage(WebDriver driver) {
        super(driver);
    }

    public void clickToCurrencySettingsMenu(){
        currencyDropdownMenu.click();
    }

    public void chooseTypeOfCurrencyFromDropdownMenu(final String currencyType){

        for (WebElement currency: currencySettingsDropdownMenu) {
           if (currency.getText().contains(currencyType)){
                currency.click();
           }
        }
    }

    public void clickSaveChangesButton(){
        saveChangesButton.click();
    }

    public boolean isGoToWebsiteButtonVisible(){
        return goToWebsiteButton.isDisplayed();
    }

    public void chooseCountryFromList(final String country){
        Select countriesList = new Select(countriesDropdownMenu);
        countriesList.selectByVisibleText(country);
    }

    public void goToWebsiteButtonClick(){
        goToWebsiteButton.click();
    }

    public void closeDropDown(){

        action.moveByOffset(350 , 0).click().perform();
    }

    public boolean isSaveChangeButtonVisible(){
        return saveChangesButton.isDisplayed();
    }

    public void getLanguage(final String language){
        for(WebElement lang : languagesList){
            if(lang.getText().contains(language)){
                lang.click();
            }
        }
    }

}
