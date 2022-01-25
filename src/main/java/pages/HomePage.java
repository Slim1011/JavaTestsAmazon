package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    private WebElement searchField;

    @FindBy(xpath = "//input[@id='nav-search-submit-button']")
    private WebElement searchButton;

    @FindBy(xpath = "//a[@id='nav-link-accountList']")
    private WebElement signInButton;

    @FindBy(xpath = "//a[@id='nav-hamburger-menu']")
    private WebElement hamburgerMenu;

    @FindBy(xpath = "//div[text()='Computers']")
    private WebElement computersSubMenu;

    @FindBy(xpath = "//a[text()='Computers & Tablets']")
    private WebElement computersAndTabletsSubMenu;

    @FindBy(xpath = "//a[text()='Registry']")
    private WebElement registryButton;

    @FindBy(xpath = "//a[@id='icp-touch-link-country']")
    private WebElement countryChangeButton;

    @FindBy(xpath = "//span[@class='nav-logo-locale']")
    private WebElement homePageLogoButton;

    @FindBy(xpath = "//a[@id='icp-touch-link-language']")
    private WebElement languageButton;

    @FindBy(xpath = "//div[@id='nav-cart-text-container']//span[@class='nav-line-2']")
    private WebElement cartButton;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage(String url){
        driver.get(url);
    }

    public boolean isSearchFieldIsVisible(){
      return searchField.isDisplayed();
    }

    public void enterTextToSearchField(final String searchText){
        searchField.clear();
        searchField.sendKeys(searchText);
    }

    public void clickSearchButton(){
        searchButton.click();
    }

    public void isSignInButtonVisible(){
        signInButton.isDisplayed();
    }

    public void clickSignInButton(){
        signInButton.click();
    }

    public void clickHamburgerMenu(){

        hamburgerMenu.click();
    }

    public void clickComputersSubMenu(){
        computersSubMenu.click();
    }

    public WebElement getComputersAndTabletsSubMenu(){
       return computersAndTabletsSubMenu;
    }

    public void clickComputersAndTabletsSubMenu(){
        computersAndTabletsSubMenu.click();
    }

    public boolean isRegistryButtonVisible(){
        return registryButton.isDisplayed();
    }

    public void clickRegistryButton(){

        registryButton.click();
    }

    public boolean isCountryChangeButtonVisible(){
        return countryChangeButton.isDisplayed();
    }

    public void clickChangeOfCountryButton(){
        countryChangeButton.click();
    }

    public String getTextFromLogoButton(){
        return homePageLogoButton.getText();
    }

    public boolean isLanguageButtonVisible(){
       return languageButton.isDisplayed();
    }

    public void clickLanguageButton(){
        languageButton.click();
    }

    public String getCartButtonText(){
        return cartButton.getText();
    }

}
