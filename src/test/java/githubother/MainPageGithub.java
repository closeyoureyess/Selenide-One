package githubother;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPageGithub {

    @Test
    void ghChoice() {

        open("https://github.com/");
        $("[role=banner]").$(byText("Solutions")).hover();

    }
}
