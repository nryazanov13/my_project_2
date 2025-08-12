import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class TextBoxTests {

    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920*1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
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
        $("#subjectsInput").setValue("QA Automation");
        $$(".subjects-auto-complete__input").first().click();
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


        $(".btn-primary").pressEnter();






    }

}
