package utils;

import com.github.javafaker.Faker;
import io.netty.util.internal.ThreadLocalRandom;
import org.apache.commons.lang3.RandomStringUtils;

import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Locale;

public class RandomDataUtils {
    protected Faker faker;

    public RandomDataUtils() {
        faker = new Faker(new Locale("en-US"));
    }

    public String[] generateDateOfBirth() {
        var randomYear = Integer.toString(getRandomBetween(1900, 2022));
        var randomMonth = (Month.values()[getRandomBetween(1, 11)]).toString().toLowerCase();
        randomMonth = Character.toUpperCase(randomMonth.charAt(0)) + randomMonth.substring(1);
        var randomDay = Integer.toString(getRandomBetween(1, 30));
        return new String[]{randomDay, randomMonth, randomYear};
    }

    public String[] generateDateOfBirthFaker() {
        var randomBirthday = faker.date().birthday(15, 65);//Sun Aug 04 22:09:15 CEST 1991
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMM/yyyy", Locale.ENGLISH);
        return sdf.format(randomBirthday).split("/");
    }

    public String getRandomStringFromArray(String[] array) {
        return array[this.getRandomBetween(0, array.length - 1)];
    }

    public <E> E getRandomElementFromArray(E[] array) {
        return array[faker.random().nextInt(array.length)];
    }

    public int getRandomBetween(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public int getRandomBetweenFaker(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public String generateStringAlphabetic(int min, int max) {
        return RandomStringUtils.randomAlphabetic(min, max);
    }

    public String generateStringNumeric(int min, int max) {
        return Integer.toString(faker.number().numberBetween(min, max));
    }

    public long generateRandomNumberFaker(int numberOfDigits, boolean strict) {
        return faker.number().randomNumber(numberOfDigits, true);
    }


}
