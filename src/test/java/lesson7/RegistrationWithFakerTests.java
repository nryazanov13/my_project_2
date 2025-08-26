package lesson7;

import lesson6.TestBase;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomUtils;


public class RegistrationWithFakerTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormWithPageObjectPositiveTest() {

        registrationPage.openPage()
                .removeBanner()
                .setFirstNameInput(RandomUtils.firstName)
                .setLastNameInput(RandomUtils.lastName)
                .setEmailInput(RandomUtils.email)
                .setGenderInput(RandomUtils.gender)
                .setUserNumberInput(RandomUtils.phoneNumber)
                .setDateOfBirth(RandomUtils.month, RandomUtils.year,RandomUtils.day)
                .setSubjectInput(RandomUtils.subject)
                .setHobbiesInput(RandomUtils.hobbies)
                .uploadPicture(RandomUtils.picture)
                .setCurrentAddress(RandomUtils.address)
                .setState(RandomUtils.state)
                .setCity(RandomUtils.city)
                .clickSubmitButton()

                //проверки
                .checkIfTableIsVisible()
                .checkResult("Student Name", RandomUtils.fullName)
                .checkResult("Student Email", RandomUtils.email)
                .checkResult("Gender",RandomUtils.gender)
                .checkResult("Mobile",RandomUtils.phoneNumber)
                .checkResult("Date of Birth", RandomUtils.getDateOfBirth())
                .checkResult("Subjects", RandomUtils.subject)
                .checkResult("Hobbies",RandomUtils.hobbies)
                .checkResult("Picture",RandomUtils.picture)
                .checkResult("Address",RandomUtils.address)
                .checkResult("State and City",RandomUtils.stateAndCity);

    }

    @Test
    void fillFormWithPageObjectRequiredFieldsTest (){
        registrationPage.openPage()
                .setFirstNameInput(RandomUtils.firstName)
                .setLastNameInput(RandomUtils.lastName)
                .setGenderInput(RandomUtils.gender)
                .setUserNumberInput(RandomUtils.phoneNumber)
                .clickSubmitButton()

                //проверки
                .checkIfTableIsVisible()
                .checkResult("Student Name",RandomUtils.fullName)
                .checkResult("Gender",RandomUtils.gender)
                .checkResult("Mobile",RandomUtils.phoneNumber);
    }

    @Test
    void fillFormWithPageObjectNegativeTest() {

        registrationPage.openPage()
                .clickSubmitButton()
                //проверки
                .checkIfTableIsNotVisible();
    }
}
