package hillel.mySpringRest.service;

import hillel.mySpringRest.model.Greeting;
import hillel.mySpringRest.repository.GreetingRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class GreetingService {

    private final GreetingRepository greetingRepository;


    public Greeting findByKey(String language) {
        if (!language.equalsIgnoreCase("random")) {
            return greetingRepository.findByLanguage(language);
        }
        return greetingRepository.findByRandom();
    }


}

