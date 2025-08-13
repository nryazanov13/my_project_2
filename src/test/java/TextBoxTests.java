import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class TextBoxTests {

    @BeforeAll
    static void setUp(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        //Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTest(){
        //open website
        open("/automation-practice-form") ;
        //set firstName
        $("#firstName").setValue("Nikita");
        //set lastName
        $("#lastName").setValue("Ryazanov");
        //set userEmail
        $("#userEmail").setValue("nikita@gmail.com");
        //Choose male gender
        $("#gender-radio-1").parent().click();
        //input phoneNumber
        $("#userNumber").setValue("1234567890");
        //set dateOfBirth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("September");
        $(".react-datepicker__year-select").selectOption("1993");
        $$(".react-datepicker__day").findBy(text("16")).click();

        //set subject
        $("#subjectsInput").setValue("Math").pressEnter();
        //set reading hobbies
        $("#hobbies-checkbox-2").parent().click();
        //Upload picture
        $("#uploadPicture").uploadFile(new File("/home/vdiuser/Desktop/1.jpeg"));
        //set currebtAddress
        $("#currentAddress").setValue("Saint-Petersburg");
        //Choose state
        $("#state").click();
        $(byText("NCR")).click();

        //Choose City
        $("#city").click();
        $(byText("Delhi")).click();

        //Press submit button
        $(".btn-primary").pressEnter();


        //Check if table is visible
        $(".table-responsive").shouldBe(visible);

        //Check each row for the certain value
        $$(".table-responsive tbody tr").get(0).shouldHave(text("Student Name"), text("Nikita Ryazanov"));
        $$(".table-responsive tbody tr").get(1).shouldHave(text("Student Email"), text("nikita@gmail.com"));
        $$(".table-responsive tbody tr").get(2).shouldHave(text("Gender"), text("Male"));
        $$(".table-responsive tbody tr").get(3).shouldHave(text("Mobile"), text("1234567890"));
        $$(".table-responsive tbody tr").get(4).shouldHave(text("Date of Birth"), text("16 September,1993"));
        $$(".table-responsive tbody tr").get(5).shouldHave(text("Subjects"), text("Maths"));
        $$(".table-responsive tbody tr").get(6).shouldHave(text("Hobbies"), text("Reading"));
        $$(".table-responsive tbody tr").get(7).shouldHave(text("Picture"), text("1.jpeg"));
        $$(".table-responsive tbody tr").get(8).shouldHave(text("Address"), text("Saint-Petersburg"));
        $$(".table-responsive tbody tr").get(9).shouldHave(text("State and City"), text("NCR Delhi"));

    }

}
