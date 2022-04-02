package facade;

import org.testng.Assert;
import org.testng.annotations.Test;
import template.TestTemplate;

public class SearchTest extends TestTemplate {
    @Test
    public void verifySearchTargetPageSuccessfully() {
        MainPage searchPage = new MainPage(webDriver);
        SearchResultPage searchResultPage = new SearchResultPage(webDriver);
        TargetPage targetPage = new TargetPage(webDriver);
        SearchFacade searchFacade = new SearchFacade(webDriver, searchPage, searchResultPage);
        searchFacade.searchText("Github", "https://github.com/");
        Assert.assertEquals(targetPage.getPageTitle(), "GitHub: Where the world builds software · GitHub");
    }
}
