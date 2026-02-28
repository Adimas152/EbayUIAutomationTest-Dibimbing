package tests;

import core.BaseTest;
import core.DriverManager;
import core.TestUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AllFilterPage;
import pages.CellPhonePage;
import pages.DashboardPage;
import pages.SearchResultPage;

public class searchEbayTest extends BaseTest {
    @Test(description = "Scenario 1: Access product via category and apply multiple filters",
            groups = "regression")
    public void TC_01_applyMultipleFiltersFromCategoryh() {
        DashboardPage dashboardPage = new DashboardPage(DriverManager.getDriver());
        CellPhonePage cellPhonePage = new CellPhonePage(DriverManager.getDriver());
        AllFilterPage allFilterPage = new AllFilterPage(DriverManager.getDriver());
        dashboardPage.navigateCellPhonesCategory();
        cellPhonePage.clickSubCategoryCellPhoneSmartphones();
        cellPhonePage.clickAllFilter();
        allFilterPage.filterCondition();
        allFilterPage.filterPrice();
        allFilterPage.filterLocation();
        allFilterPage.clickApplyFilter();
        cellPhonePage.clickFilterApplied();
        Assert.assertTrue(cellPhonePage.isConditionFilterApplied(), "Condition filter not applied!");
        Assert.assertTrue(cellPhonePage.isPriceFilterApplied(), "Price filter not applied!");
        Assert.assertTrue(cellPhonePage.isItemLocationFilterApplied(), "Item location filter not applied!");
    }

    @DataProvider(name = "searchInput")
    public Object[][] searchInput() {
        return TestUtils.getTestData("src/test/resources/testdata/testdata.xlsx", "search-input-data");
    }

    @Test(description = "Scenario 2: Access product via Search with category filter",
            groups = "regression", dataProvider = "searchInput")
    public void TC_02_SearchProductWithCategoryFilter(String searchInput) {

        DashboardPage dashboardPage = new DashboardPage(DriverManager.getDriver());
        SearchResultPage searchResultPage = new SearchResultPage(DriverManager.getDriver());

        dashboardPage.serachProductByKeyword(searchInput);
        dashboardPage.selectSearchCategory();
        dashboardPage.clickSerachSubmitButton();

        Assert.assertTrue(
                searchResultPage.isFirstProductTitleContainsKeyword(searchInput),
                "First product title does not contain the searched keyword: " + searchInput
        );
    }
}
