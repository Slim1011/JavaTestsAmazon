package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import manager.PageFactoryManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.ArrayList;
import java.util.List;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DefinitionSteps {

    private static final long DEFAULT_TIMEOUT = 60;

    WebDriver driver;
    HomePage homePage;
    SearchResultPage searchResultPage;
    SignInPage signInPage;
    RegisterPage registerPage;
    CustomerPreferencesPage customerPreferencesPage;
    RegistriesPage registriesPage;
    PageFactoryManager pageFactoryManager;

    @Before
    public void testsSetUp(){
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @After
    public void tearDown(){driver.quit();}

    @And("User opens {string} page")
    public void openPage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @And("User checks search field visibility")
    public void isSearchFieldVisible() {
       assertTrue(homePage.isSearchFieldIsVisible());
    }

    @And("User makes search by keyword {string}")
    public void makeSearchByKeyword(final String keyword) {
       homePage.enterTextToSearchField(keyword);
    }

    @And("User clicks search button")
    public void clicksSearchButton() {
        homePage.clickSearchButton();
    }

    @And("User checks that current URL contains search word {string}")
    public void checksCurrentUrl(final String searchWord) {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(driver.getCurrentUrl().contains(searchWord));
    }

    @And("User checks that amount of products in search page are equal to expected amount{string}")
    public void checksThatAmountOfProductsIsCorrect(String amountOfProducts) {
        searchResultPage = pageFactoryManager.getSearchResultPage();
        assertEquals( Integer.parseInt(amountOfProducts), searchResultPage.getResultList().size());
    }

    @And("User checks sign In button visibility")
    public void checkSignInButtonVisibility() {
        homePage.isSignInButtonVisible();
    }

    @And("User clicks sign In button")
    public void clickSignInButton() {
        homePage.clickSignInButton();
    }

    @And("User clicks Create your Amazon account button")
    public void clickCreateYourAmazonAccountButton() {
        signInPage = pageFactoryManager.getSignInPage();
        signInPage.clickSignInButton();
    }

    @And("User enter name {string} into Your name field")
    public void enterNameIntoYourNameField(final String name) {
        registerPage = pageFactoryManager.getRegisterPage();
        registerPage.enterNameIntoYourNameField(name);
    }

    @And("User enter password {string} into Password field")
    public void enterPasswordIntoPasswordField(final String password) {
        registerPage.enterPasswordIntoPasswordField(password);
    }

    @And("User enter password {string} into Reenter Password field")
    public void enterPasswordIntoReenterPasswordField(final String password) {
        registerPage.enterPasswordIntoReenterPasswordField(password);
    }

    @And("User clicks continue button")
    public void clicksContinueButton() {
        registerPage.clickContinueButton();
    }

    @And("User checks that error message {string} is shown")
    public void checkThatEmailErrorMessageIsShown(String expectedErrorMessage) {
      assertTrue(registerPage.getTextFromEmailErrorMessage().contains(expectedErrorMessage));
    }

    @And("User checks actual type of currency {string}")
    public void checkActualTypeOfCurrency(final String actualCurrencyType) {
        searchResultPage = pageFactoryManager.getSearchResultPage();
        assertTrue(searchResultPage.getPriceSymbolText().contains(actualCurrencyType));
    }

    @And("User clicks Change currency button")
    public void clickChangeCurrencyButton() {
        searchResultPage.clickChangeCurrencyButton();
    }

    @And("User clicks currency settings drop - down menu")
    public void clickToCurrencySettingsDropDownMenu() {
        customerPreferencesPage = pageFactoryManager.getCustomerPreferencesPage();
        customerPreferencesPage.clickToCurrencySettingsMenu();
    }

    @And("User choose another currency type {string}")
    public void chooseAnotherCurrency(final String currencyType) {
        customerPreferencesPage.chooseTypeOfCurrencyFromDropdownMenu(currencyType);
    }

    @And("User clicks Save changes button")
    public void clickButtonSaveChanges() {
        customerPreferencesPage.clickSaveChangesButton();
    }


    @And("User checks that product prise contains another currency type {string}")
    public void checkThatProductPriseContainsNewTypeOfCurrency(final String newTypeOfCurrency) {
        assertTrue(searchResultPage.getPriceSymbolText().contains(newTypeOfCurrency));
    }

    @And("User clicks the All menu")
    public void clickAllMenu() {
        homePage.clickHamburgerMenu();
    }

    @And("User clicks on Computers sub-menu")
    public void clickComputersSubMenu() {
        homePage.clickComputersSubMenu();
    }

    @And("User clicks on Computers & Tablets sub-menu")
    public void clickComputersTabletsSubMenu() {
        homePage.waitVisibilityOfElement(DEFAULT_TIMEOUT, homePage.getComputersAndTabletsSubMenu());
        homePage.clickComputersAndTabletsSubMenu();
    }

    @And("User chooses HP brand checkbox for filtering")
    public void clickHpCheckBox() {
        searchResultPage = pageFactoryManager.getSearchResultPage();
        searchResultPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultPage.clickHpCheckBox();
    }

    @And("User clicks on first item after filtering")
    public void clickOnFirstItem() {
        searchResultPage.clicksOnFirstItem();
    }

    @And("User clicks Add to cart button")
    public void clickAddToCartButton() {
        searchResultPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultPage.clickAddToCartButton();
    }

    @And("User checks items count {string} in the cart")
    public void checkItemsCountInTheCart(final String expectedCount){
        searchResultPage.waitVisibilityOfElement(DEFAULT_TIMEOUT,searchResultPage.getCartSidePanel());
        searchResultPage.closeCartSidePanel();
        searchResultPage.waitForText(DEFAULT_TIMEOUT, searchResultPage.getCartItem(),"1");
        assertEquals(expectedCount, searchResultPage.getCartItemNumber());
    }

    @And("User checks registry button visibility")
    public void checkRegistryButtonVisibility() {
        assertTrue(homePage.isRegistryButtonVisible());
    }

    @And("User clicks registry button")
    public void clickRegistryButton() {
        homePage.clickRegistryButton();
    }

    @And("User checks Registrant name input field visibility")
    public void checkRegistrantNameFieldVisibility() {
        registriesPage = pageFactoryManager.getRegistriesPage();
        assertTrue(registriesPage.isRegistrantNameInputFieldVisible());
    }

    @And("User enter incorrect  name {string} into Registrant name field")
    public void enterKeysIntoRegistrantNameField(final String name) {
        registriesPage.enterNameIntoRegistrantNameField(name);
    }

    @And("User choose gift type{string} from dropdown menu")
    public void chooseTypeOfGiftFromDropDownMenu(final String typeOfGift) {
        registriesPage.chooseBirthdayFromRegistryMenu(typeOfGift);
    }

    @And("User clicks button Search")
    public void clickButtonSearch() {
        registriesPage.clickSearchButton();
    }

    @And("User checks that no gifts message {string} is shown")
    public void checkNoGiftsMessage(final String message){
        registriesPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, registriesPage.getMessageField());
        assertEquals(message, registriesPage.getTextFromMessageField());
    }

    @And("User checks Change of country button visibility")
    public void checkChangeOfCountryButtonVisibility() {
        assertTrue(homePage.isCountryChangeButtonVisible());
    }

    @And("User clicks on Change of country button")
    public void clickChangeOfCountryButton() {
        homePage.clickChangeOfCountryButton();
    }

    @And("User checks Go to website button visibility")
    public void isGoToWebsiteButtonVisible(){
        customerPreferencesPage = pageFactoryManager.getCustomerPreferencesPage();
        customerPreferencesPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(customerPreferencesPage.isGoToWebsiteButtonVisible());
    }

    @And("User chooses country {string} from dropdown menu")
    public void chooseCountryFromDropdownMenu(final String country) {
        customerPreferencesPage.chooseCountryFromList(country);
        customerPreferencesPage.closeDropDown();
    }

    @And("User clicks on Go to website button")
    public void clickGoToWebsiteButton() {
        customerPreferencesPage.goToWebsiteButtonClick();
    }

    @And("User switches to another window")
    public void switchToAnotherWindow() {
        ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
    }

    @And("User checks that new web site Amazon logo contains country code {string}")
    public void checkThatAmazonLogoContainsCountryCode( final String countryCode) {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        assertTrue(homePage.getTextFromLogoButton().contains(countryCode));
    }

    @And("User checks that new site current url equals to expected Url {string}")
    public void checkThatNewSiteUrlEqualsExpectedUrl(final String expectedUrl) {
        assertEquals(driver.getCurrentUrl(), expectedUrl);
    }

    @And("User input  minimum price {string} into min price window")
    public void inputPriceIntoMinWindow(final String minPrice) {
        searchResultPage = pageFactoryManager.getSearchResultPage();
        searchResultPage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
        searchResultPage.sendKeyIntoMinWindow(minPrice);
    }

    @And("User input maximum price {string} into max price window")
    public void inputPriceIntoMaxWindow(final String maxPrice) {
        searchResultPage.sendKeyIntoMaxWindow(maxPrice);
    }

    @And("User clicks Go button")
    public void clickGoButton() {
        searchResultPage.clickGoButton();
    }

    @And("User checks that all items from filtered list has price between minimum {string} and maximum {string}")
    public void checksThatAllItemsHasCorrectPrice(final String minPrice, final String maxPrice) {
        List <WebElement> itemsPrices = searchResultPage.getPricesList();
        for ( WebElement price : itemsPrices) {
            String priceStripped = price.getText().replaceAll("[,]", "");
          assertTrue( Integer.parseInt(minPrice) <= Integer.parseInt(priceStripped)
                  && Integer.parseInt(priceStripped) <= Integer.parseInt(maxPrice));
        }
    }

    @And("User checks Language button visibility")
    public void isLanguageButtonVisible() {
        assertTrue(homePage.isLanguageButtonVisible());
    }

    @And("User clicks Language button")
    public void clickLanguageButton() {
        homePage.clickLanguageButton();
    }

    @And("User checks Save changes button visibility")
    public void isSaveChangesButtonVisible() {
        customerPreferencesPage = pageFactoryManager.getCustomerPreferencesPage();
        assertTrue(customerPreferencesPage.isSaveChangeButtonVisible());
    }

    @And("User chooses the language {string} from list")
    public void changeLanguageFromList(final String language) {
        customerPreferencesPage.getLanguage(language);
    }

    @And("User checks that cart button text is translated {string} as expected")
    public void checkThatButtonTextIsTranslated(final String translatedText) {
        homePage.waitForPageLoadComplete(DEFAULT_TIMEOUT);
       assertTrue(homePage.getCartButtonText().contains(translatedText));
    }

    @And("User checks Location button visibility")
    public void isLocationButtonVisible() {
        searchResultPage = pageFactoryManager.getSearchResultPage();
        assertTrue(searchResultPage.isLocationButtonVisible());
    }

    @And("User clicks Location button")
    public void userClicksLocationButton() {
        searchResultPage.clickLocationButton();
    }

    @And("User chooses country of location {string} from dropdown menu in location popup")
    public void chooseCountry(final String country){
        searchResultPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, searchResultPage.getCountriesList());
        searchResultPage.chooseCountryFromList(country);
    }

    @And("User clicks Done button")
    public void clickDoneButton() {
        searchResultPage.clickDoneButton();
    }

    @And("User checks that first item from filtered list has correct shipping location {string}")
    public void checkThatItemHasCorrectLocation(final String locationCountry){
        searchResultPage.waitVisibilityOfElement(DEFAULT_TIMEOUT, searchResultPage.getFirstSearchedElement());
        assertTrue(searchResultPage.getTextFromFirstSearchElement().contains(locationCountry));
    }

}
