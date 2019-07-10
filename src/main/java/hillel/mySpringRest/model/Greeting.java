package hillel.mySpringRest.model;

import lombok.Data;
@Data
public class Greeting {
    private String greeting;
    public Greeting( String greeting) {
        this.greeting = greeting;
    }
}
