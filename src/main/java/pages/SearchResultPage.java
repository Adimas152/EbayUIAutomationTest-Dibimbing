package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends BasePage{
    private static final Logger log = LogManager.getLogger(SearchResultPage.class);

    @FindBy (xpath = "(//div[@role='heading']//span[contains(@class,'su-styled-text')])[3]")
    private WebElement firstProductTitle;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public boolean isFirstProductTitleContainsKeyword(String keyword) {

        waitForVisibility(firstProductTitle);

        String actualTitle = firstProductTitle.getText().trim();
        log.info("First product title: {}", actualTitle);

        return actualTitle.toLowerCase().contains(keyword.toLowerCase());
    }

    public boolean isFirstItemListedAfterSearchContains(String searchInput) {
        waitForVisibility(firstProductTitle);

        String itemText = firstProductTitle.getText();
        log.info("First carousel item text: " + itemText);

        return itemText.toLowerCase().contains(searchInput.toLowerCase());

    }
}
