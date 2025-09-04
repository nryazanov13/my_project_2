package alesson6;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class initialTextBoxTest {
    @BeforeAll
    static void setUp(){
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillFormTest(){
        //open website
        open("/automation-practice-form") ;
        //remove ads
        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");
        //set firstName
        $("#firstName").setValue("Nikita");
        //set lastName
        $("#lastName").setValue("Ryazanov");
        //set userEmail
        $("#userEmail").setValue("nikita@gmail.com");
        //Choose male gender
        $("#genterWrapper").$(byText("Male")).click();
        //input phoneNumber
        $("#userNumber").setValue("1234567890");
        //set dateOfBirth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("September");
        $(".react-datepicker__year-select").selectOption("1993");
        $$(".react-datepicker__day").findBy(text("16")).click();

        //set subject
        $("#subjectsInput").setValue("Maths").pressEnter();
        //set reading hobbies
        $("#hobbiesWrapper").$(byText("Reading")).click();
        //Upload picture
        $("#uploadPicture").uploadFromClasspath("1.jpeg");
        //set currentAddress
        $("#currentAddress").setValue("Saint-Petersburg");
        //Choose state
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();

        //Choose City
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();

        //Press submit button
        $("#submit").click();


        //Check if table is visible
        $(".table-responsive").shouldBe(visible);

        //Check each row for the certain value
        $(".table-responsive").shouldHave(text("Student Name"), text("Nikita Ryazanov"));
        $(".table-responsive").shouldHave(text("Student Email"), text("nikita@gmail.com"));
        $(".table-responsive").shouldHave(text("Gender"), text("Male"));
        $(".table-responsive").shouldHave(text("Mobile"), text("1234567890"));
        $(".table-responsive").shouldHave(text("Date of Birth"), text("16 September,1993"));
        $(".table-responsive").shouldHave(text("Subjects"), text("Maths"));
        $(".table-responsive").shouldHave(text("Hobbies"), text("Reading"));
        $(".table-responsive").shouldHave(text("Picture"), text("1.jpeg"));
        $(".table-responsive").shouldHave(text("Address"), text("Saint-Petersburg"));
        $(".table-responsive").shouldHave(text("State and City"), text("NCR Delhi"));

    }

}
