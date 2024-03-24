package githubother;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class HomeWorkDragAndDrop {

    SelenideElement columnA = $("#column-a");
    SelenideElement columnB = $("#column-b");

    @BeforeAll
    static void beforeAll() {

        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.browserSize = "2560x1440";

    }

    @Test
    void testDragAndDrop() {

        open("https://the-internet.herokuapp.com/drag_and_drop");
        actions().dragAndDrop(columnA, columnB).perform();

    }

    @Test
    void throughActions() {

        open("https://the-internet.herokuapp.com/drag_and_drop");
        actions().clickAndHold(columnA)
                .moveToElement(columnB).release().perform();

    }
}
