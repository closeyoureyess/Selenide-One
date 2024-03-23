package githubother;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPageGithub {

    @BeforeAll
    static void beforeAll() {

        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "1920x1080";

    }

    @Test
    void testActions() {

        open("https://github.com/");
        $("[role=banner]").$(byText("Solutions")).hover();
        $("[aria-labelledby=solutions-for-heading] li").click();
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered"));

    }
}
