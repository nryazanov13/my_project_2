package utils;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Random;


public class RandomUtils {


    public static Faker faker = new Faker(Locale.ENGLISH);


    public static String firstName = getFirstName(),
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


    private static String getFirstName() {
        return faker.name().firstName();
    }

    private static String getLastName() {
        return faker.name().lastName();
    }

    private static String getFullName() {
        return firstName + " " + lastName;
    }

    private static String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    private static String getRandomPhoneNumber() {
        return faker.numerify("##########");
    }

    private static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};
        return getRandomItemFromArray(genders);
    }

    private static String getRandomItemFromArray(String[] array) {
        int index = new Random().nextInt(0, array.length - 1);
        return array[index];
    }


    private static String getRandomMonth() {
        String[] months = {
                "January",
                "February",
                "March",
                "April",
                "May",
                "June",
                "July",
                "August",
                "September",
                "October",
                "November",
                "December"
        };
        return getRandomItemFromArray(months);
    }

    private static String getRandomYear() {
        int year = new Random().nextInt(1990, 2021);
        return String.valueOf(year);
    }

    private static String getRandomDay() {
        int day = new Random().nextInt(1, 30);
        return String.valueOf(day);
    }

    public static String getDateOfBirth() {
        return day + " " + month + "," + year;
    }

    private static String getRandomSubject() {
        String[] subjects = {"Maths", "Physics", "Chemistry", "Computer Science",
                "English", "Biology", "History", "Arts"};
        return getRandomItemFromArray(subjects);
    }

    private static String getRandomHobby() {
        String[] hobbies = {"Reading", "Sports", "Music"};
        return getRandomItemFromArray(hobbies);
    }

    private static String getRandomPicture() {
        String[] pictures = {"1.jpeg", "2.png", "3.jpg", "4.gif"};
        return getRandomItemFromArray(pictures);
    }

    private static String getRandomAddress() {
        return faker.address().fullAddress();
    }

    private static String getRandomState() {
        String[] states = {
                "NCR",
                "Uttar Pradesh",
                "Haryana",
                "Rajasthan"
        };
        return getRandomItemFromArray(states);
    }

    private static String getRandomCity(String state) {
        return switch (state) {
            case "NCR" -> getRandomItemFromArray(new String[]{"Delhi", "Gurgaon", "Noida"});
            case "Uttar Pradesh" -> getRandomItemFromArray(new String[]{"Agra", "Lucknow", "Merrut"});
            case "Haryana" -> getRandomItemFromArray(new String[]{"Karnal", "Panipat"});
            case "Rajasthan" -> getRandomItemFromArray(new String[]{"Jaipur", "Jaiselmer"});
            default -> "Delhi";
        };
    }

    private static String getStateAndCity() {
        return state + " " + city;
    }


}
