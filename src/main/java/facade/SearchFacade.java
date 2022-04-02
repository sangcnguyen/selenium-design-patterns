package facade;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SearchFacade {
    private WebDriver driver;
    private MainPage mainPage;
    private SearchResultPage searchResultPage;

    public SearchFacade(WebDriver driver, MainPage mainPage, SearchResultPage searchResultPage) {
        this.driver = driver;
        this.mainPage = mainPage;
        this.searchResultPage = searchResultPage;
        PageFactory.initElements(driver, this);
    }

    public void searchText(String searchString, String pageUrl) {
        mainPage.goToPage();
        mainPage.searchByText(searchString);
        searchResultPage.findAndGoToPage(pageUrl);
    }
}
