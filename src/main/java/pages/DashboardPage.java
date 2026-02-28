package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPage extends BasePage{
    private static final Logger log = LogManager.getLogger(DashboardPage.class);

    @FindBy (xpath = "//input[@id='gh-ac']")
    private WebElement searchKeywordField;

    @FindBy (xpath = "//select[@id='gh-cat']")
    private WebElement categoryProductSearch;

    @FindBy (xpath = "//option[normalize-space()='Computers/Tablets & Networking']")
    private WebElement computerTabletNetworkingCategoryProduct;

    @FindBy (xpath = "//span[@class='gh-search-button__label']")
    private WebElement searchSubmitButton;

    @FindBy (xpath = "//span[@class='gh-categories__title']")
    private WebElement categoryDropdownMenu;

    @FindBy (xpath = "//a[normalize-space()='Cell Phones, Smart Watches & Accessories']")
    private WebElement cellPhonesCategoryLink;


    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public void navigateCellPhonesCategory() {
        log.info("Open category dropdown menu");
        waitForClickable(categoryDropdownMenu);
        categoryDropdownMenu.click();

        log.info("Selecting Cell Phones & Accessories category");
        waitForClickable(cellPhonesCategoryLink);
        cellPhonesCategoryLink.click();
    }

    public void serachProductByKeyword (String keyword){
        log.info("Searching product with keyword: {}", keyword);
        waitForClickable(searchKeywordField);
        searchKeywordField.clear();
        searchKeywordField.sendKeys(keyword);
    }

    public void selectSearchCategory(){
        categoryProductSearch.click();
        waitForClickable(computerTabletNetworkingCategoryProduct);
        log.info("Select Category Computers/Tablets & Networking");
        computerTabletNetworkingCategoryProduct.click();

    }

    public void clickSerachSubmitButton(){
        waitForClickable(searchSubmitButton);
        log.info("Click Serach Button");
        searchSubmitButton.click();
    }

    public void searchProduct(String keyword) {
        log.info("Searching product with keyword: {}", keyword);

        waitForClickable(searchKeywordField);
        searchKeywordField.clear();
        searchKeywordField.sendKeys(keyword);

        waitForClickable(searchSubmitButton);
        searchSubmitButton.click();
    }


}
