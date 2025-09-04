package alesson5;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDrop {
    @BeforeAll
    static void setUp(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
        Configuration.pageLoadStrategy = "eager";
    }


    @Test
    void shouldDragAndDropWithSelenideActionsTest() {
        //Open drag and drop page
        open("/drag_and_drop");
        //Move and drop element
        //Calculate coordinates
        int xOffset = $("#column-b").getLocation().getX() - $("#column-a").getLocation().getX();
        int yOffset = $("#column-b").getLocation().getY() - $("#column-a").getLocation().getY();

        // Perform drag and drop
        actions()
                .moveToElement($("#column-a"))
                .clickAndHold()
                .moveByOffset(xOffset, yOffset)
                .release()
                .perform();

        // Check if column was changed
        $("#column-a header").shouldHave(text("B"));
        $("#column-b header").shouldHave(text("A"));
    }
}
