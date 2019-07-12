package hillel.mySpringRest.repository;
import hillel.mySpringRest.model.Greeting;
import lombok.Data;
import org.springframework.stereotype.Repository;
import java.util.*;

@Data
@Repository
public class GreetingRepository {
    private static Map<String, Greeting>greetings=new HashMap<>();
    static {initGreetings();}
    private static void initGreetings() {
            greetings.put("en",new Greeting("Hello!"));
            greetings.put("it",new Greeting("Buongiorno!"));
            greetings.put("fr",new Greeting("Bonjour!"));
        }
        public static Greeting getByLanguage(String language) {
        return greetings.get(language);
        }
        public static Greeting getByRandom(){
            Random random = new Random();
            List<String> keys = new ArrayList<>(greetings.keySet());
            String  randomLanguage = keys.get( random.nextInt(keys.size()) );
            return greetings.get(randomLanguage);
        }
        public static List<Greeting>getGreetingList(int numberGreeting) {
            List<Greeting> greetingList = new ArrayList<>();
            for (int i = 0; i < numberGreeting; i++) {
                greetingList.add(getByRandom());

            }
            return greetingList;
        }
        public static double getNumberGreetingType(List<Greeting>getGreetingList,String string){
            return getGreetingList.stream().filter(greeting -> greeting.equals(new Greeting(string))).count();
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








