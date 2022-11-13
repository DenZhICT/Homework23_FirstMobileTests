package browserstack.app;

import io.appium.java_client.AppiumBy;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

public class AndroidWikiApp {

    private final String skipButton = "org.wikipedia.alpha:id/fragment_onboarding_skip_button",
            searchHolder = "Search Wikipedia",
            inputField = "org.wikipedia.alpha:id/search_src_text",
            listOfResponse = "org.wikipedia.alpha:id/page_list_item_title",
            description = "pcs-edit-section-title-description",
            something = "Topics referred to by the same term";

    public AndroidWikiApp skipLanguage() {
        step("Skip language choice", () ->
                $(AppiumBy.id(skipButton)).click());
        return this;
    }

    public AndroidWikiApp searchInput(String request) {
        step("Type search", () -> {
            $(AppiumBy.accessibilityId(searchHolder)).click();
            $(AppiumBy.id(inputField)).sendKeys(request);
        });
        return this;
    }

    public void greaterThanZero() {
        step("Verify content found", () ->
                $$(AppiumBy.id(listOfResponse))
                        .shouldHave(sizeGreaterThan(0)));
    }

    public AndroidWikiApp chooseFirst() {
        step("Verify content found", () ->
                $$(AppiumBy.id(listOfResponse))
                        .first().click());
        return this;
    }

    public void findSomething(String request) {
        step("", () ->
                $(AppiumBy.className("android.widget.TextView")).shouldHave(text(request)));
    }
}
