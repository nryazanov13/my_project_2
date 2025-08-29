package utils;

import com.github.javafaker.Faker;

import java.util.Locale;

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
        return faker.options().option(genders);
    }

    public static String getRandomMonth() {
        return faker.options().option(
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
                "November"
                ,"December"
        );
    }

    public static String getRandomDay() {
        return String.valueOf(faker.date().birthday().getDate());
    }

    public static String getRandomYear() {
        return String.valueOf(1900 + faker.date().birthday().getYear());
    }


    public static String getDateOfBirth() {
        return day + " " + month + "," + year;
    }

    public static String getRandomSubject() {
        String[] subjects = {
                "Maths",
                "Physics",
                "Chemistry",
                "Computer Science",
                "English",
                "Biology",
                "History",
                "Arts"
        };
        return faker.options().option(subjects);
    }

    public static String getRandomHobby() {
        String[] hobbies = {
                "Reading",
                "Sports",
                "Music"
        };
        return faker.options().option(hobbies);
    }

    public static String getRandomPicture() {
        String[] pictures = {
                "1.jpeg",
                "2.png",
                "3.jpg",
                "4.gif"
        };
        return faker.options().option(pictures);
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
        return faker.options().option(states);
    }

    public static String getRandomCity(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> "Delhi";
        };
    }

    public static String getStateAndCity() {
        return state + " " + city;
    }


}
