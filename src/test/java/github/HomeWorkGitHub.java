package github;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.HighlightOptions.background;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class HomeWorkGitHub {

    @Test
    void searSortAssertions() {

        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;

        open("https://github.com/");
//        $(".search-input").click();
        $(byText("Search or jump to...")).click();
        sleep(3000);
        //Проверка, что окно открылось
        $(".search-suggestions.position-fixed.width-full.color-shadow-large.border.color-fg-default.color-bg-default.overflow-hidden.d-flex.flex-column.query-builder-container")
                .should(appear);
        //Ввод в строку поиска
        $("#query-builder-test").setValue("Selenide").pressEnter();
        //Поиск в главном контейнере нужного результата, нужен селенид/селенид
        $("[data-testid=results-list]").shouldHave(text("selenide/selenide"));
        //Проверить первый результат поиска на то, что там содержится нужная ссылка и перейти внутрь
        $(".Text-sc-17v1xeu-0.qaOIC.search-match").parent()
                .shouldHave(attribute("href", "https://github.com/selenide/selenide")).click();
        //Выбрать Wiki, перейти внутрь
        $("ul.UnderlineNav-body.list-style-none li").sibling(4).click();
        //Раскрыть скрытые в Shows(3).. пункты
        $(".Link--muted.js-wiki-more-pages-link.btn-link.mx-auto.f6").click();
        //Проверка, что SoftAssertions есть в списке
        $("ul[data-filterable-for=wiki-pages-filter]").shouldHave(text("SoftAssertions"));
        //Переход в статью SoftAssertions
        $("ul[data-filterable-for=wiki-pages-filter] li").sibling(16)
                .$("span.Truncate").click();
        //Проверка, что тест для Junit5 есть в списке
        $("#wiki-body").shouldHave(text("Using JUnit5 extend test class"));
        //Проверка, что есть такой текст во вставке с кодом
        $("div.highlight.highlight-source-java.notranslate.position-relative.overflow-auto")
                .sibling(9).highlight(background()).shouldHave(text("@ExtendWith"));
    }
}
