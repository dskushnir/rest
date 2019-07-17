package hillel.mySpringRest.repository;

import hillel.mySpringRest.model.Greeting;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class GreetingRepositoryTest {

    private final Map<String, Greeting> greetingsTest = new HashMap<>();

    {
        greetingsTest.put("en", new Greeting("Hello!"));
        greetingsTest.put("it", new Greeting("Buongiorno!"));
        greetingsTest.put("fr", new Greeting("Bonjour!"));
    }

    private final Random random = new Random();


    private Greeting findByRandom() {
        List<String> keys = new ArrayList<>(greetingsTest.keySet());
        String randomLanguage = keys.get(random.nextInt(keys.size()));
        return greetingsTest.get(randomLanguage);

    }


    private List<Greeting> createGreetingsList() {
        int numberGreetings = 300000;
        return IntStream.range(0, numberGreetings).
                mapToObj(i -> findByRandom()).collect(Collectors.toList());


    }


    private double frequencyTheoretical() {
        return (double) createGreetingsList().size() / greetingsTest.size();
    }


    private Map<String, Long> frequencyByLanguage() {
        return createGreetingsList().stream().
                collect(Collectors.groupingBy(Greeting::getGreeting, Collectors.counting()));
    }

    private double chiSquare() {
        return frequencyByLanguage().values().stream().
                map((e -> (Math.pow((e - frequencyTheoretical()), 2) / frequencyTheoretical()))).
                mapToDouble(e -> e).sum();
    }

    private boolean isEqualDistribution(double chiSquare) {

        double chiSquareMax = 9.21;
        return chiSquare < chiSquareMax;
    }

    @Test
    public void shouldIsEqualDistribution() throws Exception {
        boolean actual = isEqualDistribution(8.0);
        Assertions.assertThat(actual).isEqualTo(isEqualDistribution(chiSquare()));
    }


}






