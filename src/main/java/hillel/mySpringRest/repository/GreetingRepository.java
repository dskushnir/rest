package hillel.mySpringRest.repository;

import hillel.mySpringRest.model.Greeting;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository
public class GreetingRepository {


    private final Map<String, Greeting> greetings = Map.of(
            "en", new Greeting("Hello!"),
            "it", new Greeting("Buongiorno!"),
            "fr", new Greeting("Bonjour!"));
    private final Random random = new Random();


    public Greeting findByLanguage(String language) {
        return greetings.getOrDefault(language, new Greeting("There is no greeting in this language "));
    }


    public Greeting findByRandom() {
        List<String> keys = new ArrayList<>(greetings.keySet());
        String randomLanguage = keys.get(random.nextInt(keys.size()));
        return greetings.get(randomLanguage);
    }

}








