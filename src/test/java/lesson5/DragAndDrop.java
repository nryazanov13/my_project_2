package lesson5;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DragAndDrop {
    @BeforeAll
    static void setUp(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://github.com";
        Configuration.pageLoadStrategy = "eager";
    }


    @Test
    void shouldDragAndDropWithSelenideActionsTest() {
        //Open selenide page on GitHub
        open("/selenide/selenide");
        //Click on wiki-tab
        $("#wiki-tab").click();
        //Check if there is "soft assertions" text on the page
        $("#wiki-body").$("ul").shouldHave(text("Soft assertions"));
        //Open "soft assertions" page
        $("#wiki-body").$$("a").findBy(text("Soft assertions")).click();
    }
}
