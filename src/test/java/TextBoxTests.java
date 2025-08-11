import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;


public class TextBoxTests {

    @BeforeAll
    static void beforeAll(){
        Configuration.browserSize = "1920*1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest(){
        open("/automation-practice-form") ;
        $("#firstName").setValue("Nikita");
        $("#lastName").setValue("Ryazanov");
        $("#userEmail").setValue("nikita@gmail.com");
        $("#gender-radio-1").click();
        $("#userNumber").setValue("1234567890");
        $("#dateOfBirthInput").setValue("16 Sep 1993");
        $("#subjectsInput").setValue("QA Automation");
        $("#hobbies-checkbox-1").click();
        //Upload picture
        $("currentAddress").setValue("Saint-Petersburg");
        //Choose state
        //Choose City






    }

}
