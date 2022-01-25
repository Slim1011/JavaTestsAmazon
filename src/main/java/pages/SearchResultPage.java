package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SearchResultPage extends BasePage{


    @FindBy(xpath = "//div[contains(@class,'s-result-item s-asin sg-col-0-of-12 sg-col-16-of-20 s')]")
    private List<WebElement> resultList;

    @FindBy(xpath = "(//div[@class='a-row a-size-base a-color-base'])[1]")
    private WebElement priceSymbol;

    @FindBy(xpath = "//a[@id='icp-touch-link-cop']")
    private WebElement changeCurrencyButton;

    @FindBy(xpath = "//span[text()='HP']")
    private WebElement hpCheckBox;

    @FindBy(xpath = "//div[@class='a-section a-spacing-medium']")
    private List<WebElement> productResultList;

    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//span[@id='nav-cart-count']")
    private WebElement cartItemNumber;

    @FindBy(xpath = "//a[@id='attach-close_sideSheet-link']")
    private WebElement cartSidePanel;

    @FindBy(xpath = "//input[@id='low-price']")
    private WebElement minPriceWindow;

    @FindBy(xpath = "//input[@id='high-price']")
    private WebElement maxPriceWindow;

    @FindBy(xpath = "//input[@class='a-button-input']")
    private WebElement goButton;

    @FindBy(xpath = "//span[@class='a-price-whole']")
    private List<WebElement> pricesList;

    @FindBy(xpath = "//a[@id='nav-global-location-popover-link']")
    private WebElement locationButton;

    @FindBy(xpath = "//select[@class='a-native-dropdown']")
    private WebElement countriesList;

    @FindBy(xpath = "//button[@name='glowDoneButton']")
    private WebElement doneButton;

    @FindBy(xpath = "//span[@class='a-size-small']")
    private List<WebElement> shippingList;


    private static final long DEFAULT_TIMEOUT = 60;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getResultList(){
        return resultList;
    }

    public String getPriceSymbolText(){
        return priceSymbol.getText();
    }

    public void clickChangeCurrencyButton(){
        changeCurrencyButton.click();
    }

    public void clickHpCheckBox(){
        hpCheckBox.click();
    }

    public void clicksOnFirstItem(){
        productResultList.get(0).click();
    }

    public void clickAddToCartButton(){
        addToCartButton.click();
    }

    public String getCartItemNumber(){
       return cartItemNumber.getText();
    }

    public WebElement getCartItem(){
        return cartItemNumber;
    }

    public WebElement getCartSidePanel(){
        return cartSidePanel;
    }

    public void closeCartSidePanel(){
        cartSidePanel.click();
    }

    public void sendKeyIntoMinWindow(final String minPrice){
        minPriceWindow.sendKeys(minPrice);
    }

    public void sendKeyIntoMaxWindow(final String maxPrice){
        maxPriceWindow.sendKeys(maxPrice);
    }

    public void clickGoButton(){
        goButton.click();
    }

    public List<WebElement> getPricesList(){
        return pricesList;
    }

    public boolean isLocationButtonVisible(){
        return locationButton.isDisplayed();
    }

    public void clickLocationButton(){
        locationButton.click();
    }

    public WebElement getCountriesList(){
        return countriesList;
    }

    public void chooseCountryFromList(final String country){
        Select newCountry = new Select(countriesList);
        newCountry.selectByVisibleText(country);
    }

    public void clickDoneButton(){
        doneButton.click();
    }

    public WebElement getFirstSearchedElement(){
        return shippingList.get(0);
    }

    public String getTextFromFirstSearchElement(){
        return shippingList.get(0).getText();
    }

}


