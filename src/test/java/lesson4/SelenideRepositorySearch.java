package lesson4;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.*;

public class SelenideRepositorySearch {

    @BeforeAll
    static void setUp(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";
    }


    @Test
    void shouldFindJUnit5CodeExample(){
        //Open selenide page on GitHub
        open("/selenide/selenide");
        //Click on wiki-tab
        $("#wiki-tab").click();
        //Check if there is "soft assertions" text on the page
        $("#wiki-body").$("ul").shouldHave(text("Soft assertions"));
        //Open "soft assertions" page
        $("#wiki-body").$$("a").findBy(text("Soft assertions")).click();

        //Example of JUnit5 text
        String JUnit5Text = """
            @ExtendWith({SoftAssertsExtension.class})
            class Tests {
              @Test
              void test() {
                Configuration.assertionMode = SOFT;
                open("page.html");
            
                $("#first").should(visible).click();
                $("#second").should(visible).click();
              }""";

        //Check if there is code example for JUnit5
        $(withTagAndText("h4","3. Using JUnit5 extend test class:"))
                .parent()
                .sibling(0)
                .shouldHave(text(JUnit5Text));
    }
}
