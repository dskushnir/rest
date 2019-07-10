package hillel.mySpringRest.controller;

import hillel.mySpringRest.model.Greeting;
import hillel.mySpringRest.service.GreetingService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Data
@RequestMapping("/greetings")
public class GreetingController {
    @Autowired
    private GreetingService greetingService;
    @RequestMapping(value = "{language}", method = RequestMethod.GET)
    public Greeting getGreeting(@PathVariable("language") String language) {
        return greetingService.getByKey(language);
    }

}
