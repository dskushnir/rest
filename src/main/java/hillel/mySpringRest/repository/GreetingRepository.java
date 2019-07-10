package hillel.mySpringRest.repository;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.*;
@Data
@Repository
public class GreetingRepository {
    private static Map<String,String>greeting=new HashMap<String, String>(){{
    put("en","Hello!");
    put("it","Buongiorno");
    put("fr","Bonjour");}};

}






