package hillel.mySpringRest.service;

import hillel.mySpringRest.repository.GreetingRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
@Data



public class GreetingService {
   /* public static void main(String[] args) {



    Map<String, String> greeting = new HashMap<String, String>() {{
        put("en", "Hello!");
        put("it", "Buongiorno");
        put("fr", "Bonjour");
    }};
     //
        System.out.println(valueGetLanguage(greeting,"it"));
        System.out.println(valueRandom(greeting));
}*/

    private GreetingRepository greetingRepository;

    public static String valueGetLanguage( Map<String,String> greeting,String language){
        return greeting.entrySet().stream().filter(x->language.equalsIgnoreCase(x.getKey())).map(x->x.getValue())
                .collect(Collectors.joining());

    }


    public static String valueRandom(Map<String,String> greeting) {
        Object randomName = greeting.keySet().toArray()[new Random().nextInt(greeting.keySet().toArray().length)];
        return greeting.get(randomName);

    }



}

