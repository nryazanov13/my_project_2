package utils;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Random;

import static lesson7.RegistrationWithFakerTests.*;


public class RandomUtils {


    public static Faker faker = new Faker(Locale.ENGLISH);


    public static String getFirstName() {
        return faker.name().firstName();
    }

    public static String getLastName() {
        return faker.name().lastName();
    }

    public static String getFullName() {
        return firstName + " " + lastName;
    }

    public static String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    public static String getRandomPhoneNumber() {
        return faker.numerify("##########");
    }

    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};
        return getRandomItemFromArray(genders);
    }

    public static String getRandomItemFromArray(String[] array) {
        int index = new Random().nextInt(0, array.length - 1);
        return array[index];
    }


    public static String getRandomMonth() {
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

    public static String getRandomYear() {
        int year = new Random().nextInt(1990, 2021);
        return String.valueOf(year);
    }

    public static String getRandomDay() {
        int day = new Random().nextInt(1, 30);
        return String.valueOf(day);
    }

    public static String getDateOfBirth() {
        return day + " " + month + "," + year;
    }

    public static String getRandomSubject() {
        String[] subjects = {"Maths", "Physics", "Chemistry", "Computer Science",
                "English", "Biology", "History", "Arts"};
        return getRandomItemFromArray(subjects);
    }

    public static String getRandomHobby() {
        String[] hobbies = {"Reading", "Sports", "Music"};
        return getRandomItemFromArray(hobbies);
    }

    public static String getRandomPicture() {
        String[] pictures = {"1.jpeg", "2.png", "3.jpg", "4.gif"};
        return getRandomItemFromArray(pictures);
    }

    public static String getRandomAddress() {
        return faker.address().fullAddress();
    }

    public static String getRandomState() {
        String[] states = {
                "NCR",
                "Uttar Pradesh",
                "Haryana",
                "Rajasthan"
        };
        return getRandomItemFromArray(states);
    }

    public static String getRandomCity(String state) {
        return switch (state) {
            case "NCR" -> getRandomItemFromArray(new String[]{"Delhi", "Gurgaon", "Noida"});
            case "Uttar Pradesh" -> getRandomItemFromArray(new String[]{"Agra", "Lucknow", "Merrut"});
            case "Haryana" -> getRandomItemFromArray(new String[]{"Karnal", "Panipat"});
            case "Rajasthan" -> getRandomItemFromArray(new String[]{"Jaipur", "Jaiselmer"});
            default -> "Delhi";
        };
    }

    public static String getStateAndCity() {
        return state + " " + city;
    }


}
