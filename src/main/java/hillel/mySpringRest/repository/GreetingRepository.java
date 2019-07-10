package hillel.mySpringRest.repository;
import hillel.mySpringRest.model.Greeting;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.*;


@Repository
public class GreetingRepository {
    private static Map<String, Greeting>greetings=new HashMap<>();
    static {initGreetings();}
    private static void initGreetings() {
            greetings.put("en",new Greeting("Hello!"));
            greetings.put("it",new Greeting("Buongiorno"));
            greetings.put("fr",new Greeting("Bonjour"));
        }
        public Greeting getByLanguage(String language){
        return greetings.get(language);
        }
        public Greeting getByRandom(){
            Object randomLanguage = greetings.keySet().toArray()[new Random().nextInt(greetings.keySet().toArray().length)];
            return greetings.get(randomLanguage);
        }








  /*  public static String getByLanguage(Map<String,String> greeting,String language){
        return greeting.entrySet().stream().filter(x->language.equalsIgnoreCase(x.getKey())).map(x->x.getValue())
                .collect(Collectors.joining());
    }

    public static String getByRandom(Map<String,String> greeting) {
        Object randomName = greeting.keySet().toArray()[new Random().nextInt(greeting.keySet().toArray().length)];
        return greeting.get(randomName);

    }*/

}








