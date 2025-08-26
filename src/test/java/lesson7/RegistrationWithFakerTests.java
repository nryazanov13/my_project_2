package lesson7;

import lesson6.TestBase;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.RandomUtils;

import static utils.RandomUtils.*;


public class RegistrationWithFakerTests extends TestBase {


    public static String firstName = RandomUtils.getFirstName(),
            lastName = getLastName(),
            fullName = getFullName(),
            email = getRandomEmail(),
            phoneNumber = getRandomPhoneNumber(),
            gender = getRandomGender(),
            month = getRandomMonth(),
            year = getRandomYear(),
            day = getRandomDay(),
            subject = getRandomSubject(),
            hobbies = getRandomHobby(),
            picture = getRandomPicture(),
            address = getRandomAddress(),
            state = getRandomState(),
            city = getRandomCity(state),
            stateAndCity = getStateAndCity();

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormWithPageObjectPositiveTest() {

        registrationPage.openPage()
                .removeBanner()
                .setFirstNameInput(firstName)
                .setLastNameInput(lastName)
                .setEmailInput(email)
                .setGenderInput(gender)
                .setUserNumberInput(phoneNumber)
                .setDateOfBirth(month, year, day)
                .setSubjectInput(subject)
                .setHobbiesInput(hobbies)
                .uploadPicture(picture)
                .setCurrentAddress(address)
                .setState(state)
                .setCity(city)
                .clickSubmitButton()

                //проверки
                .checkIfTableIsVisible()
                .checkResult("Student Name", fullName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phoneNumber)
                .checkResult("Date of Birth", getDateOfBirth())
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobbies)
                .checkResult("Picture", picture)
                .checkResult("Address", address)
                .checkResult("State and City", stateAndCity);

    }

    @Test
    void fillFormWithPageObjectRequiredFieldsTest() {
        registrationPage.openPage()
                .setFirstNameInput(firstName)
                .setLastNameInput(lastName)
                .setGenderInput(gender)
                .setUserNumberInput(phoneNumber)
                .clickSubmitButton()

                //проверки
                .checkIfTableIsVisible()
                .checkResult("Student Name", fullName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phoneNumber);
    }

    @Test
    void fillFormWithPageObjectNegativeTest() {

        registrationPage.openPage()
                .clickSubmitButton()
                //проверки
                .checkIfTableIsNotVisible();
    }
}
