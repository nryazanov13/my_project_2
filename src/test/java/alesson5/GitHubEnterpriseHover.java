package alesson5;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class GitHubEnterpriseHover {
    @BeforeAll
    static void setUp(){
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }


    @Test
    void shouldFindEnterpriseByHoverTest() {

        //Open selenide page on GitHub
        open("https://github.com");
        //Hover mouse on "Solutions"
        $$("li").findBy(text("Solutions")).hover();
        //Click on "Enterprise" text
        $$(".HeaderMenu-dropdown-link").findBy(text("Enterprise")).click();
        //Create variable for enterprise text
        String enterpriseText = "The AI-powered developer platform";
        //Check if text == enterpriseText variable
        $("#hero-section-brand-heading").shouldHave(text(enterpriseText));

    }
}
