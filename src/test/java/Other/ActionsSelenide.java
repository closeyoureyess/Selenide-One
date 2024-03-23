package Other;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class ActionsSelenide {

    @Test
    void testAction() {

        open("https://github.com/");
        $("[role=banner]").$(byText("Solutions")).hover();

    }
}
