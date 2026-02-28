package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AllFilterPage extends BasePage {
    private static final Logger log = LogManager.getLogger(DashboardPage.class);

    @FindBy(xpath = "//*[@aria-label='Condition']")
    private WebElement filterConditionDropdown;

    @FindBy(xpath = "//label[@for='group-checkbox-New']")
    private WebElement checkboxConditionNew;

    @FindBy(xpath = "//*[@aria-label='Price']")
    private WebElement filterPriceDropdown;

    @FindBy(xpath = "//label[contains(@for, 'under-idr')]")
    private WebElement radioBtnPriceUnder;

    @FindBy(xpath = "//h3[@class='seo-accordion__title' and @aria-label='Item location']")
    private WebElement filterItemLocationDropdown;

    @FindBy(xpath = "//label[contains(@for, 'worldwide')]")
    private WebElement radioBtnItemLocationWorldwide;

    @FindBy(xpath = "//button[@class='btn-submit btn btn--primary']")
    private WebElement applyButton;

    public AllFilterPage(WebDriver driver) {
        super(driver);
    }

    public void scrollToElement(WebElement element) {
        try {
            new Actions(driver).moveToElement(element).perform();
        } catch (Exception e) {
            // fallback jika elemen masih jauh di bawah
            new Actions(driver).scrollByAmount(0, 400).perform();
        }
    }

    public void filterCondition(){
        waitForVisibility(filterConditionDropdown);
        filterConditionDropdown.click();
        waitForVisibility(checkboxConditionNew);
        checkboxConditionNew.click();
    }

    public void filterPrice(){
        filterPriceDropdown.click();
        waitForVisibility(radioBtnPriceUnder);
        radioBtnPriceUnder.click();
    }

    public void filterLocation(){
        waitForClickable(filterItemLocationDropdown);
//        scrollToElement(filterItemLocationDropdown);
        filterItemLocationDropdown.click();

        waitForClickable(radioBtnItemLocationWorldwide);
//        scrollToElement(radioBtnItemLocationWorldwide);
        radioBtnItemLocationWorldwide.click();
    }

    public void clickApplyFilter(){
        applyButton.click();
    }

}
