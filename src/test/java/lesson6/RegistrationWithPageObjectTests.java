package lesson6;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class RegistrationWithPageObjectTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormWithPageObjectPositiveTest() {

        registrationPage.openPage()
                .removeBanner()
                .setFirstNameInput("Nikita")
                .setLastNameInput("Ryazanov")
                .setEmailInput("nikita@gmail.com")
                .setGenderInput("Male")
                .setUserNumberInput("1234567890")
                .setDateOfBirth("September", "1993", "07")
                .setSubjectInput("Maths")
                .setHobbiesInput("Reading")
                .uploadPicture("1.jpeg")
                .setCurrentAddress("Saint-Petersburg")
                .setState("NCR")
                .setCity("Delhi")
                .clickSubmitButton()

                //проверки
                .checkIfTableIsVisible()
                .checkResult("Student Name","Nikita Ryazanov")
                .checkResult("Student Email", "nikita@gmail.com")
                .checkResult("Gender","Male")
                .checkResult("Mobile","1234567890")
                .checkResult("Date of Birth", "7 September,1993")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies","Reading")
                .checkResult("Picture","1.jpeg")
                .checkResult("Address","Saint-Petersburg")
                .checkResult("State and City","NCR Delhi");

    }

    @Test
    void fillFormWithPageObjectRequiredFieldsTest (){
        registrationPage.openPage()
                .setFirstNameInput("Nikita")
                .setLastNameInput("Ryazanov")
                .setGenderInput("Male")
                .setUserNumberInput("1234567891")
                .clickSubmitButton()

                //проверки
                .checkIfTableIsVisible()
                .checkResult("Student Name","Nikita Ryazanov")
                .checkResult("Gender","Male")
                .checkResult("Mobile","1234567891");
    }

    @Test
    void fillFormWithPageObjectNegativeTest() {

        registrationPage.openPage()
                .clickSubmitButton()
                //проверки
                .checkIfTableIsNotVisible();
    }



}

