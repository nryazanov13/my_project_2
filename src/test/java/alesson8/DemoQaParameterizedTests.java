package alesson8;

import data.Gender;
import helpers.TestBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;
import pages.RegistrationPage;

import java.util.stream.Stream;

import static utils.RandomUtils.*;


@DisplayName("Тестируем заполнение формы с обязательными входными данными")
public class DemoQaParameterizedTests extends TestBase {

    private final String
            firstName = getRandomFirstName(),
            lastName = getRandomLastName(),
            phoneNumber = getRandomPhoneNumber(),
            gender = getRandomGender();


    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeEach
        void setUp(){
        registrationPage
                .openPage()
                .removeBanner();
    }


    @Tag("Happy path")
    @DisplayName("Тест с различными именами используя @ValueSource")
    @ParameterizedTest(name = "Имя: {0}")
    @ValueSource(strings = {"John", "Anna", "Michael", "Sarah"})
    void fillFormWithDifferentFirstNameTest(String firstName) {
        registrationPage
                .setFirstNameInput(firstName)
                .setLastNameInput(lastName)
                .setGenderInput(gender)
                .setUserNumberInput(phoneNumber)
                .clickSubmitButton()

                //проверки
                .checkIfTableIsVisible()
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phoneNumber);
    }


    @Tag("Happy path")
    @DisplayName("Тест с различными фамилиями используя @ValueSource")
    @ParameterizedTest(name = "Фамилия: {0}")
    @ValueSource(strings = {"Doe", "Smith", "Williams", "Johnson"})
    void fillFormWithDifferentLastNameTest(String lastName) {
        registrationPage
                .setFirstNameInput(firstName)
                .setLastNameInput(lastName)
                .setGenderInput(gender)
                .setUserNumberInput(phoneNumber)
                .clickSubmitButton()

                //проверки
                .checkIfTableIsVisible()
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phoneNumber);
    }


    @Tag("Happy path")
    @DisplayName("Тест с различными именами и фамилиями используя @CsvSource")
    @ParameterizedTest(name = "Имя: {0}, Фамилия: {1}")
    @CsvSource({
            "John, Doe",
            "Anna, Smith",
            "Michael, Johnson",
            "Sarah, Williams"
    })
    void fillFormWithDifferentNamesTest(String firstName, String lastName) {
        registrationPage
                .openPage()
                .removeBanner()
                .setFirstNameInput(firstName)
                .setLastNameInput(lastName)
                .setGenderInput(gender)
                .setUserNumberInput(phoneNumber)
                .clickSubmitButton()

                .checkIfTableIsVisible()
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phoneNumber);
    }


    @DisplayName("Тест регистрации c различными обязательными полями используя @CsvFileSource")
    @ParameterizedTest(name = "Тест #{index}: Имя - {0}, Фамилия - {1}, Пол - {2}, тел - {3}")
    @CsvFileSource(resources = "/RegistrationWithRequiredFields.csv", numLinesToSkip = 1)
    void fillFormWithAllRequiredFieldsViaCsvFileSourceTest(String firstName, String lastName,
                                           String gender, String phoneNumber) {

        registrationPage
                .openPage()
                .removeBanner()
                .setFirstNameInput(firstName)
                .setLastNameInput(lastName)
                .setGenderInput(gender)
                .setUserNumberInput(phoneNumber)
                .clickSubmitButton()

                // проверки
                .checkIfTableIsVisible()
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", gender)
                .checkResult("Mobile", phoneNumber);
    }


    @Tag("Happy path")
    @DisplayName("Тест с различным полом пользователя используя @EnumSource")
    @ParameterizedTest(name = "Пол пользователя - {0}")
    @EnumSource(Gender.class)
    void fillFormWithDifferentGendersTest(Gender gender) {
        registrationPage
                .setFirstNameInput(firstName)
                .setLastNameInput(lastName)
                .setGenderInput(gender.getDisplayName()) // Используем displayName из enum
                .setUserNumberInput(phoneNumber)
                .clickSubmitButton()

                // проверки
                .checkIfTableIsVisible()
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", gender.getDisplayName()) // Проверяем displayName
                .checkResult("Mobile", phoneNumber);
    }


    private static Stream<Arguments> fillFormWithAllRequiredFieldsViaMethodSourceTest() {
        return Stream.of(
                Arguments.of("Иван", "Петров", Gender.MALE, "1234567890"),
                Arguments.of("Анна", "Сидорова", Gender.FEMALE, "0987654321"),
                Arguments.of("Алекс", "Смит", Gender.OTHER, "5551234567"),
                Arguments.of("Ольга", "Иванова", Gender.FEMALE, "9998887777"),
                Arguments.of("Петр", "Смирнов", Gender.MALE, "1112223333")
        );
    }


    @Tag("Happy path")
    @DisplayName("Тест всех обязательных полей используя @MethodSource")
    @ParameterizedTest(name = "Тест #{index}: Имя - {0} Фамилия - {1} Пол - {2}, тел - {3}")
    @MethodSource()
    void fillFormWithAllRequiredFieldsViaMethodSourceTest(String firstName, String lastName,
                                           Gender gender, String phoneNumber) {
        registrationPage
                .setFirstNameInput(firstName)
                .setLastNameInput(lastName)
                .setGenderInput(gender.getDisplayName())
                .setUserNumberInput(phoneNumber)
                .clickSubmitButton()

                .checkIfTableIsVisible()
                .checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Gender", gender.getDisplayName())
                .checkResult("Mobile", phoneNumber);
    }

}
