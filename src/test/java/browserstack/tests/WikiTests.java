package browserstack.tests;

import browserstack.app.AndroidWikiApp;
import browserstack.base.TestBase;
import org.junit.jupiter.api.Test;


public class WikiTests extends TestBase {

    AndroidWikiApp wikiApp = new AndroidWikiApp();

    @Test
    void searchTest() {
        wikiApp
                .skipLanguage()
                .searchInput("BrowserStack")
                .greaterThanZero();
    }

    @Test
    void searchQATest() {
        String request = "Quality assurance";

        wikiApp
                .skipLanguage()
                .searchInput(request)
                .chooseFirst()
                .findSomething(request);
    }
}
