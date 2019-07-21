package hillel.mySpringRest.controller;

import hillel.mySpringRest.model.Greeting;
import hillel.mySpringRest.service.GreetingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class GreetingController {

    private final GreetingService greetingService;

    @GetMapping("/greetings/{language}")
    public Greeting findByKey(@PathVariable String language) {
        return greetingService.findByKey(language);
    }

}
