package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CellPhonePage extends BasePage {
    private static final Logger log = LogManager.getLogger(DashboardPage.class);

    @FindBy(xpath = "//a[normalize-space()='Cell Phone Accessories']")
    private WebElement cellPhoneSmartphonesSubCategory;

    @FindBy(xpath = "//button[@class='filter-button filter-button--unselected brwr__all-filters']")
    private WebElement allFilter;

    @FindBy(xpath = "//span[contains(text(),'Condition: New')]")
    private WebElement conditionFilterApplied;

    @FindBy(xpath = "//span[contains(text(),'Price: Under')]")
    private WebElement priceFilterApplied;

    @FindBy(xpath = "//span[contains(text(),'Item location: Worldwide')]")
    private WebElement itemLocFilterApplied;

    @FindBy(xpath = "//button[contains(@class,'filter-button--selected') and contains(., 'filters applied')]")
    private WebElement allFilterApplied;

    public CellPhonePage(WebDriver driver) {
        super(driver);
    }

    public void clickSubCategoryCellPhoneSmartphones(){
        log.info("Click menu smartphone");
        waitForClickable(cellPhoneSmartphonesSubCategory);
        cellPhoneSmartphonesSubCategory.click();
    }

    public void clickAllFilter(){
        waitForClickable(allFilter);
        allFilter.click();
    }

    public void clickFilterApplied() {
        waitForClickable(allFilterApplied);
        allFilterApplied.click();
    }

    public boolean isConditionFilterApplied() {
        waitForVisibility(conditionFilterApplied);
        log.info(conditionFilterApplied.getText() + " - Filter Applied");
        return conditionFilterApplied.isDisplayed();
    }

    public boolean isPriceFilterApplied() {
        waitForVisibility(priceFilterApplied);
        log.info(priceFilterApplied.getText() + " - Filter Applied");
        return priceFilterApplied.isDisplayed();
    }

    public boolean isItemLocationFilterApplied() {
        waitForVisibility(itemLocFilterApplied);
        log.info(itemLocFilterApplied.getText() + " - Filter Applied");
        return itemLocFilterApplied.isDisplayed();
    }

}
