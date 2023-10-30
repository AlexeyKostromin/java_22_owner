package helpers;

import utils.RandomDataUtils;

import java.util.HashMap;
import java.util.Map;

public class DataStudentHelper extends RandomDataUtils {

    private final String[]
            gender = {"Male", "Female", "Other"},
            subjects = {"Maths", "English", "Chemistry", "Hindi", "Commerce", "Economics"},
            sport = {"Sports", "Reading", "Music"};
    private final String fileName = "File1.png";

    private final Map<String, String[]> statesAndCities = new HashMap<>();

    {
        statesAndCities.put("NCR", new String[]{"Delhi", "Gurgaon", "Noida"});
        statesAndCities.put("Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"});
        statesAndCities.put("Haryana", new String[]{"Karnal", "Panipat"});
    }

    public String generateFirstName() {
        return faker.name().firstName();
    }

    public String generateLastName() {
        return faker.name().lastName();
    }

    public String generateEmail() {
        return faker.internet().emailAddress();
    }

    public String generatePhone(int digits) {
        return Long.toString(generateRandomNumberFaker(digits, true));
    }

    public String generateFullAddress() {
        return faker.address().fullAddress();
    }

    public String generateGender() {
        return faker.options().option(gender);
    }

    public String getSubject() {
        return faker.options().option(subjects);
    }

    public String getHobby() {
        return faker.options().option(sport);
    }

    public String getFilename() {
        return this.fileName;
    }

    public String getState() {
        return faker.options().option(statesAndCities.keySet().toArray()).toString();
    }

    public String getCity(String state) {
        return faker.options().option(statesAndCities.get(state));
    }


}
