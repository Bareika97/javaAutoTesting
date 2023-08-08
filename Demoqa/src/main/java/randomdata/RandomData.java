package randomdata;

import org.openqa.selenium.WebDriver;

import java.util.*;
import java.util.stream.Collectors;

import static common.Config.SUBJECTS;

public class RandomData {
    protected WebDriver driver;
    private static Random random = new Random();
    private static String randomState;
    private static Map<String, String[]> stateAndCity = new HashMap<>();

    public RandomData(WebDriver driver) {
        this.driver = driver;
    }

    public static Map<String, String[]> createStateAndCites() {

        stateAndCity.put("NCR", new String[]{"Delhi", "Gurgaon", "Noida"});
        stateAndCity.put("Uttar Pradesh", new String[]{"Agra", "Lucknow", "Merrut"});
        stateAndCity.put("Haryana", new String[]{"Karnal", "Panipat"});
        stateAndCity.put("Rajasthan", new String[]{"Jaipur", "Jaiselmer"});
        return stateAndCity;
    }

    public static String generateSubject() {
        return SUBJECTS[random.nextInt(SUBJECTS.length)];
    }

    public static String generateRandomState() {
        Set<String> setStates = stateAndCity.keySet();
        List<String> list = setStates.stream().collect(Collectors.toList());
        randomState = list.get(random.nextInt(list.size()));
        return randomState;
    }

    public static String generateRandomCity() {
        String[] cities = stateAndCity.get(randomState);
        return cities[random.nextInt(cities.length)];
    }

}
