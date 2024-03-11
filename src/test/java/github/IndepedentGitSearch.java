package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
public class IndepedentGitSearch {

    @Test
    void searchGH() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;

        open("https://github.com/");
        $(".search-input").click();
        $(".search-suggestions").should(appear);
        $("#query-builder-test").setValue("Selenide")
                .pressEnter();
        $("[data-testid=results-list]").shouldHave(text("selenide/selenide"));
        $(".Text-sc-17v1xeu-0.qaOIC.search-match").parent().shouldHave(attribute("href", "https://github.com/selenide/selenide"))
                .click();

    }
}
