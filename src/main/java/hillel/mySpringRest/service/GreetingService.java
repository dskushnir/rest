package hillel.mySpringRest.service;

import hillel.mySpringRest.model.Greeting;
import hillel.mySpringRest.repository.GreetingRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
@Data
public class GreetingService {
@Autowired
    private GreetingRepository greetingRepository;

    public Greeting getByKey(String language) {
        if(!language.equalsIgnoreCase("random")) {
            return greetingRepository.getByLanguage(language);
        }
        return greetingRepository.getByRandom();
    }





}

