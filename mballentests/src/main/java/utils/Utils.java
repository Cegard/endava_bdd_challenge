package utils;

import com.github.javafaker.Faker;

import java.util.Random;
import java.util.UUID;

public class Utils {
    private static Random random = null;

    public static String randomClientNameGenerator() {
        return Faker.instance().name().fullName();
    }

    public static String randomIDGenerator() {
        return UUID.randomUUID().toString();
    }

    public static Random getRandom() {
        if(random == null) {
            random = new Random();
        }
        return random;
    }
}
