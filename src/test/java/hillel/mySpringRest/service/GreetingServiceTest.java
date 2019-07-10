package hillel.mySpringRest.service;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class GreetingServiceTest {
    Map<String,String> greeting=new HashMap<String, String>(){{
        put("en","Hello!");
        put("it","Buongiorno");
        put("fr","Bonjour");}};




}